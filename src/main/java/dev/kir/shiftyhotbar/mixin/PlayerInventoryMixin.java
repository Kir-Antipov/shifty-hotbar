package dev.kir.shiftyhotbar.mixin;

import dev.kir.shiftyhotbar.ShiftyHotbar;
import dev.kir.shiftyhotbar.api.ScrollableInventory;
import dev.kir.shiftyhotbar.util.MathUtil;
import dev.kir.shiftyhotbar.util.ScrollUtil;
import dev.kir.shiftyhotbar.util.SlotSwapper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerInventory.class)
abstract class PlayerInventoryMixin implements ScrollableInventory {
    @Shadow
    public @Final DefaultedList<ItemStack> main;

    @Shadow
    public int selectedSlot;

    private int[] columns;
    private int[] rows;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(PlayerEntity player, CallbackInfo ci) {
        int columnCount = PlayerInventory.getHotbarSize();
        int rowCount = this.main.size() / columnCount;

        this.columns = new int[columnCount];
        for (int i = 0; i < columnCount; ++i) {
            this.columns[i] = i;
        }

        this.rows = new int[rowCount];
        for (int i = 0; i < rowCount; ++i) {
            this.rows[i] = i;
        }
    }

    @Inject(method = "scrollInHotbar", at = @At("HEAD"), cancellable = true)
    private void scrollInHotbar(double scrollAmount, CallbackInfo ci) {
        ScrollType scrollType = ScrollUtil.getActiveScrollModifier();
        if (scrollType == null) {
            return;
        }

        if (scrollType.isRow()) {
            scrollAmount = scrollAmount * (ShiftyHotbar.getConfig().invertRowScroll() ? 1 : -1);
        } else if (scrollType.isColumn()) {
            scrollAmount = scrollAmount * (ShiftyHotbar.getConfig().invertColumnScroll() ? -1 : 1);
        }

        this.scroll(scrollAmount, scrollType);
        ci.cancel();
    }

    @Override
    public void scroll(double scrollAmount, ScrollType scrollType) {
        int direction = (int)Math.signum(scrollAmount);
        if (direction == 0 || scrollType.isNone() || !PlayerInventory.isValidHotbarIndex(this.selectedSlot)) {
            return;
        }

        SlotSwapper swapper = SlotSwapper.from((PlayerInventory)(Object)this).orElse(null);
        if (swapper == null) {
            return;
        }

        ScrollUtil.scroll(swapper, this.columns.length, this.rows.length, this.selectedSlot, direction, scrollType);
        int[] indices = scrollType.isInSelected() ? null : scrollType.isRow() ? this.rows : this.columns;
        if (indices != null) {
            ScrollUtil.scroll(indices, direction);
        }
    }

    @Override
    public void scrollTo(int target, ScrollType scrollType) {
        if (scrollType.isNone() || scrollType.isInSelected()) {
            return;
        }

        int[] indices = scrollType.isRow() ? this.rows : this.columns;
        int selectedIndex = scrollType.isRow() ? 0 : PlayerInventory.isValidHotbarIndex(this.selectedSlot) ? this.selectedSlot : 0;
        target = ((target % indices.length) + indices.length) % indices.length;
        int foundAt = ArrayUtils.indexOf(indices, target);
        if (foundAt == -1) {
            return;
        }

        double scrollAmount = selectedIndex - foundAt;
        scrollAmount = MathUtil.absMin(scrollAmount, MathUtil.absMin(scrollAmount - indices.length, scrollAmount + indices.length));
        int count = Math.abs((int)scrollAmount);
        for (int i = 0; i < count; ++i) {
            this.scroll(scrollAmount, scrollType);
        }
    }
}

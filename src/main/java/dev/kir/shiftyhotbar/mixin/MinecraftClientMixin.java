package dev.kir.shiftyhotbar.mixin;

import dev.kir.shiftyhotbar.api.ScrollableInventory;
import dev.kir.shiftyhotbar.util.ScrollUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
final class MinecraftClientMixin {
    @Shadow
    public ClientPlayerEntity player;

    @ModifyVariable(method = "handleInputEvents", at = @At(value = "FIELD", shift = At.Shift.BEFORE, target = "Lnet/minecraft/entity/player/PlayerInventory;selectedSlot:I"))
    private int setSelectedSlot(int i) {
        PlayerInventory inventory = this.player.getInventory();
        ScrollableInventory.ScrollType scrollType = ScrollUtil.getActiveScrollModifier();
        if (scrollType != null) {
            ((ScrollableInventory)inventory).scrollTo(i, scrollType);
            i = inventory.selectedSlot;
        }
        return i;
    }
}

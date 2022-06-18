package dev.kir.shiftyhotbar.compat.mixin.ipn;

import dev.kir.shiftyhotbar.util.SlotSwapper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerInventory;
import org.anti_ad.mc.ipn.api.access.IPN;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(SlotSwapper.class)
class SlotSwapperMixin {
    @Inject(method = "Ldev/kir/shiftyhotbar/util/SlotSwapper;swap(II)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void swap(int left, int right, CallbackInfo ci) {
        if (left < PlayerInventory.getHotbarSize() || right < PlayerInventory.getHotbarSize()) {
            IPN.getInstance().getContainerClicker().swap(left, right);
            ci.cancel();
        }
    }
}

package dev.kir.shiftyhotbar.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.container.SlotActionType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public final class SlotSwapper {
    private final ClientPlayerInteractionManager interactionManager;
    private final PlayerEntity player;
    private final int syncId;

    private SlotSwapper(ClientPlayerInteractionManager interactionManager, PlayerEntity player, int syncId) {
        this.interactionManager = interactionManager;
        this.player = player;
        this.syncId = syncId;
    }

    public void swap(int left, int right) {
        this.interactionManager.clickSlot(this.syncId, left, right, SlotActionType.SWAP, this.player);
    }

    public static Optional<SlotSwapper> from(PlayerInventory inventory) {
        return SlotSwapper.from(MinecraftClient.getInstance(), inventory);
    }

    public static Optional<SlotSwapper> from(MinecraftClient client, PlayerInventory inventory) {
        if (client.interactionManager == null || inventory == null || inventory.player == null) {
            return Optional.empty();
        }
        return Optional.of(new SlotSwapper(client.interactionManager, inventory.player, inventory.player.playerContainer.syncId));
    }
}

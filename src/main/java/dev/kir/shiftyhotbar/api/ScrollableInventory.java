package dev.kir.shiftyhotbar.api;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public interface ScrollableInventory {
    static @Nullable ScrollableInventory getInstance() {
        PlayerEntity player = MinecraftClient.getInstance().player;
        return player == null ? null : (ScrollableInventory)player.getInventory();
    }

    void scroll(double scrollAmount, ScrollType scrollType);

    void scrollTo(int target, ScrollType scrollType);

    enum ScrollType {
        NONE,
        ROW,
        COLUMN,
        ROW_IN_SELECTED_COLUMN,
        COLUMN_IN_SELECTED_ROW;

        public boolean isNone() {
            return this == NONE;
        }

        public boolean isRow() {
            return this == ROW || this == ROW_IN_SELECTED_COLUMN;
        }

        public boolean isColumn() {
            return this == COLUMN || this == COLUMN_IN_SELECTED_ROW;
        }

        public boolean isInSelected() {
            return this == ROW_IN_SELECTED_COLUMN || this == COLUMN_IN_SELECTED_ROW;
        }
    }
}

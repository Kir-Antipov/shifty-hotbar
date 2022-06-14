package dev.kir.shiftyhotbar.util;

import dev.kir.shiftyhotbar.api.ScrollableInventory;
import dev.kir.shiftyhotbar.input.ShiftyHotbarKeyBindings;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public final class ScrollUtil {
    private static final Map<KeyBinding, ScrollableInventory.ScrollType> MODIFIERS;

    public static @Nullable ScrollableInventory.ScrollType getActiveScrollModifier() {
        long handle = MinecraftClient.getInstance().getWindow().getHandle();
        for (Map.Entry<KeyBinding, ScrollableInventory.ScrollType> pair : MODIFIERS.entrySet()) {
            KeyBinding binding = pair.getKey();
            InputUtil.KeyCode boundKey = KeyBindingHelper.getBoundKeyOf(binding);
            if (binding.isNotBound() || boundKey.getCategory() != InputUtil.Type.KEYSYM) {
                continue;
            }

            if (InputUtil.isKeyPressed(handle, boundKey.getKeyCode())) {
                return pair.getValue();
            }
        }
        return null;
    }

    public static void scroll(int[] indices, int direction) {
        if (direction > 0) {
            for (int i = indices.length - 1; i > 0; --i) {
                int targetI = i - 1;
                int tmp = indices[i];
                indices[i] = indices[targetI];
                indices[targetI] = tmp;
            }
        } else if (direction < 0) {
            for (int i = 0; i < indices.length - 1; ++i) {
                int targetI = i + 1;
                int tmp = indices[i];
                indices[i] = indices[targetI];
                indices[targetI] = tmp;
            }
        }
    }

    public static void scroll(SlotSwapper swapper, int columns, int rows, int selectedSlot, int direction, ScrollableInventory.ScrollType scrollType) {
        if (scrollType.isRow()) {
            ScrollUtil.scrollRow(swapper, columns, rows, selectedSlot, direction, scrollType.isInSelected());
        } else if (scrollType.isColumn()) {
            ScrollUtil.scrollColumn(swapper, columns, rows, direction, scrollType.isInSelected());
        }
    }

    private static void scrollRow(SlotSwapper swapper, int columns, int rows, int selectedSlot, int direction, boolean isInSelected) {
        int cStart = isInSelected ? selectedSlot : 0;
        int cEnd = isInSelected ? selectedSlot + 1 : columns;
        if (direction < 0) {
            for (int rI = 1; rI < rows; ++rI) {
                for (int cI = cStart; cI < cEnd; ++cI) {
                    int slotId = cI + rI * columns;
                    swapper.swap(slotId, cI);
                }
            }
        } else if (direction > 0) {
            for (int rI = rows - 1; rI > 0; --rI) {
                for (int cI = cStart; cI < cEnd; ++cI) {
                    int slotId = cI + rI * columns;
                    swapper.swap(slotId, cI);
                }
            }
        }
    }

    private static void scrollColumn(SlotSwapper swapper, int columns, int rows, int direction, boolean isInSelected) {
        if (direction > 0) {
            for (int cI = 0; cI < columns; ++cI) {
                swapper.swap((cI == columns - 1) ? columns : (cI + 1 + columns), cI);
            }

            for (int cI = 0; cI < columns; ++cI) {
                swapper.swap(cI + columns, cI);
            }

            for (int cI = columns - 1; cI > 0; --cI) {
                swapper.swap(cI + columns, cI - 1 + columns);
            }

            if (!isInSelected) {
                for (int rI = 1; rI < rows; ++rI) {
                    for (int cI = columns - 1; cI > 0; --cI) {
                        int slotId = cI + rI * columns;
                        int targetSlotId = (cI - 1) + rI * columns;
                        swapper.swap(slotId, targetSlotId);
                    }
                }
            }
        } else if (direction < 0) {
            for (int cI = columns - 1; cI >= 0; --cI) {
                swapper.swap(cI == 0 ? (2 * columns - 1) : (cI - 1 + columns), cI);
            }

            for (int cI = columns - 1; cI >= 0; --cI) {
                swapper.swap(cI + columns, cI);
            }

            for (int cI = 0; cI < columns - 1; ++cI) {
                swapper.swap(cI + columns, cI + 1 + columns);
            }

            if (!isInSelected) {
                for (int rI = 1; rI < rows; ++rI) {
                    for (int cI = 0; cI < columns - 1; ++cI) {
                        int slotId = cI + rI * columns;
                        int targetSlotId = (cI + 1) + rI * columns;
                        swapper.swap(slotId, targetSlotId);
                    }
                }
            }
        }
    }

    static {
        MODIFIERS = new HashMap<>();
        MODIFIERS.put(ShiftyHotbarKeyBindings.ROW_MODIFIER, ScrollableInventory.ScrollType.ROW);
        MODIFIERS.put(ShiftyHotbarKeyBindings.COLUMN_MODIFIER, ScrollableInventory.ScrollType.COLUMN);
        MODIFIERS.put(ShiftyHotbarKeyBindings.ROW_IN_SELECTED_COLUMN_MODIFIER, ScrollableInventory.ScrollType.ROW_IN_SELECTED_COLUMN);
        MODIFIERS.put(ShiftyHotbarKeyBindings.COLUMN_IN_SELECTED_ROW_MODIFIER, ScrollableInventory.ScrollType.COLUMN_IN_SELECTED_ROW);
    }
}

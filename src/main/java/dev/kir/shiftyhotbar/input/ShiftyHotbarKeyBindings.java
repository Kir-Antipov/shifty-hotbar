package dev.kir.shiftyhotbar.input;

import dev.kir.shiftyhotbar.ShiftyHotbar;
import dev.kir.shiftyhotbar.api.ScrollableInventory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public final class ShiftyHotbarKeyBindings {
    private static final String CATEGORY = "key.categories." + ShiftyHotbar.MOD_ID;
    private static final String KEY_PATH = "key." + ShiftyHotbar.MOD_ID + ".";

    public static final KeyBinding ROW_MODIFIER;
    public static final KeyBinding COLUMN_MODIFIER;
    public static final KeyBinding ROW_IN_SELECTED_COLUMN_MODIFIER;
    public static final KeyBinding COLUMN_IN_SELECTED_ROW_MODIFIER;

    public static final KeyBinding PREVIOUS_ROW;
    public static final KeyBinding PREVIOUS_COLUMN;
    public static final KeyBinding PREVIOUS_ROW_IN_SELECTED_COLUMN;
    public static final KeyBinding PREVIOUS_COLUMN_IN_SELECTED_ROW;

    public static final KeyBinding NEXT_ROW;
    public static final KeyBinding NEXT_COLUMN;
    public static final KeyBinding NEXT_ROW_IN_SELECTED_COLUMN;
    public static final KeyBinding NEXT_COLUMN_IN_SELECTED_ROW;

    static {
        ROW_MODIFIER = register("row_modifier", GLFW.GLFW_KEY_LEFT_ALT);
        PREVIOUS_ROW = register("previous_row", GLFW.GLFW_KEY_DOWN, scroll(1, ScrollableInventory.ScrollType.ROW));
        NEXT_ROW = register("next_row", GLFW.GLFW_KEY_UP, scroll(-1, ScrollableInventory.ScrollType.ROW));

        ROW_IN_SELECTED_COLUMN_MODIFIER = register("row_in_selected_column_modifier", GLFW.GLFW_KEY_UNKNOWN);
        PREVIOUS_ROW_IN_SELECTED_COLUMN = register("previous_row_in_selected_column", GLFW.GLFW_KEY_UNKNOWN, scroll(1, ScrollableInventory.ScrollType.ROW_IN_SELECTED_COLUMN));
        NEXT_ROW_IN_SELECTED_COLUMN = register("next_row_in_selected_column", GLFW.GLFW_KEY_UNKNOWN, scroll(-1, ScrollableInventory.ScrollType.ROW_IN_SELECTED_COLUMN));

        COLUMN_MODIFIER = register("column_modifier", GLFW.GLFW_KEY_UNKNOWN);
        PREVIOUS_COLUMN = register("previous_column", GLFW.GLFW_KEY_LEFT, scroll(1, ScrollableInventory.ScrollType.COLUMN));
        NEXT_COLUMN = register("next_column", GLFW.GLFW_KEY_RIGHT, scroll(-1, ScrollableInventory.ScrollType.COLUMN));

        COLUMN_IN_SELECTED_ROW_MODIFIER = register("column_in_selected_row_modifier", GLFW.GLFW_KEY_UNKNOWN);
        PREVIOUS_COLUMN_IN_SELECTED_ROW = register("previous_column_in_selected_row", GLFW.GLFW_KEY_UNKNOWN, scroll(1, ScrollableInventory.ScrollType.COLUMN_IN_SELECTED_ROW));
        NEXT_COLUMN_IN_SELECTED_ROW = register("next_column_in_selected_row", GLFW.GLFW_KEY_UNKNOWN, scroll(-1, ScrollableInventory.ScrollType.COLUMN_IN_SELECTED_ROW));
    }

    private static KeyBinding register(String name, int code) {
        return register(new KeyBinding(KEY_PATH + name, code, CATEGORY));
    }

    private static KeyBinding register(String name, int code, Runnable action) {
        return register(InvokableKeyBinding.create(KEY_PATH + name, code, CATEGORY, action));
    }

    private static KeyBinding register(KeyBinding keyBinding) {
        return KeyBindingHelper.registerKeyBinding(keyBinding);
    }

    private static Runnable scroll(double scrollAmount, ScrollableInventory.ScrollType scrollType) {
        return () -> {
            ScrollableInventory inventory = ScrollableInventory.getInstance();
            if (inventory == null) {
                return;
            }

            inventory.scroll(scrollAmount, scrollType);
        };
    }

    public static void initClient() { }
}

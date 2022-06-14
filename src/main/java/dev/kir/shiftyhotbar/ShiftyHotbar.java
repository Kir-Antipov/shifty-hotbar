package dev.kir.shiftyhotbar;

import dev.kir.shiftyhotbar.config.ShiftyHotbarConfig;
import dev.kir.shiftyhotbar.input.ShiftyHotbarKeyBindings;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class ShiftyHotbar implements ClientModInitializer {
    public static final String MOD_ID = "shifty_hotbar";
    private static final ShiftyHotbarConfig CONFIG = ShiftyHotbarConfig.resolve();

    public static ShiftyHotbarConfig getConfig() {
        return CONFIG;
    }

    @Override
    public void onInitializeClient() {
        ShiftyHotbarKeyBindings.initClient();
    }
}

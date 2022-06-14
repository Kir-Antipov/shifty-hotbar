package dev.kir.shiftyhotbar.config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public interface ShiftyHotbarConfig {
    static ShiftyHotbarConfig resolve() {
        return new ShiftyHotbarConfig() { };
    }

    default boolean invertRowScroll() {
        return false;
    }

    default boolean invertColumnScroll() {
        return false;
    }
}

package dev.kir.shiftyhotbar.config;

import dev.kir.shiftyhotbar.compat.cloth.ShiftyHotbarClothConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public interface ShiftyHotbarConfig {
    static ShiftyHotbarConfig resolve() {
        return FabricLoader.getInstance().isModLoaded("cloth-config") || FabricLoader.getInstance().isModLoaded("cloth-config2") ? ShiftyHotbarClothConfig.getInstance() : new ShiftyHotbarConfig() { };
    }

    default boolean invertRowScroll() {
        return false;
    }

    default boolean invertColumnScroll() {
        return false;
    }
}

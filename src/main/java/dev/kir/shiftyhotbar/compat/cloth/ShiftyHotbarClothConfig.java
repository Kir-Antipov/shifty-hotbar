package dev.kir.shiftyhotbar.compat.cloth;

import dev.kir.shiftyhotbar.ShiftyHotbar;
import dev.kir.shiftyhotbar.config.ShiftyHotbarConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Config(name = ShiftyHotbar.MOD_ID)
public final class ShiftyHotbarClothConfig implements ShiftyHotbarConfig, ConfigData {
    @ConfigEntry.Gui.Excluded
    private static final ShiftyHotbarClothConfig INSTANCE;

    public static ShiftyHotbarClothConfig getInstance() {
        return INSTANCE;
    }

    private ShiftyHotbarClothConfig () { }

    public boolean invertRowScroll = ShiftyHotbarConfig.super.invertRowScroll();

    public boolean invertColumnScroll = ShiftyHotbarConfig.super.invertColumnScroll();

    @Override
    public boolean invertRowScroll() {
        return this.invertRowScroll;
    }

    @Override
    public boolean invertColumnScroll() {
        return this.invertColumnScroll;
    }

    static {
        INSTANCE = AutoConfig.register(ShiftyHotbarClothConfig.class, GsonConfigSerializer::new).getConfig();
    }
}

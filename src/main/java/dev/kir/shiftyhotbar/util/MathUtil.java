package dev.kir.shiftyhotbar.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class MathUtil {
    public static double absMin(double a, double b) {
        return Math.abs(a) < Math.abs(b) ? a : b;
    }
}

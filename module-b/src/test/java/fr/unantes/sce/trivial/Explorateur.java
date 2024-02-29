package fr.unantes.sce.trivial;

import java.lang.reflect.Field;

public class Explorateur {
    public static Object getField(Object var0, String var1) {
        Object var2 = null;
        Class var3 = var0.getClass();

        try {
            Field var12;
            (var12 = var3.getDeclaredField(var1)).setAccessible(true);
            var2 = var12.get(var0);
        } catch (NoSuchFieldException var8) {
            var8.printStackTrace();
        } catch (IllegalArgumentException var9) {
            var9.printStackTrace();
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        } finally {
            ;
        }

        return var2;
    }
}
package top.shjibi.utilities.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.craftbukkit.v1_19_R2.inventory.CraftItemStack.asNMSCopy;
import static top.shjibi.plugineer.util.NMSUtil.getNMClass;


public final class ItemUtil {

    private ItemUtil() {}

    /** 广播物品信息 */
    public static void broadcastItemInfo(Player p, ItemStack item) {
        broadcastItemInfo(p, "", item, "");
    }

    /** 广播物品信息 */
    public static void broadcastItemInfo(Player p, ItemStack item, String suffix) {
        broadcastItemInfo(p, "", item, suffix);
    }

    /** 广播物品信息 */
    public static void broadcastItemInfo(Player p, String prefix, ItemStack item) {
        broadcastItemInfo(p, prefix, item, "");
    }

    /** 广播物品信息 */
    public static void broadcastItemInfo(Player p, String prefix, ItemStack item, String suffix) {
        try {
            Object nmsCopy = asNMSCopy(item);
            Class<?> itemStackClass = nmsCopy.getClass();
            Class<?> baseComponentClass = getNMClass("network.chat.IChatBaseComponent");
            Class<?> mutableClass = getNMClass("network.chat.IChatMutableComponent");

            Object displayName = itemStackClass.getMethod("I").invoke(nmsCopy);
            Object literal = baseComponentClass.getMethod("b", String.class).invoke(null, prefix);
            mutableClass.getMethod("b", baseComponentClass).invoke(literal, displayName);
            mutableClass.getMethod("f", String.class).invoke(literal, suffix);

            Object entityPlayer = p.getClass().getMethod("getHandle").invoke(p);
            Class<?> entityPlayerClass = entityPlayer.getClass();
            entityPlayerClass.getMethod("a", baseComponentClass).invoke(entityPlayer, literal);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("无法广播物品信息");
        }
    }

}

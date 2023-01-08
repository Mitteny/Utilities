package top.shjibi.utilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import top.shjibi.plugineer.command.base.CommandInfo;
import top.shjibi.plugineer.command.base.PlayerCommand;

import static top.shjibi.plugineer.util.StringUtil.color;
import static top.shjibi.utilities.util.ItemUtil.broadcastItemInfo;

@CommandInfo(name = "showoff")
public final class CommandShowoff extends PlayerCommand {

    public CommandShowoff(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void execute(@NotNull Player p, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getType().isAir()) {
            p.sendMessage(color("&c你的手上没有物品"));
            return;
        }

        int amount = item.getAmount();

        if (args.length >= 1 ) {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                p.sendMessage(color("&c该玩家不存在"));
            } else {
                broadcastItemInfo(target, color("&6" + p.getName() + "&a向你展示了他的 "), item, amount > 1 ? " x " + amount : "");
                p.sendMessage(color("&a已向&6" + target.getName() + "&a展示你手上的物品"));
            }
        } else {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                broadcastItemInfo(pl, color("&6" + p.getName() + "&a向全服展示了他的 "), item, amount > 1 ? " x " + amount : "");
            }
        }


    }
}

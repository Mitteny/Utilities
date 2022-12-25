package top.shjibi.utilities.commands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import top.shjibi.utilities.Main;
import top.shjibi.utilities.base.PlayerCommandHandler;

import java.util.Collections;
import java.util.List;

import static top.shjibi.utilities.util.NMSUtil.broadcastItemInfo;
import static top.shjibi.utilities.util.StringUtil.color;

public final class CommandShowoff extends PlayerCommandHandler {

    public CommandShowoff() {
        super(Main.getInstance(), "showoff", 0, null);
    }

    @Override
    protected void execute(Player p, Command command, String label, String[] args) {
        ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getType().isAir()) {
            p.sendMessage(color("&c你的手上没有物品"));
            return;
        }

        int amount = item.getAmount();
        broadcastItemInfo(p, color("&6" + p.getName() + "&a展示了他的 "), item, amount > 1 ? " x" + amount : "");
    }

    @Override
    public List<String> completeTab(Player sender, Command command, String label, String[] args) {
        return Collections.emptyList();
    }
}

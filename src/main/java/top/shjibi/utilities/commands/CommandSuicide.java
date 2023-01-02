package top.shjibi.utilities.commands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import top.shjibi.plugineer.command.base.CommandInfo;
import top.shjibi.plugineer.command.base.PlayerCommand;

@CommandInfo(name = "suicide")
public final class CommandSuicide extends PlayerCommand {

    public CommandSuicide(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void execute(@NotNull Player sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.setHealth(0);
    }
}
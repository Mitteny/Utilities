package top.shjibi.utilities.commands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import top.shjibi.utilities.Main;
import top.shjibi.utilities.base.PlayerCommandHandler;

import java.util.Collections;
import java.util.List;

public class CommandSuicide extends PlayerCommandHandler {

    public CommandSuicide() {
        super(Main.getInstance(), "suicide", 0, null);
    }

    @Override
    protected void execute(Player sender, Command command, String label, String[] args) {
        sender.setHealth(0);
    }

    @Override
    public List<String> completeTab(Player sender, Command command, String label, String[] args) {
        return Collections.emptyList();
    }
}
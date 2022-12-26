package top.shjibi.utilities;

import org.bukkit.plugin.java.JavaPlugin;
import top.shjibi.plugineer.command.CommandManager;
import top.shjibi.utilities.commands.CommandShowoff;
import top.shjibi.utilities.commands.CommandSuicide;

public class Main extends JavaPlugin {

    /**
     * 唯一的实例
     */
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        CommandManager.newInstance(instance, CommandShowoff.class, CommandSuicide.class).register();
        getLogger().info("指令已注册~");
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("插件已关闭");
    }

    /**
     * 获取插件实例
     */
    public static JavaPlugin getInstance() {
        return instance;
    }

}

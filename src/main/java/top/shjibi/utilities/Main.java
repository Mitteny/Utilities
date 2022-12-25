package top.shjibi.utilities;

import org.bukkit.plugin.java.JavaPlugin;
import top.shjibi.utilities.util.CommandManager;

import java.util.Map;

public class Main extends JavaPlugin {

    /**
     * 唯一的实例
     */
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        CommandManager.registerHandlers();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    /**
     * 获取插件实例
     */
    public static JavaPlugin getInstance() {
        return instance;
    }

}

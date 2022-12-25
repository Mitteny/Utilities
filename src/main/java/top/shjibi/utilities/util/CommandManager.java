package top.shjibi.utilities.util;

import top.shjibi.utilities.Main;
import top.shjibi.utilities.base.BaseCommandHandler;
import top.shjibi.utilities.commands.CommandShowoff;
import top.shjibi.utilities.commands.CommandSuicide;

import java.util.logging.Level;

public final class CommandManager {

    private CommandManager() {
    }

    /**
     * 所有指令处理者的类
     */
    public static final Class<?>[] HANDLERS = {
            CommandSuicide.class, CommandShowoff.class
    };


    /**
     * 注册指令处理者(用BaseCommandHandler的register方法)
     */
    public static void registerHandlers() {
        for (Class<?> clazz : HANDLERS) {
            try {
                Object obj = clazz.getConstructor().newInstance();
                if (!(obj instanceof BaseCommandHandler handler)) return;
                handler.register();
            } catch (ReflectiveOperationException ignored) {
                Main.getInstance().getLogger().log(Level.SEVERE, "无法加载指令!");
            }
        }
    }

}

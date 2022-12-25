package top.shjibi.utilities.util;

import java.util.regex.Pattern;

public final class StringUtil {

    private StringUtil() {}

    private static final Pattern colorPattern = Pattern.compile("&([\\da-fk-orx])");
    private static final Pattern stripPattern = Pattern.compile("[&§]([\\da-fk-orx])");

    /** 给消息染色 */
    public static String color(String s) {
        return colorPattern.matcher(s).replaceAll("§$1");
    }

    /** 去掉消息的颜色 */
    public static String strip(String s) {
        return stripPattern.matcher(s).replaceAll("");
    }

}

package com.drylands.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

public class ColorUtil {

    public static @NotNull Component colorize(String message) {
        return supportLegacyFormats(message);
    }

    private static @NotNull Component supportLegacyFormats(String message) {
        message = message.replaceAll("&", "§");
        message = message.replaceAll("§0", "<black>");
        message = message.replaceAll("§1", "<dark_blue>");
        message = message.replaceAll("§2", "<dark_green>");
        message = message.replaceAll("§3", "<dark_auqa>");
        message = message.replaceAll("§4", "<dark_red>");
        message = message.replaceAll("§5", "<dark_purple>");
        message = message.replaceAll("§6", "<gold>");
        message = message.replaceAll("§7", "<gray>");
        message = message.replaceAll("§8", "<dark_gray>");
        message = message.replaceAll("§9", "<blue>");
        message = message.replaceAll("§a", "<green>");
        message = message.replaceAll("§b", "<auqa>");
        message = message.replaceAll("§c", "<red>");
        message = message.replaceAll("§d", "<light_purple>");
        message = message.replaceAll("§e", "<yellow>");
        message = message.replaceAll("§f", "<white>");
        message = message.replaceAll("§k", "<obf>");
        message = message.replaceAll("§l", "<b>");
        message = message.replaceAll("§m", "<st>");
        message = message.replaceAll("§n", "<u>");
        message = message.replaceAll("§o", "<i>");
        message = message.replaceAll("§r", "<r>");
        message = message.replaceAll("&(#[0-9a-f]{6})", "<$1>");

        return MiniMessage.miniMessage().deserialize(message);
    }

}

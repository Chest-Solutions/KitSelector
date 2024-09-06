package com.drylands;

import de.tr7zw.changeme.nbtapi.NBT;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.drylands.commands.KitCommand;
import com.drylands.util.ColorUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public final class Starter extends JavaPlugin {

    private static Plugin instance;


    public static void setInstance(Starter instance) {
        Starter.instance = instance;
    }

    @Override
    public void onEnable() {
        NBT.preloadApi();
        setInstance((Starter) getServer().getPluginManager().getPlugin("KitSelector"));
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("kit")).setExecutor(new KitCommand());
        this.saveDefaultConfig();
    }

    public static Starter getInstance() {
        return (Starter) instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @NotNull
    public static TextComponent colorize(String message) {
        return (TextComponent) ColorUtil.colorize(message);
    }
}

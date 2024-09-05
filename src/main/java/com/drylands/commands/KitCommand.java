package com.drylands.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import com.drylands.inventory.KitSelector;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            KitSelector.KitSelectInv(player);
        }
        return true;
    }
}
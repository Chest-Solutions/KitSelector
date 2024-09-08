package com.drylands.inventory;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class Kit1 implements Listener, InventoryHolder {
    private Inventory inventory;

    public static void FirstKitInventory(Player player) {
        new KitSelector().OpenKitInv(player);
    }

    public void OpenKitInv(@NotNull Player player) {
        player.setGameMode(GameMode.CREATIVE);
        this.inventory = player.getInventory();
    }
    @EventHandler
    public void onInventoryClose(@NotNull final InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (this.inventory != player.getInventory()) {
            return;
        }
        player.setGameMode(GameMode.SURVIVAL);

    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return this.inventory;
    }
}

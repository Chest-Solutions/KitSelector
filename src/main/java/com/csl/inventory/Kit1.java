package com.csl.inventory;

import com.csl.util.ColorUtil;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Material.LIME_DYE;

public class Kit1 implements Listener, InventoryHolder {
    private Inventory inventory;

    public static void FirstKitInventory(Player player) {
        new Kit1().OpenKitInv(player);
    }

    public void OpenKitInv(@NotNull Player player) {
        ItemStack confirm = new ItemStack(LIME_DYE);
        confirm.editMeta(meta -> meta.displayName(ColorUtil.colorize("<green>" + "Confirm")));
        player.setGameMode(GameMode.CREATIVE);
        this.inventory = player.getInventory();
        player.closeInventory();
        player.openInventory(this.inventory);
        this.inventory.setItem(1, confirm);
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

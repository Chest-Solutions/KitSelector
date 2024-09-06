package com.drylands.inventory;

import com.drylands.Starter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitSelector {
    int inventorySize = 3 * 9;

    Inventory kitInventory;

    public KitSelector() {
        // Construction started
        FileConfiguration config = Starter.getInstance().getConfig();
        String inventoryName = config.getString("kit-selection-name");
        kitInventory = Bukkit.createInventory(null, inventorySize, Starter.colorize(inventoryName));
        ItemStack NetherStar = new ItemStack(Material.NETHER_STAR);
        String ItemName = config.getString("item-name");
        NetherStar.editMeta(meta -> meta.displayName(Starter.colorize("<white>" + ItemName)));
        kitInventory.setItem(10, NetherStar);
        kitInventory.setItem(13, NetherStar);
        kitInventory.setItem(16, NetherStar);

    }

    public static void KitSelectInv(Player player) {
        new KitSelector().OpenKitInv(player);
    }

    public void OpenKitInv(Player player) {
        player.openInventory(kitInventory);
    }

}
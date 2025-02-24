package com.csl.inventory;

import com.csl.Starter;
import com.csl.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KitSelector implements Listener, InventoryHolder {
    int inventorySize = 3 * 9;
    private final Inventory inventory;


    public KitSelector() {
        // Construction started
        FileConfiguration config = Starter.getInstance().getConfig();
        String inventoryName = config.getString("kit-selection-name");
        String ItemName = config.getString("kit-names");
        inventory = Bukkit.createInventory(this, inventorySize, ColorUtil.colorize(inventoryName));
        // KIT 1
        ItemStack NetherStar1 = new ItemStack(Material.NETHER_STAR);
        NetherStar1.editMeta(meta -> {
            assert ItemName != null;
            meta.displayName(ColorUtil.colorize("<white>" + ItemName.replaceAll("%num%", "1")));
        });
        // KIT 2
        ItemStack NetherStar2 = new ItemStack(Material.NETHER_STAR);
        NetherStar2.editMeta(meta -> {
            assert ItemName != null;
            meta.displayName(ColorUtil.colorize("<white>" + ItemName.replaceAll("%num%", "2")));
        });
        //KIT 3
        ItemStack NetherStar3 = new ItemStack(Material.NETHER_STAR);
        NetherStar3.editMeta(meta -> {
            assert ItemName != null;
            meta.displayName(ColorUtil.colorize("<white>" + ItemName.replaceAll("%num%", "3")));
        });
        this.inventory.setItem(10, NetherStar1);
        this.inventory.setItem(13, NetherStar2);
        this.inventory.setItem(16, NetherStar3);

    }

    public static void KitSelectInv(Player player) {
        new KitSelector().OpenKitInv(player);
    }

    public void OpenKitInv(@NotNull Player player) {
        player.openInventory(this.inventory);
    }
    @EventHandler
    public void onInventoryClick(@NotNull InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();

        if (!(inventory.getHolder(false) instanceof KitSelector)) {
            return;
        }

        event.setCancelled(true);

        if (event.getRawSlot() == 10) {
            Kit1.FirstKitInventory(player);
        }

        if (event.getRawSlot() == 13) {
            //open second inventory gui
        }

        if (event.getRawSlot() == 16) {
            //open third inventory gui
        }



    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return this.inventory;
    }
}
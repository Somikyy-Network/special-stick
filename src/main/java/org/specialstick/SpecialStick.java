package org.specialstick;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public final class SpecialStick extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("MyMinecraftPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("MyMinecraftPlugin has been disabled.");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() == Material.STICK) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 1));
            launchLeafBall(player);
        }
    }

    private void launchLeafBall(Player player) {
        Vector direction = player.getLocation().getDirection().normalize();
        LeafBall leafBall = new LeafBall(this, player.getLocation(), direction);
        leafBall.start();
    }
}

package org.specialstick;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class LeafBall extends BukkitRunnable {
    private final SpecialStick plugin;
    private final Location location;
    private final Vector direction;
    private final World world;
    private final Random random;
    private int distanceTraveled;

    public LeafBall(SpecialStick plugin, Location location, Vector direction) {
        this.plugin = plugin;
        this.location = location;
        this.direction = direction;
        this.world = location.getWorld();
        this.random = new Random();
        this.distanceTraveled = 0;
    }

    @Override
    public void run() {
        if (distanceTraveled > random.nextInt(13) + 3) {
            createDome(location);
            cancel();
            return;
        }

        location.add(direction);
        world.spawnParticle(Particle.VILLAGER_HAPPY, location, 10, 0.2, 0.2, 0.2, 0.05);
        distanceTraveled++;
    }

    public void start() {
        this.runTaskTimer(plugin, 0, 1);
    }

    private void createDome(Location center) {
        int radius = random.nextInt(4) + 3;
        DomeCreator.createLeafDome(center, radius);
    }
}


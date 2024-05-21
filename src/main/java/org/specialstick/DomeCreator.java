package org.specialstick;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class DomeCreator {
    public static void createLeafDome(Location center, int radius) {
        World world = center.getWorld();
        int cx = center.getBlockX();
        int cy = center.getBlockY();
        int cz = center.getBlockZ();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + y * y + z * z <= radius * radius) {
                        world.getBlockAt(cx + x, cy + y, cz + z).setType(Material.OAK_LEAVES);
                    }
                }
            }
        }

        world.getBlockAt(cx, cy, cz).setType(Material.OAK_LOG);
    }
}
package com.qezy.qezymob.models;

import net.minecraft.server.v1_16_R3.*;

import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import org.bukkit.Location;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.PolarBear;
import net.minecraft.server.v1_16_R3.WorldServer;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityPolarBear;



public class PolarMain extends EntityPolarBear {
    public PolarMain(Location loc) {
        super(EntityTypes.POLAR_BEAR, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());

        this.setHealth(700);
        this.setAbsorptionHearts(5);
        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(
                ChatColor.translateAlternateColorCodes('&', "&b&o&lqezy Polar Bear")));

    }

    public void initPathfinder() {
        super.initPathfinder();
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<EntityHuman>(
                this, EntityHuman.class, true));
        this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<PolarMain>(
                this, PolarMain.class, false));

    }

    private void t (Location loc) {
        WorldServer world = ((CraftWorld) loc.getWorld()).getHandle();

    }

}


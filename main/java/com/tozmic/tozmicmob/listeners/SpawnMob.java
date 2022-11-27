package com.qezy.qezymob.listeners;

import com.qezy.qezymob.models.PolarMain;

import net.minecraft.server.v1_16_R3.WorldServer;

import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Animals;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import org.bukkit.Bukkit;

import java.util.Random;

public class SpawnMob implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){
        Random rand = new Random();
        if (!(event.getEntity() instanceof Animals)) //uses instance of animals to spawn
            return;
        if(event.getLocation().getBlock().isLiquid()) //prevents spawning in water
            return;
        if(!(event.getLocation().getBlock().isPassable())) //prevents spawning inside a block
            return;
        //if((int) (Math.random() * 10) == 1) {
        int  n = rand.nextInt(100) + 1; //chance for rate that the entity spawns in the world
        if (n<=5){
            event.setCancelled(true);
            PolarMain bear = new PolarMain(event.getLocation());
            WorldServer world = ((CraftWorld)event.getLocation().getWorld()).getHandle();
            world.addEntity(bear);
            //Bukkit.broadcastMessage("" + event.getLocation()); //sends location of polar bear
        }


    }
}

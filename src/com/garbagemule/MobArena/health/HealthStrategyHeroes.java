package com.garbagemule.MobArena.health;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class HealthStrategyHeroes implements HealthStrategy
{
    @Override
    public void setHealth(Player p, double health) {
        double current = p.getHealth();
        double regain  = health == p.getMaxHealth() ? p.getMaxHealth() : health - current;
        
        try {
            EntityRegainHealthEvent event = new EntityRegainHealthEvent(p, regain, RegainReason.CUSTOM);
            Bukkit.getPluginManager().callEvent(event);
        }
        catch (Exception e) {} // Because Bukkit is retarded.
    }
}

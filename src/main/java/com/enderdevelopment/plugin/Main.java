package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.Location;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AICombatPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AICombatPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("spawnbot")) {
            spawnBot(player);
            return true;
        } else if (command.getName().equalsIgnoreCase("spawnarmy")) {
            spawnArmy(player);
            return true;
        }

        return false;
    }

    private void spawnBot(Player player) {
        Location loc = player.getLocation();
        Zombie bot = player.getWorld().spawn(loc, Zombie.class);
        bot.setCustomName("AI Bot");
        bot.setCustomNameVisible(true);
        player.sendMessage("An AI bot has been spawned!");
    }

    private void spawnArmy(Player player) {
        Location loc = player.getLocation();
        for (int i = 0; i < 10; i++) {
            Zombie bot = player.getWorld().spawn(loc, Zombie.class);            bot.setCustomName("AI Bot");
            bot.setCustomNameVisible(true);
        }
        player.sendMessage("An AI army has been spawned!");
    }
}
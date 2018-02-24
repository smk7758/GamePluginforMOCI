package com.github.smk7758.GamePluginforMOCI;

import java.util.logging.Level;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class GameListener implements Listener {
	private Main main = null;

	public GameListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerPutBlock(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Block placed_block = event.getBlockPlaced();

		SendLog.debug("Player: " + player.getName() + " has putted a block.");
		SendLog.getLogger().log(Level.FINE, "Block: " + placed_block.getLocation().toVector().toString());

		@SuppressWarnings("unused")
		BukkitTask task = new BukkitRunnable() {
			@Override
			public void run() {
				placed_block.breakNaturally();
			}
		}.runTaskLater(main, 60 * 20);
	}

	@EventHandler
	public void onPlayerAttackEntitiy(EntityDamageByEntityEvent event) {
		Entity attacker_ = event.getDamager();
		Entity damager_ = event.getEntity();
		if (!(attacker_ instanceof Player && damager_ instanceof Player)) return;
		Player attacker = (Player) attacker_;
		Player damager = (Player) damager_;
		if (attacker.getItemInHand().getType().equals(Material.DIAMOND_AXE)) {
			damager.getWorld().strikeLightning(damager.getLocation());
		}
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		ItemStack apple = new ItemStack(Material.APPLE, 1), golden = new ItemStack(Material.GOLD_INGOT, 8);
		dropItem(player, apple);
		dropItem(player, golden);
	}

	private void dropItem(Player player, ItemStack itemstack) {
		player.getWorld().dropItemNaturally(player.getLocation(), itemstack);
	}
}

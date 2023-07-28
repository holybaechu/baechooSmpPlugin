package org.holybaechu.baechoosmpplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class BaechooSmpPlugin extends JavaPlugin implements Listener {
    static void givePlayerEffects(Player player){
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.NIGHT_VISION,
                PotionEffect.INFINITE_DURATION,
                255
        ));
        player.addPotionEffect(new PotionEffect(
                PotionEffectType.SATURATION,
                PotionEffect.INFINITE_DURATION,
                255
        ));
    }

    @Override
    public void onEnable() {
        getLogger().info("Baechoo SMP Plugin Started!");

            getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().sendMessage("배추 SMP에 오신 것을 환영합니다!");
        event.getPlayer().sendMessage("본 서버는 정해진 규칙이 없는 자유 서버입니다.");

        givePlayerEffects(event.getPlayer());
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){

        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
        {
            public void run()
            {
                getLogger().info("Baechoo SMP Plugin Started!");
                givePlayerEffects(event.getPlayer());
            }
        }, 10);
    }
}

package org.zeppelin.manyheads;

import org.bukkit.plugin.java.JavaPlugin;

public final class Manyheads extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Loading ManyHeads");
        this.getCommand("head").setExecutor(new HeadGUI());
    }
}

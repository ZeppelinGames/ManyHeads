package org.zeppelin.manyheads;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class HeadGUI implements Listener, CommandExecutor {
    private Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        System.out.println(player.getPlayerProfile().getName());

        inv = Bukkit.createInventory(null, 9, "Heads");

        //Custom texture head from https://minecraft-heads.com/custom-heads/animals/53053-chicken
        inv.setItem(0, CreateCustomHead("ca3582ce4889333dad329e4e24372a03a5daa2c34280c56256af5283edb043f8"));

        //Custom texture head from https://minecraft-heads.com/custom-heads/monsters/52974-bulbasaur-1 with custom name
        inv.setItem(1, CreateCustomHead("f783c36f5153808a0f58e9bb0e8803f0aec1f0be8e1f0107f8d93623228884fc", "Bulbasaur"));

        //Get the player who ran the command's head
        inv.setItem(2,CreatePlayerHead(player.getPlayerProfile().getName()));

        //Get player head via username
        inv.setItem(3, CreatePlayerHead("ZeppelinGames"));

        player.openInventory(inv);
        return true;
    }

    private ItemStack CreateCustomHead(String id) { return CreateCustomHead(id, ""); }
    private ItemStack CreateCustomHead(String id, String name) {
        ItemStack customHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) customHead.getItemMeta();

        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID(), name);
        PlayerTextures texture = profile.getTextures();

        try {
            texture.setSkin(new URL("http://textures.minecraft.net/texture/" + id));
        } catch (MalformedURLException e) {
            System.out.println("Couldn't get texture");
        }

        profile.setTextures(texture);

        meta.setOwnerProfile(profile);

        customHead.setItemMeta(meta);
        return customHead;
    }

    private ItemStack CreatePlayerHead(String playerName) {
        ItemStack customHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) customHead.getItemMeta();

        meta.setOwnerProfile(Bukkit.createPlayerProfile(playerName));

        customHead.setItemMeta(meta);
        return customHead;
    }
}

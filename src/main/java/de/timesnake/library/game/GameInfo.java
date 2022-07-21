package de.timesnake.library.game;

import de.timesnake.database.util.game.DbGameInfo;
import de.timesnake.database.util.object.Type;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {

    protected DbGameInfo database;

    protected String name;
    protected String displayName;
    protected ChatColor chatColor;
    protected Integer maxPlayers;
    protected String headLine;
    protected ItemStack item;
    protected Integer slot;
    protected Type.Availability mapAvailability;
    protected Type.Availability kitAvailability;
    protected String texturePackLink;

    public GameInfo(DbGameInfo game) {
        this.database = game.toDatabase();
        this.loadFromDatabase(game.toLocal());
    }

    protected void loadFromDatabase(DbGameInfo game) {
        this.name = game.getName();
        this.displayName = game.getDisplayName();

        String chatColorName = game.getChatColorName();

        this.chatColor = ChatColor.valueOf(chatColorName.toUpperCase());

        this.maxPlayers = game.getMaxPlayers();
        this.headLine = game.getHeadLine();

        this.slot = game.getSlot();
        this.texturePackLink = game.getTexturePackLink();

        String materialName = game.getItemName().toUpperCase();

        this.item = new ItemStack(Material.getMaterial(materialName));
        ItemMeta meta = this.item.getItemMeta();

        //displayName
        meta.setDisplayName(ChatColor.valueOf(chatColorName.toUpperCase()) + displayName);

        //headLine
        this.headLine = game.getHeadLine();
        if (headLine != null) {
            List<String> lore = new ArrayList<>();
            lore.add("");
            for (String lorePart : headLine.split("\n")) {
                lore.add("§f" + lorePart);
            }
            meta.setLore(lore);
        }

        this.item.setItemMeta(meta);
        //slot
        Integer slot = game.getSlot();
        if (slot != null) {
            this.slot = slot;
        }

        this.mapAvailability = game.getMapAvailability();
        this.kitAvailability = game.getKitAvailability();
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public String getHeadLine() {
        return headLine;
    }

    public ItemStack getItem() {
        return item;
    }

    public Integer getSlot() {
        return slot;
    }


    public DbGameInfo getDatabase() {
        return database;
    }

    public Type.Availability getMapAvailability() {
        return mapAvailability;
    }

    public Type.Availability getKitAvailability() {
        return kitAvailability;
    }

    public String getTexturePackLink() {
        return this.texturePackLink;
    }

    public Boolean hasTexturePack() {
        return texturePackLink != null;
    }

}

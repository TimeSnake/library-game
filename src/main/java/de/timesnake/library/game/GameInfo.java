/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.game;

import de.timesnake.database.util.game.DbGameInfo;
import de.timesnake.library.basic.util.Availability;
import de.timesnake.library.chat.ExTextColor;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {

  protected DbGameInfo database;

  protected String name;
  protected String displayName;
  protected ExTextColor textColor;
  protected Integer maxPlayers;
  protected String headLine;
  protected ItemStack item;
  protected Integer slot;
  protected boolean enabled;
  protected Availability mapAvailability;
  protected Availability kitAvailability;
  protected String texturePackLink;
  protected String texturePackHash;
  protected Availability oldPvPAvailability;

  public GameInfo(DbGameInfo game) {
    this.database = game.toDatabase();
    this.loadFromDatabase(game.toLocal());
  }

  protected void loadFromDatabase(DbGameInfo game) {
    this.name = game.getName();
    this.displayName = game.getDisplayName();
    this.textColor = game.getTextColor();
    this.maxPlayers = game.getMaxPlayers();
    this.headLine = game.getHeadLine();

    this.slot = game.getSlot();
    this.enabled = game.isEnabled();
    this.texturePackLink = game.getTexturePackLink();
    this.texturePackHash = game.getTexturePackHash();
    this.oldPvPAvailability = game.getOldPvPAvailability();

    String materialName = game.getItemName().toUpperCase();

    this.item = new ItemStack(Material.getMaterial(materialName));
    ItemMeta meta = this.item.getItemMeta();

    //displayName
    meta.displayName(Component.text(displayName, this.textColor));

    //headLine
    this.headLine = game.getHeadLine();

    List<String> lore = new ArrayList<>();
    lore.add("");

    if (this.headLine != null) {
      for (String lorePart : headLine.split("\n")) {
        lore.add("§f" + lorePart);
      }
    }
    meta.setLore(lore);

    this.item.setItemMeta(meta);
    //slot
    this.slot = game.getSlot();

    this.mapAvailability = game.getMapAvailability();
    this.kitAvailability = game.getKitAvailability();
  }

  public String getName() {
    return name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public ExTextColor getTextColor() {
    return textColor;
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

  public boolean isEnabled() {
    return enabled;
  }

  public DbGameInfo getDatabase() {
    return database;
  }

  public Availability getMapAvailability() {
    return mapAvailability;
  }

  public Availability getKitAvailability() {
    return kitAvailability;
  }

  public String getTexturePackLink() {
    return this.texturePackLink;
  }

  public String getTexturePackHash() {
    return this.texturePackHash;
  }

  public Boolean hasTexturePack() {
    return texturePackLink != null;
  }

  public Availability getOldPvPAvailability() {
    return oldPvPAvailability;
  }
}

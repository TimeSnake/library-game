/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.game;

import de.timesnake.database.util.game.DbGameInfo;
import de.timesnake.database.util.game.DbTmpGameInfo;
import de.timesnake.library.basic.util.Availability;
import de.timesnake.library.basic.util.DiscordChannelType;

import java.util.List;

public class TmpGameInfo extends GameInfo {

  private Integer autoStartPlayerNumber;
  private Integer minPlayerNumber;
  private List<Integer> teamSizes;
  private Availability teamMerge;
  private boolean showSelectedKits;
  private boolean requireEqualTimeSize;
  private boolean hideTeams;
  private DiscordChannelType discordType;
  private List<String> description;

  public TmpGameInfo(DbTmpGameInfo game) {
    super(game);
  }

  @Override
  protected void loadFromDatabase(DbGameInfo game) {
    super.loadFromDatabase(game);
    DbTmpGameInfo tmpGame = ((DbTmpGameInfo) game);
    this.autoStartPlayerNumber = tmpGame.getAutoStartPlayerNumber();
    this.minPlayerNumber = tmpGame.getMinPlayerNumber();
    this.teamSizes = tmpGame.getTeamSizes();
    this.teamMerge = tmpGame.getTeamMergeAvailability();
    this.showSelectedKits = tmpGame.showSelectedKits();
    this.requireEqualTimeSize = tmpGame.isEqualTeamSizeRequired();
    this.hideTeams = tmpGame.hideTeams();
    this.discordType = tmpGame.getDiscordType();
    this.description = tmpGame.getDescription();
  }

  public Integer getAutoStartPlayerNumber() {
    return autoStartPlayerNumber;
  }

  public Integer getMinPlayerNumber() {
    return minPlayerNumber;
  }

  public List<Integer> getTeamSizes() {
    return teamSizes;
  }

  public Availability getTeamMerge() {
    return teamMerge;
  }

  public boolean showSelectedKits() {
    return showSelectedKits;
  }

  public boolean isEqualTimeSizeRequired() {
    return requireEqualTimeSize;
  }

  public boolean hideTeams() {
    return hideTeams;
  }

  public DiscordChannelType getDiscordType() {
    return discordType;
  }

  public List<String> getDescription() {
    return description;
  }
}

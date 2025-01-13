/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.game;

import de.timesnake.database.util.game.DbGameInfo;
import de.timesnake.database.util.game.DbNonTmpGameInfo;

public class NonTmpGameInfo extends GameInfo {

  private boolean creationRequestable;
  private boolean ownable;

  public NonTmpGameInfo(DbNonTmpGameInfo game) {
    super(game);
  }

  @Override
  protected void loadFromDatabase(DbGameInfo game) {
    super.loadFromDatabase(game);
    DbNonTmpGameInfo nonTmpGame = ((DbNonTmpGameInfo) game);
    this.creationRequestable = nonTmpGame.isCreationRequestable();
    this.ownable = nonTmpGame.isOwnable();
  }

  public boolean isCreationRequestable() {
    return creationRequestable;
  }

  public boolean isOwnable() {
    return ownable;
  }

}

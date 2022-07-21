package de.timesnake.library.game;

import de.timesnake.database.util.game.DbGameInfo;
import de.timesnake.database.util.game.DbNonTmpGameInfo;

public class NonTmpGameInfo extends GameInfo {

    private boolean generateable;
    private boolean allowAutoDelete;
    private boolean ownable;


    public NonTmpGameInfo(DbNonTmpGameInfo game) {
        super(game);
    }

    @Override
    protected void loadFromDatabase(DbGameInfo game) {
        super.loadFromDatabase(game);
        DbNonTmpGameInfo nonTmpGame = ((DbNonTmpGameInfo) game);
        this.generateable = nonTmpGame.isGenerateable();
        this.allowAutoDelete = nonTmpGame.isAutoDeleteAllowed();
        this.ownable = nonTmpGame.isOwnable();
    }

    public boolean isGenerateable() {
        return generateable;
    }

    public boolean isAutoDeleteAllowed() {
        return allowAutoDelete;
    }

    public boolean isOwnable() {
        return ownable;
    }

}

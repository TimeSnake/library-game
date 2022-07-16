package de.timesnake.library.game;

import de.timesnake.database.util.game.DbNonTmpGameInfo;

public class NonTmpGameInfo extends GameInfo {

    private final boolean generateable;
    private final boolean allowAutoDelete;
    private final boolean ownable;


    public NonTmpGameInfo(DbNonTmpGameInfo game) {
        super(game);
        this.generateable = game.isGenerateable();
        this.allowAutoDelete = game.isAutoDeleteAllowed();
        this.ownable = game.isOwnable();
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

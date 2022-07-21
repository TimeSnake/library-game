package de.timesnake.library.game;

import de.timesnake.database.util.game.DbGameInfo;
import de.timesnake.database.util.game.DbTmpGameInfo;
import de.timesnake.database.util.object.Type;

import java.util.List;

public class TmpGameInfo extends GameInfo {

    private Integer autoStartPlayerNumber;
    private Integer minPlayerNumber;
    private List<Integer> teamSizes;
    private Type.Availability teamMerge;
    private boolean requireEqualTimeSize;
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
        this.requireEqualTimeSize = tmpGame.isEqualTeamSizeRequired();
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

    public Type.Availability getTeamMerge() {
        return teamMerge;
    }

    public boolean isEqualTimeSizeRequired() {
        return requireEqualTimeSize;
    }

    public List<String> getDescription() {
        return description;
    }
}

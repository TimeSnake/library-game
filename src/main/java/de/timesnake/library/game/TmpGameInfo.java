package de.timesnake.library.game;

import de.timesnake.database.util.game.DbTmpGameInfo;
import de.timesnake.database.util.object.Type;

import java.util.List;

public class TmpGameInfo extends GameInfo {

    private final Integer autoStartPlayerNumber;
    private final Integer minPlayerNumber;
    private final List<Integer> teamSizes;
    private final Type.Availability teamMerge;
    private final boolean requireEqualTimeSize;
    private final List<String> description;

    public TmpGameInfo(DbTmpGameInfo game) {
        super(game);
        this.autoStartPlayerNumber = game.getAutoStartPlayerNumber();
        this.minPlayerNumber = game.getMinPlayerNumber();
        this.teamSizes = game.getTeamSizes();
        this.teamMerge = game.getTeamMergeAvailability();
        this.requireEqualTimeSize = game.isEqualTeamSizeRequired();
        this.description = game.getDescription();
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

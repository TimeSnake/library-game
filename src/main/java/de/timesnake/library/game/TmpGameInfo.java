/*
 * workspace.library-game.main
 * Copyright (C) 2022 timesnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; If not, see <http://www.gnu.org/licenses/>.
 */

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
    private boolean showSelectedKits;
    private boolean requireEqualTimeSize;
    private boolean hideTeams;
    private Type.Discord discordType;
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
        if (this.discordType == null) {
            this.discordType = Type.Discord.FORBIDDEN;
        }
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

    public boolean showSelectedKits() {
        return showSelectedKits;
    }

    public boolean isEqualTimeSizeRequired() {
        return requireEqualTimeSize;
    }

    public boolean hideTeams() {
        return hideTeams;
    }

    public Type.Discord getDiscordType() {
        return discordType;
    }

    public List<String> getDescription() {
        return description;
    }
}

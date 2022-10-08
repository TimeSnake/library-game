/*
 * library-game.main
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
import de.timesnake.database.util.game.DbNonTmpGameInfo;

public class NonTmpGameInfo extends GameInfo {

    private boolean creationRequestable;
    private boolean ownable;
    private boolean allowNetherAndEnd;

    public NonTmpGameInfo(DbNonTmpGameInfo game) {
        super(game);
    }

    @Override
    protected void loadFromDatabase(DbGameInfo game) {
        super.loadFromDatabase(game);
        DbNonTmpGameInfo nonTmpGame = ((DbNonTmpGameInfo) game);
        this.creationRequestable = nonTmpGame.isCreationRequestable();
        this.ownable = nonTmpGame.isOwnable();
        this.allowNetherAndEnd = nonTmpGame.isNetherAndEndAllowed();
    }

    public boolean isCreationRequestable() {
        return creationRequestable;
    }

    public boolean isOwnable() {
        return ownable;
    }

    public boolean isNetherAndEndAllowed() {
        return this.allowNetherAndEnd;
    }

}

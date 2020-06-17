package com.mygdx.game.UI.battle;

import com.mygdx.game.Entity.Player;
import com.mygdx.game.Event.Battle;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.UI.UI;

/**
 * Abstract class for all UI related to battles
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public abstract class BattleUI extends UI {
    protected Battle battle;


    public BattleUI(GameScreen screen, TileMap tileMap, Player player, ResourceManager rm, Battle battle) {
        super(screen, tileMap, player, rm);
        this.battle = battle;
    }
}

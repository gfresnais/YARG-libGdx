package com.mygdx.game.UI.battle;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Event.Battle;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Screens.GameScreen;

/**
 * Displays battle related elements
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class BattleScene extends BattleUI {

    private Stage stage;

    // Health bars

    // Sprites

    // Animations

    // Labels



    public BattleScene(GameScreen screen, TileMap tileMap, Player player, ResourceManager rm, Battle battle, Stage stage) {
        super(screen, tileMap, player, rm, battle);
        this.stage = stage;

        // Hud

        // Sprites

        // Animations

        // Add to the stage
    }

    @Override
    public void update(float delta) {
        // Handle moves
    }

    @Override
    public void render(float delta) {
        screen.getGame().batch.begin();

        // Handle animations

        screen.getGame().batch.end();
    }
}

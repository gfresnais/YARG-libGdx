package Map;

import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Handles the game map
 * Is responsible for player movements
 *
 * @author gfresnais
 */
public class GameMap {
    private TileMap tileMap;
    private Player player;
    private ResourceManager rm;

    //TODO Handle music
    private Music mapTheme;

    /**
     * Constructor
     * @param player
     * @param rm
     */
    public GameMap(Player player, ResourceManager rm) {
        //TODO add game screen
        this.player = player;
        this.rm = rm;
    }


}

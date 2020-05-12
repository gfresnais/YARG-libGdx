package com.mygdx.game.Inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Item
 *
 * @author gfresnais
 */
public class Item {
    private String name;
    private String labelName;
    private String desc;
    private int type;

    private Image actor;

    public Item(ResourceManager rm, String name, String desc) {
        this.name = name;
        this.desc = desc;
        labelName = name;
        //TODO get the image with ResourceManager
        actor = new Image();
    }
}

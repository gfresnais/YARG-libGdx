package com.mygdx.game.Inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Item
 * TODO add a better description
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Item {
    private String name;
    private String labelName;
    private String desc;
    /*
    TODO define the types
     */
    private int type;

    //TODO add the attributes for each type of item

    private boolean isEquipped;

    private Image actor;

    public Item(ResourceManager rm, String name, String desc) {
        this.name = name;
        this.desc = desc;
        labelName = name;
        //TODO get the image with ResourceManager
        actor = new Image();
    }

    public int getType() { return type; }

    public void setEquipped( boolean isEquipped ) { this.isEquipped = isEquipped; }
}

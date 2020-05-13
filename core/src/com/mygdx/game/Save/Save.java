package com.mygdx.game.Save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Handles saving data
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Save {
    private Json json;
    private FileHandle file;

    /**
     * Constructor
     * TODO modify and add data
     * @param path
     */
    public Save(String path) {
        //TODO add player data
        json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        json.setUsePrototypes(false);
        file = Gdx.files.local(path);
    }

    /**
     * Saves data
     */
    public void save() {
        //TODO add real data
        file.writeString(Base64Coder.encodeString(json.prettyPrint("Hello")), false);
    }

    public void load(ResourceManager rm) {
        if(!file.exists()) save();

        //Example
        String str = json.fromJson(String.class, Base64Coder.decodeString(file.readString()));

        System.out.println(str);

        //TODO load real data
    }
}

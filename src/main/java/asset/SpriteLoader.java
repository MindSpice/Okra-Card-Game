package asset;


import javafx.scene.image.Image;
import util.FileLoader;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

public class SpriteLoader {

    static HashMap<String, Image[]> cachedSprites = new HashMap<>();
    static HashMap<String, Image[]> cachedNum = new HashMap<>();
    static String spriteDir = "/Assets/Sprites/";



//    void importSprites(Character.Brute type) {
//
//        switch (type) {
//            case LVL0:  {
//
//            }
//        }
//    }

    public static Image[] importCharSprites(Character type){

        // Needs some fuckery to make work, but should allow for easy enum passes
        // Downside is the messy if statements

        ///////////////////
        //Warrior Sprites//
        ///////////////////


        if (type.getType() == Character.Warrior.class.getSimpleName()) {

            if (cachedSprites.containsKey(Character.Warrior.class.getSimpleName() + type)) {
                return cachedSprites.get(Character.Warrior.class.getSimpleName() + type);
            }

            if (Character.Warrior.LVL0.equals(type)) {
                URL url = SpriteLoader.class.getResource(spriteDir + "Warrior/0/");
                Image[] images = FileLoader.imgDirectory(url.getPath());
                cachedSprites.put(Character.Warrior.class.getSimpleName() + type, images);
                return cachedSprites.get(Character.Warrior.class.getSimpleName() + type);
            }
        }
        return null;
    }

    public static BufferedImage[] importNumSprites() {
        BufferedImage[] images = new BufferedImage[2];

        URL url = SpriteLoader.class.getResource(spriteDir + "Numbers/n_sheet_green.png");
        images[0] = FileLoader.imgSingleBuffered(url.getPath());

        url = SpriteLoader.class.getResource(spriteDir + "Numbers/n_sheet_red.png");
        images[1] = FileLoader.imgSingleBuffered(url.getPath());

        return images;
    }

}




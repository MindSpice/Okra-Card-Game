package asset;


import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Objects;

import static java.awt.image.BufferedImage.TYPE_BYTE_INDEXED;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class HealthDisplay {



    enum Player{
        PLAYER,
        ENEMY
    }

    BufferedImage hpSprite;
    int[] hpNum = new int[10];
    int w = 12;
    int h = 16;



    public HealthDisplay(String player) {

        if (player.equals("player")) {
            hpSprite = SpriteLoader.importNumSprites()[0];
        } else {
            hpSprite = SpriteLoader.importNumSprites()[1];
        }
        for (int i = 0; i < 10; ++i) {
            hpNum[i] = i * w;
        }
    }

    public Image getHealth(int health) {
        int[] hp  = Integer.toString(health).chars().map(c -> c-'0').toArray();

        BufferedImage returnImage = new BufferedImage(w * hp.length, h,TYPE_INT_ARGB);
        Graphics2D img = returnImage.createGraphics();

        for (int i = 0; i < hp.length; ++i) {
            BufferedImage num = hpSprite.getSubimage(hpNum[hp[i]],0,w,h);
            img.drawImage(num,null,i * w,0);
        }
        img.dispose();
        return SwingFXUtils.toFXImage(returnImage, null);
    }


}

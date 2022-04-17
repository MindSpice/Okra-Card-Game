package util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class ImageUtil {

    public static Image[] mirror(Image[] frames) {
        Image[] mirroredFrames = new Image[frames.length];
        int j = 0;

        for (Image i : frames) {
            BufferedImage sprite = SwingFXUtils.fromFXImage(i, null);
            BufferedImage img = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);

            for (int xx = sprite.getWidth() - 1; xx > 0; xx--) {
                for (int yy = 0; yy < sprite.getHeight(); yy++) {
                    img.setRGB(sprite.getWidth() - xx, yy, sprite.getRGB(xx, yy));
                }
            }
            mirroredFrames[j] = SwingFXUtils.toFXImage(img,null);
            j++;
        }
        return mirroredFrames;
    }

}

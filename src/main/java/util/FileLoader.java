package util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class FileLoader {

    public static Image[] imgDirectory (String path){

        File directory = new File(path);
        File[] fileList = directory.listFiles();
        Arrays.sort(fileList);
        Image[] images = new Image[directory.listFiles().length];
        for (File f : directory.listFiles()) {
        }
        try {
            int i = 0;
            for (File f : fileList) {
                BufferedImage bf = ImageIO.read(f);
                Image image = SwingFXUtils.toFXImage(bf, null);
                images[i] = image;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }


}

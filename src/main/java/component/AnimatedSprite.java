package component;

import javafx.scene.image.Image;

public class AnimatedSprite {

    private Image[] frames;
    double frameTime;

    public AnimatedSprite(Image[] frames, double frameTime) {
        this.frames = frames;
        this.frameTime =frameTime;
    }

    public Image update(double time) {
        int index = (int)((time % (frames.length * frameTime)) / frameTime);
        return frames[index];
    }

    public Image getFrame(int i) {
        if(i > 0 && i < frames.length) {
            return frames[i];
        } else {
            return null;
        }
    }

    public int getFrameCount() {
        return frames.length;
    }

    public double getFrameTime() {
        return frameTime;
    }
}

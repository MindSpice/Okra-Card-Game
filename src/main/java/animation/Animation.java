package animation;

import component.AnimatedSprite;
import entity.GraphicObject;
import gameboard.GameBoard;
import javafx.scene.canvas.GraphicsContext;

public class Animation {
    protected AnimatedSprite animation;
    protected GraphicsContext gc = GameBoard.getGraphicsContext();
    protected GraphicObject animatedObject;
    GraphicObject targetObject;


    protected void draw() {
        gc.drawImage(animation.update(GameBoard.getTime()), animatedObject.getPosX(),animatedObject.getPosY());
    }

}

package animation;

import component.AnimatedSprite;
import entity.GraphicObject;

public class Move extends Animation{
    double targetX;
    double targetY;
    boolean negY = false;
    boolean negX = false;
    double speed = 10;
    boolean metX = false;
    boolean metY = false;
    // class should be re-instantiated for every new movement event

    public Move(double targetX, double toY, double fromX, double fromY, GraphicObject objectToMove, AnimatedSprite animation){
        this.targetX = targetX;
        this.targetY = toY;
        this.animatedObject = objectToMove;
        this.animation = animation;
        if (targetX < fromX){
            negX = true;
            //speedX = -speedX;
        }
        if (toY < fromY){
            negY = true;
            //speedY = -speedY;
        }
    }

    public Move(GraphicObject animatedObject, GraphicObject targetObject, AnimatedSprite animation) {
        this.animatedObject = animatedObject;
        this.targetObject = targetObject;
        targetX = targetObject.getPosX();
        targetY = targetObject.getPosY();
        this.animation = animation;
    }



    // Functions return false until end conditions (location, collision) are met

    public boolean updateUntilPos() {
        if (negX && animatedObject.getPosX() <= targetX) metX = true;
        if (negY && animatedObject.getPosY() <= targetY) metY = true;
        if (!negX && animatedObject.getPosX() >= targetX) metX = true;
        if (!negY && animatedObject.getPosY() >= targetY) metY = true;

        move();

        if (metX && metY) {
            return true;
        } else{
            return false;
        }
    }

    public boolean updateUntilCollide() {
        if (!animatedObject.intersects(targetObject)) {
            move();
            return false;
        } else {
            return true;
        }
    }


    private void move() {
        double deltaX = targetX - animatedObject.getPosX();
        double deltaY = targetY - animatedObject.getPosY();

        double magnitude = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        deltaX = deltaX / magnitude * speed;
        deltaY = deltaY / magnitude * speed;

        if (!metX) animatedObject.setPosX(animatedObject.getPosX() + deltaX);
        if (!metY) animatedObject.setPosY(animatedObject.getPosY() + deltaY);

        draw();

    }

}


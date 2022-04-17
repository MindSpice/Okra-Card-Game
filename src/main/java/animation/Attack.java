package animation;


import component.AnimatedSprite;
import entity.GraphicObject;
import gameboard.GameBoard;
import pawn.Pawn;

public class Attack extends Animation{
    double endTime;
    Pawn target;

    public Attack(GraphicObject pawn, Pawn target, AnimatedSprite animation) {
        this.animatedObject = pawn;
        this.animation = animation;
        this.target = target;

    }

    public boolean attack() {
        if (endTime > GameBoard.getTime()) {
            draw();
            target.setState(Pawn.State.DEFEND);
            return false;
        } else {
            target.setState(Pawn.State.IDLE);
            return true;
        }
    }

    public void initAttack() {
        endTime = GameBoard.getTime() + (animation.getFrameCount() * animation.getFrameTime());
    }
}

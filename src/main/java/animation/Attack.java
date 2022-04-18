package animation;


import component.AnimatedSprite;
import entity.GraphicObject;
import gameboard.GameBoard;
import entity.Pawn;

public class Attack extends Animation{
    double endTime;
    Pawn target;
    int damage;

    public Attack(GraphicObject pawn, Pawn target, AnimatedSprite animation,int damage) {
        this.animatedObject = pawn;
        this.animation = animation;
        this.target = target;
        this.damage = damage;

    }

    public boolean attack() {
        if (endTime > GameBoard.getTime()) {
            draw();
            target.setState(Pawn.State.DEFEND);

            return false;
        } else {
            target.setState(Pawn.State.IDLE);
            target.setHp(target.getHp() - this.damage);
            return true;
        }
    }

    public void initAttack() {
        endTime = GameBoard.getTime() + (animation.getFrameCount() * animation.getFrameTime());
    }
}

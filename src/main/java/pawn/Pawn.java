package pawn;



import animation.Attack;
import animation.Move;
import entity.GraphicObject;
import component.AnimatedSprite;
import card.Card;
import effect.Power;
import effect.Status;
import gameboard.GameBoard;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import util.ImageUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pawn.Pawn.State.*;


public class Pawn extends GraphicObject {




    //Object Context
    boolean isPlayerPawn;
    boolean selected = false;
    boolean dead;
    Position pos;
    State state = IDLE;
    int hpOffset;

    // Stats Contexts
    int hp;
    int mp;
    int dp;
    int sp;

    // Card context
    Card card1;
    Card card2;
    Card ability;
    Power power;
    List<Status> statusEffects = new ArrayList<>();

    // Animations
    AnimatedSprite chargeAnimation;
    AnimatedSprite attackAnimation;
    AnimatedSprite defendAnimation;
    AnimatedSprite idleAnimation;
    Move move;
    Attack attack;


    public enum State {
        ATTACK,
        CHARGE,
        DEFEND,
        IDLE,
        RESET
    }



    //
    public enum Position {
        ONE(50, 35),
        TWO(50, 185),
        THREE(50, 335);

       final double x;
       final double y;

        Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
    }


    public Pawn(String name, int hp, int mp, int dp, int sp, Image[] animationFrames, Position pos, boolean isPlayer) {
        Image[] frames = animationFrames;
        super.gc = GameBoard.getGraphicsContext();
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.dp = dp;
        this.sp = sp;
        this.pos = pos;


        if (isPlayer) {
        frames = ImageUtil.mirror(frames); // mirror frames for easier asset management;
        posX += 700;    // Move X placement over to players side
        }

        this.idleAnimation = new AnimatedSprite(Arrays.copyOfRange(frames, 0, 6), .2);
        this.defendAnimation = new AnimatedSprite(Arrays.copyOfRange(frames, 7, 13), .2);
        this.chargeAnimation = new AnimatedSprite(Arrays.copyOfRange(frames, 14, 15), .2);
        this.attackAnimation = new AnimatedSprite(Arrays.copyOfRange(frames, 16, 19), .1);

        this.posX += pos.getX();
        this.posY = pos.getY();

        this.isPlayerPawn = isPlayer;
        this.width = animationFrames[0].getWidth();     //Needs to be set for mouse over interactions
        this.height = animationFrames[0].getHeight();   //First idle frame grabbed as "good enough"

    }



    public void draw(double time) {
        DropShadow enemy = new DropShadow(6, 2, 2, Color.RED);
        DropShadow player = new DropShadow(6, 2, 2, Color.GREEN);

        if (selected){
            if (isPlayerPawn) gc.setEffect(player);
            else gc.setEffect(enemy);
        }else {
            gc.setEffect(null);
        }

        switch (this.state) {

            case CHARGE:

                if(move.updateUntilCollide()) {
                    state = ATTACK;
                    move = null;
                    attack.initAttack();
                }
                break;

            case ATTACK:

                if(attack.attack()) {
                    state = RESET;
                    attack = null;
                    resetPos();
                }
                break;

            case DEFEND:
                gc.drawImage(defendAnimation.update(time), posX, posY);

                break;

            case IDLE:
                gc.drawImage(idleAnimation.update(time), posX, posY);
                break;
            case RESET:

                if(move.updateUntilPos()) {
                    state = IDLE;
                    move = null;
                }
                break;
        }
    }



    public void attack(Pawn enemy) {
        this.state = CHARGE;
        move = new Move(this, enemy, chargeAnimation);
        attack = new Attack(this, enemy, attackAnimation);

    }


    public void resetPos(){
        // ternary shifts x +700 for player pawns, since they are declared from an enum and constructor originally sets #spaghetti
        move = new Move((isPlayerPawn ? pos.getX() + 700 : pos.getX()),
                pos.getY(),this.posX,this.posY,this, idleAnimation);

    }

    public void setSelected(boolean isSelected){
        this.selected = isSelected;
    }

    public void setState(State state) {
        this.state = state;

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public boolean isDead(){
        return this.dead;
    }

}

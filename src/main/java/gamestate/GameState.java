package gamestate;

public class GameState {

    public enum Turn {
        PLAYER,
        ENEMY;
    }

    //TODO: Need to make a class and add container for player/enemy account information

    public static final PlayerState playerState = null;
    public static final PlayerState enemyState  = null;
    Turn turn;
    int RoundNumber;
    boolean isOver;
    boolean hasWinner;






}

package gamestate;

import card.Card;
import entity.Pawn;

import java.util.List;

public class PlayerState {

    private Pawn pawn1;
    private Pawn pawn2;
    private Pawn pawn3;

    List<Card> actionCardHand;
    List<Card> abilityCardHand;
    List<Card> powerCardHand;

    public PlayerState(Pawn[] pawns) {
        pawn1 = pawns[0];
        pawn2 = pawns[1];
        pawn3 = pawns[2];
    }

    public Pawn getPawn1() {
        return pawn1;
    }

    public Pawn getPawn2() {
        return pawn2;
    }

    public Pawn getPawn3() {
        return pawn3;
    }

    public List<Card> getActionCardHand() {
        return actionCardHand;
    }

    public List<Card> getAbilityCardHand() {
        return abilityCardHand;
    }

    public List<Card> getPowerCardHand() {
        return powerCardHand;
    }



}

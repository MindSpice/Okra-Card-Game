package gamestate;

import card.Card;
import effect.Status;

import java.sql.Array;
import java.util.List;

public class PlayerState {

    int pawn1_HP;
    int pawn2_HP;
    int pawn3_HP;
    int pawn1_MP;
    int pawn2_MP;
    int pawn3_MP;
    int pawn1_SP;
    int pawn2_SP;
    int pawn3_SP;
    int pawn1_DP;
    int pawn2_DP;
    int pawn3_DP;

    List<Status> pawn1_statusEffects;
    List<Status> pawn2_statusEffects;
    List<Status> pawn3_statusEffects;

    int[] pawn_1_xy = new int[2];
    int[] pawn_2_xy = new int[2];
    int[] pawn_3_xy = new int[2];

    List<Card> actionCardHand;
    List<Card> abilityCardHand;
    List<Card> powerCardHand;

}

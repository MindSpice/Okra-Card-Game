package asset;

import pawn.Pawn;

public class AssetLoader {

    public static Pawn[] initPawns(Character char1, Character char2, Character char3, boolean isPlayer) {
        Pawn[] pawns = new Pawn[3];

        pawns[0] = new Pawn(char1.getName(), char1.getHp(), char1.getMp(), char1.getDp(),char1.getSp(),
                SpriteLoader.importSprites(char1), Pawn.Position.ONE, isPlayer);

        pawns[1] = new Pawn(char2.getName(), char2.getHp(), char2.getMp(), char2.getDp(),char2.getSp(),
                SpriteLoader.importSprites(char2), Pawn.Position.TWO, isPlayer);

        pawns[2] = new Pawn(char3.getName(), char3.getHp(), char3.getMp(), char3.getDp(),char3.getSp(),
                SpriteLoader.importSprites(char3), Pawn.Position.THREE, isPlayer);

        return pawns;
    }

}

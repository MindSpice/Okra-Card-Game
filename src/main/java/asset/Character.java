package asset;

public interface Character {
    public int getHp();
    public int getMp();
    public int getDp();
    public int getSp();
    public String getName();

    default String getType () {
        return this.getClass().getSimpleName();
    }

//    enum Brute implements Character {
//        LVL0,
//        LVL1,
//        LVL2,
//        LVL3,
//        LVL4;
//
//    }

    enum Warrior implements Character {
        LVL0(100,20, 20, 50, "Basic Warrior"),
        LVL1(100,20, 20, 50, "Basic Warrior"),
        LVL2(100,20, 20, 50, "Basic Warrior"),
        LVL3(100,20, 20, 50, "Basic Warrior"),
        LVL4(100,20, 20, 50, "Basic Warrior");

        private int hp;
        private int mp;
        private int dp;
        private int sp;
        private String name;

        Warrior(int hp, int mp, int dp, int sp, String name) {
            this.hp = hp;
            this.mp = mp;
            this.dp = dp;
            this.sp = sp;
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public int getMp() {
            return mp;
        }

        public int getDp() {
            return dp;
        }

        public int getSp() {
            return sp;
        }
        public String getName() {
            return name;
        }

    }
//    enum Ranger implements Character {
//        LVL0,
//        LVL1,
//        LVL2,
//        LVL3,
//        LVL4
//    }
//    enum Mage implements Character {
//        LVL0,
//        LVL1,
//        LVL2,
//        LVL3,
//        LVL4
//    }
//    enum Okruid implements Character {
//        LVL0,
//        LVL1,
//        LVL2,
//        LVL3,
//        LVL4
//    }

}

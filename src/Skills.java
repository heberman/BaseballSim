package src;

import java.util.Random;

public class Skills {
    private int hitting_ability;
    private int pitching_ability;
    private int fielding_ability;
    private int clutch;

    public Skills(int h, int p, int f) {
        hitting_ability = h;
        pitching_ability = p;
        fielding_ability = f;
        clutch = 50;
    }

    public int getHittingAbility() {
        return hitting_ability;
    }

    public int getPitchingAbility() {
        return pitching_ability;
    }

    public int getFieldingAbility() {
        return fielding_ability;
    }

    public int getClutch() {
        return clutch;
    }
}

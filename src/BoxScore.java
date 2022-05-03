package src;

import java.util.ArrayList;

public class BoxScore {
    private int[] visiting_scores = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] home_scores = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private ArrayList<BatterGameStats> batter_stats = new ArrayList<BatterGameStats>();
    private ArrayList<PitcherGameStats> pitcher_stats = new ArrayList<PitcherGameStats>();

    public BoxScore() {
        for (int i = 0; i < 9; i++) {
            batter_stats.add(new BatterGameStats());
            pitcher_stats.add(new PitcherGameStats());
        }
    }

    public BatterGameStats getBatterStats(int index) {
        return batter_stats.get(index);
    }

    public PitcherGameStats getPitcherStats(int index) {
        return pitcher_stats.get(index);
    }

    public void runScored(boolean is_visitor, int inning) {
        if (is_visitor)
            visiting_scores[inning]++;
        else
            home_scores[inning]++;
    }
}

package src;

public class PitcherGameStats {
    private double innings_pitched;
    private int hits;
    private int earned_runs;
    private int walks;
    private int strikeouts;
    private int homeruns;

    public PitcherGameStats() {
        innings_pitched = hits = earned_runs = walks = strikeouts = homeruns = 0;
    }

    public double getInningsPitched() {
        return innings_pitched;
    }

    public void incrementInningsPitched() {
        if ((innings_pitched * 10) % 10 == 2) {
            innings_pitched += 0.8;
        } else {
            innings_pitched += 0.1;
        }
    }

    public int getHits() {
        return hits;
    }

    public void incrementHits() {
        hits++;
    }

    public int getEarnedRuns() {
        return earned_runs;
    }

    public void incrementEarnedRuns() {
        earned_runs++;
    }

    public int getWalks() {
        return walks;
    }

    public void incrementWalks() {
        walks++;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void incrementStrikeouts() {
        strikeouts++;
    }

    public int getHomeruns() {
        return homeruns;
    }

    public void incrementHomeruns() {
        homeruns++;
    }
    
}

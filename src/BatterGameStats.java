package src;

public class BatterGameStats {
    private int at_bats;
    private int runs;
    private int hits;
    private int rbi;
    private int doubles;
    private int triples;
    private int homeruns;
    private int walks;
    private int strikeouts;

    public BatterGameStats() {
        at_bats = runs = hits = rbi = doubles = triples = homeruns = walks = strikeouts = 0;
    }

    public int getAtBats() {
        return at_bats;
    }

    public void incrementAtBats() {
        at_bats++;
    }

    public int getRuns() {
        return runs;
    }

    public void incrementRuns() {
        runs++;
    }

    public int getHits() {
        return hits;
    }

    public void incrementHits() {
        hits++;
    }
    
    public int getRBI() {
        return rbi;
    }

    public void incrementRBI() {
        rbi++;
    }

    public int getDoubles() {
        return doubles;
    }

    public void incrementDoubles() {
        doubles++;
    }

    public int getTriples() {
        return triples;
    }

    public void incrementTriples() {
        runs++;
    }

    public int getHomeuns() {
        return homeruns;
    }

    public void incrementHomeruns() {
        homeruns++;
    }

    public int getWalks() {
        return walks;
    }

    public void incrementWalks() {
        runs++;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void incrementStrikeouts() {
        strikeouts++;
    }
}

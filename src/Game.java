package src;

import java.util.Random;

import javax.lang.model.type.NullType;

public class Game {
    private Team visiting_team;
    private Team home_team;
    private int visitor_score;
    private int home_score;
    private int current_inning;
    private boolean is_top_inning;
    private int current_balls;
    private int current_strikes;
    private int current_outs;
    private int current_vis_batter;
    private int current_home_batter;
    private Player current_home_pitcher;
    private Player current_vis_pitcher;
    private Player[] runners_on = {null, null, null, null};
    private BoxScore boxScore;

    private final int strike_chance = 550;
    private final int fairball_chance = 350;
    private final int hit_chance = 200;
    private final int double_chance = 200;
    private final int triple_chance = 20;
    private final int homerun_chance = 120;

    Random rand = new Random();

    public Game(Team vis, Team home, Player vis_starting_pitcher, Player home_starting_pitcher) {
        visiting_team = vis;
        home_team = home;
        visitor_score = home_score = current_balls = current_strikes = current_outs = 0;
        current_inning = current_vis_batter = current_home_batter = 1;
        current_vis_pitcher = vis_starting_pitcher;
        current_home_pitcher = home_starting_pitcher;
        is_top_inning = true;
        boxScore = new BoxScore();
    }

    // returns 0 if ball, 1 if strike, 2 if out, or 3 if hit
    public int simPitch(Player batter, Player pitcher) {
        int hitter_ability = batter.getPlayerSkills().getHittingAbility();
        int pitcher_ability = pitcher.getPlayerSkills().getPitchingAbility();

        int local_strike_chance = strike_chance + pitcher_ability;
        
        if (rand.nextInt(1000) >= local_strike_chance)
            return 0;

        int local_fairball_chance = fairball_chance + hitter_ability;

        if (rand.nextInt(1000) >= local_fairball_chance)
            return 1;

        int local_hit_chance = hit_chance + hitter_ability;

        if (rand.nextInt(1000) >= local_hit_chance)
            return 2;

        return 3;
    }

    public void simBatter(Player batter, Player pitcher) {
        int pitch = 0;
        boolean batter_is_visitor = batter.getTeam() == visiting_team.getTeamName();

        runners_on[0] = batter;

        do {
            System.out.println(String.format("%o - %o", current_balls, current_strikes));

            pitch = simPitch(batter, pitcher);

            if (pitch == 0) {
                current_balls++;
                
                if (current_balls >= 4) {
                    batterWalk(batter_is_visitor);
                    System.out.println(String.format("%s walks %s", pitcher.getLastName(), batter.getLastName()));
                    return;
                }
            } else {
                current_strikes++;

                if (current_strikes >= 3) {
                    System.out.println(String.format("%s strikes out %s", pitcher.getLastName(), batter.getLastName()));
                    current_outs++;
                    return;
                }
            }

        } while (pitch < 2);

        if (pitch == 2) {
            System.out.println(String.format("%s gets out", batter.getLastName()));
            current_outs++;
        } else {
            int hit_result = rand.nextInt(1000);

            if (hit_result <= triple_chance) {
                baseHit(3, batter_is_visitor);
                System.out.println(String.format("%s hits a triple off of %s", batter.getLastName(), pitcher.getLastName()));
            } else if (hit_result <= homerun_chance + triple_chance) {
                baseHit(4, batter_is_visitor);
                System.out.println(String.format("%s hits a homer off of %s", batter.getLastName(), pitcher.getLastName()));
            } else if (hit_result <= double_chance + homerun_chance + triple_chance) {
                baseHit(2, batter_is_visitor);
                System.out.println(String.format("%s hits a double off of %s", batter.getLastName(), pitcher.getLastName()));
            } else {
                baseHit(1, batter_is_visitor);
                System.out.println(String.format("%s hits a single off of %s", batter.getLastName(), pitcher.getLastName()));
            }
        }
    }

    private void runnerScores(boolean is_visitor) {
        if (is_visitor)
            visitor_score++;
        else
            home_score++;
                
        System.out.println(String.format("%s scores for the %s", runners_on[3].getLastName(), runners_on[3].getTeam()));
    }

    private void batterWalk(boolean is_visitor) {
        if (runners_on[1] != null) {
            if (runners_on[2] == null) {
                runners_on[2] = runners_on[1];
            } else if (runners_on[3] == null) {
                runners_on[3] = runners_on[2];
                runners_on[2] = runners_on[1];
            } else {
                runnerScores(is_visitor);
                runners_on[3] = runners_on[2];
                runners_on[2] = runners_on[1];
                runners_on[1] = runners_on[0];
            }
        }

        runners_on[1] = runners_on[0];
    }

    private void baseHit(int bases, boolean is_visitor) {
        for (int i = 0; i < bases; i++) {
            if (runners_on[3] != null) {
                runnerScores(is_visitor);
            }

            runners_on[3] = runners_on[2];
            runners_on[2] = runners_on[1];
            runners_on[1] = runners_on[0];
            runners_on[0] = null;
        }
    }

    private void resetCount() {
        current_balls = 0;
        current_strikes = 0;
    }

    public void simInning() {
        while (current_outs < 3) {
            if (is_top_inning) {
                simBatter(visiting_team.getLineup().get(current_vis_batter - 1), current_home_pitcher);

                if (current_vis_batter == 9)
                    current_vis_batter = 0;

                current_vis_batter++;
                resetCount();
            } else {
                simBatter(home_team.getLineup().get(current_home_batter - 1), current_vis_pitcher);

                if (current_home_batter == 9)
                    current_home_batter = 0;

                current_home_batter++;
                resetCount();
            }
        }

        if (is_top_inning) {
            is_top_inning = false;
            System.out.println("Bottom " + current_inning);
        } else {
            is_top_inning = true;
            current_inning++;
            System.out.println("Top " + current_inning);
        }

        current_outs = 0;
        runners_on[3] = runners_on[2] = runners_on[1] = null;
    }

    public void simGame() {
        while (current_inning < 10)
            simInning();

        System.out.println("Final Score:");
        System.out.println(String.format("%o - %o", visitor_score, home_score));
    }
}

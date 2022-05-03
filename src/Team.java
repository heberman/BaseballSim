package src;

import java.util.ArrayList;

public class Team {
    private String team_location;
    private String team_name;
    private int wins;
    private int losses;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> lineup = new ArrayList<Player>();

    public Team(String location, String name, ArrayList<Player> p_arr) {
        team_location = location;
        team_name = name;
        players = p_arr;
        
        for (int i = 0; i < 9; i++) {
            lineup.add(p_arr.get(i));
        }
    }

    public String getTeamName() {
        return team_name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> getLineup() {
        return lineup;
    }
}

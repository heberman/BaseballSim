import java.security.PolicySpi;

public class Player {
    private String first_name;
    private String last_name;
    private byte player_num;
    private byte age;
    private String position;
    private String team;
    private Stats player_stats;
    private Skills player_skills;

    public Player(String fname, String lname, byte num, byte a, String pos, String t) {
        first_name = fname;
        last_name = lname;
        player_num = num;
        age = a;
        position = pos;
        team = t;
    }
}

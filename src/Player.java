package src;

public class Player {
    private String first_name;
    private String last_name;
    private int player_num;
    private int age;
    private String position;
    private String team;
    private CareerStats player_stats;
    private Skills player_skills;

    public Player(String fname, String lname, String pos, String t, int hit_num, int pitch_num, int field_num) {
        first_name = fname;
        last_name = lname;
        player_num = 1;
        age = 21;
        position = pos;
        team = t;
        player_stats = new CareerStats();
        player_skills = new Skills(hit_num, pitch_num, field_num);
    }

    public String getLastName() {
        return last_name;
    }

    public Skills getPlayerSkills() {
        return player_skills;
    }

    public String getTeam() {
        return team;
    }
}

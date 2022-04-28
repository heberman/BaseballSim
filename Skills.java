import java.util.Random;

public class Skills {
    private int hitting_ability;
    private int pitching_ability;
    private int fielding_ability;
    private int clutch;

    Random rand = new Random();

    public Skills() {
        hitting_ability = rand.nextInt(100);
        pitching_ability = rand.nextInt(100);
        fielding_ability = rand.nextInt(100);
        clutch = rand.nextInt(100);
    }
}

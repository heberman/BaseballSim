package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> padres_players = new ArrayList<Player>();
        ArrayList<Player> dodgers_players = new ArrayList<Player>();

        padres_players.add(new Player("Trent", "Grisham", "Center Fielder", "Padres", 60, 10, 80));
        padres_players.add(new Player("Jake", "Cronenworth", "Second Baseman", "Padres", 70, 10, 75));
        padres_players.add(new Player("Manny", "Machado",  "Third Baseman", "Padres", 85, 10, 90));
        padres_players.add(new Player("Fernando", "Tatis Jr.",  "Shortstop", "Padres", 90, 10, 85));
        padres_players.add(new Player("Eric", "Hosmer",  "First Baseman", "Padres", 65, 10, 85));
        padres_players.add(new Player("Austin", "Nola",  "Catcher", "Padres", 60, 10, 75));
        padres_players.add(new Player("Jurickson", "Profar",  "Left Fielder", "Padres", 55, 10, 80));
        padres_players.add(new Player("Will", "Myers",  "Right Fielder", "Padres", 45, 10, 80));
        padres_players.add(new Player("Ha-Seong", "Kim",  "Designated Hitter", "Padres", 40, 10, 80));
        padres_players.add(new Player("Yu", "Darvish",  "Starting Pitcher", "Padres", 10, 90, 80));

        dodgers_players.add(new Player("Mookie", "Betts", "Right Fielder", "Dodgers", 85, 10, 85));
        dodgers_players.add(new Player("Freddie", "Freeman", "First Baseman", "Dodgers", 93, 10, 80));
        dodgers_players.add(new Player("Trea", "Turner", "Second Baseman", "Dodgers", 90, 10, 75));
        dodgers_players.add(new Player("Justin", "Turner", "Third Baseman", "Dodgers", 82, 10, 80));
        dodgers_players.add(new Player("Max", "Muncy", "Designated Hitter", "Dodgers", 85, 10, 70));
        dodgers_players.add(new Player("Will", "Smith", "Catcher", "Dodgers", 82, 10, 65));
        dodgers_players.add(new Player("Cody", "Bellinger", "Center Fielder", "Dodgers", 75, 10, 75));
        dodgers_players.add(new Player("Chris", "Taylor", "Left Fielder", "Dodgers", 70, 10, 75));
        dodgers_players.add(new Player("Gavin", "Lux", "Second Baseman", "Dodgers", 50, 10, 75));
        dodgers_players.add(new Player("Walker", "Bueler", "Starting Pitcher", "Dodgers", 10, 90, 80));
    
        Team padres = new Team("San Diego", "Padres", padres_players);
        Team dodgers = new Team("Los Angeles", "Dodgers", dodgers_players);

        Game myGame = new Game(dodgers, padres, dodgers.getPlayers().get(9), padres.getPlayers().get(9));

        myGame.simGame();
    }
}

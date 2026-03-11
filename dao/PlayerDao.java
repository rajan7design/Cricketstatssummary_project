package dao;

import util.FileUtil;
import java.util.List;

public class PlayerDao {

    private final String FILE = "players.txt";

    public void savePlayer(String data) {

        FileUtil.write(FILE, data);
    }

    public void showPlayers() {

        List<String> players = FileUtil.read(FILE);

        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }

        System.out.println("\n--- Players ---");

        for (String p : players) {
            System.out.println(p);
        }
    }
}

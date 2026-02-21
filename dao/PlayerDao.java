package dao;

import java.io.*;

public class PlayerDAO {

    private final String FILE_NAME = "players.txt";

    public void savePlayer(String data) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(data);
            bw.write("-------------------------\n");

        } catch (IOException e) {
            System.out.println("Error saving data to file.");
        }
    }

    public void showPlayers() {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}

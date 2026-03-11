package Controller;
import dao.PlayerDao;
import model.Batsman;
import model.Bowler;

import java.util.Scanner;

public class CricketControllerr {

    private PlayerDao dao = new PlayerDao();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n--- Cricket Stats Summary ---");
            System.out.println("1. Add Batsman");
            System.out.println("2. Add Bowler");
            System.out.println("3. Show All Players");
            System.out.println("4. Match Score Table");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBatsman();
                    break;

                case 2:
                    addBowler();
                    break;

                case 3:
                    dao.showPlayers();
                    break;

                case 4:
                    matchTable();
                    break;

                case 5:
                    System.out.println("Program Ended.");
                    return;

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    private void addBatsman() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Nationality: ");
        String nationality = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Runs: ");
        int runs = sc.nextInt();
        System.out.print("Balls: ");
        int balls = sc.nextInt();
        System.out.print("Innings: ");
        int innings = sc.nextInt();
        sc.nextLine();

        Batsman b = new Batsman(name, nationality, age, runs, balls, innings);
        dao.savePlayer(b.toFileString());
        System.out.println("Batsman saved!");
    }

    private void addBowler() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Nationality: ");
        String nationality = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Wickets: ");
        int wickets = sc.nextInt();
        System.out.print("Runs Conceded: ");
        int runs = sc.nextInt();
        System.out.print("Overs: ");
        double overs = sc.nextDouble();
        sc.nextLine();

        Bowler b = new Bowler(name, nationality, age, wickets, runs, overs);
        dao.savePlayer(b.toFileString());
        System.out.println("Bowler saved!");
    }

    private void matchTable() {
        System.out.print("Number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] name = new String[n];
        int[] runs = new int[n];
        int[] balls = new int[n];
        int[] fours = new int[n];
        int[] sixes = new int[n];
        int[] wickets = new int[n];
        double[] bowlerOvers = new double[n];
        int[] runsConceded = new int[n];

        System.out.println("\nEnter player stats:");

        for (int i = 0; i < n; i++) {
            System.out.println("\nPlayer " + (i + 1));
            System.out.print("Name: ");
            name[i] = sc.nextLine();
            System.out.print("Runs: ");
            runs[i] = sc.nextInt();
            System.out.print("Balls: ");
            balls[i] = sc.nextInt();
            System.out.print("Fours: ");
            fours[i] = sc.nextInt();
            System.out.print("Sixes: ");
            sixes[i] = sc.nextInt();
            System.out.print("Wickets: ");
            wickets[i] = sc.nextInt();
            System.out.print("Overs bowled (0 if none): ");
            bowlerOvers[i] = sc.nextDouble();
            if (bowlerOvers[i] > 0) {
                System.out.print("Runs conceded: ");
                runsConceded[i] = sc.nextInt();
            }
            sc.nextLine();
        }

        System.out.print("\nOvers played: ");
        double overs = sc.nextDouble();
        System.out.print("Wide balls: ");
        int wides = sc.nextInt();
        System.out.print("No balls: ");
        int noBalls = sc.nextInt();
        System.out.print("Leg byes: ");
        int legByes = sc.nextInt();

        int extras = wides + noBalls + legByes;
        int totalRuns = 0;
        for (int r : runs) totalRuns += r;
        int finalScore = totalRuns + extras;
        double runRate = finalScore / overs;

        System.out.println("\n=========== MATCH SUMMARY ===========");
        System.out.println("Extras: " + extras);
        System.out.println("Final Score: " + finalScore);
        System.out.println("Overs: " + overs);
        System.out.printf("Run Rate : %.2f\n", runRate);
        System.out.println("=====================================");

        // Bowling table
        System.out.println("\n=========== BOWLING SCOREBOARD ===========");
        System.out.printf("%-20s %8s %8s %8s %10s\n",
                "Player", "Overs", "Runs", "Wkts", "Economy");
        for (int i = 0; i < n; i++) {
            if (bowlerOvers[i] > 0) {
                double economy = runsConceded[i] / bowlerOvers[i];
                System.out.printf("%-20s %8.1f %8d %8d %10.2f\n",
                        name[i], bowlerOvers[i], runsConceded[i], wickets[i], economy);
            }
        }
        System.out.println("==========================================");

        // Batting table
        System.out.println("\n=========== BATTING SCOREBOARD ===========");
        System.out.printf("%-20s %5s %5s %5s %5s %10s\n",
                "Player", "R", "B", "4s", "6s", "SR");
        for (int i = 0; i < n; i++) {
            double strikeRate = balls[i] == 0 ? 0 : (runs[i] * 100.0) / balls[i];
            System.out.printf("%-20s %5d %5d %5d %5d %10.2f\n",
                    name[i], runs[i], balls[i], fours[i], sixes[i], strikeRate);
        }
        System.out.println("==========================================");

    
        String manOfMatch = "";
        int maxPoints = -1;
        for (int i = 0; i < n; i++) {
            int points = runs[i] + (wickets[i] * 10);
            if (points > maxPoints) {
                maxPoints = points;
                manOfMatch = name[i];
            }
        }
        System.out.println("\nMan of the Match: " + manOfMatch);
    }
}

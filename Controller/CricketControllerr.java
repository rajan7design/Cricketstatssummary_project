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
            System.out.println("4. Match Scoreboard");
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
                    matchScoreboard();
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

    private void matchScoreboard() {

        System.out.print("Number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] name = new String[n];
        int[] runs = new int[n];
        int[] balls = new int[n];
        int[] fours = new int[n];
        int[] sixes = new int[n];
        int[] wickets = new int[n];
        double[] overs = new double[n];
        int[] runsConceded = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Name: ");
            name[i] = sc.nextLine();

            System.out.print("Runs: ");
            runs[i] = sc.nextInt();

            System.out.print("Balls: ");
            balls[i] = sc.nextInt();

            System.out.print("4s: ");
            fours[i] = sc.nextInt();

            System.out.print("6s: ");
            sixes[i] = sc.nextInt();

            System.out.print("Wickets: ");
            wickets[i] = sc.nextInt();

            System.out.print("Overs Bowled: ");
            overs[i] = sc.nextDouble();

            System.out.print("Runs Conceded: ");
            runsConceded[i] = sc.nextInt();
            sc.nextLine();
        }

        System.out.print("Wide: ");
        int wide = sc.nextInt();

        System.out.print("No Ball: ");
        int noball = sc.nextInt();

        System.out.print("Leg Bye: ");
        int legbye = sc.nextInt();

        System.out.print("Dead Ball: ");
        int dead = sc.nextInt();

        System.out.print("Total Overs: ");
        double totalOvers = sc.nextDouble();

        int extras = wide + noball + legbye + dead;

        int totalRuns = extras;
        for (int r : runs) {
            totalRuns += r;
        }

        double runRate = totalRuns / totalOvers;

        System.out.println("\n====== MATCH SUMMARY ======");
        System.out.println("Extras : " + extras);
        System.out.println("Final Score : " + totalRuns);
        System.out.println("Overs : " + totalOvers);
        System.out.printf("Run Rate : %.2f\n", runRate);
        System.out.println("===========================");

        System.out.println("\n====== BATTING SCOREBOARD ======");
        System.out.printf("%-20s %5s %5s %5s %5s %8s\n","Player","R","B","4s","6s","SR");

        for (int i = 0; i < n; i++) {

            double sr = 0;
            if (balls[i] > 0)
                sr = (runs[i] * 100.0) / balls[i];

            System.out.printf("%-20s %5d %5d %5d %5d %8.2f\n",
                    name[i], runs[i], balls[i], fours[i], sixes[i], sr);
        }

        System.out.println("================================");

        System.out.println("\n====== BOWLING SCOREBOARD ======");
        System.out.printf("%-20s %5s %5s %5s %8s\n","Player","O","R","W","Econ");

        for (int i = 0; i < n; i++) {

            if (overs[i] > 0) {

                double econ = runsConceded[i] / overs[i];

                System.out.printf("%-20s %5.1f %5d %5d %8.2f\n",
                        name[i], overs[i], runsConceded[i], wickets[i], econ);
            }
        }

        System.out.println("================================");

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

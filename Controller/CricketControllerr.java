package controller;

import dao.PlayerDAO;
import model.Batsman;
import model.Bowler;

import java.util.Scanner;

public class CricketControllerr {

    private CricketDAO dao = new CricketDAO();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n--- Cricket Stats Summary ---");
            System.out.println("1. Add Batsman");
            System.out.println("2. Add Bowler");
            System.out.println("3. Show Players");
            System.out.println("4. Exit");

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
}

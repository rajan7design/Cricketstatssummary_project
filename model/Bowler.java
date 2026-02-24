

import model.Bowler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlerManager {

    public static void main(String[] args) {

        List<Bowler> bowlerRoster = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean choice = true;

        while (choice) {
            System.out.println("Enter the name:");
            String name = input.nextLine();

            System.out.println("Enter nationality:");
            String nationality = input.nextLine();

            System.out.println("Enter age:");
            int age = input.nextInt();

            System.out.println("Enter wickets taken:");
            int wickets = input.nextInt();

            System.out.println("Enter runs conceded:");
            int runsConceded = input.nextInt();

            System.out.println("Enter overs bowled:");
            double overs = input.nextDouble();
            input.nextLine();
            
            bowlerRoster.add(new Bowler(name, nationality, age, wickets, runsConceded, overs));

            System.out.println("Do you want to continue adding? (y/n)");
            char c = input.next().charAt(0);
            input.nextLine(); 
            
            if (c == 'n' || c == 'N') {
                choice = false;
            }
        }

        System.out.println("\nCurrent Bowlers Roster:");
        for (Bowler bowler : bowlerRoster) {
            System.out.println(bowler);
            System.out.println();
        }

        if (!bowlerRoster.isEmpty()) {
            Bowler firstBowler = bowlerRoster.get(0);
            System.out.println("First bowler's name: " + firstBowler.getName());
        }

        input.close();
    }
}

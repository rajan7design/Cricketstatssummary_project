

import model.Batsman;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BatsmanManager {

    public static void main(String[] args) {

        List<Batsman> batsmanRoster = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean choice = true;

        while (choice) {
            System.out.println("Enter the name:");
            String name = input.nextLine();

            System.out.println("Enter nationality:");
            String nationality = input.nextLine();

            System.out.println("Enter age:");
            int age = input.nextInt();

            System.out.println("Enter total runs:");
            int runs = input.nextInt();

            System.out.println("Enter total matches:");
            int matches = input.nextInt();
            input.nextLine();
            
            batsmanRoster.add(new Batsman(name, nationality, age, runs, matches));

            System.out.println("Do you want to continue adding? (y/n)");
            char c = input.next().charAt(0);
            input.nextLine(); 

            if (c == 'n' || c == 'N') {
                choice = false;
            }
        }

        System.out.println("\nCurrent Batsmen Roster:");
        for (Batsman batsman : batsmanRoster) {
            System.out.println(batsman);
            System.out.println();
        }

        if (!batsmanRoster.isEmpty()) {
            Batsman firstBatsman = batsmanRoster.get(0);
            System.out.println("First batsman's name: " + firstBatsman.getName());
        }

        input.close();
    }
}

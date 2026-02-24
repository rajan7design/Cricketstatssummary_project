package arrayList;

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

            System.out.println("Enter your nationality:");
            String nationality = input.nextLine();

            batsmanRoster.add(new Batsman(name, average, nationality));

            System.out.println("Do you want to continue adding? (y/n)");
            char c = input.next().charAt(0);
            input.nextLine(); 

            if (c == 'n' || c == 'N') {
                choice = false;
            }
        }

        System.out.println("\nCurrent Roster:");

        for (Batsman batsman : batsmanRoster) {
            System.out.println(batsman);
        }

        if (!batsmanRoster.isEmpty()) {
            Batsman firstBatsman = batsmanRoster.get(0);
            System.out.println("\nFirst batsman's name: " + firstBatsman.getName());
        }

        input.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("\n--- Cricket Stats CLI ---");
            System.out.println("1. Add Batsman");
            System.out.println("2. Add Bowler");
            System.out.println("3. Show All Batsmen");
            System.out.println("4. Show All Bowlers");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
            System.out.println("1.Add Batsman");
            System.out.print("Please enter the Batsman name: ");
            String batsmanName = sc.nextLine();
            System.out.println("Batsman " + batsmanName + " added successfully.");
        } else if (num == 2) {
            System.out.println("2.Add Bowler");
            System.out.print("Please enter the Bowler name: ");
            String bowlerName = sc.nextLine();
            System.out.println("Bowler " + bowlerName + " added successfully.");
        } else if (num == 3) {
            System.out.println("3.Show All Batsmen");
            System.out.println("Displaying all batsmen...");
        } else if (num == 4) {
            System.out.println("4.Show All Bowlers");
            System.out.println("Displaying all bowlers...");
        } else if (num == 5) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Invalid option. Please try again.");
        }
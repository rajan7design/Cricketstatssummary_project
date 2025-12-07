import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Cricket Stats Summary ---");
            System.out.println("1. Add Batsman");
            System.out.println("2. Add Bowler");
            System.out.println("3. Show All Batsmen");
            System.out.println("4. Show All Bowlers");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {

                System.out.println("1. Add Batsman");
                System.out.print("Enter Batsman name: ");
                String batsmanName = sc.nextLine();

                System.out.print("Enter runs: ");
                int runs = sc.nextInt();

                System.out.print("Enter balls faced: ");
                int balls = sc.nextInt();

                System.out.print("Enter times out: ");
                int outs = sc.nextInt();

                System.out.println("Batsman " + batsmanName + " added successfully.");
               
            } else if (num == 2) {

                System.out.println("2. Add Bowler");
                System.out.print("Enter Bowler name: ");
                String bowlerName = sc.nextLine();

                System.out.print("Enter runs conceded: ");
                int runsConceded = sc.nextInt();

                System.out.print("Enter overs bowled: ");
                double overs = sc.nextDouble();

                System.out.print("Enter wickets taken: ");
                int wickets = sc.nextInt();

                System.out.println("Bowler " + bowlerName + " added successfully.");

            } else if (num == 3) {

                System.out.println("Displaying all batsmen...");

            } else if (num == 4) {

                System.out.println("Displaying all bowlers...");

            } else if (num == 5) {

                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}

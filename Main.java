import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = "players.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            System.out.print("How many players do you want to add? ");
            int n = sc.nextInt();
            sc.nextLine(); 
            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details of player " + i);

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                String age = sc.nextLine();

                System.out.print("Nationality: ");
                String nationality = sc.nextLine();

                writer.write("Name: " + name);
                writer.newLine();
                writer.write("Age: " + age);
                writer.newLine();
                writer.write("Nationality: " + nationality);
                writer.newLine();
                writer.write("--------------------");
                writer.newLine();
            }

            writer.close();
            System.out.println("\n Data saved successfully!");

            
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\n Players Details:\n");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(" Error Handling File.");
        }

        sc.close();
    }
}

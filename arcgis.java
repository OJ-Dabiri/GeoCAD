import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CoPlot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int runr = 1;
        while (runr != 0) {
            coPlot(input);
            System.out.print("Enter 0 to stop: ");
            runr = input.nextInt();
        }

        input.close();
    }

    public static void coPlot(Scanner input) {
        System.out.print("Enter plan name: ");
        String plname = input.nextLine();

        FileWriter fil;
        try {
            fil = new FileWriter("arcGIS.txt", true);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.print("Enter number of pillars: ");
        int pilnum = input.nextInt();
        input.nextLine();  // Consume the newline character left by nextInt()

        System.out.print("Enter easting: ");
        float east = input.nextFloat();
        input.nextLine();  // Consume the newline character left by nextFloat()

        System.out.print("Enter northing: ");
        float nort = input.nextFloat();
        input.nextLine();  // Consume the newline character left by nextFloat()

        System.out.print("Enter survey date: ");
        String date = input.nextLine();

        System.out.print("Enter surveyor name: ");
        String surv = input.nextLine();

        for (int i = 0; i < pilnum; i++) {
            try {
                fil.write(plname + ",");
                fil.write(surv + ",");
                fil.write(date + ",");
                System.out.printf("Pillar %d:\n", i);
                System.out.print("Pillar name: ");
                String pillar = input.nextLine();
                fil.write(pillar + ",");
                System.out.print("Enter distance: ");
                float dist = input.nextFloat();
                input.nextLine();  // Consume the newline character left by nextFloat()
                System.out.print("Enter bearing in degrees: ");
                float beard = input.nextFloat();
                input.nextLine();  // Consume the newline character left by nextFloat()
                System.out.print("Enter bearing in minutes: ");
                float bearm = input.nextFloat();
                input.nextLine();  // Consume the newline character left by nextFloat()
                float beardec = beard + (bearm / 60);
                float depar = dist * (float) Math.sin(Math.toRadians(beardec));
                float latt = dist * (float) Math.cos(Math.toRadians(beardec));
                float coneast = east + depar;
                float connort = nort + latt;
                System.out.printf("Easting: %f\n", coneast);
                fil.write(Float.toString(coneast) + ",");
                System.out.printf("Northing: %f\n", connort);
                fil.write(Float.toString(connort) + "\n");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            fil.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
import Day1.FuelCounter;
import Day2.IntcodeComputer;
import Day3.ManhattanSurfaces;
import Day4.PasswordFinder;
import Day5.ModifiedComputer;
import Day5.UltraModifiedComputer;
import Day6.ChecksumCalc;
import Day7.AmplifiersSeries;


import java.util.Scanner;

public class LabMain {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Which day would you like to run? Enter EXIT to exit the program :)");
            String choice = keyboard.next();

            switch (choice.toUpperCase()) {
                case "DAY1", "DAY 1", "DAY ONE", "ONE", "1" -> {
                    System.out.println("part 1 or part 2?");
                    String choice1 = keyboard.next();
                    FuelCounter fuel = new FuelCounter("Day1.txt");
                    if (choice1.toUpperCase().equals("1") || choice1.equals("ONE")) {
                        System.out.println(fuel.theoreticalFuelTotal() + "\n");
                    } else {
                        System.out.println(fuel.actualFuelTotal() + "\n");
                    }
                }

                case "DAY2", "DAY 2", "DAY TWO", "TWO", "2" -> {
                    System.out.println("part 1 or part 2?");
                    String choice1 = keyboard.next();
                    IntcodeComputer computer = new IntcodeComputer("Day2.txt");
                    if (choice1.toUpperCase().equals("1") || choice1.equals("ONE")) {
                        System.out.println(computer.getFirst() + "\n");
                    } else {
                        System.out.println(computer.iterate() + "\n");
                    }
                }

                case "DAY3", "DAY 3", "DAY THREE", "THREE", "3" -> {
                    System.out.println("part 1 or part 2?");
                    String choice1 = keyboard.next();
                    ManhattanSurfaces surface = new ManhattanSurfaces(12001, "Day3_Wire1.txt", "Day3_Wire2.txt");
                    if (choice1.toUpperCase().equals("1") || choice1.equals("ONE")) {
                        System.out.println(surface.minManhattanDist() + "\n");
                    } else {
                        System.out.println(surface.shortestPath().get(0) + "\n");
                    }
                }

                case "DAY4", "DAY 4", "DAY FOUR", "FOUR", "4" -> {
                    System.out.println("part 1 or 2?");
                    String choice1 = keyboard.next();
                    PasswordFinder password = new PasswordFinder("Day4.txt");
                    if (choice1.toUpperCase().equals("1") || choice1.toUpperCase().equals("ONE")) {
                        System.out.println(password.looseSearch() + "\n");
                    } else {
                        System.out.println(password.strictSearch() + "\n");
                    }
                }

                case "DAY5", "DAY 5", "DAY FIVE", "FIVE", "5" -> {
                    System.out.println("Would you like to run the modified or ultra computer?");
                    String choices2 = keyboard.next();
                    if (choices2.toUpperCase().equals("MODIFIED")) {
                        ModifiedComputer modified = new ModifiedComputer();
                        modified.modified("Day5.txt");
                    } else {
                        UltraModifiedComputer ultra = new UltraModifiedComputer();
                        ultra.modified("Day5.txt");
                    }
                }

                case "DAY6", "DAY 6", "DAY SIX", "SIX", "6" -> {
                    ChecksumCalc orbitCount = new ChecksumCalc();
                    System.out.println(orbitCount.checksums("Day6.txt") + " direct and indirect orbits in the system. \n");
                }

                case "DAY7", "DAY 7", "DAY SEVEN", "SEVEN", "7" -> {
                    AmplifiersSeries amps = new AmplifiersSeries();
                    System.out.println("The maximum thruster output signal is " + amps.series("Day7.txt") + "\n");
                }

                case "EXIT" -> System.exit(0);
                default -> System.out.println("Input invalid, please try again! \n");
            }
        }
    }
}
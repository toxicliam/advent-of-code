package adventofcode2019;

import adventofcode2019.Day1.FuelCounter;
import adventofcode2019.Day2.IntcodeComputer;
import adventofcode2019.Day3.ManhattanSurface;
import adventofcode2019.Day4.PasswordFinder;
import adventofcode2019.Day5.ModifiedComputer;
import adventofcode2019.Day5.UltraModifiedComputer;
import adventofcode2019.Day6.ChecksumCalc;
import adventofcode2019.Day7.AmplifiersSeries;
import adventofcode2019.Day7.Problem2.FeedbackLoop;

import java.util.Scanner;

public class LabMain {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Which day would you like to run? Enter EXIT to exit the program.");
            String choice = keyboard.next();
            switch (choice.toUpperCase()) {
                case "DAY1":
                    //AoC Day1
                    FuelCounter code = new FuelCounter();
                    int[] bigbrain = code.fuel("Day1.txt");
                    System.out.println(bigbrain[0] + " pounds of fuel is needed for a ship of " + bigbrain[1] + " mass. \n");
                    break;
                case "DAY2":
                    //AoC Day2
                    IntcodeComputer computer = new IntcodeComputer();
                    try {
                        System.out.println(computer.computer("Day2.txt")[0] + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "DAY3":
                    ManhattanSurface surface = new ManhattanSurface();
                    double[] wires = surface.manhattanSurface(12001, "Day3_Wire1.txt", "Day3_Wire2.txt");
                    System.out.println("Manhattan Distance:: " + wires[0] + "\n");
                    System.out.println("Shortest Path:: " + wires[1] + "\n");
                    break;
                case "DAY4":
                    PasswordFinder password = new PasswordFinder();
                    System.out.print("Would you like to find the first or second password?");
                    String choices = keyboard.next();
                    if (choices.toUpperCase().equals("FIRST")) {
                        System.out.println("There are " + password.rangeSearch("136818", "685979").size() + " viable passwords in the given range. \n");
                    } else {
                        System.out.println("There are " + password.rangeSearch2("136818", "685979") + " vaible passwords in the given range. \n");
                    }
                    break;
                case "DAY5":
                    System.out.println("Would you like to run the modified or ultra computer?");
                    String choices2 = keyboard.next();
                    if (choices2.toUpperCase().equals("MODIFIED")) {
                        ModifiedComputer modified = new ModifiedComputer();
                        modified.modified("Day5.txt");
                    } else {
                        UltraModifiedComputer ultra = new UltraModifiedComputer();
                        ultra.modified("Day5.txt");
                    }
                    break;
                case "DAY6":
                    ChecksumCalc orbitCount = new ChecksumCalc();
                    System.out.println(orbitCount.checksums("Day6.txt") + " direct and indirect orbits in the system. \n");
                    break;
                case "DAY7":
                    System.out.println("Would you like to run the series circuit or the feedback loop?");
                    String choices3 = keyboard.next();
                    switch (choices3.toUpperCase()) {
                        case "SERIES":

                            AmplifiersSeries amps = new AmplifiersSeries();
                            System.out.println("The maximum thruster output signal is " + amps.series("Day7.txt") + "\n");
                            break;
                        case "FEEDBACK":
                            FeedbackLoop pc = new FeedbackLoop();
                            System.out.println(pc.feedback("Day7.txt") + "\n");
                            break;
                    }
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input invalid, please try again! \n");
                    break;
            }
        }
    }
}
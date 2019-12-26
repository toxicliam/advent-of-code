package adventofcode2019;

import adventofcode2019.Day1.FuelCounter;
import adventofcode2019.Day2.IntcodeComputer;
import adventofcode2019.Day3.ManhattanSurface;
import adventofcode2019.Day4.PasswordFinder;
import adventofcode2019.Day5.ModifiedComputer;
import adventofcode2019.Day5.UltraModifiedComputer;
import adventofcode2019.Day6.ChecksumCalc;
import adventofcode2019.Day7.AmplifiersSeries;

import javax.swing.plaf.multi.MultiLookAndFeel;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Which day would you like to run? Enter EXIT to exit the program.");
            String choice = keyboard.next();
            switch (choice.toUpperCase()) {
                case "DAY1":
                    //AoC Day1
                    FuelCounter code = new FuelCounter();
                    printInt(code.fuel("Day1.txt"));
                    break;
                case "DAY2":
                    //AoC Day2
                    IntcodeComputer computer = new IntcodeComputer();
                    try {
                        printInt(computer.computer("Day2.txt")[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "DAY3":
                    ManhattanSurface surface = new ManhattanSurface();
                    try {
                        double[] wires = surface.manhattanSurface(12001, "Day3_Wire1.txt", "Day3_Wire2.txt");
                        printStringDouble("Manhattan Distance:: ", wires[0]);
                        printStringDouble("Shortest Path:: ", wires[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "DAY4":
                    PasswordFinder password = new PasswordFinder();
                    printString("Would you like to find the first or second password?");
                    String choices = keyboard.next();
                    if (choices.toUpperCase().equals("FIRST")) {
                        try {
                            printInt(password.rangeSearch("136818", "685979").size());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            printInt(password.rangeSearch2("136818", "685979"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "DAY5":
                    System.out.println("Would you like to run the modified or ultra computer?");
                    String choices2 = keyboard.next();
                    if (choices2.toUpperCase().equals("MODIFIED")) {
                        ModifiedComputer modified = new ModifiedComputer();
                        try {
                            modified.modified("Day5.txt");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        UltraModifiedComputer ultra = new UltraModifiedComputer();
                        ultra.modified("Day5.txt");
                    }
                    break;
                case "DAY6":
                    ChecksumCalc orbitCount = new ChecksumCalc();
                    System.out.println(orbitCount.checksums("Day6.txt"));
                case "DAY7":
                    AmplifiersSeries amps = new AmplifiersSeries();
                    System.out.println(amps.series("Day7.txt"));
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    printString("Input invalid, please try again!");
                    break;
            }
        }
    }

    private static void printInt(int a) {
        System.out.println(a);
    }

    private static void printStringDouble(String a, double b) {
        System.out.println(a + b);
    }

    private static void printString(String a) {
        System.out.println(a);
    }
}
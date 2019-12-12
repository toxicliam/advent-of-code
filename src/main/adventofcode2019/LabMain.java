package adventofcode2019;

import adventofcode2019.Day1.FuelCounter;
import adventofcode2019.Day2.IntcodeComputer;
import adventofcode2019.Day3.ManhattanSurface;

import java.util.Scanner;

public class LabMain {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Which day would you like to run? Enter EXIT to exit the program.");
            String choice = keyboard.next();
            switch (choice.toUpperCase()) {
                case "DAY1":
                    //AoC Day1
                    FuelCounter code = new FuelCounter();
                    System.out.println(code.fuel("Day1.txt"));
                    break;
                case "DAY2":
                    //AoC Day2
                    IntcodeComputer computer = new IntcodeComputer();
                    try {
                        System.out.println(computer.computer("Day2.txt")[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "DAY3":
                    ManhattanSurface surface = new ManhattanSurface();
                    try {
                        double[] wires = surface.manhattanSurface(12001, "Day3_Wire1.txt", "Day3_Wire2.txt");
                        System.out.println("Manhattan Distance:: " + wires[0]);
                        System.out.println("Shortest Path:: " + wires[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input invalid, please try again!");
                    break;
            }
        }
    }
}
package adventofcode2019;

import adventofcode2019.Day1.FuelCounter;
import adventofcode2019.Day2.IntcodeComputer;
import adventofcode2019.Day3.ManhattanSurface;

import java.util.Scanner;

public class LabMain {
    private static int x = 0;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Which day would you like to run?");
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
                    computer.computer("Day2.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "DAY3":
                ManhattanSurface surface = new ManhattanSurface();
                try {
                    System.out.println("Manhattan Distance:: " + surface.manhattanSurface(12001, "Day3_Wire1.txt", "Day3_Wire2.txt"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
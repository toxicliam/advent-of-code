package adventofcode2019.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FuelCounter {
    public int fakeFuel(double a) {
        return (int) (Math.floor(a / 3) - 2);
    }

    public int actualFuel(double a) {
        int fuel = fakeFuel(a);
        int burden = (int) (Math.floor((double) fuel / 3) - 2);

        while (burden > 0) {
            fuel += burden;
            burden = (int) (Math.floor((double) burden / 3) - 2);
        }
        return fuel;
    }

    public int fuel(String a) {
        Scanner scanner1 = null;
        try {
            scanner1 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> instructions = new ArrayList<>();
        assert scanner1 != null;
        while (scanner1.hasNext()) {
            instructions.add(scanner1.next());
        }
        int loops = instructions.size();
        int iteration = 0;
        int sum = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to calculate the actual fuel (a) or the theoretical fuel (t)?");
        String choice = keyboard.next();
        switch (choice.toUpperCase()) {
            case "A":
                for (int x = 0; x < loops; x++) {
                    sum += actualFuel(Integer.parseInt(instructions.get(iteration)));
                    iteration++;
                }
                break;
            case "T":
                for (int x = 0; x < loops; x++) {
                    sum += fakeFuel(Integer.parseInt(instructions.get(iteration)));
                    iteration++;
                }
                break;
        }
        return sum;
    }
}

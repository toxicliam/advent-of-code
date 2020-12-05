package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FuelCounter {
    private ArrayList<String> masses = new ArrayList<>();
    private int sum;

    public FuelCounter(String a) throws FileNotFoundException {

        Scanner scanner1 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner1.hasNext()) {
            masses.add(scanner1.next());
        }
    }

    public FuelCounter() {
    }

    public int theoreticalFuelTotal() {
        for (String s : masses) {
            sum += fakeFuel(Integer.parseInt(s));
        }
        return sum;
    }

    public int actualFuelTotal() {
        for (String s : masses) {
            sum += actualFuel(Integer.parseInt(s));
        }
        return sum;
    }

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
}

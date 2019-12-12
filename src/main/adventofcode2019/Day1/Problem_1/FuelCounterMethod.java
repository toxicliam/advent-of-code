package AdventOfCode2019.Day1.Problem_1;

public class FuelCounterMethod {
    private int fuel;
    public int fuelCounterUpper (double a){
        return (int)(Math.round(a / 3) - 2);
    }
}

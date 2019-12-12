package AdventOfCode2019.Day1.Problem_2;

public class FuelCounterMethod2 {
    private int fuel, extra;
    public int fuelCounterUpper (double a){
        fuel = (int) (Math.floor(a / 3) - 2);
        extra = (int) (Math.floor((double)fuel / 3) - 2);

        while (extra>0) {
            fuel += extra;
            extra =(int) (Math.floor((double)extra / 3) - 2);
        }
        return fuel;
    }
}

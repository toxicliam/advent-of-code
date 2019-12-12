package Day1;

import adventofcode2019.Day1.FuelCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActualFuelTest {
    @Test
    public void test1(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(2, fuel.actualFuel(14));
    }
    @Test
    public void test2(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(966, fuel.actualFuel(1969));
    }
    @Test
    public void test3(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(50346, fuel.actualFuel(100756));
    }
}

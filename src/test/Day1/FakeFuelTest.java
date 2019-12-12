package Day1;

import adventofcode2019.Day1.FuelCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FakeFuelTest {
    @Test
    public void test1(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(2, fuel.fakeFuel(12));
    }
    @Test
    public void test2(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(2, fuel.fakeFuel(14));
    }
    @Test
    public void test3(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(654, fuel.fakeFuel(1969));
    }
    @Test
    public void test4(){
        FuelCounter fuel = new FuelCounter();
        Assertions.assertEquals(33583, fuel.fakeFuel(100756));
    }
}

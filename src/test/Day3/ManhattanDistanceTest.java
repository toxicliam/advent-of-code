package Day3;

import adventofcode2019.Day3.ManhattanSurface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManhattanDistanceTest {
    @Test
    public void Example1()throws Exception{
        ManhattanSurface distance = new ManhattanSurface();
        Assertions.assertEquals(159, distance.manhattanSurface(10001, "Day3TestExample1_Wire1.txt", "Day3TestExample1_Wire2.txt"));
    }
    @Test
    public void Example2()throws Exception{
        ManhattanSurface distance = new ManhattanSurface();
        Assertions.assertEquals(135, distance.manhattanSurface(10001, "Day3TestExample2_Wire1.txt", "Day3TestExample2_Wire2.txt"));
    }
    @Test
    public void Example3()throws Exception{
        ManhattanSurface distance = new ManhattanSurface();
        Assertions.assertEquals(6, distance.manhattanSurface(31, "Day3TestExample3_Wire1.txt", "Day3TestExample3_Wire2.txt"));
    }
}

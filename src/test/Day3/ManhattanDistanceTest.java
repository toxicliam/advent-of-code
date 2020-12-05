package Day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManhattanDistanceTest {
    @Test
    public void Example1() throws Exception {
        ManhattanSurfaces distance = new ManhattanSurfaces(31, "Day3TestExample1_Wire1.txt", "Day3TestExample1_Wire2.txt");
        Assertions.assertEquals(6, distance.minManhattanDist());
    }

    @Test
    public void Example2() throws Exception {
        ManhattanSurfaces distance = new ManhattanSurfaces(10001, "Day3TestExample2_Wire1.txt", "Day3TestExample2_Wire2.txt");
        Assertions.assertEquals(159, distance.minManhattanDist());
    }

    @Test
    public void Example3() throws Exception {
        ManhattanSurfaces distance = new ManhattanSurfaces(10001, "Day3TestExample3_Wire1.txt", "Day3TestExample3_Wire2.txt");
        Assertions.assertEquals(135, distance.minManhattanDist());
    }

}

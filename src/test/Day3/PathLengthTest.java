package Day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathLengthTest {
    @Test
    public void test1() throws Exception {
        ManhattanSurfaces path = new ManhattanSurfaces(31, "Day3TestExample1_Wire1.txt", "Day3TestExample1_Wire2.txt");
        Assertions.assertEquals(30, path.shortestPath().get(0));
    }

    @Test
    public void test2() throws Exception {
        ManhattanSurfaces path = new ManhattanSurfaces(10001, "Day3TestExample2_Wire1.txt", "Day3TestExample2_Wire2.txt");
        Assertions.assertEquals(610, path.shortestPath().get(0));
    }

    @Test
    public void test3() throws Exception {

        ManhattanSurfaces path = new ManhattanSurfaces(10001, "Day3TestExample3_Wire1.txt", "Day3TestExample3_Wire2.txt");
        Assertions.assertEquals(410, path.shortestPath().get(0));
    }
}

package Day3;

import adventofcode2019.Day3.ManhattanSurface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathLengthTest {
    @Test
    public void test1(){
        ManhattanSurface path = new ManhattanSurface();
        try {
            double[] wires = path.manhattanSurface(31, "Day3TestExample1_Wire1.txt", "Day3TestExample1_Wire2.txt");
            Assertions.assertEquals(30, wires[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        ManhattanSurface path = new ManhattanSurface();
        try {
            double[] wires = path.manhattanSurface(10001, "Day3TestExample2_Wire1.txt", "Day3TestExample2_Wire2.txt");
            Assertions.assertEquals(610, wires[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        ManhattanSurface path = new ManhattanSurface();
        try {
            double[] wires = path.manhattanSurface(10001, "Day3TestExample3_Wire1.txt", "Day3TestExample3_Wire2.txt");
            Assertions.assertEquals(410, wires[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

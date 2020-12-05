package Day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntcodeComputerTest {
    @Test
    public void testExample1() throws Exception {
        IntcodeComputer test1 = new IntcodeComputer("Day2TestExample1.txt");
        Assertions.assertArrayEquals(new Integer[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50}, test1.computer());
    }

    @Test
    public void testExample2() throws Exception {
        IntcodeComputer test2 = new IntcodeComputer("Day2TestExample2.txt");
        Assertions.assertArrayEquals(new Integer[]{2, 0, 0, 0, 99}, test2.computer());
    }

    @Test
    public void testExample3() throws Exception {
        IntcodeComputer test3 = new IntcodeComputer("Day2TestExample3.txt");
        Assertions.assertArrayEquals(new Integer[]{2, 3, 0, 6, 99}, test3.computer());
    }

    @Test
    public void testExample4() throws Exception {
        IntcodeComputer test4 = new IntcodeComputer("Day2TestExample4.txt");
        Assertions.assertArrayEquals(new Integer[]{2, 4, 4, 5, 99, 9801}, test4.computer());
    }

    @Test
    public void testExample5() throws Exception {
        IntcodeComputer test5 = new IntcodeComputer("Day2TestExample5.txt");
        Assertions.assertArrayEquals(new Integer[]{30, 1, 1, 4, 2, 5, 6, 0, 99}, test5.computer());
    }
}

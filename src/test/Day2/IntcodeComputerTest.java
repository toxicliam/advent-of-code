package Day2;

import adventofcode2019.Day2.IntcodeComputer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntcodeComputerTest {
    @Test
    public void testExample1() throws Exception {

        IntcodeComputer test1 = new IntcodeComputer();
        Integer[] expected1 = new Integer[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50};

        Assertions.assertArrayEquals(expected1, test1.computer("Day2TestExample1.txt"));
    }

    @Test
    public void testExample2() throws Exception {

        IntcodeComputer test2 = new IntcodeComputer();
        Integer[] expected2 = new Integer[]{2, 0, 0, 0, 99};

        Assertions.assertArrayEquals(expected2, test2.computer("Day2TestExample2.txt"));
    }

    @Test
    public void testExample3() throws Exception {

        IntcodeComputer test3 = new IntcodeComputer();
        Integer[] expected3 = new Integer[]{2, 3, 0, 6, 99};

        Assertions.assertArrayEquals(expected3, test3.computer("Day2TestExample3.txt"));
    }

    @Test
    public void testExample4() throws Exception {

        IntcodeComputer test4 = new IntcodeComputer();
        Integer[] expected4 = new Integer[]{2, 4, 4, 5, 99, 9801};

        Assertions.assertArrayEquals(expected4, test4.computer("Day2TestExample4.txt"));
    }

    @Test
    public void testExample5() throws Exception {

        IntcodeComputer test5 = new IntcodeComputer();
        Integer[] expected5 = new Integer[]{30, 1, 1, 4, 2, 5, 6, 0, 99};
        Assertions.assertArrayEquals(expected5, test5.computer("Day2TestExample5.txt"));
    }
}

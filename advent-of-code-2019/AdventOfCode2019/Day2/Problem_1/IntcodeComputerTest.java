package Day2.Problem_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntcodeComputerTest {
    @Test
    public void testExample1() throws Exception {

        Integer[] opcodeInt = {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
        IntcodeComputer test1 = new IntcodeComputer();
        Integer[] expected1 = new Integer[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50};

        Assertions.assertArrayEquals(expected1, test1.computer2(opcodeInt));
    }

    @Test
    public void testExample2() throws Exception {

        Integer[] opcodeInt = {1, 1, 1, 4, 99, 5, 6, 0, 99};
        IntcodeComputer test1 = new IntcodeComputer();
        Integer[] expected1 = new Integer[]{30, 1, 1, 4, 2, 5, 6, 0, 99};

        Assertions.assertArrayEquals(expected1, test1.computer2(opcodeInt));
    }

    @Test
    public void testExample3() throws Exception {

        Integer[] opcodeInt = {1, 0, 0, 0, 99};
        IntcodeComputer test1 = new IntcodeComputer();
        Integer[] expected1 = new Integer[]{2, 0, 0, 0, 99};

        Assertions.assertArrayEquals(expected1, test1.computer2(opcodeInt));
    }

    @Test
    public void testExample4() throws Exception {

        Integer[] opcodeInt = {2, 3, 0, 3, 99};
        IntcodeComputer test1 = new IntcodeComputer();
        Integer[] expected1 = new Integer[]{2, 3, 0, 6, 99};

        Assertions.assertArrayEquals(expected1, test1.computer2(opcodeInt));
    }

    @Test
    public void testExample5() throws Exception {

        Integer[] opcodeInt = {2, 4, 4, 5, 99, 0};
        IntcodeComputer test1 = new IntcodeComputer();
        Integer[] expected1 = new Integer[]{2, 4, 4, 5, 99, 9801};

        Assertions.assertArrayEquals(expected1, test1.computer2(opcodeInt));
    }
    @Test
    public void testAnswer()throws Exception {

        Integer[] opcodeInt = {1,12,2,1,1,2,3,1,3,4,3,1,5,0,3,2,1,9,19,1,19,5,23,2,6,23,27,1,6,27,31,2,31,9,35,1,35,6,39,1,10,39,43,2,9,43,47,1,5,47,51,2,51,6,55,1,5,55,59,2,13,59,63,1,63,5,67,2,67,13,71,1,71,9,75,1,75,6,79,2,79,6,83,1,83,5,87,2,87,9,91,2,9,91,95,1,5,95,99,2,99,13,103,1,103,5,107,1,2,107,111,1,111,5,0,99,2,14,0,0};
        IntcodeComputer test1 = new IntcodeComputer();

        Assertions.assertEquals(2, test1.computer2(opcodeInt)[0]);
    }
}

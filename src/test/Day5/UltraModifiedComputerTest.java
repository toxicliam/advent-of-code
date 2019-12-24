package Day5;

import adventofcode2019.Day5.UltraModifiedComputer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class UltraModifiedComputerTest {
    @Test
    public void test1() throws FileNotFoundException {
        UltraModifiedComputer computer = new UltraModifiedComputer();
        Assertions.assertEquals(0, computer.modified("Day5TestExample4-1.txt").get(7));
    }
    @Test
    public void test2() throws FileNotFoundException {
        UltraModifiedComputer computer2 = new UltraModifiedComputer();
        Assertions.assertEquals(1, computer2.modified("Day5TestExample4-2.txt").get(7));
    }
    @Test
    public void test3() throws FileNotFoundException {
        UltraModifiedComputer computer3 = new UltraModifiedComputer();
        Assertions.assertEquals(1, computer3.modified("Day5TestExample5-1.txt").get(7));
    }
    @Test
    public void test4() throws FileNotFoundException {
        UltraModifiedComputer computer4 = new UltraModifiedComputer();
        Assertions.assertEquals(0, computer4.modified("Day5TestExample5-2.txt").get(7));
    }
    @Test
    public void test5() throws FileNotFoundException {
        UltraModifiedComputer computer5 = new UltraModifiedComputer();
        Assertions.assertEquals(0, computer5.modified("Day5TestExample6-1.txt").get(3));
    }
    @Test
    public void test6() throws FileNotFoundException {
        UltraModifiedComputer computer6 = new UltraModifiedComputer();
        Assertions.assertEquals(1, computer6.modified("Day5TestExample6-2.txt").get(3));
    }
}

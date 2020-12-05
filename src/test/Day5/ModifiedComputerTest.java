package Day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModifiedComputerTest {
    @Test
    public void test1() {
        ModifiedComputer computer = new ModifiedComputer();
        Assertions.assertEquals(99, computer.modified("Day5TestExample1.txt").get(4));
    }

    @Test
    public void test2() {
        ModifiedComputer computer2 = new ModifiedComputer();
        Assertions.assertEquals(99, computer2.modified("Day5TestExample2.txt").get(4));
    }
    @Test
    public void test3() {
        ModifiedComputer computer3 = new ModifiedComputer();
        Assertions.assertEquals(2, computer3.modified("Day5TestExample3.txt").get(4));
    }
}

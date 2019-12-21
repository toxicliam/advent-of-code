package Day5;

import adventofcode2019.Day5.UltraModifiedComputer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UltraModifiedCopmuterTest {
    @Test
    public void test1(){
        UltraModifiedComputer computer = new UltraModifiedComputer();
        Assertions.assertEquals(1, computer.modified("Day5TestExample4.txt").get(9));
    }
}

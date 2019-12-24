package Day6;

import adventofcode2019.Day6.ChecksumCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ChecksumCalcTest {
    @Test
    public void test1() throws FileNotFoundException {
        ChecksumCalc example1 = new ChecksumCalc();
        Assertions.assertEquals(42, example1.checksums("Day6TestExample1.txt"));
    }
}

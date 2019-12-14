package Day4;

import adventofcode2019.Day4.PasswordFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFinderTest {
    @Test
    public void test1() {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(1, pass.rangeSearch("10", "15" ).size());
    }
    @Test
    public void test2() {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(2, pass.rangeSearch("10", "30" ).size());
    }
    @Test
    public void test3() {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(5, pass.rangeSearch("10", "56" ).size());
    }
}
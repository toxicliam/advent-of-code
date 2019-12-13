package Day4;

import adventofcode2019.Day4.PasswordFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFinderTest {
    @Test
    public void test1() {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(1, pass.rangeSearch("10", "15" ));
    }
}

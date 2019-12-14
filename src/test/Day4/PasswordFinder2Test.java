package Day4;

import adventofcode2019.Day4.PasswordFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFinder2Test {
    @Test
    public void test1() throws Exception {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(1, pass.rangeSearch2("112232", "112234" ));
    }
    @Test
    public void test2() throws Exception {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(2, pass.rangeSearch2("10", "30" ));
    }
    @Test
    public void test3() throws Exception {
        PasswordFinder pass = new PasswordFinder();
        Assertions.assertEquals(5, pass.rangeSearch2("10", "56" ));
    }
}

package Day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFinderTest {
    @Test
    public void test1() throws Exception {
        PasswordFinder pass = new PasswordFinder("Day4Example1.txt");
        Assertions.assertEquals(1, pass.looseSearch());
    }

    @Test
    public void test2() throws Exception {
        PasswordFinder pass = new PasswordFinder("Day4Example2.txt");
        Assertions.assertEquals(2, pass.looseSearch());
    }

    @Test
    public void test3() throws Exception {
        PasswordFinder pass = new PasswordFinder("Day4Example3.txt");
        Assertions.assertEquals(5, pass.looseSearch());
    }
}

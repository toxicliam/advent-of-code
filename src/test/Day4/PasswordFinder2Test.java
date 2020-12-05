package Day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFinder2Test {
    @Test
    public void test1() throws Exception {
        PasswordFinder pass = new PasswordFinder("Day4Example12.txt");
        Assertions.assertEquals(1, pass.strictSearch());
    }

    @Test
    public void test2() throws Exception {
        PasswordFinder pass = new PasswordFinder("Day4Example22.txt");
        Assertions.assertEquals(2, pass.strictSearch());
    }

    @Test
    public void test3() throws Exception {
        PasswordFinder pass = new PasswordFinder("Day4Example32.txt");
        Assertions.assertEquals(5, pass.strictSearch());
    }
}

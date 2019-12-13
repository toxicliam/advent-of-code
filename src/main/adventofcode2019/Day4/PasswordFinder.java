package adventofcode2019.Day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordFinder {
    public int rangeSearch(int a, int b) {
        List<Integer> answer = new ArrayList<>();
        int run = 0;
        for (int x = a; x < b; x++) {
            List<Integer> digit = new ArrayList<>();
            int fail = 0;
            while (x > 0) {
                int lastDigit = x % 10;
                digit.add(lastDigit);
                x = x / 10;
            }
            Collections.reverse(digit);
            for (int z = 0; z < digit.size() - 1; z++) {
                if (digit.get(z) > digit.get(z + 1)) {
                    continue;
                }
                if (run == 0) {
                    for (int y = 0; y < digit.size() - 1; y++) {
                        if (!((digit.get(y)).equals(digit.get(y + 1)))) {
                            fail++;
                        }
                    }
                    run++;
                }
            }
            if (fail < digit.size() - 1) {
                answer.add(a + x);
            }
            System.out.println("System ran successfully");
        }
        return answer.size();
    }
}
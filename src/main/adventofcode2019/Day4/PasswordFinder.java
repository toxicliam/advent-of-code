package adventofcode2019.Day4;

import java.util.ArrayList;
import java.util.List;

public class PasswordFinder {
    public int rangeSearch(String a, String b) {
        int max = Integer.parseInt(b) - Integer.parseInt(a);
        List<Integer> answers = new ArrayList<>();
        boolean skip = false;
        int bottom = Integer.parseInt(a);
        for (int x = bottom + 1; x < bottom + max; x++) {
            String num = String.valueOf(x);
            int pass = 0;
            for (int z = 0; z < a.length() - 1; z++) {
                char first = num.charAt(z);
                char second = num.charAt(z + 1);
                if (first == second) {
                    pass++;
                }
            }
            for (int z = 0; z < a.length() - 1; z++) {
                char first = num.charAt(z);
                char second = num.charAt(z + 1);
                if (first > second) {
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                if (pass > a.length() - 1) {
                    answers.add(Integer.parseInt(num));
                }
            }
        }
        return answers.size();
    }
}
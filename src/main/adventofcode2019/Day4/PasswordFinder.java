package adventofcode2019.Day4;

import java.util.ArrayList;
import java.util.List;

public class PasswordFinder {
    public List<Integer> rangeSearch(String a, String b) {
        int max = Integer.parseInt(b) - Integer.parseInt(a);
        List<Integer> answers = new ArrayList<>();
        int bottom = Integer.parseInt(a);
        for (int x = bottom + 1; x < bottom + max; x++) {
            String num = String.valueOf(x);
            int pass = 0;
            boolean skip = false;
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
                if (pass > 0) {
                    answers.add(Integer.parseInt(num));
                }
            }
        }
        return answers;
    }

    public int rangeSearch2(String a, String b) {
        List<Integer> source;
        source = rangeSearch(a, b);
        System.out.println(source.size());
        List<Integer> answers = new ArrayList<>();
        int max = Integer.parseInt(b) - Integer.parseInt(a);
        int bottom = Integer.parseInt(a);
        int iteration = 0;
        for (int z = bottom + 1; z < bottom + max - 1; z++) {
            String num = String.valueOf(source.get(iteration));
            int fail = 0;
            for (int x = 0; x < num.length() - 2; x++) {
                char first = num.charAt(x);
                char second = num.charAt(x + 1);
                char third = num.charAt(x + 2);
                if (first == second && second == third) {
                    fail++;
                }
            }
            if (fail != 0) {
                answers.add(z + bottom);
            }
            iteration++;
        }
        return answers.size();
    }
}
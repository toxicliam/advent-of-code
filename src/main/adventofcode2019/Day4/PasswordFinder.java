package adventofcode2019.Day4;

import java.util.ArrayList;
import java.util.List;

public class PasswordFinder {
    public ArrayList<Integer> rangeSearch(String a, String b) {
        int max = Integer.parseInt(b) - Integer.parseInt(a);
        ArrayList<Integer> answers = new ArrayList<>();
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
        ArrayList<Integer> source = rangeSearch(a, b);
        System.out.println(source.size());
        List<Integer> answers = new ArrayList<>();
        int max = Integer.parseInt(b) - Integer.parseInt(a);
        int bottom = Integer.parseInt(a);
        for (int z = 1; z < max - 2; z++) {
            String num = String.valueOf(source.get(z - 1));
            int pass = 0;
            for (int x = 0; x < num.length() - 2; x++) {
                char first = num.charAt(x);
                char second = num.charAt(x + 1);
                char third = num.charAt(x + 2);
                if (first == second && second != third) {
                    pass++;
                }
            }
            if (pass > 0) {
                answers.add(z + bottom);
            }
        }
        return answers.size();
    }
}
package adventofcode2019.Day4;

import java.util.ArrayList;
import java.util.List;

public class PasswordFinder {
    public ArrayList<Integer> rangeSearch(String a, String b) throws Exception {
        int max = Integer.parseInt(b) - Integer.parseInt(a);
        ArrayList<Integer> answers = new ArrayList<>();
        int bottom = Integer.parseInt(a);
        for (int x = 1; x < max; x++) {
            String num = String.valueOf(x + bottom);
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

    public int rangeSearch2(String a, String b) throws Exception {
        ArrayList<Integer> source = rangeSearch(a, b);
        List<Integer> answers = new ArrayList<>();
        int max = source.size();
        int bottom = Integer.parseInt(a);
        for (int z = 0; z < max - 1; z++) {
            String num = String.valueOf(source.get(z));
            int size = num.length();
            int pass = 0;
            ArrayList<Character> numArray = new ArrayList<>();
            for (int x = 0; x <= size - 1; x++) {
                numArray.add(num.charAt(x));
            }
            if (numArray.toArray()[0] == numArray.toArray()[1] && numArray.toArray()[1] != numArray.toArray()[2])
                pass++;
            for (int x = 1; x < size - 1; x++) {
                char first = numArray.get(x - 1);
                char second = numArray.get(x);
                char third = numArray.get(x + 1);
                if (x + 2 < size) {
                    char fourth = numArray.get(x + 2);
                    if (second == third && second != first && second != fourth)
                        pass++;
                } else {
                    if (numArray.toArray()[size - 2] == numArray.toArray()[size - 1] && numArray.toArray()[size - 2] != numArray.toArray()[size - 3])
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
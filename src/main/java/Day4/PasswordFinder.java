package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PasswordFinder {
    String[] range = new String[]{"", ""};

    public PasswordFinder(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile())).useDelimiter("-");
        int i = 0;
        while (scanner.hasNext()) {
            range[i] = scanner.next();
            i++;
        }
    }

    public int looseSearch() {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(range[1]) - Integer.parseInt(range[0]); i++) {
            if (isValid((Integer.parseInt(range[0]) + i)))
                values.add("" + (Integer.parseInt(range[0]) + i));
        }
        return values.size();
    }

    public int strictSearch() {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(range[1]) - Integer.parseInt(range[0]); i++) {
            if (isValid((Integer.parseInt(range[0]) + i)) && strictRule((Integer.parseInt(range[0]) + i)))
                values.add("" + (Integer.parseInt(range[0]) + i));
        }
        return values.size();
    }

    public boolean isValid(int pass) {
        if (("" + pass).length() != 6)
            return false;

        if (pass > Integer.parseInt(range[1]) || pass < Integer.parseInt(range[0]))
            return false;
        int same = 0;
        for (int i = 0; i < ("" + pass).length() - 1; i++) {
            if (Integer.parseInt("" + ("" + pass).charAt(i)) > Integer.parseInt("" + ("" + pass).charAt(i + 1)))
                return false;
            if (("" + pass).charAt(i) == ("" + pass).charAt(i + 1))
                same++;
        }
        return same != 0;
    }

    public boolean strictRule(int pass) {
        for (int i = 0; i < ("" + pass).length() - 1; i++) {
            char current = ("" + pass).charAt(i);
            if (current == ("" + pass).charAt(i + 1)) {
                for (int j = i + 2; j < ("" + pass).length(); j++) {
                    if (current == ("" + pass).charAt(j))
                        return false;
                }
            }
        }
        return true;
    }
//    public ArrayList<Integer> rangeSearch(String a, String b) throws Exception {
//        int max = Integer.parseInt(b) - Integer.parseInt(a);
//        ArrayList<Integer> answers = new ArrayList<>();
//        int bottom = Integer.parseInt(a);
//        for (int x = 1; x < max; x++) {
//            String num = String.valueOf(x + bottom);
//            int pass = 0;
//            boolean skip = false;
//            for (int z = 0; z < a.length() - 1; z++) {
//                char first = num.charAt(z);
//                char second = num.charAt(z + 1);
//                if (first == second) {
//                    pass++;
//                }
//            }
//            for (int z = 0; z < a.length() - 1; z++) {
//                char first = num.charAt(z);
//                char second = num.charAt(z + 1);
//                if (first > second) {
//                    skip = true;
//                    break;
//                }
//            }
//            if (!skip) {
//                if (pass > 0) {
//                    answers.add(Integer.parseInt(num));
//                }
//            }
//        }
//        return answers;
//    }

//    public int rangeSearch2(String a, String b) throws Exception {
//        ArrayList<Integer> source = rangeSearch(a, b);
//        List<Integer> answers = new ArrayList<>();
//        int max = source.size();
//        int bottom = Integer.parseInt(a);
//        for (int z = 0; z < max - 1; z++) {
//            String num = String.valueOf(source.get(z));
//            int size = num.length();
//            int pass = 0;
//            ArrayList<Character> numArray = new ArrayList<>();
//            for (int x = 0; x <= size - 1; x++) {
//                numArray.add(num.charAt(x));
//            }
//            if (numArray.toArray()[0] == numArray.toArray()[1] && numArray.toArray()[1] != numArray.toArray()[2])
//                pass++;
//            for (int x = 1; x < size - 1; x++) {
//                char first = numArray.get(x - 1);
//                char second = numArray.get(x);
//                char third = numArray.get(x + 1);
//                if (x + 2 < size) {
//                    char fourth = numArray.get(x + 2);
//                    if (second == third && second != first && second != fourth)
//                        pass++;
//                } else {
//                    if (numArray.toArray()[size - 2] == numArray.toArray()[size - 1] && numArray.toArray()[size - 2] != numArray.toArray()[size - 3])
//                        pass++;
//                }
//            }
//            if (pass > 0) {
//                answers.add(z + bottom);
//            }
//        }
//        return answers.size();
//    }
}
package adventofcode2019.Day7;

import java.util.ArrayList;
import java.util.List;

public class HeapAlg {
    private static List<String> phase = new ArrayList<>();

    public List<String> printAllRecursive(
            int n, int[] elements) {
        while (true) {
            if (n == 1) {
                return printArray(elements);
            } else {
                for (int i = 0; i < n - 1; i++) {
                    printAllRecursive(n - 1, elements);
                    if (n % 2 == 0) {
                        swap(elements, i, n - 1);
                    } else {
                        swap(elements, 0, n - 1);
                    }
                }
                printAllRecursive(n - 1, elements);
            }
        }

    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static List<String> printArray(int[] input) {
        String setting = "";
        for (int t = 0; t <= 4; t++) {
            setting = String.valueOf(input[t]);
        }
        phase.add(setting);
        return phase;
    }
}

package adventofcode2019.Day7;


import java.io.FileNotFoundException;
import java.util.*;

public class AmplifiersSeries {
    private static List<String> perm = new ArrayList<>();

    public Integer series(String a) throws FileNotFoundException {

        List<Integer> output = new ArrayList<>();
        int[] phase = {0, 1, 2, 3, 4};
        printAllRecursive(5, phase);
        int amp4CodeInt;
        int amp3CodeInt;
        int amp2CodeInt;
        int amp1CodeInt;
        for (int i = 0; i < perm.size(); i++) {
            Map<Integer, String> setting = new HashMap<>();
            for (int j = 0; j <= 4; j++) {
                String h;
                try {
                    h = perm.get(i).substring(j, j + 1);
                } catch (IndexOutOfBoundsException e) {
                    h = perm.get(i).substring(j);
                }
                setting.putIfAbsent(j, h);
            }
            AmpComputer computer = new AmpComputer();
            amp1CodeInt = computer.modified(a, Integer.parseInt(setting.get(0)), 0);
            amp2CodeInt = computer.modified(a, Integer.parseInt(setting.get(1)), amp1CodeInt);
            amp3CodeInt = computer.modified(a, Integer.parseInt(setting.get(2)), amp2CodeInt);
            amp4CodeInt = computer.modified(a, Integer.parseInt(setting.get(3)), amp3CodeInt);
            output.add(computer.modified(a, Integer.parseInt(setting.get(4)), amp4CodeInt));
            System.out.println(i);
        }
        Collections.sort(output);
        Collections.reverse(output);
        return output.get(0);
    }

    public void printAllRecursive(int n, int[] input) {
        if (n == 1) {
            printArray(input);
        } else {
            printAllRecursive(n - 1, input);
            for (int i = 0; i < n - 1; i++) {
                if (n % 2 == 0) {
                    swap(input, i, n - 1);
                } else {
                    swap(input, 0, n - 1);
                }
                printAllRecursive(n - 1, input);
            }
        }

    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void printArray(int[] input) {
        StringBuilder setting = new StringBuilder();
        for (int t = 0; t <= 4; t++) {
            setting.append(input[t]);
        }
        perm.add(setting.toString());

    }
}



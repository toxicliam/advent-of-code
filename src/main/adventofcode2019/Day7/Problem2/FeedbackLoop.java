package adventofcode2019.Day7.Problem2;


import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FeedbackLoop {
    private static List<String> perm = new ArrayList<>();
    private FeedbackComputer computer = new FeedbackComputer();
    private int d = 0;

    public Integer series(String a) throws FileNotFoundException {

        List<Integer> output = new ArrayList<>();
        int[] phase = {0, 1, 2, 3, 4};
        printAllRecursive(5, phase);
        AtomicInteger amp5CodeInt = new AtomicInteger();
        AtomicInteger amp4CodeInt = new AtomicInteger();
        AtomicInteger amp3CodeInt = new AtomicInteger();
        AtomicInteger amp2CodeInt = new AtomicInteger();
        AtomicInteger amp1CodeInt = new AtomicInteger();
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
            Runnable amp1 = () -> {
                if (d == 0) {
                    try {
                        amp1CodeInt.set(computer.modified(a, Integer.parseInt(setting.get(0)), 0));
                        d++;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        amp1CodeInt.set(computer.modified(a, Integer.parseInt(setting.get(0)), Integer.parseInt(String.valueOf(amp5CodeInt))));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            };
            Runnable amp2 = () -> {
                try {
                    amp2CodeInt.set(computer.modified(a, Integer.parseInt(setting.get(1)), Integer.parseInt(String.valueOf(amp1CodeInt))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            };
            Runnable amp3 = () -> {
                try {
                    amp3CodeInt.set(computer.modified(a, Integer.parseInt(setting.get(2)), Integer.parseInt(String.valueOf(amp2CodeInt))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            Runnable amp4 = () -> {
                try {
                    amp4CodeInt.set(computer.modified(a, Integer.parseInt(setting.get(3)), Integer.parseInt(String.valueOf(amp3CodeInt))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            Runnable amp5 = () -> {
                try {
                    amp5CodeInt.set(computer.modified(a, Integer.parseInt(setting.get(4)), Integer.parseInt(String.valueOf(amp4CodeInt))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
//            output.add(computer.modified(a, Integer.parseInt(setting.get(4)), amp4CodeInt.get()));
//            System.out.println(i);
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



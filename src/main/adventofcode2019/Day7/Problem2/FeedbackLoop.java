package adventofcode2019.Day7.Problem2;


import java.io.FileNotFoundException;
import java.util.*;

public class FeedbackLoop {
    private static List<String> perm = new ArrayList<>();
    private FeedbackComputer computer = new FeedbackComputer();
    private int d = 0, s = 0, h = 0, c = 0;
    private Thread second, third, fourth, fifth;

    public Integer feedback(String a) throws FileNotFoundException {
        List<Integer> output = new ArrayList<>();
        int[] phase = {5, 6, 7, 8, 9};
        printAllRecursive(5, phase);

        Queue<Integer[]> queue12 = new LinkedList<>();
        Queue<Integer[]> queue23 = new LinkedList<>();
        Queue<Integer[]> queue34 = new LinkedList<>();
        Queue<Integer[]> queue45 = new LinkedList<>();
        Queue<Integer[]> queue51 = new LinkedList<>();
        queue12.add(new Integer[]{0, 0});

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
                try {
                    Integer[] amp1Output = computer.modified(a, Integer.parseInt(setting.get(0)), 0, 0);
                    queue12.add(amp1Output);
                    if (d == 0)
                        second.start();
                    d++;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                } else if (!(queue51.peek() == null)) {
//                    try {
//                        Integer[] inputted = queue51.poll();
//                        Integer[] amp1Output = computer.modified(a, Integer.parseInt(setting.get(4)), inputted[0], inputted[1]);
//                        queue12.add(amp1Output);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
            };
            Thread first = new Thread(amp1);
            Runnable amp2 = () -> {
                try {
                    Integer[] inputted = queue12.poll();
                    Integer[] amp3Output = computer.modified(a, Integer.parseInt(setting.get(1)), inputted[0], inputted[1]);
                    queue23.add(amp3Output);
                    if (h == 0) {
                        third.start();
                        h++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            second = new Thread(amp2);

            Runnable amp3 = () -> {
                try {
                    Integer[] inputted = queue23.poll();
                    Integer[] amp3Output = computer.modified(a, Integer.parseInt(setting.get(1)), inputted[0], inputted[1]);
                    queue34.add(amp3Output);
                    if (c == 0) {
                        fourth.start();
                        c++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            third = new Thread(amp3);

            Runnable amp4 = () -> {
                try {
                    Integer[] inputted = queue34.poll();
                    Integer[] amp4Output = computer.modified(a, Integer.parseInt(setting.get(1)), inputted[0], inputted[1]);
                    queue45.add(amp4Output);
                    if (s == 0) {
                        fifth.start();
                        s++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            fourth = new Thread(amp4);

            Runnable amp5 = () -> {
                try {
                    Integer[] inputted = queue45.poll();
                    Integer[] amp5Output = computer.modified(a, Integer.parseInt(setting.get(4)), inputted[0], inputted[1]);
                    queue51.add(amp5Output);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            fifth = new Thread(amp5);

            if (d == 0) {
                first.start();
            }
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



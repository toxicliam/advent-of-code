package adventofcode2019.Day7;


import java.io.FileNotFoundException;
import java.util.*;

public class AmplifiersSeries {
    private int amp4CodeInt, amp3CodeInt, amp2CodeInt, amp1CodeInt;

    public Integer series(String a) throws FileNotFoundException {
        AmpComputer computer = new AmpComputer();


        HeapAlg heap = new HeapAlg();
        int[] phase = {0, 1, 2, 3, 4};
        List<String> settings = heap.printAllRecursive(5, phase);
        Map<Integer, String> phaseSetting = new HashMap<>();
        for (int i = 0; i <= settings.size(); i++) {
            try {
                phaseSetting.put(i, settings.get(i).substring(i, i + 1));
            } catch (IndexOutOfBoundsException e) {
                phaseSetting.put(i, settings.get(i).substring(i));
            }
        }
        return recursion(a, phaseSetting, 0, 0).get(0);
    }

    public List<Integer> recursion(String a, Map<Integer, String> phaseSetting, int i, int j) throws FileNotFoundException {
        AmpComputer computer = new AmpComputer();
        Map<Integer, Integer> output = new HashMap<>();
        List<Integer> finale = new ArrayList<>();
        while (i < phaseSetting.size()) {
            if (j < 5) {
                if (j == 0) {
                    output.put(j, computer.modified(a, Integer.parseInt(phaseSetting.get(i).substring(j, j + 1)), 0));
                } else {
                    output.put(j, computer.modified(a, Integer.parseInt(phaseSetting.get(i).substring(j, j + 1)), output.get(j - 1)));
                }
                j++;
                recursion(a, phaseSetting, i, j);
            }
            finale.add(output.get(4));
            i++;
        }
        Collections.sort(finale);
        return finale;
    }
}



package adventofcode2019.Day7;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmplifiersSeries {
    public Integer series(String a) throws FileNotFoundException {
        List<Integer> output = new ArrayList<>();
        HeapAlg heap = new HeapAlg();
        int[] phase = {0, 1, 2, 3, 4};
        List<String> settings = heap.printAllRecursive(5, phase);
        int amp4CodeInt = 0;
        int amp3CodeInt = 0;
        int amp2CodeInt = 0;
        int amp1CodeInt = 0;
        for (int i = 0; i < settings.size(); i++) {
            for (int j = 0; j <= 4; j++) {
                AmpComputer computer = new AmpComputer();
                if (j == 0)
                    amp1CodeInt = computer.modified(a, Integer.parseInt(settings.get(i).substring(j, j + 1)), 0);
                if (j == 1)
                    amp2CodeInt = computer.modified(a, Integer.parseInt(settings.get(i).substring(j, j + 1)), amp1CodeInt);
                if (j == 2)
                    amp3CodeInt = computer.modified(a, Integer.parseInt(settings.get(i).substring(j, j + 1)), amp2CodeInt);
                if (j == 3)
                    amp4CodeInt = computer.modified(a, Integer.parseInt(settings.get(i).substring(j, j + 1)), amp3CodeInt);
                if (j == 4)
                    output.add(computer.modified(a, Integer.parseInt(settings.get(i).substring(j)), amp4CodeInt));
            }
            System.out.println(i);
        }
        Collections.sort(output);
        return output.get(0);
    }

//    public List<Integer> recursion(String a, Map<Integer, String> phaseSetting, int i, int j) throws FileNotFoundException {
//        AmpComputer computer = new AmpComputer();
//        Map<Integer, Integer> output = new HashMap<>();
//        List<Integer> finale = new ArrayList<>();
//        while (i < phaseSetting.size()) {
//            if (j < 5) {
//                if (j == 0) {
//                    output.put(j, computer.modified(a, Integer.parseInt(phaseSetting.get(i).substring(j, j + 1)), 0));
//                } else {
//                    output.put(j, computer.modified(a, Integer.parseInt(phaseSetting.get(i).substring(j, j + 1)), output.get(j - 1)));
//                }
//                j++;
//                recursion(a, phaseSetting, i, j);
//            }
//            finale.add(output.get(4));
//            i++;
//        }
//        Collections.sort(finale);
//        return finale;
//    }
}



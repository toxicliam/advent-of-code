package adventofcode2019.Day7;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AmplifiersSeries {
//    private int j = 0, l = 0, k = 0, h = 0, amp4CodeInt, amp3CodeInt, amp2CodeInt, amp1CodeInt;

    public Integer series(String a) throws FileNotFoundException {
//        List<Integer> amp1Code = new ArrayList<>();
//        List<Integer> amp2Code = new ArrayList<>();
//        List<Integer> amp3Code = new ArrayList<>();
//        List<Integer> amp4Code = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        AmpComputer computer = new AmpComputer();
        int i;
        HeapAlg heap = new HeapAlg();
        int[] phase = {0,1,2,3,4};
        List<String> settings = heap.printAllRecursive(5, phase);
        Map<String, Integer> phaseSetting = null;
        for (int i = 0; i <= settings.size() + 1; i++){
            phaseSetting.put(settings.get(i).substring(0 + i, i), i);
//            amp1CodeInt = computer.modified(a, , 0);
        }
//        for (i = 0; i <= 4; i++) {
//            if (i != h && i != j && i != k && i != l) {
//                amp1CodeInt = computer.modified(a, i, 0);
//                if (amp1CodeInt == 6969)
//                    System.out.println("lmao");
//            }
//            for (l = 0; l <= 4; l++) {
//                if (l != h && l != j && l != k && l != i) {
//                    amp2CodeInt = computer.modified(a, l, amp1CodeInt);
//                    if (amp2CodeInt == 6969)
//                        System.out.println("lmao");
//                }
//                for (j = 0; j <= 4; j++) {
//                    if (j != h && j != k && j != l && j != i) {
//                        amp3CodeInt = computer.modified(a, j, amp2CodeInt);
//                        if (amp3CodeInt == 6969)
//                            System.out.println("lmao");
//                    }
//                    for (k = 0; k <= 4; k++) {
//                        if (k != h && k != j && k != l && k != i) {
//                            amp4CodeInt = computer.modified(a, k, amp3CodeInt);
//                            if (amp4CodeInt == 6969)
//                                System.out.println("lmao");
//                        }
//                        for (h = 0; h <= 4; h++) {
//                            if (h != k && h != j && h != l && h != i) {
//                                int amp5CodeInt = computer.modified(a, h, amp4CodeInt);
//                                if (amp5CodeInt == 6969)
//                                    System.out.println("lmao");
//                                output.add(amp5CodeInt);
//                            }
//                        }
//                    }
//                }
//            }
        }
//        Collections.sort(output);
//        return output.get(output.size() - 1);
    }
}

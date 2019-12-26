package adventofcode2019.Day7;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmplifiersSeries {


    public Integer series(String a) throws FileNotFoundException {
        List<Integer> amp1Code = new ArrayList<>();
        List<Integer> amp2Code = new ArrayList<>();
        List<Integer> amp3Code = new ArrayList<>();
        List<Integer> amp4Code = new ArrayList<>();
        List<Integer> amp5Code = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            for (int l = 0; l <= 4; l++) {
                AmpComputer computer = new AmpComputer();
                switch (i) {
                    case 0:
                        amp1Code.add(computer.modified(a, l, 0));
                        break;
                    case 1:
                        amp2Code.add(computer.modified(a, l, amp1Code.get(l)));
                        break;
                    case 2:
                        amp3Code.add(computer.modified(a, l, amp2Code.get(l)));
                        break;
                    case 3:
                        amp4Code.add(computer.modified(a, l, amp3Code.get(l)));
                        break;
                    case 4:
                        amp5Code.add(computer.modified(a, l, amp4Code.get(l)));
                        break;
                }
            }
        }
        Collections.sort(amp5Code);
        return amp5Code.get(amp5Code.size() - 1);
    }
}

package Day2.Problem_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntcodeRunner {
    public void runner() throws Exception{

        try {
            Integer[] opcodes = getIntegers();
            IntcodeComputer loop = new IntcodeComputer();
            System.out.print(loop.computer2(opcodes)[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Integer[] getIntegers() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Day2.txt"));
        List <Integer> opcodes = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            opcodes.add(scanner.nextInt());
        }
        return opcodes.toArray(new Integer[opcodes.size()]);
    }
}

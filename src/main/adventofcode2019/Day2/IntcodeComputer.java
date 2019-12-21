package adventofcode2019.Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IntcodeComputer {
    public Integer[] computer(String a) throws Exception {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        List<Integer> opcodes = new ArrayList<>();
        while (scanner.hasNextInt()) {
            opcodes.add(scanner.nextInt());
        }
        int programCounter = 0;
        int index;
        int element;
        int e1;
        int e2;
        while (opcodes.get(programCounter) != 99) {
            switch (opcodes.get(programCounter)) {
                case 1:
                    index = opcodes.get(programCounter + 3);
                    e1 = opcodes.get(opcodes.get(programCounter + 1));
                    e2 = opcodes.get(opcodes.get(programCounter + 2));
                    element = e1 + e2;
                    opcodes.set(index, element);
                    break;
                case 2:
                    index = opcodes.get(programCounter + 3);
                    e1 = opcodes.get(opcodes.get(programCounter + 1));
                    e2 = opcodes.get(opcodes.get(programCounter + 2));
                    element = (e1 * e2);
                    opcodes.set(index, element);
                    break;
                default:
                    throw new Exception("Switch Statement Error");
            }
            programCounter += 4;
        }
        return opcodes.toArray(new Integer[0]);
    }

}


package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IntcodeComputer {
    private List<Integer> intcode = new ArrayList<>();

    public IntcodeComputer(String a) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner.hasNextInt()) {
            intcode.add(scanner.nextInt());
        }
    }

    public Integer[] computer() throws Exception {
        int pointer = 0;
        while (intcode.get(pointer) != 99) {
            switch (intcode.get(pointer)) {
                case 1 -> intcode.set(intcode.get(pointer + 3), intcode.get(intcode.get(pointer + 1)) + intcode.get(intcode.get(pointer + 2)));
                case 2 -> intcode.set(intcode.get(pointer + 3), intcode.get(intcode.get(pointer + 1)) * intcode.get(intcode.get(pointer + 2)));
                default -> throw new Exception("Switch Statement Error");
            }
            pointer += 4;
        }

        return intcode.toArray(Integer[]::new);
    }

    public int iterate() throws Exception {
        int noun, verb = 0;
        List<Integer> reset = new ArrayList<>(intcode);
        for (noun = 0; noun < 100; noun++) {
            for (verb = 0; verb < 100; verb++) {
                intcode.clear();
                intcode.addAll(reset);
                intcode.set(1, noun);
                intcode.set(2, verb);
                if (computer()[0] == 19690720)
                    return (100 * noun) + verb;
            }
        }
        return 0;
    }

    public int getFirst() {
        return intcode.get(0);
    }
}


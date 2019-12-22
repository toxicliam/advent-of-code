package adventofcode2019.Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChecksumCalc {
    public int checksums(String a) throws FileNotFoundException {
        Scanner scanner1 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        ArrayList<String> map = new ArrayList<>();
        while (scanner1.hasNextLine()){
            map.add(scanner1.nextLine());
        }
        for (int x = 0; x < map.size() - 1; x++) {
            StringTokenizer tokenizer = new StringTokenizer(map.get(x), ")");

        }
        return 0;
    }
}

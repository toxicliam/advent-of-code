package adventofcode2019.Day6;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.String.valueOf;

public class ChecksumCalc {
    private int x = 0;

    public int checksums(String a) throws FileNotFoundException {

        LinkedList orbits = new LinkedList();
        Scanner scanner1 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        ArrayList<String> instructions = new ArrayList<>();
        while (scanner1.hasNext()) {
            instructions.add(scanner1.next());
        }
        Map<String, LinkedList.Node> planetIndex = new HashMap<>();
        while (x < instructions.size()) {
            StringTokenizer tokenizer = new StringTokenizer(instructions.get(x), ")");
            while (tokenizer.hasMoreTokens()) {
                String planet = tokenizer.nextToken();
                if (planetIndex.get(planet) == null) {
                    planetIndex.put(planet, new LinkedList.Node(planet));

                }
            }
            x++;
        }
        int z = 0;
        while (z < instructions.size()) {
            StringTokenizer tokenizer = new StringTokenizer(instructions.get(z), ")");
            String planet1 = tokenizer.nextToken();
            String planet2 = tokenizer.nextToken();
            if (z == 0)
                orbits.head.next = planetIndex.get(planet1);
            planetIndex.get(planet1).next = planetIndex.get(planet2);
            z++;
        }
        LinkedList.Node n = orbits.head;
        int orbitCount = 0;
        while (n != null) {
            orbitCount++;
            n = n.next;
        }
        return orbitCount;
    }
}

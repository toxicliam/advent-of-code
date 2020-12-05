package Day6;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ChecksumCalc {
    private int x = 0;

    public int checksums(String a) throws FileNotFoundException {

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
                planetIndex.putIfAbsent(planet, new LinkedList.Node(planet));
            }
            x++;
        }
        int z = 0;
        while (z < instructions.size()) {
            StringTokenizer tokenizer = new StringTokenizer(instructions.get(z), ")");
            String planet1 = tokenizer.nextToken();
            String planet2 = tokenizer.nextToken();
            planetIndex.get(planet1).list.add(planetIndex.get(planet2));
            z++;
        }
        return planetIterator(planetIndex.get("COM"), 0);
    }

    public int planetIterator(LinkedList.Node a, int path) {
        int count = 0;
        for (LinkedList.Node child : a.list) {
            count += planetIterator(child, path + 1);
        }
        return count + path;
    }
}

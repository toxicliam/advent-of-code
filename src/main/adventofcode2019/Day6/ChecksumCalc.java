package adventofcode2019.Day6;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChecksumCalc {
    private int x = 0;

    public class Planet {
        String name;
        Planet orbitedPlanet = null;
        List<Planet> planetsOrbitingMe = new ArrayList<>();

        public Planet(String name, Planet orbits) {
            this.orbitedPlanet = orbits;
            this.name = name;
            if (Objects.nonNull(orbits)) {
                orbitedPlanet.addOrbitingPlanet(this);
            }
        }

        public void addOrbitingPlanet(Planet orbitsMe) {
            planetsOrbitingMe.add(orbitsMe);
        }
    }

    public int checksums(String a) throws FileNotFoundException {

        LinkedList orbits = new LinkedList();
        Scanner scanner1 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        ArrayList<String> instructions = new ArrayList<>();
        while (scanner1.hasNext()) {
            instructions.add(scanner1.next());
        }

        /**
         * XXX.lrm - TODO - Consider looking at using List<Planet> like below:
         *
         * class Planet {
         *   String name;
         *   Planet orbitedPlanet;
         *   List<Planet> planetsOrbitingMe;
         *
         * }
         *
         *      Then, you can say
         *
         *      Map<String, Planet> planetarySystem = HashMap<String, Planet>();
         *
         *      now, you can do exactly the same as before except instead of creating a new LinkedList.Node
         *      you just have to create a Planet() you pass in null if it is the COM (Centre of Mass)
         *
         *      once you are finished loading all the A)B entries, you will have a graph (technically a
         *      directed acyclic graph - a fancy way of saying, you can only traverse the graph connections
         *      in one direction and acyclic means the nodes don't cycle back to each other so it's safe
         *      to traverse them without needing to keep track of the paths you've travelled up to now)
         **/
        Map<String, LinkedList.Node> planetIndex = new HashMap<>();
        Map<String, Planet> planetarySystem = new HashMap<>();
        while (x < instructions.size()) {
            StringTokenizer tokenizer = new StringTokenizer(instructions.get(x), ")");

            // this method uses a map of strings to planets where each planet keeps track of the planet
            // it orbits and any planets orbiting it
            dadCode(planetarySystem, instructions.get(x));

            liamCode(planetIndex, tokenizer);
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

    private void dadCode(Map<String, Planet> planetarySystem, String orbit) {
        String[] planets = orbit.split("\\)");
        // computeIfAbsent is a short hand way of doing if (map.get(thing) == null) map.put(thing,theThing);
        Planet currentPlanet = planetarySystem.computeIfAbsent(planets[0], (name) -> new Planet(name, null));
        Planet orbitingPlanet = planetarySystem.computeIfAbsent(planets[1], (name) -> new Planet(name, currentPlanet));

    }

    private void liamCode(Map<String, LinkedList.Node> planetIndex, StringTokenizer tokenizer) {
        while (tokenizer.hasMoreTokens()) {
            String planet = tokenizer.nextToken();

            if (planetIndex.get(planet) == null) {
                planetIndex.put(planet, new LinkedList.Node(planet));

            }
        }
    }
}

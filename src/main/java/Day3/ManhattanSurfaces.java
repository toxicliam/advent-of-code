package Day3;

import java.io.File;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.ceil;

public class ManhattanSurfaces {
    private int[][] surface;
    private int originX, originY, dimensions;
    private List<String> instructions1 = new ArrayList<>(), instructions2 = new ArrayList<>();

    public ManhattanSurfaces(int x, String a, String b) throws Exception {
        Scanner scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        while (scanner.hasNext()) {
            instructions1.add(scanner.next());
        }
        scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(b)).getFile()));
        while (scanner.hasNext()) {
            instructions2.add(scanner.next());
        }
        dimensions = x;
        originX = (int) ceil(dimensions / 2.0);
        originY = (int) ceil(dimensions / 2.0);
        surface = new int[dimensions][dimensions];
        surface[originY][originX] = 4;
        wireDrawer(instructions1, 1);
        wireDrawer(instructions2, 2);
    }

    public void wireDrawer(List<String> instructions, int wire) {
        int positionX = originX, positionY = originY;
        for (String s : instructions) {
            String direction = s.substring(0, 1);
            int distance = Integer.parseInt(s.substring(1));
            switch (direction) {
                case "R" -> {
                    for (int x = 1; x <= distance; x++) {
                        if (surface[positionY][positionX + x] == 1 && surface[positionY][positionX + x] != wire)
                            surface[positionY][positionX + x] = 3;
                        else
                            surface[positionY][positionX + x] = wire;
                    }
                    positionX += distance;
                }
                case "L" -> {
                    for (int x = 1; x <= distance; x++) {
                        if (surface[positionY][positionX - x] == 1 && surface[positionY][positionX - x] != wire)
                            surface[positionY][positionX - x] = 3;
                        else
                            surface[positionY][positionX - x] = wire;
                    }
                    positionX -= distance;
                }
                case "U" -> {
                    for (int y = 1; y <= distance; y++) {
                        if (surface[positionY - y][positionX] == 1 && surface[positionY - y][positionX] != wire)
                            surface[positionY - y][positionX] = 3;
                        else
                            surface[positionY - y][positionX] = wire;
                    }
                    positionY -= distance;
                }
                case "D" -> {
                    for (int y = 1; y <= distance; y++) {
                        if (surface[positionY + y][positionX] == 1 && surface[positionY + y][positionX] != wire)
                            surface[positionY + y][positionX] = 3;
                        else
                            surface[positionY + y][positionX] = wire;
                    }
                    positionY += distance;
                }
            }
        }
    }


    public int minManhattanDist() {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (surface[i][j] == 3) {
                    int z = abs(j - originX) + (abs(i - originY));
                    distances.add(z);
                }
            }
        }
        Collections.sort(distances);
        return distances.get(0);
    }

    public List<Integer> shortestPath() {
        int positionX = originX;
        int positionY = originY;
        int pathLength = 0;

        List<Integer> total = new ArrayList<>();
        for (String s : instructions1) {
            String direction = s.substring(0, 1);
            int distance = Integer.parseInt(s.substring(1));
            switch (direction) {
                case "R" -> {
                    for (int x = 1; x <= distance; x++) {
                        ++pathLength;
                        if (surface[positionY][positionX + x] == 3) {
                            total.add(pathLength + seeker(positionX + x, positionY));
                        }
                    }
                    positionX += distance;
                }
                case "L" -> {
                    for (int x = 1; x <= distance; x++) {
                        ++pathLength;
                        if (surface[positionY][positionX - x] == 3) {
                            total.add(pathLength + seeker(positionX - x, positionY));
                        }
                    }
                    positionX -= distance;
                }
                case "U" -> {
                    for (int x = 1; x <= distance; x++) {
                        ++pathLength;
                        if (surface[positionY - x][positionX] == 3) {
                            total.add(pathLength + seeker(positionX, positionY - x));
                        }
                    }
                    positionY -= distance;
                }
                case "D" -> {
                    for (int x = 1; x <= distance; x++) {
                        ++pathLength;
                        if (surface[positionY + x][positionX] == 3) {
                            total.add(pathLength + seeker(positionX, positionY + x));
                        }
                    }
                    positionY += distance;
                }
            }
        }
        Collections.sort(total);
        return total;
    }

    private int seeker(int cordX, int cordY) {
        int positionX = originX;
        int positionY = originY;
        int pathLength = 0;
        for (String s : instructions2) {
            String direction = s.substring(0, 1);
            int distance = Integer.parseInt(s.substring(1));
            switch (direction) {
                case "R" -> {
                    for (int x = 1; x <= distance; x++) {
                        ++pathLength;
                        if (positionY == cordY && positionX + x == cordX) return pathLength;
                    }
                    positionX += distance;
                }
                case "L" -> {
                    for (int x = 1; x <= distance; x++) {
                        ++pathLength;
                        if (positionY == cordY && positionX - x == cordX) return pathLength;
                    }
                    positionX -= distance;
                }
                case "U" -> {
                    for (int y = 1; y <= distance; y++) {
                        ++pathLength;
                        if (positionY - y == cordY && positionX == cordX) return pathLength;
                    }
                    positionY -= distance;
                }
                case "D" -> {
                    for (int y = 1; y <= distance; y++) {
                        ++pathLength;
                        if (positionY + y == cordY && positionX == cordX) return pathLength;
                    }
                    positionY += distance;
                }
            }
        }
        return pathLength;

    }
}

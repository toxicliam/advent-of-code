//
//
//
//
//I want to keep this a relic of how terrible i originally did it
//
//
//
//
//
//package Day3;
//
//import Day3.VectorSplitter;
//
//import java.io.File;
//import java.util.*;
//
//import static java.lang.Math.abs;
//import static java.lang.Math.ceil;
//
//public class ManhattanSurface {
//    private int count;
//
//    public double[] manhattanSurface(int dimensions, String a, String b) throws Exception {
//        Scanner scanner1 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
//        Scanner scanner2 = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(b)).getFile()));
//        ArrayList<String> instructions1 = new ArrayList<>();
//        ArrayList<String> instructions2 = new ArrayList<>();
//        VectorSplitter vector = new VectorSplitter();
//        int originX = (int) ceil(dimensions / 2.0);
//        int originY = (int) ceil(dimensions / 2.0);
//        int positionX = originX;
//        int positionY = originY;
//        while (scanner1.hasNext()) {
//            instructions1.add(scanner1.next());
//        }
//        while (scanner2.hasNext()) {
//            instructions2.add(scanner2.next());
//        }
//        int wire1Loops = instructions1.size();
//        int wire2Loops = instructions2.size();
//        int[][] surface = new int[dimensions][dimensions];
//        int iteration = 0;
//        while (wire1Loops > 0) {
//            int direction1 = vector.splitter(instructions1.get(iteration))[0];
//            count += 1;
//            int distance1 = vector.splitter(instructions1.get(iteration))[1];
//            switch (direction1) {
//                case 0:
//                    for (int x = 0; x < distance1; x++) {
//                        surface[positionY][positionX + x] = 1;
//                    }
//                    positionX += distance1;
//                    break;
//                case 15:
//                    for (int x = 0; x < distance1; x++) {
//                        surface[positionY + x][positionX] = 1;
//                    }
//                    positionY += distance1;
//                    break;
//                case 10:
//                    for (int x = 0; x < distance1; x++) {
//                        surface[positionY][positionX - x] = 1;
//                    }
//                    positionX -= distance1;
//                    break;
//                case 5:
//                    for (int x = 0; x < distance1; x++) {
//                        surface[positionY - x][positionX] = 1;
//                    }
//                    positionY -= distance1;
//                    break;
//                case 20:
//                    throw new Exception("Direction = 20");
//            }
//            wire1Loops--;
//            iteration++;
//        }
//        positionX = originX;
//        positionY = originY;
//        iteration = 0;
//        while (wire2Loops > 0) {
//            int direction2 = vector.splitter(instructions2.get(iteration))[0];
//            int distance2 = vector.splitter(instructions2.get(iteration))[1];
//            count += 1;
//            switch (direction2) {
//                case 0:
//                    for (int x = 0; x < distance2; x++) {
//                        if ((surface[positionY][positionX + x] == 2) || (surface[positionY][positionX + x] == 0))
//                            surface[positionY][positionX + x] = 2;
//                        else if (surface[positionY][positionX + x] == 1)
//                            surface[positionY][positionX + x] = 3;
//                    }
//                    positionX += distance2;
//                    break;
//                case 15:
//                    for (int x = 0; x < distance2; x++) {
//                        if ((surface[positionY + x][positionX] == 2) || (surface[positionY + x][positionX] == 0))
//                            surface[positionY + x][positionX] = 2;
//                        else if (surface[positionY + x][positionX] == 1)
//                            surface[positionY + x][positionX] = 3;
//                    }
//                    positionY += distance2;
//                    break;
//                case 10:
//                    for (int x = 0; x < distance2; x++) {
//                        if ((surface[positionY][positionX - x] == 2) || (surface[positionY][positionX - x] == 0))
//                            surface[positionY][positionX - x] = 2;
//                        else if (surface[positionY][positionX - x] == 1)
//                            surface[positionY][positionX - x] = 3;
//                    }
//                    positionX -= distance2;
//                    break;
//                case 5:
//                    for (int x = 0; x < distance2; x++) {
//                        if ((surface[positionY - x][positionX] == 2) || (surface[positionY - x][positionX] == 0))
//                            surface[positionY - x][positionX] = 2;
//                        else if (surface[positionY - x][positionX] == 1)
//                            surface[positionY - x][positionX] = 3;
//                    }
//                    positionY -= distance2;
//                    break;
//                case 20:
//                    throw new Exception("Direction = 20");
//            }
//            wire2Loops--;
//            iteration++;
//        }
//
//        List<Double> originDistances = new ArrayList<>();
//        surface[(int) ceil(dimensions / 2.0)][(int) ceil(dimensions / 2.0)] = 4;
//        for (int i = 0; i < dimensions; i++) {
//            for (int j = 0; j < dimensions; j++) {
//                if (surface[i][j] == 3) {
//                    double z = abs(i - ceil(dimensions / 2.0)) + abs(j - ceil(dimensions / 2.0));
//                    originDistances.add(z);
//                }
//            }
//        }
//        Collections.sort(originDistances);
////        System.out.println("Sorted list of distances:: " + originDistances);
////        System.out.println("Amount of distances calculated:: " + originDistances.size());
////        System.out.println("Directions inputted for each wire:: " + count / 2);
//        double result = wireTracer(originX, originY, instructions1, instructions2, surface).get(0);
//        if (originDistances.get(0) == 0) {
//            double bruh = originDistances.get(1);
//            return new double[]{bruh, result};
//        } else {
//            double bruh = originDistances.get(0);
//            return new double[]{bruh, result};
//        }
//    }
//
//    public List<Integer> wireTracer(int originX, int originY, ArrayList<
//            String> instructions1, ArrayList<String> instructions2, int[][] surface) {
//        VectorSplitter vector = new VectorSplitter();
//        int positionX = originX;
//        int positionY = originY;
//        int pathLength = 0;
//        int loops = instructions1.size();
//        int pathLength2;
//        int iteration = 0;
//        List<Integer> total = new ArrayList<>();
//        while (loops > 0) {
//            int direction = vector.splitter(instructions1.get(iteration))[0];
//            int distance = vector.splitter(instructions1.get(iteration))[1];
//            switch (direction) {
//                case 0:
//                    for (int x = 0; x < distance; x++) {
//                        if (surface[positionY][positionX + x] == 3) {
//                            pathLength2 = cordFinder(positionX + x, positionY, originX, originY, instructions2);
//                            total.add(pathLength + pathLength2);
//                        }
//                        pathLength++;
//                    }
//                    positionX += distance;
//                    break;
//                case 15:
//                    for (int x = 0; x < distance; x++) {
//                        if (surface[positionY + x][positionX] == 3) {
//                            pathLength2 = cordFinder(positionX, positionY + x, originX, originY, instructions2);
//                            total.add(pathLength + pathLength2);
//                        }
//                        pathLength++;
//                    }
//                    positionY += distance;
//                    break;
//                case 10:
//                    for (int x = 0; x < distance; x++) {
//                        if (surface[positionY][positionX - x] == 3) {
//                            pathLength2 = cordFinder(positionX - x, positionY, originX, originY, instructions2);
//                            total.add(pathLength + pathLength2);
//                        }
//                        pathLength++;
//                    }
//                    positionX -= distance;
//                    break;
//                case 5:
//                    for (int x = 0; x < distance; x++) {
//                        if (surface[positionY - x][positionX] == 3) {
//                            pathLength2 = cordFinder(positionX - originX, positionY - x, originX, originY, instructions2);
//                            total.add(pathLength + pathLength2);
//                        }
//                        pathLength++;
//                    }
//                    positionY -= distance;
//                    break;
//            }
//            loops--;
//            iteration++;
//        }
//        Collections.sort(total);
//        return total;
//    }
//
//
//    private int cordFinder(int cordX, int cordY, int originX, int originY, ArrayList<String> instructions) {
//        int positionX = originX;
//        int positionY = originY;
//        int loops = instructions.size();
//        VectorSplitter vector = new VectorSplitter();
//        int pathLength = 0;
//        int iteration = 0;
//        while (loops > 0) {
//            int direction = vector.splitter(instructions.get(iteration))[0];
//            int distance = vector.splitter(instructions.get(iteration))[1];
//            switch (direction) {
//                case 0:
//                    for (int x = 0; x < distance; x++) {
//                        if (positionY == cordY && positionX + x == cordX) return pathLength;
//                        ++pathLength;
//                    }
//                    positionX += distance;
//                    break;
//                case 15:
//                    for (int x = 0; x < distance; x++) {
//                        if (positionY + x == cordY && positionX == cordX) return pathLength;
//                        ++pathLength;
//                    }
//                    positionY += distance;
//                    break;
//                case 10:
//                    for (int x = 0; x < distance; x++) {
//                        if (positionY == cordY && positionX - x == cordX) return pathLength;
//                        ++pathLength;
//                    }
//                    positionX -= distance;
//                    break;
//                case 5:
//                    for (int x = 0; x < distance; x++) {
//                        if (positionY - x == cordY && positionX == cordX) return pathLength;
//                        ++pathLength;
//                    }
//                    positionY -= distance;
//                    break;
//            }
//            loops--;
//            iteration++;
//        }
//        return pathLength;
//
//    }
//}
//

package AdventOfCode2019.Day3.Problem_1_2;

public class VectorSplitter {
    public int[] splitter(String a) {
    String direction = a.substring(0,1);
    int directionNum;
    switch(direction){
        case "R":
            directionNum = 0;
            break;
        case "U":
            directionNum = 5;
            break;
        case "L":
            directionNum = 10;
            break;
        case "D":
            directionNum = 15;
            break;
        default:
            directionNum = 20;
            break;
    }
        return new int[]{directionNum, Integer.parseInt(a.substring(1))};
    }
}

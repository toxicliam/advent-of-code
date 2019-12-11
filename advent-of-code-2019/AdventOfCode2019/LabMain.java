import Day3.ManhattanSurface;

public class LabMain {
    private static int x = 0;

    public static void main(String[] args) {
        
        //AoC Day1 Problem1
/*
        FuelCounterRunner code = new FuelCounterRunner();
        code.runner();
*/
        //AoC Day1 Problem2
/*
        FuelCounterRunner2 code2 = new FuelCounterRunner2();
        code2.runner();
*/
        //AoC Day2 Problem1
/*
        IntcodeRunner code3 = new IntcodeRunner();
        try {
            code3.runner();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    //AoC Day2 Problem2
/*
        IntcodeLoop loop2 = new IntcodeLoop();
        try {
            System.out.println(loop2.output());
        } catch (Exception e) {
            e.printStackTrace();
        }
    */
//AoC Day3 Problem1
        ManhattanSurface code4 = new ManhattanSurface();
        try {
            System.out.println("Manhattan Distance:: " + code4.manhattanSurface(12001, "Day3_Wire1.txt", "Day3_Wire2.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Day2.Problem_2;


import Day2.Problem_1.IntcodeComputer;
import Day2.Problem_1.IntcodeRunner;

public class IntcodeLoop {
    private int noun = 0, verb = 0, result;
    public int output()throws Exception{
        IntcodeRunner intcode = new IntcodeRunner();
        IntcodeComputer copmuter = new IntcodeComputer();
        do{
            Integer[] array = intcode.getIntegers();
            array[1] = noun++;
            verb = 0;
            do{
                array[2] = verb++;
                try{
                    result = copmuter.computer2(array.clone())[0];
                }catch (Exception e){
                    System.out.println("Error");
                }
            }while(result != 19690720 && verb < 99);
        }while(result != 19690720 && noun < 99);
        return ((100 * (noun-1)) + (verb-1));
    }
}

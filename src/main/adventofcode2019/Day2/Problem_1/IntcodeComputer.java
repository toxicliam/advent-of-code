package Day2.Problem_1;

public class IntcodeComputer {
    private int x = 0;
    private int pos = 0;

//    public int[] computer(int[] array) {
//
////        int rows = (int) Math.ceil((double) (a.chars().filter(ch -> ch == ',').count()) / 4);
//        String result;
//        while (x == 0) {
//            int pos2;
//            int total;
//            switch (array[pos]) {
//                case 1:
//                    ++pos;
//                    int pos1 = array[pos];
//                    ++pos;
//                    if (pos1 != 99) {
//                        pos2 = array[pos];
//                        ++pos;
//                        if (pos2 != 99) {
//                            total = array[pos1] + array[pos2];
//                            array[array[pos]] = total;
//                            ++pos;
////                            x++;
//                        } else {
//                            x = 100;
//
//                        }
//                    } else {
//                        x = 100;
//
//                    }
//                    break;
//                case 2:
//                    ++pos;
//                    pos1 = array[pos];
//                    ++pos;
//                    if (pos1 != 99) {
//                        pos2 = array[pos];
//                        ++pos;
//                        if (pos2 != 99) {
//                            total = array[pos1] * array[pos2];
//                            array[array[pos]] = total;
//                            ++pos;
////                            x++;
//                        } else {
//                            x = 100;
//                        }
//                    } else {
//                        x = 100;
//
//                    }
//                    break;
//                case 99:
//                    x = 100;
//                    break;
//                default:
//                    x = 100;
//                    break;
//            }
//        }
////        result = String.valueOf(array[0]);
//        return array;
//    }

    public Integer[] computer2(Integer[] array) throws Exception {
        int programCounter = 0;
        while (array[programCounter] != 99) {
            switch (array[programCounter]) {
                case 1:
                    array[array[programCounter + 3]] = array[array[programCounter + 1]] + array[array[programCounter + 2]];
                    break;
                case 2:
                    array[array[programCounter + 3]] = array[array[programCounter + 1]] * array[array[programCounter + 2]];
                    break;
                default:
                    throw new Exception("Error");
            }
            programCounter += 4;
        }
        return array;
    }
}


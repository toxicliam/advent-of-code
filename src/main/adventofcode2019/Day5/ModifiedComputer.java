package adventofcode2019.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModifiedComputer {
    public void modified(String a) {
        Scanner scanner = null;
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> intcode = new ArrayList<>();
        try {
            scanner = new Scanner(new File(a));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scanner != null;
        while (scanner.hasNextInt()) {
            intcode.add(scanner.nextInt());
        }
        int loops = intcode.size();
        int pos = 0;
        int element1;
        int element2;
        int parameter1;
        int parameter2;
        while (loops > 0) {
            String instruction = String.valueOf(intcode.get(pos));
            StringBuilder sb = new StringBuilder(instruction);
            char opcode = instruction.charAt(instruction.length() - 1);
            switch (opcode) {
                case '1':
                    try {
                        parameter1 = sb.reverse().charAt(2);
                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        parameter2 = sb.reverse().charAt(3);
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    intcode.set(intcode.get(pos + 3), element1 + element2);
                    pos += 4;
                    loops--;
                    break;
                case '2':
                    try {
                        parameter1 = sb.reverse().charAt(2);
                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        parameter2 = sb.reverse().charAt(3);
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    intcode.set(intcode.get(pos + 3), element1 * element2);
                    pos += 4;
                    loops--;
                    break;
                case '3':
                    System.out.println("Please input an integer:: ");
                    int input = keyboard.nextInt();
                    intcode.set(intcode.get(pos + 1), input);
                    pos += 2;
                    break;
                case '4':
                    try {
                        parameter1 = sb.reverse().charAt(1);
                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    System.out.println(element1);
                    pos += 2;
                    loops--;
                    break;
                case '9':
                    loops = 0;
                    break;

            }
//            System.out.println(loops);
        }
    }

}

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
            if (instruction.length() == 1) {
                switch (instruction) {
                    case "1":
                    case "2":
                        int index;
                        int element;
                        int e1;
                        int e2;
                        switch (intcode.get(pos)) {
                            case 1:
                                index = intcode.get(pos + 3);
                                e1 = intcode.get(intcode.get(pos + 1));
                                e2 = intcode.get(intcode.get(pos + 2));
                                element = e1 + e2;
                                intcode.set(index, element);
                                break;
                            case 2:
                                index = intcode.get(pos + 3);
                                e1 = intcode.get(intcode.get(pos + 1));
                                e2 = intcode.get(intcode.get(pos + 2));
                                element = (e1 * e2);
                                intcode.set(index, element);
                                break;
                        }
                        pos += 4;
                        loops--;
                        break;
                    case "3":
                        System.out.println("Please input an integer:: ");
                        int input = keyboard.nextInt();
                        intcode.set(intcode.get(pos + 1), input);
                        pos += 2;
                        loops--;
                        break;
                    case "4":
                        System.out.println(intcode.get(intcode.get(pos + 1)));
                        pos += 2;
                        loops--;
                        break;
                }
            } else {
                String opcode = instruction.substring(instruction.length() - 2);
                switch (opcode) {
                    case "01":
                        StringBuilder sb1 = new StringBuilder(instruction);
                        parameter1 = sb1.reverse().charAt(2);
                        try {
                            parameter2 = sb1.reverse().charAt(3);
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
                    case "02":
                        StringBuilder sb2 = new StringBuilder(instruction);
                        parameter1 = sb2.reverse().charAt(2);
                        try {
                            parameter2 = sb2.reverse().charAt(3);
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
                    case "04":
                        StringBuilder sb3 = new StringBuilder(instruction);
                        parameter1 = sb3.reverse().charAt(2);
                        if (parameter1 == 0)
                            element1 = intcode.get(intcode.get(pos + 1));
                        else
                            element1 = intcode.get(pos + 1);
                        System.out.println(element1);
                        pos += 2;
                        loops--;
                        break;
                    case "99":
                        loops = 0;
                        break;
                }
            }
//            System.out.println(loops);
        }
    }

}

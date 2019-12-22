package adventofcode2019.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UltraModifiedComputer {
    public ArrayList<Integer> modified(String a) {
        //reading my file with input
        Scanner scanner = null;
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> intcode = new ArrayList<>();
        try {
            scanner = new Scanner(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(a)).getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scanner != null;
        while (scanner.hasNextInt()) {
            intcode.add(scanner.nextInt());
        }
        //initailizing variables
        int loops = intcode.size();
        int pos = 0;
        int element1;
        int element2;
        int parameter1;
        int parameter2;
        //main loop
        while (loops > 0) {
            //instantiate variables
            String instruction = String.valueOf(intcode.get(pos));
            StringBuilder sb = new StringBuilder(instruction);
            char opcode = instruction.charAt(instruction.length() - 1);
            switch (opcode) {
                case '1':
                    //reverse once in order to guaruntee the order of instructions
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        if (String.valueOf(sb.charAt(3)).equals("0"))
                            parameter2 = 0;
                        else
                            parameter2 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    //do the actual operation (output is always in position mode)
                    intcode.set(intcode.get(pos + 3), element1 + element2);
                    //increment the cursor
                    pos += 4;
                    loops--;
                    break;
                case '2':
                    //reverse once in order to guaruntee the order of instructions
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;

                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        if (String.valueOf(sb.charAt(3)).equals("0"))
                            parameter2 = 0;
                        else
                            parameter2 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    //do the actual operation
                    intcode.set(intcode.get(pos + 3), element1 * element2);
                    //increment the cursor
                    pos += 4;
                    loops--;
                    break;
                case '3':
                    //ask for input
                    System.out.println("Please input an integer:: ");
                    int input = keyboard.nextInt();
                    //place input
                    intcode.set(intcode.get(pos + 1), input);
                    //increment the cursor
                    pos += 2;
                    break;
                case '4':
                    //reverse to guaruntee placement
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    //output output
                    System.out.println(element1);
                    //increment cursor
                    pos += 2;
                    loops--;
                    break;
                case '5':
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;

                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        if (String.valueOf(sb.charAt(3)).equals("0"))
                            parameter2 = 0;
                        else
                            parameter2 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    //do the actual operation
                    if (element1 != 0) {
                        loops += pos - element2;
                        pos = element2;
                    } else {
                        pos += 3;
                        loops--;
                    }
                    break;
                case '6':
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;

                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        if (String.valueOf(sb.charAt(3)).equals("0"))
                            parameter2 = 0;
                        else
                            parameter2 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    //do the actual operation
                    if (element1 == 0) {
                        loops += pos - element2;
                        pos = element2;
                    } else {
                        pos += 3;
                        loops--;
                    }
                    break;
                case '7':
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;

                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        if (String.valueOf(sb.charAt(3)).equals("0"))
                            parameter2 = 0;
                        else
                            parameter2 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    //do the actual operation
                    if (element1 < element2)
                        intcode.set(intcode.get(pos + 3), 1);
                    else
                        intcode.set(intcode.get(pos + 3), 0);
                    //increment the cursor
                    pos += 4;
                    loops--;
                    break;
                case '8':
                    try {
                        if (String.valueOf(sb.reverse().charAt(2)).equals("0"))
                            parameter1 = 0;
                        else
                            parameter1 = 1;

                    } catch (IndexOutOfBoundsException e) {
                        parameter1 = 0;
                    }
                    try {
                        if (String.valueOf(sb.charAt(3)).equals("0"))
                            parameter2 = 0;
                        else
                            parameter2 = 1;
                    } catch (IndexOutOfBoundsException e) {
                        parameter2 = 0;
                    }
                    //0 means position mode, 1 means immidiate mode
                    if (parameter1 == 0)
                        element1 = intcode.get(intcode.get(pos + 1));
                    else
                        element1 = intcode.get(pos + 1);
                    if (parameter2 == 0)
                        element2 = intcode.get(intcode.get(pos + 2));
                    else
                        element2 = intcode.get(pos + 2);
                    //do the actual operation
                    if (element1 == element2)
                        intcode.set(intcode.get(pos + 3), 1);
                    else
                        intcode.set(intcode.get(pos + 3), 0);
                    //increment the cursor
                    pos += 4;
                    loops--;
                    break;
                case '9':
                    //exit intcode
                    loops = 0;
                    break;

            }
//            System.out.println(loops);
        }
        return intcode;
    }

}

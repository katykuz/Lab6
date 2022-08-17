/*
 * Ekaterina Kuznetsova
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package EKuznetsova1_Lab6;

import java.io.IOException;
import java.util.Scanner;

/**
 * The RPN class takes a String expression (constructor) and evaluates
 * it as a mathematical expression (evaluate method), returning a double.
 *
 * @author Ekaterina Kuznetsova
 * @version 1.0
 */

//TODO: Look at toString method in LinkedStack example of the book
public class RPN {

    public static void main(String[] args) throws IOException {
        //create scanner object for user input
        Scanner keyboard = new Scanner(System.in);
        //declare variable to hold user response
        String repeat;
        String input;

        //welcome message
        welcome();

        //do-while loop for user to repeat the decoder
        do {
            System.out.println("\n(blank line to quit)");
            System.out.print("calc> ");
            input = keyboard.nextLine();
            repeat = "";

            if (!input.isEmpty()) {
                RPNCalculator calc = new RPNCalculator(input);


                //prompt user about running program again
                System.out.print("\nMake another calculation? " +
                        "Enter yes to repeat: ");

                //get user input
                repeat = keyboard.nextLine();
            }

            //conclude do-while loop with verification of user response
        } while (repeat.equalsIgnoreCase("yes"));

        //goodbye message
        goodbye();

        //close scanner
        keyboard.close();
    }

    public static void welcome() {

        System.out.println("RPN Calculator");
    }

    public static void goodbye() {

        System.out.println("Thanks for using the PRN Calculator! Bye!");
    }


}

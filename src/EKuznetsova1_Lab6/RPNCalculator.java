/*
 * Ekaterina Kuznetsova
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package EKuznetsova1_Lab6;

import java.util.Objects;
import java.util.Scanner;

public class RPNCalculator {

    public RPNCalculator(String input) {
        String[] tempArray = parseTheString(input);
        evaluate(tempArray);
    }

    private String[] parseTheString(String input) {
        //create a String array to temporarily hold the individual components
        //of the string input
        String[] inputSeparated = input.split(" ", 0);


        for (int i = 0; i < inputSeparated.length; i++)
            System.out.println(inputSeparated[i]);

        return inputSeparated;
    }

    public void evaluate(String[] inputSeparated) {

        Stack calculatorMemory = new Stack();

        double num1, num2, solution, test;
        String operator, result;


            //Iterating through the contents of string array
            for (int i = 0; i < inputSeparated.length; i++) {

                // If the character is not the operator character, then push it
                // to the stack
                if (!Objects.equals(inputSeparated[i], "+") &&
                        !Objects.equals(inputSeparated[i], "-") &&
                        !Objects.equals(inputSeparated[i], "*") &&
                        !Objects.equals(inputSeparated[i], "/")) {

                    Scanner scan = new Scanner(inputSeparated[i]);
                    if (scan.hasNextDouble()) {
                        //push to stack
                        calculatorMemory.
                                push(Double.parseDouble(inputSeparated[i]));
                    } else
                        throw new IllegalArgumentException("Invalid inputs.");
                    continue;
                }
                //if it is an operator, then perform the calculation based off
                //the operator
                else {
                    // else if the character is the special
                    operator = inputSeparated[i];
                }

                // Switch-Case
                switch (operator) {
                    case "+":

                        // Performing the "+" operation by poping
                        // put the first two character
                        // and then again store back to the stack

                        num1 = calculatorMemory.pop();
                        num2 = calculatorMemory.pop();
                        solution = num1 + num2;
                        calculatorMemory.push(solution);
                        break;

                    case "-":

                        // Performing the "-" operation by poping
                        // put the first two character
                        // and then again store back to the stack
                        num1 = calculatorMemory.pop();
                        num2 = calculatorMemory.pop();
                        solution = num2 - num1;
                        calculatorMemory.push(solution);
                        break;

                    case "*":

                        // Performing the "*" operation
                        // by poping put the first two character
                        // and then again store back to the stack

                        num1 = calculatorMemory.pop();
                        num2 = calculatorMemory.pop();
                        solution = num1 * num2;
                        calculatorMemory.push(solution);
                        break;

                    case "/":

                        // Performing the "/" operation by poping
                        // put the first two character
                        // and then again store back to the stack

                        num1 = calculatorMemory.pop();
                        num2 = calculatorMemory.pop();
                        solution = num2 / num1;
                        calculatorMemory.push(solution);
                        break;

                    default:
                        throw new IllegalArgumentException("Unknown operator.");

                }
            }

            // Method to convert the String to double
            printAnswer(calculatorMemory.pop());

    }

    public void printAnswer(Double answer){
        System.out.println("\n" + answer);
    }


}

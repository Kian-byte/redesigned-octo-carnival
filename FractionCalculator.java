package com.acwd.m1.iu10;

import java.util.Scanner;

/**
 *
 *
 * @author Teo Kian Heng
 * @version 1.0
 * @since 23/04/2019
 *
 */

public class FractionCalculator {

    public static boolean restart = true;
    public static String operation;


    /**
     * Method for get operation
     * @return
     */
    public static String getOperation(){

        Scanner input = new Scanner(System.in); // Scanner user operation
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.next();

        while (!(operation.equals("+") || operation.equals("-") || operation.equals("/")
                || operation.equals("=") || operation.equals("*")
                || operation.equalsIgnoreCase("q"))) {

                System.out.print("Invalid fraction, Please enter " +
                        "(+, -, / , *, = " + "or Q to quit): ");
                operation = input.next();
        }

        if (operation.equalsIgnoreCase("q")){
            System.exit(0);
        }
        return operation;
    }


    /**
     * Method for validFunction
     * @param input
     * @return
     */
    public static boolean validFraction (String input){

        if (input.contains("/")) {
            String[] inputParts = input.split("/");

            if (inputParts[1].matches("0")) {
                return false;
            }
            else if (inputParts[0].matches("-?\\d+") && inputParts[1].matches("-?\\d+")) {
                return true;
            }
            } else {
            if (input.matches("-?\\d+")) {
                return true;
            }
            return false;
            }
            return false;
        }


    /**
     * Method for getFraction
     * @return
     */
    public static Fraction getFraction () {

        Scanner input = new Scanner(System.in); // Scanner a fraction
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String inputData = input.nextLine();
        //System.out.println(inputData);

        while (!validFraction(inputData)) {
            System.out.print("Invalid fraction. Please enter a fraction (a/b) or (a), " +
                    "" + "where a and b are integers and b is not zero: ");
            inputData = input.next();
        }
        if (inputData.contains("/")) {
            String[] inputParts = inputData.split("/");
            int num = Integer.parseInt(inputParts[0]);
            int den = Integer.parseInt(inputParts[1]);
            return new Fraction(num, den);

        } else {
            return new Fraction(Integer.parseInt(inputData));
        }
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("\nThis program is a fraction calculator." + "\nIt will add, subtract, " +
                           "multiply and divide fractions until you type Q to quit.");

        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");

        while (restart){
            System.out.println("-------------------------------------------------------------------------------");

            operation = getOperation();
            Fraction input1 = getFraction();
            Fraction input2 = getFraction();

            Fraction output = new Fraction(1, 1);
            System.out.println("Your first fraction input : " + input1.toString() + ", "
                    + "and your second fraction input : " + input2.toString());

            if (operation.equals("*")) {
                output = input1.multiply(input2);
                // print method needed
            }   else if (operation.equals("/")) {
                output = input1.divide(input2);
                // print method needed
            }   else if (operation.equals("+")) {
                output = input1.add(input2);
                // print method needed
            }   else if (operation.equals("-")) {
                output = input1.subtract(input2);
                // print method needed
            }   else if (operation.equals("=")) {
                boolean result = input1.equals(input2);
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " is " + result);
            }

            output.toLowestTerms(); // Convert output to lowest term
            if(output.getDenominator()==1){
                int outlnt = output.getNumerator();
                System.out.println("Result is " + input1.toString() + " " + operation + " "
                        + input2.toString() + " = " + output);

            continue;
            }
           System.out.println("Result is " + input1.toString() + " " + operation + " "
                    + input2.toString() + " = " + output);
        }
    }
}




package com.acwd.m1.iu7;

import java.util.*; // Import the scanner class

public class OddsorEvens {

    public static void main(String[] args) {

        //Part 1 - Picks Odds or Evens
        System.out.println("Let's play a game called \"Odds and Evens\"."); //Greeting

        Scanner inputName = new Scanner(System.in);                         //Scanner for Username
        System.out.print("What is your name? ");                            //Getting Username
        String name = inputName.nextLine();
        String choice = "";
        Scanner inputChoice = new Scanner(System.in);                      //Scanner for User's choice
        do {
            System.out.print("Hi " + name + ", which do you choose ? (O)dds or (E)vens?");  //Getting User's choice
            choice = inputChoice.nextLine();

        } while (!(choice.equalsIgnoreCase("O") || choice.equalsIgnoreCase("E")));

        /* while (choose.equals("o")&&choose.equals("O")&&choose.equals("E")&&choose.equals("e")) {
          System.out.println("Hi" + name + " , invalid choice, please enter only Odd or Even"); */

        if (choice.equals("o") || choice.equals("O")) {                                                 // input check with condition
            System.out.println("Hi " + name + ", your choice is Odd, the computer will be Even.");      //if condition true, 1st command code will be executed
            }
                else {
            System.out.println("Hi " + name + ", your choice is Even, the computer will be Odd.");    //if condition false, 2nd command code will be executed
            }

        System.out.println("-----------");

        //Part 2 - Play the Game
        System.out.print("How many \"finger\" do you put out?");
        Scanner inputfinger = new Scanner (System.in);
        int finger = inputfinger.nextInt();

        Random rand = new Random();
        int computer = rand.nextInt(6);

        while(finger>(5) || finger<(0))
            {
                System.out.print("Your selection is out of range, please re-enter.");  //Getting User's choice
                finger = inputfinger.nextInt();
            }
                System.out.println("Your selection is " + finger + " the computer plays " + computer + " \"fingers\".");  //Getting User's choice

        System.out.println("-----------");

        //Part 3 - Who won?
        int sum = finger +  computer;
        System.out.println("The sum is " + finger + " + " + computer + " = " + sum + ".");

        int result = sum%2;
        //boolean Result = sum%2 == 0;

        if (result==(0)) {
            System.out.println("The sum is even.");
        }
        else {System.out.println("The sum is odd.");}

        if (result==(1)&&choice.equalsIgnoreCase("O"))
        {System.out.println("Congratulation " + name + ", you chosen Odd that meant you have won.");
                }
        else if (result==(0)&&choice.equalsIgnoreCase("O"))
        {System.out.println("Sorry, you chosen Odd that meant you have lost.");
                }
        else if (result == (1) && choice.equalsIgnoreCase("E"))
        {System.out.println("Sorry, you chosen Even that meant you have lost.");
                }
        else {System.out.println("Congratulation " + name + ", you chosen Even that meant you have won.");}

        System.out.println("-----------");
    }
    }



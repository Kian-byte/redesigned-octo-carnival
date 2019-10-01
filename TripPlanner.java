package com.acwd.m1.iu6;

import java.util.Scanner; // Import the scanner class

public class TripPlanner {

    public static void main(String[] args) {

        myPart1(); // Greeting
        myPart2(); // Travel time and Budget
        myPart3(); // Time Difference
        myPart4(); // Country Area
    }

    public static void myPart1() {
        System.out.println("Welcome to Vocaticn Planner!");
        Scanner inputName = new Scanner(System.in);
        Scanner inputCity = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = inputName.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String city = inputCity.nextLine();
        System.out.println("Great! " + city + " sound like a great trip. ");
        System.out.println("********");
    }

    public static void myPart2() {
        Scanner inputDay = new Scanner(System.in);
        Scanner inputMoney = new Scanner(System.in);
        Scanner inputCurrency = new Scanner(System.in);
        Scanner inputRate = new Scanner(System.in);

        System.out.print("How many day are you going to spend travelling? ");
        int day = inputDay.nextInt();

        System.out.print("How much money in USD are you going to spend on this trip? ");
        double money = inputMoney.nextDouble();

        System.out.print("What is the three letter currency symbol for your travel destination ? ");
        String currency = inputCurrency.nextLine();

        System.out.print("How many " + currency + " are there in 1 USD? ");
        double rate = inputRate.nextDouble();
        System.out.println("********");


        int hr = day * 24;
        int min = hr * 60;
        System.out.println("If you are travelling for " + day + " days that is the same as " + hr + " hours or " + min + " minutes.");

        double daily = money / day;
        System.out.println("If you are going to spend $" + String.format("%.2f",money) + " USD that mean per day you can spend up to $" + String.format("%.2f",daily) + " USD.");

        double budget = rate * money;
        double dailyLoc = rate * money / day;
        System.out.println("Your total budget in " + currency + " is " + String.format("%.2f",budget) + " " + currency + ", which per day is " + String.format("%.2f",dailyLoc) + " " + currency + ".");
        System.out.println("********");
    }

    public static void myPart3() {
        Scanner inputTimeDiff = new Scanner(System.in);

        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        double timeDiff = inputTimeDiff.nextDouble();

        double timeMid = 24.00 + timeDiff;
        double timeNoon = 12.00 + timeDiff;
        System.out.println("That mean that if it is midnight at home it will be " + timeMid%24 + "0 in your travel destination \nand when it is noon at home it will be " + timeNoon%24 + "0 in your travel destination.");
    }

    public static void myPart4(){
        Scanner inputSize = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2?");
        double size = inputSize.nextDouble();

        double mile = size * 0.386;
        System.out.println("In miles2 that is " + String.format("%.2f",mile) + ".");
    }
}


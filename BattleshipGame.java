package com.acwd.m1.iu9;
import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {

    static int[][] ocean = new int[10][10];

    static int ComputerTotalShipNo = 5;
    static int PlayerTotalShipNo = 5;

    public static void main(String[] args) {

        System.out.println("\n" + "*** Welcome to Battle Ships Game ****");        //Display statement
        System.out.println("Right now, the sea is empty.");

        createMap();
        deployShips();
        createMap();
        computerDeployShip();
        createMap();
        while (ComputerTotalShipNo > 0 && PlayerTotalShipNo > 0){

              playerTurn();
              computerTurn();
              createMap();

              System.out.println("Player total ship : " + PlayerTotalShipNo);
              System.out.println("Computer total ship : " + ComputerTotalShipNo);
              }
              gameOver();
    }

    //Input Player's Ships coordinate and Deploy Player's Ship
    public static void deployShips() {

        System.out.println("\n" + "Deploy your ships:");
        System.out.println("Only numeric entry is valid:");
        Scanner input = new Scanner(System.in); // Scanner for coordinate

        int x = 0, y = 0, row = 0, col = 0, i = 0;

        int PlayerTotalShipNo = 5;
        for (i = 1; i <= PlayerTotalShipNo; i++) {
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            y = input.nextInt();

     /*       0   0   0   0   0
            space space space space space
           0    1   0   0   0
           space @ space space space

        if( [][] = 1)
            System.out.println("@");
        else if ([][] = 0)
            System.out.println(" ");    */

            //int [][]ocean = new int[10][10];
            if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && (ocean[x][y] == 0)) {
                ocean[x][y] = 1;

                } else if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && (ocean[x][y] == 1)) {
                System.out.println("You can't place two or more ships on the same location.");
                i--;
                } else if ((x < 0 || x >= 10) || (y < 0 || y >= 10)) {
                i--;
                System.out.println("You can't place the ship outside the grid.");
                }
            }
    }

    public static void computerDeployShip() {

        System.out.println("\n" + "Computer is deploying 5 ships.");
        Random rand = new Random();
        int ComputerTotalShipNo = 1;

        //int computer = rand.nextInt(()*10));

        while (ComputerTotalShipNo < 6) {//(for (int i = 1; i <= ComputerTotalShipNo; i++) {
            int x = rand.nextInt(10);
            //int x = (int) (Math.random() * 10);
            int y = rand.nextInt(10);
            //int y = (int) (Math.random() * 10);

            if ((x >= 0 && x < 10) && (y >= 0 && y < 10) && (ocean[x][y] == 0)) {
                ocean[x][y] = 2;
                System.out.println(ComputerTotalShipNo + ".ship deploy");
                ComputerTotalShipNo++;
            }
        }
    }

    public static void createMap() {


        System.out.println("\n" + "  0123456789  ");

        int count = 0;                                          //initalising counter

        //int[][] ocean = new int[10][10];                     //creating 2D grind (10 x 10 array)
        for (int row = 0; row < ocean.length; row++) {         //1st for loop for
            System.out.print(row + "|");                       //printing left side row number and " |"

            for (int col = 0; col < ocean[row].length; col++) {     //2nd for loop
                /*if (ocean[row][col] == 0) {                       //if loop to create space in array
                    System.out.print(" ");
                } else if (ocean[row][col] == 1) {
                    System.out.print("@");
                } else if (ocean[row][col] == 2) {
                    System.out.print("#");
                }*/

                switch (ocean[row][col]){
                    case 1:
                        System.out.print("@"); // Player Deployed Ship
                        break;
                    case 2:
                        System.out.print(" "); // Computer Deployed Ship(ship is set to invisible  " ")
                        break;
                    case 3:
                        System.out.print("M"); // Player Missed
                        break;
                    case 4:
                        System.out.print("m"); // Computer Missed
                        break;
                    case 5:
                        System.out.print("H"); // Player Hit
                        break;
                    case 6:
                        System.out.print("h"); // Computer Hit
                        break;
                    case 7:
                        System.out.print("O"); // Player Own Hit
                        break;
                    case 8:
                        System.out.print("o"); // Computer Own Hit
                        break;
                    default:
                        System.out.print(" ");
                }
            }
            System.out.print("|" + row + "\n");             //printing right side "|" and row number
        }
        System.out.println("  0123456789  ");
    }


    public static void playerTurn() {

        System.out.println("\nYour Turn");
        int x , y , row, col;

            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < 10 /*row*/) && (y >= 0 && y < 10 /*col*/))//valid guess
            {
                if (ocean[x][y] == 2) //if computer is already there; computer loses ship
                {
                    System.out.println("Boom ! You sink the ship!");
                    //System.out.print("H");//hit mark
                    ocean [x][y] = 5;
                    --ComputerTotalShipNo;

                    } else if (ocean[x][y] == 1) {
                    System.out.println("Oh no, you sunk your own ship");
                    //System.out.println("h");
                    ocean [x][y] = 7;
                    --PlayerTotalShipNo;

                    } else if (ocean[x][y] == 0) {
                    System.out.println("Sorry you missed");
                    //System.out.println("M");
                    ocean[x][y] =3;
                }
                }

                if (((x < 0) || x >= 10 /*ocean[row]*/)||(y < 0 || y >= 10 /*ocean[col]*/)) {// invalid guess
                System.out.println("You can't place shot outside the grid");
                }
                //System.out.println("Player total ship : " + PlayerTotalShipNo);
                //System.out.println("Computer total ship : " + ComputerTotalShipNo);
                //(PlayerTotalShipNo !=0 || ComputerTotalShipNo !=0);
    }

   public static void computerTurn() {

        System.out.println("\nComputer Turn");
        int x , y , row, col;

        Random rand = new Random();

             x = rand.nextInt(10);
             y = rand.nextInt(10);
            //x = (int) (Math.random() * 10);
            //y = (int) (Math.random() * 10);

            if ((x >= 0 && x < 10) && (y >= 0 && y < 10)) //valid guess
            {
                if (ocean[x][y] == 1) //if player ship is already there; player loses ship
                {
                    System.out.println("The computer sunk one of your ships!");
                    //System.out.print("x");//hit mark
                    ocean[x][y] = 6;
                    --PlayerTotalShipNo;

                } else if (ocean[x][y] == 2) {
                    System.out.println("The computer sunk one of it ships");
                    //System.out.print("h");//hit mark
                    ocean [x][y] = 8;
                    --ComputerTotalShipNo;

                } else if (ocean[x][y] == 0) {
                    System.out.println("Computer missed"); //Saving missed guesses for computer
                    //System.out.print("h");//hit mark
                    ocean [x][y] = 4;
                   // if (missedGuess[x][y] != 1)
                   //     missedGuess[x][y] = 1;
                }
            }
    }

    public static void gameOver() {

        System.out.println("\nYour Ships: " + PlayerTotalShipNo + " | Computer Ships: " + ComputerTotalShipNo );

        if (PlayerTotalShipNo > 0 && ComputerTotalShipNo <= 0)
            System.out.println("Hooray ! You won the battle!");
        else
            System.out.println("Sorry, you lost the battle.");
        }
}

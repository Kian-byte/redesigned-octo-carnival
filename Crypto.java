package com.acwd.m1.iu8;

import java.util.*; // Import the scanner class

public class Crypto {

     public static void main(String[] args) {

         // Take-in input string to be encrypted
         Scanner inputText = new Scanner(System.in);
         System.out.println("Please enter a text :");
         String text = inputText.nextLine();

         String replaceSentence = normalizeText(text);

         System.out.println("Sentence length is " + replaceSentence.length());

         Scanner numbershift = new Scanner(System.in);
         System.out.println("Please input shift value :");
         int shift = inputText.nextInt();
         //char shift = numbershift.findInLine(".").charAt(0);

         System.out.println("The shift value enter is " + shift);
         System.out.println("----------");
         System.out.print("Based on the input shift value, the encrypted text is ");

         caesarify(replaceSentence, shift);
         System.out.print(caesarify(replaceSentence, shift));
         System.out.println("\n");
         System.out.println("----------");
         System.out.println("Please enter group value :");
         int space = inputText.nextInt();
         System.out.println(groupify(replaceSentence, space));;
         System.out.println("----------");
         //System.out.println("After shifting, the Caesar cipher sentence is ");
     }

     //Part 1 - Normalize Text
     public static String normalizeText(String text) {

         String replaceSentence = text.replaceAll("[^\\pL]", "").toUpperCase();
         System.out.println("After replacement : " + replaceSentence);
         System.out.println("----------");
         return (replaceSentence);
     }

     // Part 2 - Caesar Cipher - encryption
     public static String caesarify(String replaceSentence, int shift) {

         String result = "";
         int i;
         for (i = 0; i < replaceSentence.length(); i++){
             char temp = replaceSentence.charAt(i);
             temp += shift;
             if (temp < 'A'){temp += 25;}
                else
             if (temp > 'Z'){temp -= 26;}

             result += temp;
         }
        return (result);
     }

     //Part 3 - Codegroups
     public static String groupify(String text, int Space) {

         //Scanner inputNumber = new Scanner(System.in);

         int group =1;
         String str = "";

         for (int i = 0; i < text.length(); i++) {
             str += text.charAt(i);

                // checking group size, create group with user value, follow by adding a space after to each grouping
                if (group == Space){
                    group = 1;
                    str += " ";}
                    else {
                        group ++; }

                    //check if at the end of text
                    if (i == text.length()-1) {
                    //check if need to add 'x'
                        if(text.length() % Space != 0) {

                        //adding x to the remainder
                        for (int j = 0; j < (Space - (text.length() % Space)); j++) {
                        str += "x";
                     }
                 }
             }
         }


            return (str);
     }

    public static String shiftAlphabet (int shift) {

       int start = 0;
       if (shift <0){ start = (int) 'Z' + shift + 1;}
       else { start = 'A' + shift;}

        String result ="";

        char currChar = (char) start;
        for (; currChar <= 'Z'; ++currChar){

            result = result + currChar;}

        if (result.length()<26){
            for (currChar = 'A';result.length()<26; ++ currChar){
                result= result + currChar;}
            }
                System.out.print(result);
                return (result);
    }
   }


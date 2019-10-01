package com.acwd.m1.iu10;

import java.util.InputMismatchException;

    public class Fraction {

        // creating the two fields
        private int num = 0;
        private int den = 0;

        // two parameter constructor
        public Fraction(int num, int den) {
            if (den < 0) {
                this.num = (-1) * num;
                this.den = (-1) * den;
            } else {
                this.num = num;
                this.den = den;
            }
        }

        // one parameter constructor
        public Fraction (int num) {
            this.num = num;
            this.den = 1;
        }

        // zero parameter constructor
        public Fraction () {
            this.num = 0;
            this.den = 1;
        }

        // method exposes value of numerator to user
        public int getNumerator() {
            return this.num;
        }

        // method exposes value of denominator to user
        public int getDenominator() {
            return this.den;
        }

        // "numerator/denominator" , a String representation of the fraction
        public String toString() {
            return this.num + "/" + this.den;
        }

        // method return the result of numerator/denominator
        public double toDouble() {
            return (double) num / den;
        }

        // method converts the current fraction to the lowest terms
        public void toLowestTerms() {
            int numGCD = gcd(this.num, this.den);
            this.num /= numGCD;
            this.den /= numGCD;
        }

        // method takes in two ints and returns the Greatest Common Divisor.
        public int gcd(int num, int den) {
            if (den == 0) {
                return Math.abs(num);
            }
            return Math.abs(gcd(den, num % den));
        }

        // method return the new Fraction that is the sum of other and this fraction
        public Fraction add(Fraction other){
            int tempNum = (this.num * other.den);
            int tempDen = (this.den * other.den);
            int newNum = (other.num * this.den);
            int fracNum = tempNum + newNum;
            Fraction result = new Fraction(fracNum, tempDen);
            return(result);
        }

        // method return the new Fraction that is the difference between the other and this fraction
        public Fraction subtract(Fraction other){
            int tempNum = (this.num * other.den);
            int tempDen = (this.den * other.den);
            int newNum = (other.num * this.den);
            int fracNum = tempNum - newNum;
            Fraction result = new Fraction(fracNum, tempDen);
            return(result);
        }

        // method return the new Fraction that is the product between the other and this fraction
        public Fraction multiply(Fraction other) {
            int fracNum = this.num * other.num;
            int fracDen = this.den * other.den;
            Fraction result = new Fraction(fracNum, fracDen);
            return(result);
        }

        // method return the new Fraction that is the division between the other and this fraction,
        // throw an IllegalArgumentException() if the user asks to divide by 0(zero)
        public Fraction divide(Fraction other) {
            if (other.num == 0 && other.den == 1) {
                throw new IllegalArgumentException("Denominator value cannot be 0!");
            }
            int fracNum = this.num * other.den;
            int fracDen = this.den * other.num;
            Fraction result = new Fraction(fracNum, fracDen);
            return (result);
        }

        // method must take in am "Object" to properly override the Object class's
        // equals method, but should ultimately check if two fractions are equal
        public boolean equals(Object other){
            if (other instanceof Fraction) {
                Fraction otherFrac = (Fraction) other;
                otherFrac.toLowestTerms();

                Fraction thisFrac = new Fraction(this.num, this.den);
                thisFrac.toLowestTerms();

                if ((thisFrac.num == otherFrac.num) && (thisFrac.den == otherFrac.den)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new InputMismatchException();
            }
        }
}

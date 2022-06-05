package com.simpleprograms;

/**
 * A class with methods that prints numbers from 1 to 100. But instead of
 * multiples of three, it prints "Fizz", and instead of numbers that are
 * multiples of five, - "Buzz". Instead of numbers that are multiples of both
 * three and five at the same time, it prints "FizzBuzz".
 * 
 * @author VitasSalvantes
 * @version 2.0
 */

public class FizzBuzz {

/** Method that launches the program */
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {

            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
                continue;
            }

            if (i % 5 == 0) {
                System.out.print("Buzz ");
                continue;
            }

            if (i % 3 == 0) System.out.print("Fizz "); else System.out.print(i + " ");
        }
    }
}
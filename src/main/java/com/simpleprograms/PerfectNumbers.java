package com.simpleprograms;

import java.util.Scanner;

/**
 * Class with methods that creates a sequence of perfect numbers
 * 
 * @author VitasSalvantes
 * @version 2.0
 */
public class PerfectNumbers {

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        String sequence = "";
        long summ = 0, number = 2L;

        System.out.println("- How many numbers? (Attention! To display more than 4 numbers, you will have to wait!)");
        int length = new Scanner(System.in).nextInt();

        while (length > 0) {
            summ = 0;

            for (long i = 1L; i < number; i++) {
                if (number % i == 0) {
                    summ += i;
                }
            }

            if (summ == number) {
                sequence += number + " ";
                length--;
            }

            System.out.println(number); // For debugging
            number++;
        }

        System.out.println("Perfect numbers: " + sequence);
    }
}
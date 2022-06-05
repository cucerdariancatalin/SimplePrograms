package com.SimplePrograms;

import java.util.Scanner;

/**
 * Class-example of Fibonacci numbers implementation
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
public class FibonacciNumbers {

    /** Method that launches the program */
    public static void main(String[] args) {
        System.out.println("- How many numbers?");
        int numberOfNumbers = new Scanner(System.in).nextInt();

        System.out.println(new FibonacciNumbers().makeFibonacciNumbers(numberOfNumbers));
    }

    /** Method that generates Fibonacci numbers */
    private String makeFibonacciNumbers(int numberOfNumbers) {
        String fibonacciNumbers = "Your numbers: 1 ";
        int nextNumber = 1, previousNumber = 0, currentNumber, counter = numberOfNumbers;

        while (counter > 1) {
            currentNumber = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = currentNumber;
            fibonacciNumbers += currentNumber + " ";
            
            counter--;
        }

        return fibonacciNumbers;
    }
}
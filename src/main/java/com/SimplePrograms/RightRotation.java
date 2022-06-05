package com.SimplePrograms;

import java.util.Scanner;

/**
 * The simple program to do the right rotation.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class RightRotation {
    public static void main(String[] args) {
        // The Scanner object to get the user input
        Scanner scanner = new Scanner(System.in);

        // The array of numbers
        String[] numbers = scanner.nextLine().trim().split(" ");

        // The number to shift all elements of the array
        int rotationNumber = scanner.nextInt() % numbers.length;

        // The last element of the array
        String buffer;

        // 1. Save the last number in the buffer
        // 2. Shift all elements to right once (here the last number is lost)
        // 3. Assign the first element to the value from the buffer
        // 4. Repeat it all rotationNumber times
        for (int i = 0; i < rotationNumber; i++) {
            buffer = numbers[numbers.length - 1];
            System.arraycopy(numbers, 0, numbers, 1, numbers.length - 1);
            numbers[0] = buffer;
        }

        // Print the rotated array
        for (String number : numbers) {
            System.out.print(number + " ");
        }
    }
}

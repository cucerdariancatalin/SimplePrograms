package com.simpleprograms;

import java.util.Scanner;

/**
 * Simple program to find out whether the queens can capture each other.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class Queens {

    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("X and Y coordinates of the first queen:");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println("X and Y coordinates of the second queen:");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        boolean intersectHorizontallyOrVertically = x1 == x2 || y1 == y2;
        boolean intersectDiagonally = Math.abs(x1 - x2) == Math.abs(y1 - y2);

        System.out.println("\nCan queens capture each other?");
        if (intersectHorizontallyOrVertically || intersectDiagonally) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

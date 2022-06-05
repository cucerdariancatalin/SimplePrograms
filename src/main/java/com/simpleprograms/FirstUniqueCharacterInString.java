package com.simpleprograms;

import java.util.*;

/**
 * A simple program to find the first unique character in a string
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class FirstUniqueCharacterInString {

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        System.out.println("- String?");
        String s = new Scanner(System.in).nextLine();
        char[] chars1 = s.toCharArray();
        char[] chars2 = s.toCharArray();
        int uniqNumber = 0;

        for (char c1 : chars1) {
            for (char c2 : chars2) {
                if (c1 == c2) {
                    uniqNumber++;
                }
            }
            if (uniqNumber == 1) {
                System.out.println("First  unique character: " + "\"" + c1 + "\"");
                break;
            }
            uniqNumber = 0;
        }

        if (uniqNumber == 0) {
            System.out.println("There are no unique characters in the string!");
        }
    }
}
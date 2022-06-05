package com.SimplePrograms;

/**
 * Example of exchanging the values of two variables without using the third
 * 
 * @author VitasSalvantes
 * @version 2.0
 */
public class ExchangedValues {

    /** Method that launches the program */
    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println(a + " and " + b);
        a += b;
        b = a - b;
        a -= b;
        System.out.println(a + " and " + b);
    }
}
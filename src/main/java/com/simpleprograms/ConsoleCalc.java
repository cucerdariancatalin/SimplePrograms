package com.simpleprograms;

import java.util.Scanner;

/**
 * A class with methods that allow you to perform simple math operations
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class ConsoleCalc {

    /**
     * The first number entered by the user and the result of calculations at the
     * same time
     */
    private double firstNumber;

    /** Each subsequent number entered by the user */
    private double nextNumber;

    /** The mathematical operation to be performed */
    private String operation;

    /** Flag showing the current state of program execution */
    private boolean run = true;

    /** A Scanner class object that accepts user input */
    private Scanner sc = new Scanner(System.in);

    /** Method that launches the program */
    public static void main(String[] args) {
        ConsoleCalc cc = new ConsoleCalc();

        cc.userGuid();
        cc.makeComputation();
    }

    /** Method regulating program execution */
    private void makeComputation() {
        setFirstNumber();

        while (run) {
            setOperation();

            if (run) {
                setNextNumber();
                doTheCalculation();
            }
        }

    }

    /** Method displaing information about program usage */
    private void userGuid() {
        System.out.println("Welcome!\n");
        // TODO add user guid
    }

    /**
     * Method that sets the value of a {@link ConsoleCalc#firstNumber} and validates
     * user input
     */
    public void setFirstNumber() {
        System.out.println("- Your number:");
        try {
            firstNumber = sc.nextDouble();
        } catch (Exception incorrectInput) {
            System.out.println("Incorrect input");
            setFirstNumber();
        }
    }

    /**
     * Method that sets the value of a {@link ConsoleCalc#nextNumber} and validates
     * user input
     */
    public void setNextNumber() {
        System.out.println("- Your number:");
        try {
            nextNumber = sc.nextDouble();
        } catch (Exception incorrectInput) {
            System.out.println("Incorrect input");
            setNextNumber();
        }
    }

    /**
     * Method that sets the value of a {@link ConsoleCalc#operation} and validates
     * user input. Stops the program and the calling {@link ConsoleCalc#getResult()}
     * when you type "="
     */
    public void setOperation() {
        System.out.println("- Your operation:");
        // TODO add formatter
        try {
            operation = sc.next();
        } catch (Exception incorrectInput) {
            System.out.println("Incorrect input");
            setOperation();
        }

        if (operation.equals("=")) {
            getResult();
        }
    }

    /**
     * Method containing instructions for performing mathematical operations other
     * than "=" (see {@link ConsoleCalc#setOperation()})
     */
    private void doTheCalculation() {
        switch (operation) {
            case "+":
                firstNumber += nextNumber;
                break;

            case "-":
                firstNumber -= nextNumber;
                break;

            case "/":
                firstNumber /= nextNumber;
                break;

            case "*":
                firstNumber *= nextNumber;
                break;

            default:
                System.out.println("Something went wrong...");
                break;
        }
    }

    /**
     * Method that stops the execution of the program and outputs the formatted
     * result
     */
    private void getResult() {
        // TODO add formatter
        System.out.println(firstNumber);
        run = false;
        sc.close();
    }

}

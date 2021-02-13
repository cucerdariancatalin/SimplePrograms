import java.util.Scanner;

/**
 * Class-example of Fibonacci numbers implementation
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class FibonacciNumbers {

    /** Previous calculated number */
    private int past = 0;

    /** Number calculated in this iteration */
    private int present = 0;

    /** The final result of finding the Fibonacci numbers */
    private int result;

    /** The number of Fibonacci numbers displayed */
    private int lgth;

    /** A Scanner class object that accepts user input */
    private Scanner sc;

    /** Method that launches the program */
    public static void main(String[] args) {
        FibonacciNumbers fn = new FibonacciNumbers();
        fn.run();
    }

    /**
     * A method that calls a dialog with the user and accepts the number of
     * Fibonacci numbers from the user
     */
    private void run() {
        System.out.println("- How many numbers?");

        sc = new Scanner(System.in);
        lgth = sc.nextInt();
        sc.close();

        makeNumbers();
    }

    /** Method generating Fibonacci numbers */
    private void makeNumbers() {
        System.out.print(present + " ");
        present = 1;

        while (lgth > 0) {
            result = present;
            present += past;
            past = result;
            System.out.print(result + " ");
            lgth--;
        }
    }
}
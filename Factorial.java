import java.util.Scanner;

/**
 * Class-example of factorial implementation
 * @author VitasSalvantes
 * @version 1.0
 */

public class Factorial {

    /** The number for which you want to find the factorial */
    private int number = 1;

    /** The final result of finding the factorial */
    private int result = 1;

    /** A Scanner class object that accepts user input */
    private Scanner sc;

    /** Method that launches the program */
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.go(f.getResult(), f.getNumber()));
    }

    /** Method calculates factorial and prints the result {@link Factorial#result} to the console
     * @param result {@link Factorial#result}
     * @param number {@link Factorial#number}
     */
    private int go(int result, int number) {
        sc = new Scanner(System.in);
        result = this.result;
        number = this.number;

        System.out.println("- Number?");
        number = sc.nextInt();
        System.out.print(number + "! = ");

        while (number > 0) {
            result *= number;
            number--;
        }

        sc.close();
        return result;
    }

    /** Getter for result {@link Factorial#result} */
    public int getResult() {
        return result;
    }

    /** Getter for number {@link Factorial#number} */
    public int getNumber() {
        return number;
    }
}

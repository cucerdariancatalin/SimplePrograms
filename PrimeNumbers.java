import java.util.Scanner;

/**
 * Class with methods for printing prime numbers
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class PrimeNumbers {

    /** A Scanner class object that accepts user input */
    private Scanner sc;

    /** The number of prime numbers displayed */
    private int quantity;

    /** Method that launches the program */
    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();

        pn.setQuantity();
        System.out.println(pn.creatPrimeNumbers());
    }

    /** Method for creating strings containing prime numbers */
    private String creatPrimeNumbers() {
        String s = "";
        int number = 2;

        while (quantity > 0) {

            for (int i = 2; i <= number; i++) {

                if (number % i == 0 && number != i) {
                    break;
                }

                if (number == i) {
                    s += number + " ";
                    quantity--;
                }
            }

            number++;
        }
        return s;
    }

    /** Setter for {@link PrimeNumbers#quantity} */
    public void setQuantity() {
        sc = new Scanner(System.in);

        System.out.println("- Quantity?");
        quantity = sc.nextInt();
        sc.close();
    }
}
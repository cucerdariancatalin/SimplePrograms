import java.util.Scanner;

/**
 * Class with methods that creates a sequence of perfect numbers
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
public class PerfectNumbers {

    /** A Scanner class object that accepts user input */
    final private Scanner sc = new Scanner(System.in);

    /**
     * Sequence length. Attention! To display more than four numbers, you will have
     * to wait!
     */
    private int length;

    /** Sequence of perfect numbers */
    private String sequence = "";

    /** Method that launches the program */
    public static void main(String[] args) {
        PerfectNumbers pn = new PerfectNumbers();

        pn.setLength();
        System.out.println("Pefrfect numbers: " + pn.makeNumbers());
    }

    /** Setter for {@link PerfectNumbers#length} */
    private void setLength() {
        System.out.println("- How many numbers?");
        length = sc.nextInt();

        sc.close();
    }

    /** Method that creates perfect numbers */
    private String makeNumbers() {
        long summ = 0, number = 2L;

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

            System.out.println(number);
            number++;
        }

        return sequence;
    }
}
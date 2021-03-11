import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class with methods that implement the Recaman sequence
 * 
 * @author VitasSalvantes
 * @version 1.5
 */

public class RecamanSequence {

    /** The current member of the sequence */
    private int number = 0;

    /** Numbers included in the sequence */
    final private LinkedList<Integer> sequence = new LinkedList<Integer>();

    /** Sequence length */
    private int length;

    /** A Scanner class object that accepts user input */
    final private Scanner sc = new Scanner(System.in);

    /** Method that launches the program */
    public static void main(String[] args) {
        RecamanSequence rs = new RecamanSequence();

        rs.setLength();
        rs.createSequence();
    }

    /** Setter for {@link RecamanSequence#length} */
    public void setLength() {
        System.out.println("- How many numbers?");
        length = sc.nextInt();
        sc.close();
    }

    /** Method that generates the next {@link RecamanSequence#number} */
    private void addNumber() {
        if (sequence.getLast() - number <= 0 || sequence.contains(sequence.getLast() - number)) {
            sequence.addLast(sequence.getLast() + number);
        } else {
            sequence.addLast(sequence.getLast() - number);
        }
    }

    /** Method that creates a sequence and displays it */
    private void createSequence() {
        sequence.addLast(0);
        number++;

        while (number != length) {
            addNumber();
            number++;
        }

        System.out.println(sequence);
    }
}
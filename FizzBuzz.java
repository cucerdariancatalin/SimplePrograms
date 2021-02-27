/**
 * A class with methods that prints numbers from 1 to 100. But instead of
 * multiples of three, it prints "Fizz", and instead of numbers that are
 * multiples of five, - "Buzz". Instead of numbers that are multiples of both
 * three and five at the same time, it prints "FizzBuzz".
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class FizzBuzz {

    /** Text for multiples of 5 */
    private String buzz = "Buzz ";

    /** Text for multiples of 3 */
    private String fizz = "Fizz ";

    /** Text for multiples of 15 (== 3 * 5) */
    private String fizzBuzz = "FizzBuzz ";

    /** Array with numbers from 0 to 100 */
    private int[] numbers;

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        fb.printer(fb.fizzBuzzer());
    }

    /** Method for printing the sequence to the console */
    private void printer(int[] numbers) {
        for (int i : numbers) {

            if (i % 15 == 0) {
                System.out.print(fizzBuzz);
                continue;
            }

            if (i % 5 == 0) {
                System.out.print(buzz);
                continue;
            }

            if (i % 3 == 0) {
                System.out.print(fizz);
                continue;
            }

            System.out.print(i + " ");
        }
    }

    /**
     * Method for filling an array {@link FizzBuzz#numbers} with numbers from 0 to
     * 100
     */
    private int[] fizzBuzzer() {
        numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
}
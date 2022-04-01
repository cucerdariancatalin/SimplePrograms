/**
 * The simple implementation of the Euclidean algorithm for positive integers.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class EuclideanAlgorithm {
    /**
     * The first integer.
     */
    private int firstNumber;

    /**
     * The second integer.
     */
    private int secondNumber;

    /**
     * The setter for the {@link EuclideanAlgorithm#firstNumber}.
     *
     * @param firstNumber a positive integer.
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = Math.abs(firstNumber);
    }

    /**
     * The setter for the {@link EuclideanAlgorithm#secondNumber}.
     *
     * @param secondNumber a positive integer.
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = Math.abs(secondNumber);
    }

    /**
     * The constructor to set the {@link EuclideanAlgorithm#firstNumber} and the {@link EuclideanAlgorithm#secondNumber}.
     *
     * @param firstNumber  a positive integer.
     * @param secondNumber a positive integer.
     */
    public EuclideanAlgorithm(int firstNumber,
                              int secondNumber) {
        this.firstNumber = Math.abs(firstNumber);
        this.secondNumber = Math.abs(secondNumber);
    }

    /**
     * The method to calculate the greatest common divisor.
     *
     * @return the greatest common divisor
     */
    public int calculateGCD() {
        int remainder;
        var gcdCandidate = 1;
        var biggestNumber = Math.max(this.firstNumber, this.secondNumber);
        var smallestNumber = Math.min(this.firstNumber, this.secondNumber);

        while (true) {
            remainder = biggestNumber % smallestNumber;

            if (remainder == 0) {
                return gcdCandidate;
            }

            gcdCandidate = remainder;
            biggestNumber = smallestNumber;
            smallestNumber = remainder;
        }
    }

    /**
     * The method to launch the program.
     */
    public static void main(String[] args) {
        EuclideanAlgorithm algorithm = new EuclideanAlgorithm(391, 544);

        System.out.println(algorithm.calculateGCD());

        algorithm.setFirstNumber(18);
        algorithm.setSecondNumber(12);

        System.out.println(algorithm.calculateGCD());
    }
}

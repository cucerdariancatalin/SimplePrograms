/**
 * A program for printing the multiplication table of one number
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class MultiplicationTableForNumber {

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        int firstNumber = 5;
        StringBuilder multiplicationTableForNumber = new StringBuilder();
        for (int secondNumber = 1; secondNumber < 11; secondNumber++) {
            multiplicationTableForNumber.append(firstNumber).append(" * ").append(secondNumber).append(" = ").append(firstNumber * secondNumber).append("\n");
        }

        System.out.println(multiplicationTableForNumber.toString().trim());
    }
}
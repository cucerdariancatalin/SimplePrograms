/**
 * A program for printing the multiplication table of one number
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class MultiplicationTableForNumber {
    public static void main(String[] args) {
        int secondNumber = 5;
        StringBuilder multiplicationTableForNumber = new StringBuilder();
        for (int firstNumber = 1; firstNumber < 11; firstNumber++) {
            multiplicationTableForNumber.append(firstNumber).append(" * ").append(secondNumber).append(" = ").append(firstNumber * secondNumber).append("\n");
        }

        System.out.println(multiplicationTableForNumber.toString().trim());
    }
}

/**
 * A simple class with a method to exchange values between two variables without using a third
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class ExchangedValues {
    /** First variable */
    private int a = 1;

    /** Second variable */
    private int b = 2;

    /** Method that launches the program */
    public static void main(String[] args) {
        ExchangedValues en = new ExchangedValues();
        en.exchanger();
    }

    /** Method that changes the values of the first {@link ExchangedValues#a} and second {@link ExchangedValues#b} variables */
    private void exchanger() {
        System.out.println(a + " and " + b);
        a += b;
        b = a - b;
        a -= b;
        System.out.println(a + " and " + b);
    }

}

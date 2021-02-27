/**
 * A simple class with a method to exchange values between two variables without using a third
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class ExchangedNumbers {
    private int a = 1;
    private int b = 2;

    /** Method that launches the program */
    public static void main(String[] args) {
        ExchangedNumbers en = new ExchangedNumbers();
        en.exchanger();
    }

    private void exchanger() {
        System.out.println(a + " and " + b);
        a += b;
        b = a - b;
        a -= b;
        System.out.println(a + " and " + b);
    }

}

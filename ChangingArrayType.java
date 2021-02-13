import java.util.Arrays;

/**
 * Class-example of interaction of two arrays
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class ChangingArrayType {

    /** First array with integer values */
    private int[] arr1 = new int[10];

    /** Second array with string values */
    private String[] arr2 = new String[10];

    /** The number to fill the first array */
    private int count = 9;

    /** Method that launches the program */
    public static void main(String[] args) {

        ChangingArrayType cat = new ChangingArrayType();
        cat.go();

    }

    /** Method that triggers the creation of arrays */
    private void go() {
        intArray();
        stringArray();
    }

    /** Method creating an integer array */
    private void intArray() {
        for (int i = 0; i < arr1.length - 1; i++) {
            arr1[i] = count;
            count--;
        }
        System.out.println("int: " + Arrays.toString(arr1));
    }

    /**
     * Method creating an integer array (the second array takes all the values of
     * the first array, converts them to String type and stores them in reverse
     * order)
     */
    private void stringArray() {
        count = 9;
        for (int x : arr1) {
            arr2[count] = x + "";
            count--;
        }
        System.out.println("String: " + Arrays.toString(arr2));
    }
}
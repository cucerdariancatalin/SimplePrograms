/**
 * Class-example of initializing an array in a class constructor
 * 
 * @author VitasSalvantes
 * @version 1.0
 */

public class ArrayInitialization {

    /** Array reference */
    private String[] arr;

    /** Method that launches the program */
    public static void main(String[] args) {
        ArrayInitialization ai = new ArrayInitialization();
        System.out.print(ai.getArray());
    }

    /** A constructor that initializes the array when called */
    public ArrayInitialization() {
        arr = new String[3];
        arr[0] = "Hello";
        arr[1] = ", ";
        arr[2] = "world!";
    }

    /**
     * Method to simplify array output
     * 
     * @return s - array elements, represented as a string
     */
    private String getArray() {
        String s = "";

        for (String x : arr) {
            s += x;
        }
        return s;
    }
}

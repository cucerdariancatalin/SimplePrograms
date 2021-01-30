import java.util.Arrays;

public class ChangingArrayType {

    private int[] arr1 = new int[10];
    private String[] arr2 = new String[10];
    private int count = 9;

    public static void main(String[] args) {

        ChangingArrayType cat = new ChangingArrayType();
        cat.go();

    }

    private void go() {
        intArray();
        stringArray();
    }

    private void intArray() {
        for (int i = 0; i < arr1.length - 1; i++) {
            arr1[i] = count;
            count--;
        }
        System.out.println("int: " + Arrays.toString(arr1));
    }

    private void stringArray() {
        count = 9;
        for (int x : arr1) {
            arr2[count] = x + "";
            count--;
        }
        System.out.println("String: " + Arrays.toString(arr2));
    }
}
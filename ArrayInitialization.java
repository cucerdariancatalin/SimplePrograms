public class ArrayInitialization {
    
    private String[] arr;

    public static void main(String[] args) {
        ArrayInitialization ai = new ArrayInitialization();
        System.out.print(ai.getArray());
    }

    public ArrayInitialization() {
        arr = new String[3];
        arr[0] = "Hello";
        arr[1] = ", ";
        arr[2] = "world!";
    }

    private String getArray() {
        String s = "";

        for (String x : arr) {
            s += x;
        }
        return s;
    }
}

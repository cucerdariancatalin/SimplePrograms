import java.util.Scanner;

public class FibonacciNumbers {

    private int past = 0;
    private int present = 0;
    private int result;
    private int lgth;
    private Scanner sc;

    public static void main(String[] args) {
        FibonacciNumbers fn = new FibonacciNumbers();
        fn.run();
    }

    private void run() {
        System.out.println("- How many numbers?");

        sc = new Scanner(System.in);
        lgth = sc.nextInt();
        sc.close();

        System.out.println("- " + lgth);

        makeNumbers();
    }

    private void makeNumbers() {
        System.out.print(present + " ");
        present = 1;

        while (lgth > 0) {
            result = present;
            present += past;
            past = result;
            System.out.print(result + " ");
            lgth--;
        }
    }
}
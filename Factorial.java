import java.util.Scanner;

public class Factorial {

    private int number;
    private int result = 1;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Factorial f = new Factorial();
        f.go();
    }

    private void go() {
        System.out.println("- Number?");
        number = sc.nextInt();
        System.out.print("- " + number + "\n" + number + "! = ");

        while (number > 0) {
            result *= number;
            number--;
        }

        System.out.println(result);
    }
}

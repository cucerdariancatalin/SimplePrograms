import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCipher {

private String inputMessage;
private String outputMessage = "";
private Scanner sc = new Scanner(System.in);
private ArrayList <Character> deutschAlphabet = new ArrayList<Character>();
private char [] chars;
private int key;

    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();

        System.out.println(cc.encryption(cc.getChars(), cc.createDeutschAlphabet(), cc.getKey()));
    }

    private ArrayList <Character> createDeutschAlphabet() {
        for (char buchstabe = 'a'; buchstabe <= 'z'; buchstabe++) {
            deutschAlphabet.add(buchstabe);
        }

        deutschAlphabet.add('ä');
        deutschAlphabet.add('ü');
        deutschAlphabet.add('ö');
        deutschAlphabet.add('ß');

        return deutschAlphabet;
    }

    private char [] getChars() {
        System.out.println("Your message:");
        inputMessage = sc.nextLine().toLowerCase();
        chars = inputMessage.toCharArray();
        return chars;
    }

    private int getKey() {
        System.out.println("Your key:");
        key = sc.nextInt();

        key %= 30;

        return key;
    }

    private String encryption(char [] chars, ArrayList <Character> deutschAlphabet, int key) {
        chars = this.chars;
        deutschAlphabet = this.deutschAlphabet;
        key = this.key;

        for (char c : chars) {
            if (deutschAlphabet.contains(c) == true) {
                if ((deutschAlphabet.indexOf(c) + key) > 30) {
                    outputMessage += deutschAlphabet.get(30 % (deutschAlphabet.indexOf(c) + key));
                    continue;
                }
                outputMessage += deutschAlphabet.get(deutschAlphabet.indexOf(c) + key);

            } else {
                outputMessage += c;
            }
        }
        return outputMessage;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCipher {

private String inputMessage;
private String outputMessage = "";
private Scanner sc = new Scanner(System.in);
private ArrayList <Character> deutschAlphabet = new ArrayList<Character>();
private char [] chars;
private int numberX = 1;        // TODO create input
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();

        System.out.println(cc.encryption(cc.getChars(), cc.createDeutschAlphabet()));
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
        inputMessage = sc.nextLine().toLowerCase();
        chars = new char [inputMessage.length()];

        for (int i = 0; i < inputMessage.length(); i++) {
            chars[i] = inputMessage.charAt(i);
        }
        return chars;
    }

    private String encryption(char [] chars, ArrayList <Character> deutschAlphabet) {
        chars = this.chars;
        deutschAlphabet = this.deutschAlphabet;

        for (char c : chars) {
            if (deutschAlphabet.contains(c) == true) {
                outputMessage += deutschAlphabet.get(deutschAlphabet.indexOf(c) + numberX); //TODO if ... + numberX > length

            } else {
                outputMessage += c;
            }
        }
        return outputMessage;
    }
}
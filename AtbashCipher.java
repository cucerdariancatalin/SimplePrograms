/**
 * The program to en- and decrypt messages using the Atbash cipher.
 *
 * @author VitasSalvantes
 * @version 4.0
 */
public class AtbashCipher {

    /**
     * The method en- and decrypts the message using the Atbash cipher.
     */
    public String processMessage(final String inputMessage) {
        final var outputMessage = new StringBuilder();

        for (int i = 0; i < inputMessage.length(); i++) {
            outputMessage.append((char) (Character.MAX_VALUE - inputMessage.charAt(i)));
        }

        return outputMessage.toString();
    }

    /**
     * The method launches the program.
     */
    public static void main(String[] args) {
        final var cipher = new AtbashCipher();
        final var userMessage = "Hello, World!";

        System.out.println(userMessage);
        System.out.println(cipher.processMessage(userMessage));
        System.out.println(cipher.processMessage("ﾷﾚﾓﾓﾐￓ\uFFDFﾨﾐﾍﾓﾛ\uFFDE"));
    }
}
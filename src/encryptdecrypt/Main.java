package encryptdecrypt;

import java.util.Scanner;

/**
 * @author Arkadiusz Brych
 */
public class Main {
    public static void main(String[] args) {

        String mode = getArgument2(args, "-mode");
        String key = getArgument2(args, "-key");
        String data = getArgument2(args, "-data");
        try (Scanner input = new Scanner(System.in)) {
            if (mode == null) {
                mode = "enc";
            }
            if (data == null) {
                data = input.nextLine();
                int keyInt = input.nextInt();
                if (mode.equals("enc")) {
                    System.out.println(encryptMessage(data, keyInt));
                } else {
                    System.out.println(decryptMessage(data, keyInt));
                }
            } else {
                int number = Integer.parseInt(key);
                if (mode.equals("enc")) {
                    System.out.println(encryptMessage(data, number));
                } else {
                    System.out.println(decryptMessage(data, number));
                }
            }
        }
    }

    private static String encryptMessage(String originalMessage, int moveLetters) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < originalMessage.length(); i++) {
            char oneCharFromOriginalMessage = (char) (originalMessage.charAt(i) + moveLetters);
            encrypted.append(oneCharFromOriginalMessage);
        }
        return encrypted.toString();
    }

    private static String decryptMessage(String encryptedMessage, int moveLetters) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char oneCharFromDecryptMessage = (char) (encryptedMessage.charAt(i) - moveLetters);
            decrypted.append(oneCharFromDecryptMessage);
        }
        return decrypted.toString();
    }

    private static String getArgument2(String[] args, String argName) {
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals(argName)) {
                return args[i + 1];
            }
        }
        return null;
    }
}



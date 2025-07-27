package org.example;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    private static final Scanner scanner = new Scanner(System.in); ;

    public static void main(String[] args) {
        startProcess();
    }

    /**
     * Проверяет строку, используя метод Чака Норриса.
     */
    public static void startProcess() {
        while(true){
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = readScanner().trim();
            switch (operation) {
                case "encode" -> encodeString();
                case "decode" -> decodeString();
                case "exit" -> {
                    System.out.println("Bye!");
                    closeScanner();
                    return;
                }
                default -> System.out.println("There is no '" + operation + "' operation");
            }
        }
    }

    /**
     * Считывает строку ввода от пользователя.
     * @return строку ввода
     */
    public static String readScanner() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }

    /**
     *Считывает и выводит закодированную строку.
     */
    public static void encodeString() {
        System.out.println("Input string:");
        String input = readScanner();
        String encoded = TextEncryptionService.encryptText(input);
        System.out.println("Encoded string:");
        System.out.println(encoded);
    }

    /**
     * Считывает и выводит закодированную строку.
     */
    public static void decodeString() {
        System.out.println("Input encoded string:");
        String encoded = readScanner();
        if(isValidInput(encoded)){
            String decoded = TextDecryptionService.decryptText(encoded);
            System.out.println("Decoded string:");
            System.out.println(decoded);
        }else {
            System.out.println("Encoded string is not valid.");
        }
    }

    /**
     * Проверяет, является ли строка ввода допустимой.
     * @param inputString строка ввода
     * @return  значение true, если строка ввода допустима, в противном случае значение false
     */
    public static boolean isValidInput(String inputString) {
        if (!inputString.matches("[ 0]*")) {
            return false;
        }
        String[] blocks = inputString.split(" ");
        if (blocks.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < blocks.length; i += 2) {
            if (!blocks[i].equals("0") && !blocks[i].equals("00")) {
                return false;
            }
        }
        String binaryString = TextDecryptionService.convertUnaryToBinary(inputString);
        if (binaryString.length() % 7 != 0) return false;
        return true;
    }

    private static void checkingString(String string) {
        if(!isValidInput(string)) {
            System.out.println("Encoded string is not valid.");
            decodeString();
        }
    }

    /**
     * Обрабатывает входную строку.
     * @param inputString входная строка
     * @param consumer потребитель
     */
    public static void processInputString(String inputString, Consumer<String> consumer) {
        consumer.accept(inputString);
    }
}
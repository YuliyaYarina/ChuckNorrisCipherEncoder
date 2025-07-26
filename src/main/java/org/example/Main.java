package org.example;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input String:");
        String inputString = Main.readInputStringFromUser();
        Main.processInputString(inputString, Main::checkingStringUsingChuckNorrisMethod);
    }

    /**
     * Считывает строку ввода от пользователя.
     * @return строку ввода
     */
    public static String readInputStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Проверяет строку, используя метод Чака Норриса.
     * @param inputString строка ввода
     */
    public static void checkingStringUsingChuckNorrisMethod(String inputString) {
        Predicate<String> isValidInput = Main::isValidInput;
        Consumer<String> startsTheTextDecryptorProcess = TextDecryptionService::decryptText;
        Consumer<String> startsTheTextEncryptorProcess = TextEncryptionService::decryptText;

        if (isValidInput.test(inputString)) {
            startsTheTextDecryptorProcess.accept(inputString);
        } else {
            startsTheTextEncryptorProcess.accept(inputString);
        }
    }

    /**
     * Проверяет, является ли строка ввода допустимой.
     * @param inputString строка ввода
     * @return  значение true, если строка ввода допустима, в противном случае значение false
     */
    public static boolean isValidInput(String inputString) {
        return inputString.matches("[ 0]*");
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
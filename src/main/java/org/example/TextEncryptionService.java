package org.example;

/**
 * Содержит методы шифрования текста с использованием алгоритма шифрования Чака Норриса.
 */
public class TextEncryptionService {

    /**
     * Шифрует текст.
     * @param inputString строка ввода
     * @return зашифрованный текст
     */
    public static String encryptText(String inputString) {
        String binaryString = convertToBinary(inputString);
        return encryptString(binaryString);
    }

    /**
     * Преобразует строку в двоичную.
     * @param inputString входная строка
     * @return  двоичную строку
     */
    public static String convertToBinary(String inputString) {
        StringBuilder binaryString = new StringBuilder();
        for( char c : inputString.toCharArray()) {
            binaryString.append(String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        return binaryString.toString();
    }

    /**
     * Шифрует заданную двоичную строку, используя алгоритм шифрования Чака Норриса.
     * @param binaryString двоичная строка
     * @return зашифрованную строку
     */
    public static String encryptString(String binaryString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryString.length(); ) {
            char currentChar = binaryString.charAt(i);
            int count = 1;
            while (i + 1 < binaryString.length() && binaryString.charAt(i + 1) == currentChar) {
                i++;
                count++;
            }
            result.append(currentChar == '1' ? "0 " : "00 ").append(getRepeatedZeros(count)).append(" ");
            i++;
        }
        return result.toString().trim();
    }

    /**
     * Возвращает повторяющиеся нули.
     * @return повторяющиеся нули
     */
    public static String getRepeatedZeros(int count) {
        return "0".repeat(Math.max(0, count));
    }
}

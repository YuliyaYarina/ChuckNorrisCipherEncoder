package org.example;

/**
 * Предоставляет методы расшифровки текста с использованием алгоритма шифрования Чака Норриса.
 */
public class TextDecryptionService {

    /**
     * Расшифровывает заданный текст, используя алгоритм шифрования Чака Норриса.
     * @param unary текст для расшифровки
     * @return расшифрованный текст
     */
    public static String decryptText(String unary) {
        String binaryStrings = convertUnaryToBinary(unary);
        return convertToText(binaryStrings);
    }

    /**
     * Преобразует двоичные строки в текст.
     * @param binaryString двоичные строки.
     */
    public static String convertToText(String binaryString) {
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < binaryString.length(); i += 7){
            String binaryChar = binaryString.substring(i, i + 7);
            char c = (char) Integer.parseInt(binaryChar, 2);
            text.append(c);
        }
        return text.toString();
    }

/**
 * Преобразует унарную строку в двоичную.
 * @param unarySequence Унарная последовательность
 * @return двоичную строку
 */
    public static String convertUnaryToBinary(String unarySequence) {
        String[] unarySequenceParts = unarySequence.split(" ");
        StringBuilder binarySequence = new StringBuilder();

        for (int i = 0; i < unarySequenceParts.length; i += 2) {
            binarySequence.append((unarySequenceParts[i].equals("00") ? "0" : "1").repeat(unarySequenceParts[i + 1].length()));
        }

        return binarySequence.toString();
    }
}

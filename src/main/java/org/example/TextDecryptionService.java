package org.example;

public class TextDecryptionService {

    /**
     * Расшифровывает текст.
     * @param unary Унарная строка.
     */
    public static void decryptText(String unary) {
        System.out.println("The result: " );
        String[] binaryStrings = convertUnaryToBinary(unary).split("(?<=\\G.{7})");;
        convertBinaryToSting(binaryStrings);
    }

    /**
     * Преобразует двоичные строки в текст.
     * @param binaryStrings двоичные строки.
     */
    public static void convertBinaryToSting(String[] binaryStrings) {
        for (String binaryString : binaryStrings) {
            System.out.print((char) Integer.parseInt(binaryString, 2));
        }
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

package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input String:");
        String inputString = readInputStringFromUser();
        String binaryString = convertStringToBinary(inputString);
        System.out.println(encodeStringUsingChuckNorrisMethod(binaryString));
    }

    public static String readInputStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String convertStringToBinary(String inputString) {
        StringBuilder binaryString = new StringBuilder();
        for( char c : inputString.toCharArray()) {
            binaryString.append(String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        return binaryString.toString();
    }

    public static String encodeStringUsingChuckNorrisMethod(String binaryString) {
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
        return "The result: " + result.toString().trim();
    }

    public static String getRepeatedZeros(int count) {
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < count; i++) {
            zeros.append("0");
        }
        return zeros.toString();
    }
}
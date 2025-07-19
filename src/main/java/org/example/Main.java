package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input String:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        for (int i = 0; i < str.length(); i++) {
            System.out.printf("%c = %7s", str.charAt(i), String.format("%7s", Integer.toBinaryString(str.charAt(i))).replace(' ', '0'));
        }
    }
}
package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input String:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.replaceAll("", " ");
        System.out.println(str);
    }
}
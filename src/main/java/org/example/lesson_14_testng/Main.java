package org.example.lesson_14_testng;

import org.example.lesson_14_testng.exception.InvalidValue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        try {
            System.out.println("Введите положительное целое число.");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            System.out.println(factorial.getFactorial(number));
        } catch (InvalidValue e) {
            System.out.println(e.getMessage());
        }
    }
}

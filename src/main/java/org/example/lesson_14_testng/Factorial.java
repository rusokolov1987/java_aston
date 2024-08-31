package org.example.lesson_14_testng;

import org.example.lesson_14_testng.exception.InvalidValue;

public class Factorial {
    public int getFactorial(String number) throws InvalidValue {
        if (number == null || number.isEmpty() || !number.matches("^-?\\d+")) {
            throw new InvalidValue("Вы ввели не целое число!");
        }
        if (Integer.parseInt(number) < 0) {
            throw new InvalidValue("Вы ввели не положительное целое число!");
        }
        if (Integer.parseInt(number) == 0) {
            return 1;
        }
        return Integer.parseInt(number) * getFactorial(String.valueOf(Integer.parseInt(number) - 1));
    }
}

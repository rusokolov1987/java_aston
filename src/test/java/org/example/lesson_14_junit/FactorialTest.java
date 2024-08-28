package org.example.lesson_14_junit;

import org.example.lesson_14_junit.exception.InvalidValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    private static Factorial factorial;

    @BeforeEach
    public void setUp() {
        factorial = new Factorial();
    }

    @Test
    @DisplayName("Передача в метод положительного целого числа")
    public void whenAddPositiveNumbers() throws InvalidValue {
        int expected = 120;
        int actual = factorial.getFactorial("5");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Передача в метод отрицательного числа")
    public void whenAddNegativeNumbersThenThrowInvalidValue() {
        boolean isException = false;
        try {
            int result = factorial.getFactorial("-6");
        } catch (InvalidValue e) {
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    @DisplayName("Передача в метод не числа")
    public void whenAddNotNumberThenThrowException() {
        boolean isException = false;
        try {
            int result = factorial.getFactorial("");
        } catch (InvalidValue e) {
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    @DisplayName("Передача в метод null")
    public void whenAddNullThenThrowException() {
        boolean isException = false;
        try {
            int result = factorial.getFactorial(null);
        } catch (InvalidValue e) {
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    @DisplayName("Передача в метод дробного числа")
    public void whenAddDuobleNumberThenThrowException() {
        boolean isException = false;
        try {
            int result = factorial.getFactorial("1.2");
        } catch (InvalidValue e) {
            isException = true;
        }
        assertTrue(isException);
    }
}
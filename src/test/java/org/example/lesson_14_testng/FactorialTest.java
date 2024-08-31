package org.example.lesson_14_testng;

import org.example.lesson_14_testng.exception.InvalidValue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    private Factorial factorial;

    @BeforeMethod
    public void setUp() {
        factorial = new Factorial();
    }

    @DataProvider
    public Object[][] getTestData() {
        return new Object[][] {
                {"5", 120},
                {"-5", new InvalidValue("Отрицательное число")},
                {},
        };
    }

    @Test
    public void testGetFactorial() {
    }
}
/*
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

    @DataProvider(name = "getTestData")
    public Object[][] getTestData() {
        return new Object[][] {
                {"5", "120"},
                {"-12", "Введено отрицательное число!"},
                {"1.2", "Введено дробное число!"},
                {null, "Введен NULL!"},
                {"5a", "Введено не число!"}
        };
    }

    @Test(dataProvider = "getTestData")
    public void testGetFactorial(String data, String expected) {
        int actual = 0;
        boolean isException = false;
        try {
            actual = factorial.getFactorial(data);
        } catch (InvalidValue e) {
            isException = true;
        }
        if (isException) {
            assertTrue(isException);
        } else {
            assertEquals(Integer.parseInt(expected), actual);
        }
    }
}*/

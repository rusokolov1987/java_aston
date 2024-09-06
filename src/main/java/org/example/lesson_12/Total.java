package org.example.lesson_12;

import org.example.lesson_12.exception.MyArrayDataException;
import org.example.lesson_12.exception.MyArraySizeException;

public class Total {
    private String[][] matrix;

    public Total(String[][] matrix) {
        this.matrix = matrix;
    }

    public int getSum() throws MyArraySizeException, MyArrayDataException {
        int total = 0;
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new MyArraySizeException("Неверный размер матрицы!");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!isNumber(matrix[i][j])) {
                    throw new MyArrayDataException(i, j);
                }
                total += Integer.parseInt(matrix[i][j]);
            }
        }
        return total;
    }

    private boolean isNumber(String element) {
        if (element.isEmpty() || !element.matches("^-?\\d+")) {
            return false;
        }
        return true;
    }
}

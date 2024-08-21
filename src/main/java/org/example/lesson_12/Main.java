package org.example.lesson_12;

import org.example.lesson_12.exception.MyArrayDataException;
import org.example.lesson_12.exception.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        try {
            /* Неверный размер матрицы */
            //String[][] matrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
            /* Неверный формат в ячейке матрицы */
            //String[][] matrix = {{"1", "2", "3", "34"}, {"0", "9", "6", "1"}, {"7", "8", "9", "0"}, {"7", "8", "9", ""}};
            /* Верный формат */
            String[][] matrix = {{"1", "1", "-1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
            int sum = getSum(matrix);
            System.out.println("Сумма всех элементов матрицы = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSum(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
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

    public static boolean isNumber(String element) {
        if (element.isEmpty() || !element.matches("^-?\\d+")) {
            return false;
        }
        return true;
    }
}

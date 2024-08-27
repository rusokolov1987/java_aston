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
            Total total = new Total(matrix);
            int sum = total.getSum();
            System.out.println("Сумма всех элементов матрицы = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}

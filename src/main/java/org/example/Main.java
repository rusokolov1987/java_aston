package org.example;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isPositiveSum(10, 1));
        toCompare(2);
        System.out.println(isNegativeNumber(-2));
        printString("Какая-то строка", 4);
        System.out.println(isLeapYear(900));
        replaceElements();
        addElements();
        multiplayElements();
        addDiagonalElements();
        int[] array = createArray(5, 7);
        for (int element : array)
            System.out.println(element);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = 12;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void  printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 7;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isPositiveSum(int a, int b) {
        return (a + b) >= 10 & (a + b) <= 20;
    }

    public static void toCompare(int a) {
        if (a >= 0) {
            System.out.println("Переданное число положительное");
        } else {
            System.out.println("Переданное число отрицательное");
        }
    }

    public static boolean isNegativeNumber(int a) {
        return a >= 0;
    }

    public static void printString(String str, int count) {
        if (count <= 0) {
            System.out.println("Ошибка! Отрицательное число или 0!");
        }
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4) == 0 & (year % 100 != 0) || (year % 400) == 0);
    }

    public static void replaceElements() {
        int[] array = {0, 1, 1, 0, 0, 1, 0, 1, 0};
        System.out.println("Исходный массив:");
        showArray(array);
        System.out.println("\nЦелевой массив:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        showArray(array);
        System.out.println();
    }

    public static void addElements() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++ ) {
            array[i] = i + 1;
        }
        showArray(array);
    }

    public static void multiplayElements() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        showArray(array);
    }

    public static void addDiagonalElements() {
        System.out.println();
        int[][] matrix = new int[7][7];
        int count = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][matrix.length - (count - i)] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
    }

    public static int[] createArray(int len, int initialValue) {
        if (len < 0) {
            System.out.println("Ошибка! Отрицательная длина!");
        }
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
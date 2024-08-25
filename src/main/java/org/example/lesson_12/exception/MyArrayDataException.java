package org.example.lesson_12.exception;

public class MyArrayDataException extends Exception {
    private int indexI;
    private int indexJ;

    public MyArrayDataException(int indexI, int indexJ) {
        super("В ячейке " + "[" + indexI + ", " + indexJ + "]" + ", находится не число!");
        this.indexI = indexI;
        this.indexJ = indexJ;
    }

    public int getIndexI() {
        return indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }
}

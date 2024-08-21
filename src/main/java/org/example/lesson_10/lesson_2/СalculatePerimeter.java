package org.example.lesson_10.lesson_2;

public interface СalculatePerimeter {
    default double getPerimeterShape(int sideA, int sideB) {
        return (sideA + sideB) * 2;
    }
}

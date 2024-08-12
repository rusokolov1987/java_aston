package org.example.lesson_10.lesson_2;

public interface СalculatePerimeter {
/*    double getPerimeterShape();*/

    default double getPerimeterShape(int sideA, int sideB) {
        return (sideA + sideB) * 2;
    }
}

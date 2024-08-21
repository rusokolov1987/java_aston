package org.example.lesson_10.lesson_2;

import lombok.Data;

@Data
public class Triangle extends Shape {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC, String backgroundColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getAreaShape() {
        if ((sideA + sideB) < sideC || (sideA + sideC) < sideB || (sideB + sideC) < sideA) {
            return  0.0;
        }
        else {
            double p = getPerimeterShape() / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }

    }

    public double getPerimeterShape() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Характеристики треугольника: " +
                "\nЦвет заливки: " + backgroundColor +
                "\nЦвет граней: " + borderColor +
                "\nПериметр: " + getPerimeterShape() +
                "\nПлощадь: " + getAreaShape();
    }
}

package org.example.lesson_10.lesson_2;

import lombok.Data;

@Data
public class Rectangle extends Shape {
    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB, String backgroundColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getAreaShape() {
        return sideA * sideB;
    }

    @Override
    public String toString() {
        return "Характеристики прямоугольника: " +
                "\nЦвет заливки: " + backgroundColor +
                "\nЦвет граней: " + borderColor +
                "\nПериметр: " + getPerimeterShape(sideA, sideB) +
                "\nПлощадь: " + getAreaShape();
    }
}

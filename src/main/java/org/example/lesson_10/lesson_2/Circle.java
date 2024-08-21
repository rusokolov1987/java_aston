package org.example.lesson_10.lesson_2;

import lombok.Data;

@Data
public class Circle extends Shape {
    private int radius;

    public Circle(int radius, String backgroundColor, String borderColor) {
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getAreaShape() {
        return PI * Math.pow(radius, 2);
    }

    public double getPerimeterShape() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Характеристики круга: " +
                "\nЦвет заливки: " + this.backgroundColor +
                "\nЦвет граней: " + this.borderColor +
                "\nПериметр: " + this.getPerimeterShape() +
                "\nПлощадь: " + this.getAreaShape();
    }
}

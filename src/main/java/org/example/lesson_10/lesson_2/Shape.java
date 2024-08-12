package org.example.lesson_10.lesson_2;

import lombok.Data;

@Data
public abstract class Shape implements СalculateArea, СalculatePerimeter {
    protected String backgroundColor;
    protected String borderColor;
    protected double PI = 3.14;

    @Override
    public abstract double getAreaShape();
}

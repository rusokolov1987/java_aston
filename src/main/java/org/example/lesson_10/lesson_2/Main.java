package org.example.lesson_10.lesson_2;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20, "red", "green");
        System.out.println(rectangle);

        Triangle triangle = new Triangle(10, 5, 6, "green", "yellow");
        System.out.println(triangle);

        Circle circle = new Circle(5, "blue", "black");
        System.out.println(circle);
    }
}

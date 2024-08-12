package org.example.lesson_10.lesson_1;

import lombok.Data;

@Data
public abstract class Animal {
    protected String name;
    private static int countAnimal;

    public Animal() {
        this.countAnimal += 1;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getCountAnimal() {
        return countAnimal;
    }
}

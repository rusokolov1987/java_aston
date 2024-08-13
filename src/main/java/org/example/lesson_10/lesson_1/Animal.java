package org.example.lesson_10.lesson_1;

import lombok.Data;

@Data
public abstract class Animal {
    public static int countAnimal;

    public Animal() {
        countAnimal++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}

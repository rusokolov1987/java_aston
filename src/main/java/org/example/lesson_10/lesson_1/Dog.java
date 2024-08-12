package org.example.lesson_10.lesson_1;

public class Dog extends Animal {
    private static int countDog;

    public Dog(String name) {
        super();
        this.name = name;
        countDog++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println("Да ну его! Отдохну!");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println(name + " пошел ко дну! :(");
        }
    }

    public static int getcountDog() {
        return countDog;
    }
}

package org.example.lesson_10.lesson_1;

import lombok.Data;

@Data
public class Cat extends Animal {
    private static int countCat;
    private boolean full;
    private int stomachVolume;

    public Cat(String name) {
        super();
        this.name = name;
        this.full = false;
        countCat++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println("Да ну его! Отдохну!");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Не, вводу ни за что!");
    }

    public void eat(Bowl bowl) {
        if (bowl.getCountFood() < 2) {
            System.out.println("В миске недостаточно еды, раб!");
            if (bowl.isEmpty()) {
                System.out.println("Миска пуста!");
            }
            return;
        }
        while (!getFull()) {
            bowl.deleteCountFood();
            stomachVolume += 1;
            setFull();
        }
    }

    private void setFull() {
        if (stomachVolume == 2) {
            full = true;
            return;
        }
        full = false;
    }

    public boolean getFull() {
        return full;
    }

    public static int getCountCat() {
        return countCat;
    }

    @Override
    public String toString() {
        return "Кот " + name + ((full) ? " сыт, но лишней порцайки не бывает!" : " голоден, раб!");
    }
}

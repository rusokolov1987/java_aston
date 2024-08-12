package org.example.lesson_10.lesson_1;

public class Bowl {
    private int countFood;

    public Bowl() {
    }

    public Bowl(int countFood) {
        this.countFood = countFood;
    }

    public void addFood(int count) {
        countFood += count;
        int balance = 10 - countFood;
        if (balance < 0) {
            countFood += balance;
            System.out.println("Миска полная! Заберите еду в количестве = " + Math.abs(balance));
        } else {
            System.out.println("В миске есть место в количестве = " + balance);
        }
    }

    public void deleteCountFood() {
        if (isEmpty()) {
            return;
        }
        countFood--;
    }

    public boolean isEmpty() {
        return countFood == 0;
    }

    public int getCountFood() {
        return countFood;
    }
}

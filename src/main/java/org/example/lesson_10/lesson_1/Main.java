package org.example.lesson_10.lesson_1;

public class Main {
    public static void main(String[] args) {
        Dog miki = new Dog("Miki");
        Dog rex = new Dog("Rex");
        Cat vasya = new Cat("Vasya");

        System.out.println("Количество собак = " + Dog.getcountDog());
        System.out.println("Количество котов = " + Cat.getCountCat());
        System.out.println("Количество животных = " + Animal.getCountAnimal());

        Bowl bowl = new Bowl();
        bowl.addFood(5);
        Cat[] cats = {new Cat("Sima"), new Cat("Ryzhyk"), new Cat("Snow"), new Cat("Winter")};
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }

        System.out.println("Количество собак = " + Dog.getcountDog());
        System.out.println("Количество котов = " + Cat.getCountCat());
        System.out.println("Количество животных = " + Animal.getCountAnimal());
    }
}

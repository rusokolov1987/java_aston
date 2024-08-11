package org.example.lesson_5;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Иванов", "Иван", "Иванович", "электрик", "test_1@mail.ru", "89114443322", 30000, 60);
        persons[1] = new Person("Иванова", "Ольга", "Ивановна", "оператор атракциона", "test_2@mail.ru", "89114443323", 20000, 53);
        persons[2] = new Person("Петрова", "Лариса", "Сергеевна", "оператор атракциона", "test_3@mail.ru", "89114443324", 20000, 52);
        persons[3] = new Person("Сергеев", "Сергей", "Сергеевич", "дворник", "test_4@mail.ru", "89114443325", 20000, 57);
        persons[4] = new Person("Трунов", "Алексей", "Иванович", "сторож", "test_5@mail.ru", "89114443326", 20000, 59);
    }
}
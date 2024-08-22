package org.example.lesson_13.lesson_13_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("+79210000000", "Петров");
        phoneBook.add("+79210000001", "Петров");
        phoneBook.add("+79210000002", "Сидоров");
        phoneBook.add("+79210000003", "Петров");
        phoneBook.add("+79210000004", "Мамаев");
        phoneBook.add("+79210000005", "Кудрин");
        phoneBook.add("+79210000006", "Бирук");
        phoneBook.add("+79210000007", "Захаров");
        phoneBook.add("+79210000008", "Петров");
        phoneBook.add("+79210000009", "Мартынов");
        String lastName = "Петров";
        ArrayList<String> phones = phoneBook.get(lastName);
        System.out.println("Номера телефонов для фамилии " + lastName);
        for (String item : phones) {
            System.out.println(item);
        }

    }
}

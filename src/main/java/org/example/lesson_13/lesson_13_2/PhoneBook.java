package org.example.lesson_13.lesson_13_2;

import org.example.lesson_13.lesson_13_2.exception.NotFoundLastName;

import java.util.*;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phones;

    public PhoneBook() {
        phones = new HashMap<>();
    }

    public void add(String numberPhone, String lastName) {
        if (phones.containsKey(lastName)) {
            ArrayList<String> listNumbers = phones.get(lastName);
            if (!listNumbers.contains(numberPhone)) {
                listNumbers.add(numberPhone);
                phones.put(lastName, listNumbers);
            }
        } else {
            ArrayList<String> listNumbers = new ArrayList<>();
            listNumbers.add(numberPhone);
            phones.put(lastName, listNumbers);
        }
    }

    public ArrayList<String> get(String lastName) throws NotFoundLastName {
        if (phones.containsKey(lastName)) {
            return phones.get(lastName);
        }
        throw new NotFoundLastName("В телефонном справочнике нет телефонов на имя " + lastName);
    }

    @Override
    public String toString() {
        return phones.toString();
    }
}

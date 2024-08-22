package org.example.lesson_13.lesson_13_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private HashMap<String, String> phones;

    public PhoneBook() {
        phones = new HashMap<>();
    }

    public void add(String numberPhone, String lastName) {
        phones.put(numberPhone, lastName);
    }

    public ArrayList<String> get(String lastName) {
        ArrayList<String> numbers = new ArrayList<>();
        Set<Map.Entry<String, String>> entries = phones.entrySet();
        for (Map.Entry<String, String> element : entries) {
            if (element.getValue().equals(lastName)) {
                numbers.add(element.getKey());
            }
        }
        return numbers;
    }

    @Override
    public String toString() {
        return phones.toString();
    }
}

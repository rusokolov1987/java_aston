package org.example.lesson_13.lesson_13_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Hello", "World", "Hello", "Java", "Car", "Fish", "Car", "Dog", "Animal", "Elephant", "Dog",
                "Car", "Coffee", "Tea", "Coffee", "Car", "Cat", "Animal", "Elephant", "Java"};

        /* Находим уникальные слова в массиве и выводим их в список */
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            int count = 0;
            for (int i = 0; i < words.length; i++) {
                if (word.equals(words[i])) {
                    count++;
                }
            }
            if (count == 1) {
                list.add(word);
            }
        }

        for (String item : list) {
            System.out.println(item);
        }

        /* Используем HashMap для хранения уникальных ключей и хранения повторяющихся ключей в значениях. */
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else if (map.containsKey(word)) {
                int value = map.get(word);
                value += 1;
                map.put(word, value);
            }
        }
        System.out.println(map);
    }
}

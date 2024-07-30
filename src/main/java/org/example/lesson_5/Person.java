package org.example.lesson_5;

import lombok.Data;

@Data
public class Person {
    private String LastName;
    private String FirstName;
    private String MiddleName;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    @Override
    public String toString() {
        return "Фамилия: " + this.LastName +
                "\nИмя: " + this.FirstName +
                "\nОтчество: " + this.MiddleName +
                "\nДолжность: " + this.jobTitle +
                "\nЭл. почта: " + this.email +
                "\nТелфон: " + this.phoneNumber +
                "\nЗарплата: " + this.salary;
    }
}

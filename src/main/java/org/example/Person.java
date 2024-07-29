package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
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
        return "LastName: " + this.LastName +
                "\nFirstName: " + this.FirstName +
                "\nMiddleName: " + this.MiddleName +
                "\nJobTitle: " + this.jobTitle +
                "\nemail: " + this.email +
                "\nphone: " + this.phoneNumber +
                "\nsalary: " + this.salary;
    }
}

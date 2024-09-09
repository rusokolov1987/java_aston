package org.example.lesson_17.Request;

import lombok.Data;

@Data
public class ArgsRequest {
    private String foo1;
    private String foo2;

    public ArgsRequest(){}

    public ArgsRequest(String foo1, String foo2) {
        this.foo1 = foo1;
        this.foo2 = foo2;
    }
}

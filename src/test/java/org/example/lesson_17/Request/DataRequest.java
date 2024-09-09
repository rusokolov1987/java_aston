package org.example.lesson_17.Request;

import lombok.Data;

@Data
public class DataRequest {
    private String data;

    public DataRequest() {}

    public DataRequest(String data) {
        this.data = data;
    }
}

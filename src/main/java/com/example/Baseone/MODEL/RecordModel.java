package com.example.Baseone.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RecordModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
   private String name;
    @JsonProperty("data")
   private String data;

    public RecordModel(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

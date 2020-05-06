package com.funcode.example.chapter13.configuration;

public enum DataSourceType {
    READ0("read0", "读库1"),
    READ1("read1", "读库2"),
    READ2("read2", "读库3"),

    WRITE("write", "写库");

    private String type;
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

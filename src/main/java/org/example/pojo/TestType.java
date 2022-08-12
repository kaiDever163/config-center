package org.example.pojo;

public enum TestType {
    LOCAL("1"),
    DEV("2"),
    PROD("3");

    private String value;

    TestType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

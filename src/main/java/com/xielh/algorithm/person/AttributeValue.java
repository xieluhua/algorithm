package com.xielh.algorithm.person;

public class AttributeValue {
    private String attribute_id;
    private String code;

    @Override
    public String toString() {
        return "AttributeValue{" +
            "attribute_id='" + attribute_id + '\'' +
            ", code='" + code + '\'' +
            '}';
    }

    public String getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(String attribute_id) {
        this.attribute_id = attribute_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

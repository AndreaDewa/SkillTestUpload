package com.example.demo.dto;

public class AreaPercentageDTO {
    private String value;
    private String label;
    
    public AreaPercentageDTO(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // Getters and setters
}
package com.example.demo.dto;

public class SubRawatJalanDTO {
    private String item;
    private Long total;

    public SubRawatJalanDTO(String item, Long total) {
        this.item = item;
        this.total = total;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
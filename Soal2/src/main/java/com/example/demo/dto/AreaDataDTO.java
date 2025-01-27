package com.example.demo.dto;


public class AreaDataDTO {
    private String area;
    private String subArea;
    private Long poliklinik;
    private Long igd;
    private Long total;

    public AreaDataDTO(String area, String subArea, Long poliklinik, Long igd, Long total) {
        this.area = area;
        this.subArea = subArea;
        this.poliklinik = poliklinik;
        this.igd = igd;
        this.total = total;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public Long getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(Long poliklinik) {
        this.poliklinik = poliklinik;
    }

    public Long getIgd() {
        return igd;
    }

    public void setIgd(Long igd) {
        this.igd = igd;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    
}

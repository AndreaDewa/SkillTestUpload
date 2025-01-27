package com.example.demo.dto;

public class SubAreaDto {
    private String nama;
    private Long poliklinik;
    private Long igd;
    private Long total;

    public SubAreaDto(String nama, Long poliklinik, Long igd, Long total) {
        this.nama = nama;
        this.poliklinik = poliklinik;
        this.igd = igd;
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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


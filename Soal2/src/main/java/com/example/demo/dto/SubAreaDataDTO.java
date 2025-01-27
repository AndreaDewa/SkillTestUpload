package com.example.demo.dto;

public class SubAreaDataDTO {
    private String nama;
    private int poliklinik;
    private int igd;
    private int total;

    public SubAreaDataDTO(String nama, int poliklinik, int igd, int total) {
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

    public int getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(int poliklinik) {
        this.poliklinik = poliklinik;
    }

    public int getIgd() {
        return igd;
    }

    public void setIgd(int igd) {
        this.igd = igd;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // Getters and setters
}
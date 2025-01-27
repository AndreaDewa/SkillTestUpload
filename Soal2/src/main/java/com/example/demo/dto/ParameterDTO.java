package com.example.demo.dto;

public class ParameterDTO {
    private String tipe;
    private String waktu;
    private String kategori;
    private String area;
    public ParameterDTO(String tipe, String waktu, String kategori, String area) {
        this.tipe = tipe;
        this.waktu = waktu;
        this.kategori = kategori;
        this.area = area;
    }
    public String getTipe() {
        return tipe;
    }
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    public String getWaktu() {
        return waktu;
    }
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    public String getKategori() {
        return kategori;
    }
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    
}
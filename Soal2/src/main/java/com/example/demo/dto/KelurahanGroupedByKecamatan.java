package com.example.demo.dto;

public class KelurahanGroupedByKecamatan {
    private String kecamatan;
    private Long count;

    public KelurahanGroupedByKecamatan(String kecamatan, Long count) {
        this.kecamatan = kecamatan;
        this.count = count;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}


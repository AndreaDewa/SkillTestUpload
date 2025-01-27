package com.example.demo.model;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jc_kategori")
@Data
public class Kategori implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode", length = 30)
    private String kode;

    @Column(name = "nama", nullable = false, length = 255)
    private String nama;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('Ya','Tidak') default 'Ya'")
    private Status aktif;

    public enum Status {
        Ya, Tidak
    }
}


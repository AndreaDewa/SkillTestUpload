package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "jc_barang")
@Data
public class Barang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori", referencedColumnName = "id", nullable = false)
    private Kategori kategori;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supplier", referencedColumnName = "id", nullable = false)
    private Supplier supplier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('Ya','Tidak') default 'Ya'")
    private Status aktif;

    public enum Status {
        Ya, Tidak
    }
}


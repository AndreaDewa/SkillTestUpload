package com.example.demo.model;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jc_varian")
@Data
public class Varian implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode_varian", length = 4, unique = true)
    private String kodeVarian;

    @Column(name = "varian", nullable = false, length = 100)
    private String varian;

    @Column(name = "keterangan", length = 255)
    private String keterangan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('Ya','Tidak') default 'Ya'")
    private Status aktif;

    public enum Status {
        Ya, Tidak
    }
}

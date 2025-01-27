package com.example.demo.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "jc_supplier")
@Data
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('Ya','Tidak') default 'Ya'")
    private Status aktif;

    public enum Status {
        Ya, Tidak
    }
}


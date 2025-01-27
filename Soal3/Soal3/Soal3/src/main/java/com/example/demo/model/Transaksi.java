package com.example.demo.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "jc_transaksi")
@Data
public class Transaksi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "waktu", nullable = false)
    private Timestamp waktu;

    @Column(name = "konsumen")
    private String konsumen;
}

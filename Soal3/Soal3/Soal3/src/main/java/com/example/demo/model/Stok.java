package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "jc_stok")
@Data
public class Stok implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "waktu", nullable = false)
    private Timestamp waktu;

    @Column(name = "transaksi", nullable = false)
    private String transaksiType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id", nullable = false)
    private Transaksi transaksi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_varian_barang", referencedColumnName = "id", nullable = false)
    private VarianBarang varianBarang;

    @Column(name = "masuk", nullable = false)
    private Integer masuk;

    @Column(name = "keluar", nullable = false)
    private Integer keluar;

    @Column(name = "keterangan")
    private String keterangan;
}

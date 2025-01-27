package com.example.demo.model;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jc_varian_barang")
@Data
public class VarianBarang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barang", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "jc_varian_barang_ibfk_1"))
    private Barang barang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_varian", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "jc_varian_barang_ibfk_2"))
    private Varian varian;

    @Column(name = "berat", nullable = false)
    private Double berat;

    @Column(name = "harga_modal", nullable = false)
    private Double hargaModal;

    @Column(name = "harga_jual", nullable = false)
    private Double hargaJual;
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Stok;

import java.sql.Timestamp;
import java.util.List;

public interface StokRepository extends JpaRepository<Stok, Integer> {

    @Query("SELECT s FROM Stok s JOIN s.varianBarang v JOIN v.barang b " +
           "WHERE b.nama = :namaBarang " +
           "AND (:waktu IS NULL OR s.waktu <= :waktu) " +
           "ORDER BY s.waktu DESC")
    List<Stok> findLastStokByNamaBarangAndWaktu(@Param("namaBarang") String namaBarang, 
                                                @Param("waktu") Timestamp waktu);
}


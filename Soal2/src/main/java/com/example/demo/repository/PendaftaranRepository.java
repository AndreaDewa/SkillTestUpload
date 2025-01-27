package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Pendaftaran;
import com.example.demo.dto.KecamatanKelurahanData;
import com.example.demo.dto.PersentaseWilayahDTO;
import com.example.demo.dto.SubRawatJalanDTO;
import com.example.demo.dto.VisitData;

public interface PendaftaranRepository extends JpaRepository<Pendaftaran, Long> {

    @Query("SELECT new com.example.demo.dto.VisitData(p.nama, kel.nama, kec.nama, kab.nama, pend.waktuDaftar) " +
           "FROM Pendaftaran pend " +
           "JOIN pend.pasien p " +
           "JOIN p.kelurahan kel " +
           "JOIN kel.kecamatan kec " +
           "JOIN kec.kabupaten kab " +
           "WHERE kab.nama = :kabupaten")
    List<VisitData> findVisitsByKabupaten(@Param("kabupaten") String kabupaten);

    @Query("SELECT kec.nama AS kecamatan, COUNT(pend) AS visitCount " +
            "FROM Pendaftaran pend " +
            "JOIN pend.pasien p " +
            "JOIN p.kelurahan kel " +
            "JOIN kel.kecamatan kec " +
            "JOIN kec.kabupaten kab " +
            "WHERE kab.nama = :kabupaten " +
            "GROUP BY kec.nama")
    List<Object[]> findVisitsByKecamatan(@Param("kabupaten") String kabupaten);

    @Query("SELECT COUNT(pend) FROM Pendaftaran pend " +
            "JOIN pend.pasien p " +
            "JOIN p.kelurahan kel " +
            "JOIN kel.kecamatan kec " +
            "JOIN kec.kabupaten kab " +
            "WHERE kab.nama = :kabupaten")
    Long findTotalVisitsByKabupaten(@Param("kabupaten") String kabupaten);

    @Query("SELECT new com.example.demo.dto.KecamatanKelurahanData(kec.nama, kel.nama) " +
            "FROM Pendaftaran pend " +
            "JOIN pend.pasien p " +
            "JOIN p.kelurahan kel " +
            "JOIN kel.kecamatan kec " +
            "JOIN kec.kabupaten kab " +
            "WHERE kab.nama = :kabupaten " +
            "GROUP BY kec.nama, kel.nama")
    List<KecamatanKelurahanData> findKelurahanGroupedByKecamatan(@Param("kabupaten") String kabupaten);

    @Query("SELECT new com.example.demo.dto.PersentaseWilayahDTO(k.nama, CONCAT(ROUND((COUNT(p.id) * 100.0 / (SELECT COUNT(p1.id) FROM Pendaftaran p1)), 2), ' %')) " +
           "FROM Kelurahan k " +
           "JOIN Pasien ps ON k.id = ps.kelurahan.id " +
           "JOIN Pendaftaran p ON ps.id = p.pasien.id " +
           "GROUP BY k.nama " +
           "ORDER BY COUNT(p.id) DESC")
    List<PersentaseWilayahDTO> findPersentaseWilayah();

    @Query("SELECT new com.example.demo.dto.SubRawatJalanDTO(" +
           "CASE WHEN p.jenis = 'POLIKLINIK' THEN 'poliklinik' " +
           "WHEN p.jenisIgd = 'IGD' THEN 'igd' END, COUNT(p.id)) " +
           "FROM Pendaftaran p " +
           "GROUP BY CASE WHEN p.jenis = 'POLIKLINIK' THEN 'poliklinik' " +
           "WHEN p.jenisIgd = 'IGD' THEN 'igd' END")
    List<SubRawatJalanDTO> findSubRawatJalan();
    
}



package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Barang;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Integer> {

}


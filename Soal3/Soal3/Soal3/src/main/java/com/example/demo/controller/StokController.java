package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.StokResponseDTO;
import com.example.demo.service.StokService;

import java.util.List;

@RestController
@RequestMapping("/api/stok")
public class StokController {

    @Autowired
    private StokService stokService;

    @GetMapping("/by-nama-barang")
    public List<StokResponseDTO> getStokByNamaBarangAndWaktu(@RequestParam String namaBarang, 
                                                             @RequestParam(required = false) String waktu) {
        return stokService.getLastStockByNamaBarangAndWaktu(namaBarang, waktu);
    }
}




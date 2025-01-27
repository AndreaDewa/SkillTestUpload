package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TransaksiUpdateRequest;
import com.example.demo.service.TransaksiService;


@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTransaksi(@PathVariable Integer id, @RequestBody TransaksiUpdateRequest request) {
        try {
            transaksiService.updateTransaksi(id, request);
            return ResponseEntity.ok("Transaksi updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating transaksi: " + e.getMessage());
        }
    }
}



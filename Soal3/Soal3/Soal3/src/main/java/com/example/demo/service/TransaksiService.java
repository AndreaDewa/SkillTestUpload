package com.example.demo.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TransaksiUpdateRequest;
import com.example.demo.model.Stok;
import com.example.demo.model.Transaksi;
import com.example.demo.model.VarianBarang;
import com.example.demo.repository.StokRepository;
import com.example.demo.repository.TransaksiRepository;
import com.example.demo.repository.VarianBarangRepository;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private StokRepository stokRepository;

    @Autowired
    private VarianBarangRepository varianBarangRepository;

    public void updateTransaksi(Integer id, TransaksiUpdateRequest request) throws Exception {
        Optional<Transaksi> existingTransaksiOpt = transaksiRepository.findById(id);
        if (!existingTransaksiOpt.isPresent()) {
            throw new Exception("Transaksi not found");
        }

        Transaksi existingTransaksi = existingTransaksiOpt.get();

        existingTransaksi.setKonsumen(request.getKonsumen());
        transaksiRepository.save(existingTransaksi);

        for (TransaksiUpdateRequest.TransaksiVarianUpdate varianUpdate : request.getItems()) {
            updateStock(varianUpdate, existingTransaksi);
        }
    }

    private void updateStock(TransaksiUpdateRequest.TransaksiVarianUpdate varianUpdate, Transaksi transaksi) throws Exception {
        Optional<VarianBarang> varianBarangOpt = varianBarangRepository.findById(varianUpdate.getId_varian_barang());
        if (!varianBarangOpt.isPresent()) {
            throw new Exception("Varian not found");
        }
    
        VarianBarang varianBarang = varianBarangOpt.get();
        
        Stok stok = new Stok();
        stok.setTransaksi(transaksi);
        stok.setVarianBarang(varianBarang);
        
        Integer quantity = varianUpdate.getQuantity();
    
        stok.setTransaksiType("Penerimaan");
    
        if (quantity > 0) {
            stok.setMasuk(quantity);
            stok.setKeluar(0);
        } else {
            stok.setMasuk(0);
            stok.setKeluar(Math.abs(quantity));
        }
    
        stok.setWaktu(new Timestamp(System.currentTimeMillis()));
    
        stok.setKeterangan("Stock update for transaction ID " + transaksi.getId());
    
        stokRepository.save(stok);
    }
}

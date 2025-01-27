package com.example.demo.service;

import com.example.demo.dto.StokResponseDTO;
import com.example.demo.model.Stok;
import com.example.demo.repository.StokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Service
public class StokService {

    @Autowired
    private StokRepository stokRepository;

    public List<StokResponseDTO> getLastStockByNamaBarangAndWaktu(String namaBarang, String waktu) {
        Timestamp timestamp = null;

        if (waktu != null && !waktu.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                java.util.Date parsedDate = dateFormat.parse(waktu);
                timestamp = new Timestamp(parsedDate.getTime());
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format for waktu. Expected format: yyyy-MM-dd'T'HH:mm:ss");
            }
        }
        List<Stok> stokList = stokRepository.findLastStokByNamaBarangAndWaktu(namaBarang, timestamp);
        return stokList.stream().map(this::mapToStokResponseDTO).collect(Collectors.toList());
    }

    private StokResponseDTO mapToStokResponseDTO(Stok stok) {
        StokResponseDTO response = new StokResponseDTO();
        response.setNamaBarang(stok.getVarianBarang().getBarang().getNama());
        response.setVarian(stok.getVarianBarang().getVarian().toString());
        response.setStok(stok.getMasuk() - stok.getKeluar());
        response.setWaktu(stok.getWaktu());
        return response;
    }
}

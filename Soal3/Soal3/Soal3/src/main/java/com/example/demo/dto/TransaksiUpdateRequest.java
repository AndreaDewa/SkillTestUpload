package com.example.demo.dto;

import java.util.List;
public class TransaksiUpdateRequest {

    private String konsumen;
    private List<TransaksiVarianUpdate> items; 

    public static class TransaksiVarianUpdate {
        private Integer id_varian_barang; 
        private Integer quantity; 

        public Integer getId_varian_barang() {
            return id_varian_barang;
        }

        public void setId_varian_barang(Integer id_varian_barang) {
            this.id_varian_barang = id_varian_barang;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }

    public String getKonsumen() {
        return konsumen;
    }

    public void setKonsumen(String konsumen) {
        this.konsumen = konsumen;
    }

    public List<TransaksiVarianUpdate> getItems() {
        return items;
    }

    public void setItems(List<TransaksiVarianUpdate> items) {
        this.items = items;
    }
}

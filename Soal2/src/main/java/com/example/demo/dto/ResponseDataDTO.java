package com.example.demo.dto;

import java.util.List;

public class ResponseDataDTO {
    private String status;
    private ParameterDTO parameter;
    private List<AreaPercentageDTO> persentaseWilayah;
    private List<SubAreaDataDTO> subRawatJalan;
    private List<AreaDataDTO> data;
    
    public ResponseDataDTO(String status, ParameterDTO parameter, List<AreaPercentageDTO> persentaseWilayah,
            List<SubAreaDataDTO> subRawatJalan, List<AreaDataDTO> data) {
        this.status = status;
        this.parameter = parameter;
        this.persentaseWilayah = persentaseWilayah;
        this.subRawatJalan = subRawatJalan;
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public ParameterDTO getParameter() {
        return parameter;
    }
    public void setParameter(ParameterDTO parameter) {
        this.parameter = parameter;
    }
    public List<AreaPercentageDTO> getPersentaseWilayah() {
        return persentaseWilayah;
    }
    public void setPersentaseWilayah(List<AreaPercentageDTO> persentaseWilayah) {
        this.persentaseWilayah = persentaseWilayah;
    }
    public List<SubAreaDataDTO> getSubRawatJalan() {
        return subRawatJalan;
    }
    public void setSubRawatJalan(List<SubAreaDataDTO> subRawatJalan) {
        this.subRawatJalan = subRawatJalan;
    }
    public List<AreaDataDTO> getData() {
        return data;
    }
    public void setData(List<AreaDataDTO> data) {
        this.data = data;
    }    
}

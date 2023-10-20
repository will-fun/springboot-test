package com.salt.backend.payloads.requests;

public class KonsumenRequest {
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private String status;

    //Constructor
    public KonsumenRequest() {
    }

    public KonsumenRequest(String nama, String alamat, String kota, String provinsi, String status) {
        this.nama = nama;
        this.alamat = alamat;
        this.kota = kota;
        this.provinsi = provinsi;
        this.status = status;
    }

    //Getter and Setter
    public String getNama() {
        return nama;
    }

    public String setNama(String nama) {
        return this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String setAlamat(String alamat) {
        return this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



package com.salt.backend.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "konsumen")
public class Konsumen {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 50)
  private String nama;

  @Column(columnDefinition = "TEXT")
  private String alamat;

  @Column(length = 50)
  private String kota;

  @Column(length = 4)
  private String provinsi;

  @CreationTimestamp
  @JsonIgnore
  private LocalDateTime tglRegistrasi;

  @Column(length = 1)
  private String status;

  // Constructor
  public Konsumen() {
  }

  public Konsumen(String nama, String alamat, String kota, String provinsi, String status) {
    this.nama = nama;
    this.alamat = alamat;
    this.kota = kota;
    this.provinsi = provinsi;
    this.status = status;
  }

  // Getter and Setter
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
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

  public LocalDateTime getTglRegistrasi() {
    return tglRegistrasi;
  }

  public void setTglRegistrasi(LocalDateTime tglRegistrasi) {
    this.tglRegistrasi = tglRegistrasi;
  }

}

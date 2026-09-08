/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempemesanantiketpesawat;

/**
 *
 * @author Adbang 18
 */
public class Penerbangan {
 
    String kodePenerbangan;
    String asal;
    String tujuan;
    String jamKeberangkatan;
    double harga;
 
    public Penerbangan(String kodePenerbangan, String asal, String tujuan, String jamKeberangkatan, double harga) {
        this.kodePenerbangan = kodePenerbangan;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jamKeberangkatan = jamKeberangkatan;
        this.harga = harga;
    }
}
 
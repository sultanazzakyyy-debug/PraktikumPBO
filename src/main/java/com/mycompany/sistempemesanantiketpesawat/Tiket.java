/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistempemesanantiketpesawat;

/**
 *
 * @author Adbang 18
 */
public class Tiket {
 
    String idTiket;
    Penumpang penumpang;
    Penerbangan penerbangan;
    String kelasKursi;
    String statusTiket;
 
    public Tiket(String idTiket, Penumpang penumpang, Penerbangan penerbangan, String kelasKursi) {
        this.idTiket = idTiket;
        this.penumpang = penumpang;
        this.penerbangan = penerbangan;
        this.kelasKursi = kelasKursi;
        this.statusTiket = "Dipesan";
    }
 
    double hitungTotalHarga() {
        double totalHarga = penerbangan.harga;
 
        if (kelasKursi.equals("Bisnis")) {
            totalHarga = penerbangan.harga * 1.5;
        } else if (kelasKursi.equals("First Class")) {
            totalHarga = penerbangan.harga * 2;
        }
 
        return totalHarga;
    }
 
    void tampilkanDetail() {
        System.out.println("ID Tiket         : " + idTiket);
        System.out.println("Nama Penumpang   : " + penumpang.nama);
        System.out.println("No KTP           : " + penumpang.noKTP);
        System.out.println("No Telepon       : " + penumpang.noTelepon);
        System.out.println("Kode Penerbangan : " + penerbangan.kodePenerbangan);
        System.out.println("Asal             : " + penerbangan.asal);
        System.out.println("Tujuan           : " + penerbangan.tujuan);
        System.out.println("Jam Keberangkatan: " + penerbangan.jamKeberangkatan);
        System.out.println("Kelas Kursi      : " + kelasKursi);
        System.out.println("Total Harga      : Rp" + hitungTotalHarga());
        System.out.println("Status Tiket     : " + statusTiket);
        System.out.println("-----------------------------------");
    }
}
 
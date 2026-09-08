package com.mycompany.sistempemesanantiketpesawat;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemPemesananTiketPesawat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Tiket> daftarTiket = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("");
            System.out.println("=== SISTEM PEMESANAN TIKET PESAWAT ===");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Lihat Semua Tiket");
            System.out.println("3. Update Tiket");
            System.out.println("4. Hapus Tiket");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1 -> {
                    System.out.print("ID Tiket: ");
                    String idTiket = input.nextLine();

                    System.out.print("Nama Penumpang: ");
                    String nama = input.nextLine();

                    System.out.print("No KTP: ");
                    String noKTP = input.nextLine();

                    System.out.print("No Telepon: ");
                    String noTelepon = input.nextLine();

                    Penumpang penumpang = new Penumpang(idTiket, nama, noKTP, noTelepon);

                    System.out.print("Kode Penerbangan: ");
                    String kodePenerbangan = input.nextLine();

                    System.out.print("Kota Asal: ");
                    String asal = input.nextLine();

                    System.out.print("Kota Tujuan: ");
                    String tujuan = input.nextLine();

                    System.out.print("Jam Keberangkatan: ");
                    String jam = input.nextLine();

                    System.out.print("Harga Dasar: ");
                    double harga = Double.parseDouble(input.nextLine());

                    Penerbangan penerbangan = new Penerbangan(kodePenerbangan, asal, tujuan, jam, harga);

                    System.out.print("Kelas Kursi (Ekonomi/Bisnis/First Class): ");
                    String kelasKursi = input.nextLine();

                    Tiket tiket = new Tiket(idTiket, penumpang, penerbangan, kelasKursi);
                    daftarTiket.add(tiket);
                    System.out.println("Tiket berhasil ditambahkan!");
                }
                case 2 -> {
                    System.out.println("=== DAFTAR TIKET ===");
                    if (daftarTiket.size() == 0) {
                        System.out.println("Belum ada data tiket.");
                    } else {
                        for (int i = 0; i < daftarTiket.size(); i++) {
                            System.out.println("Data ke-" + (i + 1));
                            daftarTiket.get(i).tampilkanDetail();
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Masukkan ID Tiket yang ingin diubah: ");
                    String idUbah = input.nextLine();

                    Tiket tiketUbah = null;
                    for (int i = 0; i < daftarTiket.size(); i++) {
                        if (daftarTiket.get(i).idTiket.equals(idUbah)) {
                            tiketUbah = daftarTiket.get(i);
                        }
                    }

                    if (tiketUbah != null) {
                        System.out.println("Kelas kursi saat ini: " + tiketUbah.kelasKursi);
                        System.out.print("Kelas Kursi Baru: ");
                        tiketUbah.kelasKursi = input.nextLine();

                        System.out.println("Status saat ini: " + tiketUbah.statusTiket);
                        System.out.print("Status Baru: ");
                        tiketUbah.statusTiket = input.nextLine();

                        System.out.println("Tiket berhasil diubah!");
                    } else {
                        System.out.println("Tiket tidak ditemukan.");
                    }
                }
                case 4 -> {
                    System.out.print("Masukkan ID Tiket yang ingin dihapus: ");
                    String idHapus = input.nextLine();

                    Tiket tiketHapus = null;
                    for (int i = 0; i < daftarTiket.size(); i++) {
                        if (daftarTiket.get(i).idTiket.equals(idHapus)) {
                            tiketHapus = daftarTiket.get(i);
                        }
                    }

                    if (tiketHapus != null) {
                        daftarTiket.remove(tiketHapus);
                        System.out.println("Tiket berhasil dihapus.");
                    } else {
                        System.out.println("Tiket tidak ditemukan.");
                    }
                }
                case 5 -> System.out.println("Terima kasih telah menggunakan sistem ini!");
                default -> System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 5);
    }
}
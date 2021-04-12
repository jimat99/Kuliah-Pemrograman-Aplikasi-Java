package pemrograman.aplikasi.java;

import java.util.Scanner;

public class PemrogramanAplikasiJava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String dataMahasiswa[][] = new String[3][2];
        int totalNilai;
        boolean perbandingan;
        
        System.out.println("=== Program Sederhana Tugas 1 PAJ ===");
        System.out.print("Nama mahasiswa ke-1: ");
        dataMahasiswa[0][0] = input.next();
        System.out.print("Nilai: ");
        dataMahasiswa[0][1] = input.next();

        System.out.print("Nama mahasiswa ke-2: ");
        dataMahasiswa[1][0] = input.next();
        System.out.print("Nilai: ");
        dataMahasiswa[1][1] = input.next();

        System.out.print("Nama mahasiswa ke-3: ");
        dataMahasiswa[2][0] = input.next();
        System.out.print("Nilai: ");
        dataMahasiswa[2][1] = input.next();

        totalNilai = Integer.parseInt(dataMahasiswa[0][1]) + Integer.parseInt(dataMahasiswa[1][1])
                + Integer.parseInt(dataMahasiswa[2][1]);
        System.out.println("\nTotal nilai: " + totalNilai);

        perbandingan = Integer.parseInt(dataMahasiswa[0][1]) > Integer.parseInt(dataMahasiswa[1][1]);
        System.out.println("\nNilai mahasiswa ke-1 lebih besar dibandingkan nilai mahasiswa ke-2: " + perbandingan);

        perbandingan = Integer.parseInt(dataMahasiswa[0][1]) > Integer.parseInt(dataMahasiswa[2][1]);
        System.out.println("Nilai mahasiswa ke-1 lebih besar dibandingkan nilai mahasiswa ke-3: " + perbandingan);

        perbandingan = Integer.parseInt(dataMahasiswa[1][1]) > Integer.parseInt(dataMahasiswa[2][1]);
        System.out.println("Nilai mahasiswa ke-2 lebih besar dibandingkan nilai mahasiswa ke-3: " + perbandingan);
    }
}

package main;

public class Pemain {

    public int idWca, jumlahKompetisi, jumlahPodium;
    public String nama, jenisKelamin, negara;

    public Pemain(
            int idWca, String nama, String jenisKelamin,
            String negara, int jumlahKompetisi, int jumlahPodium
    ) {
        this.idWca = idWca;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.negara = negara;
        this.jumlahKompetisi = jumlahKompetisi;
        this.jumlahPodium = jumlahPodium;
    }
}

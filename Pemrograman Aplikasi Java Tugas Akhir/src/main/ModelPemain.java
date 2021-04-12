package main;

import java.util.ArrayList;

public class ModelPemain {

    public ArrayList<Pemain> daftarPemain = new ArrayList<>();
    public int idWca = 1;

    public void buatIdSelanjutnya() {
        idWca += 1;
    }

    public void tambahPemain(Pemain pemain) {
        daftarPemain.add(pemain);
    }

    public void updatePemainDenganObjek(Pemain pemain) {
        for (int i = 0; i < daftarPemain.size(); i++) {
            if (daftarPemain.get(i).idWca == pemain.idWca) {
                daftarPemain.set(i, pemain);
            }
        }
    }

    public void hapusPemainDenganId(int idWca) {
        for (int i = 0; i < daftarPemain.size(); i++) {
            if (daftarPemain.get(i).idWca == idWca) {
                daftarPemain.remove(i);
            }
        }
    }

    public boolean temukanPemainDenganId(int idWca) {
        for (int i = 0; i < daftarPemain.size(); i++) {
            if (daftarPemain.get(i).idWca == idWca) {
                return true;
            }
        }
        return false;
    }
}
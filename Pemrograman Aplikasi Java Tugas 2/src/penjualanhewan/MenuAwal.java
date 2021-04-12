package penjualanhewan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuAwal {

    private JFrame frameIni;
    private Image ikonSapi;
    private JButton buttonKelolaHewan, buttonJualHewan;

    public MenuAwal() {
        this.instansiasiKomponen();
        this.addKomponenKeFrame();
        this.setKomponen();
        this.setProsesKomponen();
    }

    private void instansiasiKomponen() {
        this.frameIni = new JFrame("Program Penjualan Hewan");
        this.buttonKelolaHewan = new JButton("Kelola Hewan");
        this.buttonJualHewan = new JButton("Jual Hewan");
    }

    private void addKomponenKeFrame() {
        this.frameIni.add(this.buttonKelolaHewan);
        this.frameIni.add(this.buttonJualHewan);
    }

    private void setKomponen() {
        this.frameIni.setIconImage(ikonSapi);
        this.frameIni.setSize(350, 290);
        this.frameIni.setLayout(null);
        this.frameIni.setLocationRelativeTo(null);
        this.frameIni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ikonSapi = Toolkit.getDefaultToolkit().getImage("src/gambar/ikon-sapi.png");
        this.buttonKelolaHewan.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.buttonKelolaHewan.setBounds(0, 0, 350, 120);
        this.buttonJualHewan.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.buttonJualHewan.setBounds(0, 130, 350, 120);
        this.frameIni.setVisible(true);
    }

    private void setProsesKomponen() {
        this.buttonKelolaHewan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameIni.dispose();
                new KelolaHewan();
            }
        });
        this.buttonJualHewan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameIni.dispose();
                new JualHewan();
            }
        });
    }
}

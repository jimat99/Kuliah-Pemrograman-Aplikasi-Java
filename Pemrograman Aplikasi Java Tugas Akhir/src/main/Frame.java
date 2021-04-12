package main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

public class Frame {

    private ModelPemain modelPemain = new ModelPemain();
    private JFrame frame = new JFrame();
    private JLabel labelJudulTambah = new JLabel("TAMBAH");
    private JLabel labelIdTambah = new JLabel("ID WCA");
    private JLabel labelNamaTambah = new JLabel("Nama");
    private JLabel labelJenisKelaminTambah = new JLabel("Jenis Kelamin");
    private JLabel labelNegaraTambah = new JLabel("Negara");
    private JLabel labelJumlahKompetisiTambah = new JLabel("Jumlah Kompetisi");
    private JLabel labelJumlahPodiumTambah = new JLabel("Jumlah Podium");
    private JTextField textIdTambah = new JTextField();
    private JTextField textNamaTambah = new JTextField();
    private JTextField textJenisKelaminTambah = new JTextField();
    private JTextField textNegaraTambah = new JTextField();
    private JTextField textJumlahKompetisiTambah = new JTextField();
    private JTextField textJumlahPodiumTambah = new JTextField();
    private JButton buttonTambah = new JButton("Tambah");
    private JSeparator pemisahKiri = new JSeparator(SwingConstants.VERTICAL);
    private JLabel labelJudulUpdate = new JLabel("UPDATE");
    private JLabel labelIdUpdate = new JLabel("ID WCA yang Diupdate");
    private JLabel labelNamaUpdate = new JLabel("Nama");
    private JLabel labelJenisKelaminUpdate = new JLabel("Jenis Kelamin");
    private JLabel labelNegaraUpdate = new JLabel("Negara");
    private JLabel labelJumlahKompetisiUpdate = new JLabel("Jumlah Kompetisi");
    private JLabel labelJumlahPodiumUpdate = new JLabel("Jumlah Podium");
    private JTextField textIdUpdate = new JTextField();
    private JTextField textNamaUpdate = new JTextField();
    private JTextField textJenisKelaminUpdate = new JTextField();
    private JTextField textNegaraUpdate = new JTextField();
    private JTextField textJumlahKompetisiUpdate = new JTextField();
    private JTextField textJumlahPodiumUpdate = new JTextField();
    private JButton buttonUpdate = new JButton("Update");
    private JSeparator pemisahKanan = new JSeparator(SwingConstants.VERTICAL);
    private JLabel labelJudulHapus = new JLabel("HAPUS");
    private JLabel labelIdHapus = new JLabel("ID WCA yang Dihapus");
    private JTextField textIdHapus = new JTextField();
    private JButton buttonHapus = new JButton("Hapus");
    private JTable tabelPemain = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelPemain);

    public Frame() {
        addKomponenKeFrame();
        setKomponen();
        setProsesKomponen();
    }

    private void addKomponenKeFrame() {
        JComponent[] komponen = {labelJudulTambah, labelIdTambah, labelNamaTambah,
            labelJenisKelaminTambah, labelNegaraTambah, labelJumlahKompetisiTambah,
            labelJumlahPodiumTambah, textIdTambah, textNamaTambah,
            textJenisKelaminTambah, textNegaraTambah, textJumlahKompetisiTambah,
            textJumlahPodiumTambah, buttonTambah, pemisahKiri, labelJudulUpdate,
            labelIdUpdate, labelNamaUpdate, labelJenisKelaminUpdate, labelNegaraUpdate,
            labelJumlahKompetisiUpdate, labelJumlahPodiumUpdate, textIdUpdate,
            textNamaUpdate, textJenisKelaminUpdate, textNegaraUpdate,
            textJumlahKompetisiUpdate, textJumlahPodiumUpdate, buttonUpdate,
            pemisahKanan, labelJudulHapus, labelIdHapus, textIdHapus, buttonHapus, scrollPane
        };
        for (int i = 0; i < komponen.length; i++) {
            frame.add(komponen[i]);
        }
    }

    private void setKomponen() {
        try {
            FileReader pembacaFile = new FileReader("judul.txt");
            int huruf;
            String judul = "";
            while ((huruf = pembacaFile.read()) != -1) {
                judul += (char) huruf;
            }
            frame.setTitle(judul);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Eror pada file");;
        }
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelJudulTambah.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        labelJudulTambah.setBounds(100, 20, 80, 25);
        setIdTambah();
        labelIdTambah.setBounds(20, 60, 80, 25);
        labelNamaTambah.setBounds(20, 100, 80, 25);
        labelJenisKelaminTambah.setBounds(20, 140, 80, 25);
        labelNegaraTambah.setBounds(20, 180, 80, 25);
        labelJumlahKompetisiTambah.setBounds(20, 220, 80, 25);
        labelJumlahPodiumTambah.setBounds(20, 260, 80, 25);
        textIdTambah.setEditable(false);
        textIdTambah.setBounds(110, 60, 140, 25);
        textNamaTambah.setBounds(110, 100, 140, 25);
        textJenisKelaminTambah.setBounds(110, 140, 140, 25);
        textNegaraTambah.setBounds(110, 180, 140, 25);
        textJumlahKompetisiTambah.setBounds(110, 220, 140, 25);
        textJumlahPodiumTambah.setBounds(110, 260, 140, 25);
        buttonTambah.setBounds(110, 300, 80, 25);
        pemisahKiri.setBounds(266, 0, 1, 325);
        labelJudulUpdate.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        labelJudulUpdate.setBounds(366, 20, 80, 25);
        labelIdUpdate.setBounds(270, 60, 140, 25);
        labelNamaUpdate.setBounds(270, 100, 140, 25);
        labelJenisKelaminUpdate.setBounds(270, 140, 140, 25);
        labelNegaraUpdate.setBounds(270, 180, 140, 25);
        labelJumlahKompetisiUpdate.setBounds(270, 220, 140, 25);
        labelJumlahPodiumUpdate.setBounds(270, 260, 140, 25);
        textIdUpdate.setBounds(420, 60, 100, 25);
        textNamaUpdate.setBounds(420, 100, 100, 25);
        textJenisKelaminUpdate.setBounds(420, 140, 100, 25);
        textNegaraUpdate.setBounds(420, 180, 100, 25);
        textJumlahKompetisiUpdate.setBounds(420, 220, 100, 25);
        textJumlahPodiumUpdate.setBounds(420, 260, 100, 25);
        buttonUpdate.setBounds(420, 300, 80, 25);
        pemisahKanan.setBounds(532, 0, 1, 325);
        labelJudulHapus.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        labelJudulHapus.setBounds(632, 20, 80, 25);
        labelIdHapus.setBounds(536, 60, 140, 25);
        textIdHapus.setBounds(686, 60, 80, 25);
        buttonHapus.setBounds(686, 100, 80, 25);
        setTabelPemain();
        scrollPane.setBounds(80, 340, 640, 200);
        frame.setVisible(true);
    }

    private void setProsesKomponen() {
        buttonTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin untuk "
                        + "tambahkan data?") == 0;
                if (konfirmasiYes) {
                    int idWca = Integer.parseInt(textIdTambah.getText());
                    String nama = textNamaTambah.getText();
                    String jenisKelamin = textJenisKelaminTambah.getText();
                    String negara = textNegaraTambah.getText();
                    int jumlahKompetisi = Integer.parseInt(textJumlahKompetisiTambah.getText());
                    int jumlahPodium = Integer.parseInt(textJumlahPodiumTambah.getText());
                    Pemain pemain = new Pemain(
                            idWca, nama, jenisKelamin, negara, jumlahKompetisi, jumlahPodium
                    );
                    modelPemain.tambahPemain(pemain);
                    setTabelPemain();
                    setIdTambah();
                }
            }
        });
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin untuk "
                        + "update?") == 0;
                if (konfirmasiYes) {
                    int idWca = Integer.parseInt(textIdUpdate.getText());
                    boolean pemainDitemukan = modelPemain.temukanPemainDenganId(idWca);
                    if (pemainDitemukan) {
                        String nama = textNamaUpdate.getText();
                        String jenisKelamin = textJenisKelaminUpdate.getText();
                        String negara = textNegaraUpdate.getText();
                        int jumlahKompetisi = Integer.parseInt(textJumlahKompetisiUpdate.getText());
                        int jumlahPodium = Integer.parseInt(textJumlahPodiumUpdate.getText());
                        Pemain pemain = new Pemain(
                                idWca, nama, jenisKelamin, negara, jumlahKompetisi, jumlahPodium);
                        modelPemain.updatePemainDenganObjek(pemain);
                        setTabelPemain();
                    } else {
                        JOptionPane.showMessageDialog(frame, "ID WCA tersebut tidak ada");
                    }
                }
            }
        });
        buttonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin untuk "
                        + "hapus?") == 0;
                if (konfirmasiYes) {
                    int idWca = Integer.parseInt(textIdHapus.getText());
                    boolean pemainDitemukan = modelPemain.temukanPemainDenganId(idWca);
                    if (pemainDitemukan) {
                        modelPemain.hapusPemainDenganId(idWca);
                        setTabelPemain();
                    } else {
                        JOptionPane.showMessageDialog(frame, "ID WCA tersebut tidak ada");
                    }
                }
            }
        });
    }

    private void setIdTambah() {
        textIdTambah.setText(String.valueOf(modelPemain.idWca));
        modelPemain.buatIdSelanjutnya();
    }

    private void setTabelPemain() {
        DefaultTableModel modelTabel = new DefaultTableModel();
        modelTabel.addColumn("ID WCA");
        modelTabel.addColumn("Nama");
        modelTabel.addColumn("Jenis Kelamin");
        modelTabel.addColumn("Negara");
        modelTabel.addColumn("Jumlah Kompetisi");
        modelTabel.addColumn("Jumlah Podium");
        for (int i = 0; i < modelPemain.daftarPemain.size(); i++) {
            String[] data = new String[6];
            data[0] = String.valueOf(modelPemain.daftarPemain.get(i).idWca);
            data[1] = modelPemain.daftarPemain.get(i).nama;
            data[2] = modelPemain.daftarPemain.get(i).jenisKelamin;
            data[3] = modelPemain.daftarPemain.get(i).negara;
            data[4] = String.valueOf(modelPemain.daftarPemain.get(i).jumlahKompetisi);
            data[5] = String.valueOf(modelPemain.daftarPemain.get(i).jumlahPodium);
            modelTabel.addRow(data);
        }
        tabelPemain.setModel(modelTabel);
    }
}

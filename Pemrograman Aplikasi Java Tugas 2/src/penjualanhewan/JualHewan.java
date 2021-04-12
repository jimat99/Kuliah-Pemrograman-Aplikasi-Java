package penjualanhewan;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class JualHewan {

    private Database database;
    private JFrame frameIni;
    private Image ikonSapi;
    private JLabel labelJudulJualHewan, labelIdPenjualan, labelIdHewan, labelHargaPenjualan;
    private JTextField textFieldIdPenjualan, textFieldIdHewan, textFieldHargaPenjualan;
    private JButton buttonJualHewan;
    private JTable tabelPenjualan;
    private DefaultTableModel modelTabelPenjualan;
    private JScrollPane scrollPane;
    private JButton buttonKembali;

    public JualHewan() {
        this.instansiasiKomponen();
        this.addKomponenKeFrame();
        this.setKomponen();
        this.setProsesKomponen();
    }

    private void instansiasiKomponen() {
        this.database = new Database();
        this.frameIni = new JFrame("Jual Hewan");
        this.labelJudulJualHewan = new JLabel("JUAL HEWAN");
        this.labelIdPenjualan = new JLabel("ID Penjualan");
        this.labelIdHewan = new JLabel("ID Hewan yang Dijual");
        this.labelHargaPenjualan = new JLabel("Harga Penjualan");
        this.textFieldIdPenjualan = new JTextField();
        this.textFieldIdHewan = new JTextField();
        this.textFieldHargaPenjualan = new JTextField();
        this.buttonJualHewan = new JButton("Jual Hewan");
        this.tabelPenjualan = new JTable();
        this.scrollPane = new JScrollPane(this.tabelPenjualan);
        this.buttonKembali = new JButton("\u25C4 Menu Awal");
    }
    
    private void addKomponenKeFrame() {
        this.frameIni.add(this.labelJudulJualHewan);
        this.frameIni.add(this.labelIdPenjualan);
        this.frameIni.add(this.labelIdHewan);
        this.frameIni.add(this.labelHargaPenjualan);
        this.frameIni.add(this.textFieldIdPenjualan);
        this.frameIni.add(this.textFieldIdHewan);
        this.frameIni.add(this.textFieldHargaPenjualan);
        this.frameIni.add(this.buttonJualHewan);
        this.frameIni.add(this.scrollPane);
        this.frameIni.add(this.buttonKembali);
    }

    private void setKomponen() {
        this.frameIni.setIconImage(ikonSapi);
        this.frameIni.setSize(800, 600);
        this.frameIni.setLayout(null);
        this.frameIni.setLocationRelativeTo(null);
        this.frameIni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ikonSapi = Toolkit.getDefaultToolkit().getImage("src/gambar/ikon-sapi.png");
        this.labelJudulJualHewan.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        this.labelJudulJualHewan.setBounds(340, 20, 120, 25);
        this.setIdPenjualanOtomatis();
        this.labelIdPenjualan.setBounds(255, 60, 140, 25);
        this.labelIdHewan.setBounds(255, 100, 140, 25);
        this.labelHargaPenjualan.setBounds(255, 140, 140, 25);
        this.textFieldIdPenjualan.setEditable(false);
        this.textFieldIdPenjualan.setBounds(405, 60, 140, 25);
        this.textFieldIdHewan.setBounds(405, 100, 140, 25);
        this.textFieldHargaPenjualan.setBounds(405, 140, 140, 25);
        this.buttonJualHewan.setBounds(405, 180, 140, 25);
        this.setModelTabelPenjualan();
        this.tabelPenjualan.setModel(this.modelTabelPenjualan);
        this.scrollPane.setBounds(150, 250, 500, 250);
        this.buttonKembali.setBounds(20, 520, 120, 30);
        this.frameIni.setVisible(true);
    }

    private void setProsesKomponen() {
        this.buttonJualHewan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frameIni, "Apakah Anda yakin untuk "
                        + "hapus?") == 0;
                if (konfirmasiYes) {
                    try {
                        int idHewan = Integer.parseInt(textFieldIdHewan.getText());
                        int hargaPenjualan = Integer.parseInt(textFieldHargaPenjualan.getText());
                        String queryCari = "SELECT id_hewan FROM hewan WHERE id_hewan = " + idHewan;
                        ResultSet hasilQuery = database.getStatement().executeQuery(queryCari);
                        if (hasilQuery.isBeforeFirst()) {
                            String queryInsert = "INSERT INTO transaksi_penjualan(id_penjualan, "
                                    + "id_hewan, harga_penjualan) "
                                    + "VALUES (NULL, " + idHewan + ", " + hargaPenjualan + ")";
                            database.getStatement().executeUpdate(queryInsert);
                            String queryUpdate = "UPDATE hewan "
                                    + "SET sudah_terjual = TRUE "
                                    + "WHERE id_hewan = " + idHewan;
                            database.getStatement().executeUpdate(queryUpdate);
                            setModelTabelPenjualan();
                            tabelPenjualan.setModel(modelTabelPenjualan);
                            setIdPenjualanOtomatis();
                        } else {
                            JOptionPane.showMessageDialog(frameIni, "ID hewan tersebut tidak ada");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frameIni, "Terjadi kesalahan: " + ex);
                    }
                }
            }
        });
        this.buttonKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    database.getKoneksi().close();
                    frameIni.dispose();
                    new MenuAwal();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frameIni, "Terjadi kesalahan: " + ex);
                }
            }
        });
    }

    private void setIdPenjualanOtomatis() {
        try {
            String query = "SELECT auto_increment "
                    + "FROM information_schema.tables "
                    + "WHERE table_schema = 'penjualanhewan' "
                    + "AND table_name = 'transaksi_penjualan'";
            ResultSet hasilQuery = this.database.getStatement().executeQuery(query);
            hasilQuery.next();
            this.textFieldIdPenjualan.setText(String.valueOf(hasilQuery.getString("auto_increment")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.frameIni, "Terjadi kesalahan: " + ex);
        }
    }

    private void setModelTabelPenjualan() {
        this.modelTabelPenjualan = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.modelTabelPenjualan.addColumn("ID Penjualan");
        this.modelTabelPenjualan.addColumn("ID Hewan");
        this.modelTabelPenjualan.addColumn("Nama Hewan");
        this.modelTabelPenjualan.addColumn("Harga Penjualan");

        try {
            String query = "SELECT a.id_penjualan, a.harga_penjualan, "
                    + "b.id_hewan, b.nama "
                    + "FROM transaksi_penjualan a "
                    + "JOIN hewan b "
                    + "ON a.id_hewan = b.id_hewan";
            ResultSet hasilQuery = this.database.getStatement().executeQuery(query);
            while (hasilQuery.next()) {
                String[] data = new String[4];
                data[0] = String.valueOf(hasilQuery.getInt("id_penjualan"));
                data[1] = String.valueOf(hasilQuery.getInt("id_hewan"));
                data[2] = hasilQuery.getString("nama");
                data[3] = String.valueOf(hasilQuery.getInt("harga_penjualan"));
                this.modelTabelPenjualan.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.frameIni, "Terjadi kesalahan: " + ex);
        }
    }
}

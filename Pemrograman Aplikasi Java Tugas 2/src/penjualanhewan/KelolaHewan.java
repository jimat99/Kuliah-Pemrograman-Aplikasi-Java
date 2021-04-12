package penjualanhewan;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class KelolaHewan {

    private Database database;
    private JFrame frameIni;
    private Image ikonSapi;
    private JLabel labelJudulInsert, labelIdInsert, labelNamaInsert;
    private JTextField textFieldIdInsert, textFieldNamaInsert;
    private JButton buttonInsert;
    private JSeparator pemisahKiri;
    private JLabel labelJudulUpdate, labelIdUpdate, labelNamaUpdate;
    private JTextField textFieldIdUpdate, textFieldNamaUpdate;
    private JButton buttonUpdate;
    private JSeparator pemisahKanan;
    private JLabel labelJudulHapus, labelIdHapus;
    private JTextField textFieldIdHapus;
    private JButton buttonHapus;
    private JTable tabelHewan;
    private DefaultTableModel modelTabelHewan;
    private JScrollPane scrollPane;
    private JButton buttonKembali;

    public KelolaHewan() {
        this.instansiasiKomponen();
        this.addKomponenKeFrame();
        this.setKomponen();
        this.setProsesKomponen();
    }

    private void instansiasiKomponen() {
        this.database = new Database();
        this.frameIni = new JFrame("Kelola Hewan");
        this.labelJudulInsert = new JLabel("INSERT");
        this.labelIdInsert = new JLabel("ID Hewan");
        this.labelNamaInsert = new JLabel("Nama Hewan");
        this.textFieldIdInsert = new JTextField();
        this.textFieldNamaInsert = new JTextField();
        this.buttonInsert = new JButton("Insert");
        this.pemisahKiri = new JSeparator(SwingConstants.VERTICAL);
        this.labelJudulUpdate = new JLabel("UPDATE");
        this.labelIdUpdate = new JLabel("ID Hewan yang Diupdate");
        this.labelNamaUpdate = new JLabel("Nama Hewan");
        this.textFieldIdUpdate = new JTextField();
        this.textFieldNamaUpdate = new JTextField();
        this.buttonUpdate = new JButton("Update");
        this.pemisahKanan = new JSeparator(SwingConstants.VERTICAL);
        this.labelJudulHapus = new JLabel("HAPUS");
        this.labelIdHapus = new JLabel("ID Hewan yang Dihapus");
        this.textFieldIdHapus = new JTextField();
        this.buttonHapus = new JButton("Hapus");
        this.tabelHewan = new JTable();
        this.scrollPane = new JScrollPane(this.tabelHewan);
        this.buttonKembali = new JButton("\u25C4 Menu Awal");
    }

    private void addKomponenKeFrame() {
        this.frameIni.add(this.labelJudulInsert);
        this.frameIni.add(this.labelIdInsert);
        this.frameIni.add(this.labelNamaInsert);
        this.frameIni.add(this.textFieldIdInsert);
        this.frameIni.add(this.textFieldNamaInsert);
        this.frameIni.add(this.buttonInsert);
        this.frameIni.add(this.pemisahKiri);
        this.frameIni.add(this.labelJudulUpdate);
        this.frameIni.add(this.labelIdUpdate);
        this.frameIni.add(this.labelNamaUpdate);
        this.frameIni.add(this.textFieldIdUpdate);
        this.frameIni.add(this.textFieldNamaUpdate);
        this.frameIni.add(this.buttonUpdate);
        this.frameIni.add(this.pemisahKanan);
        this.frameIni.add(this.labelJudulHapus);
        this.frameIni.add(this.labelIdHapus);
        this.frameIni.add(this.textFieldIdHapus);
        this.frameIni.add(this.buttonHapus);
        this.frameIni.add(this.scrollPane);
        this.frameIni.add(this.buttonKembali);
    }

    private void setKomponen() {
        this.frameIni.setIconImage(this.ikonSapi);
        this.frameIni.setSize(800, 600);
        this.frameIni.setLayout(null);
        this.frameIni.setLocationRelativeTo(null);
        this.frameIni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ikonSapi = Toolkit.getDefaultToolkit().getImage("src/gambar/ikon-sapi.png");
        this.labelJudulInsert.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        this.labelJudulInsert.setBounds(100, 20, 80, 25);
        this.setIdInsertOtomatis();
        this.labelIdInsert.setBounds(20, 60, 80, 25);
        this.labelNamaInsert.setBounds(20, 100, 80, 25);
        this.textFieldIdInsert.setEditable(false);
        this.textFieldIdInsert.setBounds(110, 60, 140, 25);
        this.textFieldNamaInsert.setBounds(110, 100, 140, 25);
        this.buttonInsert.setBounds(110, 140, 80, 25);
        this.pemisahKiri.setBounds(266, 0, 1, 200);
        this.labelJudulUpdate.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        this.labelJudulUpdate.setBounds(366, 20, 80, 25);
        this.labelIdUpdate.setBounds(270, 60, 140, 25);
        this.labelNamaUpdate.setBounds(270, 100, 140, 25);
        this.textFieldIdUpdate.setBounds(420, 60, 100, 25);
        this.textFieldNamaUpdate.setBounds(420, 100, 100, 25);
        this.buttonUpdate.setBounds(420, 140, 80, 25);
        this.pemisahKanan.setBounds(532, 0, 1, 200);
        this.labelJudulHapus.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        this.labelJudulHapus.setBounds(632, 20, 80, 25);
        this.labelIdHapus.setBounds(536, 60, 140, 25);
        this.textFieldIdHapus.setBounds(686, 60, 80, 25);
        this.buttonHapus.setBounds(686, 100, 80, 25);
        this.setModelTabelHewan();
        this.tabelHewan.setModel(this.modelTabelHewan);
        this.scrollPane.setBounds(200, 250, 400, 250);
        this.buttonKembali.setBounds(20, 520, 120, 30);
        this.frameIni.setVisible(true);
    }

    private void setProsesKomponen() {
        this.buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frameIni, "Apakah Anda yakin untuk "
                        + "insert?") == 0;
                if (konfirmasiYes) {
                    try {
                        String nama = textFieldNamaInsert.getText();
                        String query = "INSERT INTO hewan(id_hewan, nama, sudah_terjual) "
                                + "VALUES (NULL, '" + nama + "', FALSE)";
                        database.getStatement().executeUpdate(query);
                        setModelTabelHewan();
                        tabelHewan.setModel(modelTabelHewan);
                        setIdInsertOtomatis();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frameIni, "Terjadi kesalahan: " + ex);
                    }
                }
            }
        });
        this.buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frameIni, "Apakah Anda yakin untuk "
                        + "update?") == 0;
                if (konfirmasiYes) {
                    try {
                        int idHewan = Integer.parseInt(textFieldIdUpdate.getText());
                        String nama = textFieldNamaUpdate.getText();
                        String queryCari = "SELECT id_hewan FROM hewan WHERE id_hewan = " + idHewan;
                        ResultSet hasilQuery = database.getStatement().executeQuery(queryCari);
                        if (hasilQuery.isBeforeFirst()) {
                            String queryUpdate = "UPDATE hewan "
                                    + "SET nama = '" + nama + "' "
                                    + "WHERE id_hewan = " + idHewan;
                            database.getStatement().executeUpdate(queryUpdate);
                            setModelTabelHewan();
                            tabelHewan.setModel(modelTabelHewan);
                        } else {
                            JOptionPane.showMessageDialog(frameIni, "ID hewan tersebut tidak ada");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frameIni, "Terjadi kesalahan: " + ex);
                    }
                }
            }
        });
        this.buttonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean konfirmasiYes = JOptionPane.showConfirmDialog(frameIni, "Apakah Anda yakin untuk "
                        + "hapus?") == 0;
                if (konfirmasiYes) {
                    try {
                        int idHewan = Integer.parseInt(textFieldIdHapus.getText());
                        String queryCari = "SELECT id_hewan FROM hewan WHERE id_hewan = " + idHewan;
                        ResultSet hasilQuery = database.getStatement().executeQuery(queryCari);
                        if (hasilQuery.isBeforeFirst()) {
                            String queryHapus = "DELETE FROM hewan WHERE id_hewan = " + idHewan;
                            database.getStatement().executeUpdate(queryHapus);
                            setModelTabelHewan();
                            tabelHewan.setModel(modelTabelHewan);
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

    private void setIdInsertOtomatis() {
        try {
            String query = "SELECT auto_increment "
                    + "FROM information_schema.tables "
                    + "WHERE table_schema = 'penjualanhewan' "
                    + "AND table_name = 'hewan'";
            ResultSet hasilQuery = this.database.getStatement().executeQuery(query);
            hasilQuery.next();
            this.textFieldIdInsert.setText(String.valueOf(hasilQuery.getString("auto_increment")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.frameIni, "Terjadi kesalahan: " + ex);
        }
    }

    private void setModelTabelHewan() {
        this.modelTabelHewan = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.modelTabelHewan.addColumn("ID Hewan");
        this.modelTabelHewan.addColumn("Nama Hewan");
        this.modelTabelHewan.addColumn("Sudah Terjual");
        try {
            String query = "SELECT id_hewan, nama, sudah_terjual FROM hewan";
            ResultSet hasilQuery = this.database.getStatement().executeQuery(query);
            while (hasilQuery.next()) {
                String[] data = new String[3];
                data[0] = String.valueOf(hasilQuery.getInt("id_hewan"));
                data[1] = hasilQuery.getString("nama");
                if (hasilQuery.getInt("sudah_terjual") == 1) {
                    data[2] = "Sudah";
                } else {
                    data[2] = "Belum";
                }
                this.modelTabelHewan.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.frameIni, "Terjadi kesalahan: " + ex);
        }
    }
}

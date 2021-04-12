package penjualanhewan;

import java.sql.*;
import javax.swing.*;

public class Database {

    private Connection koneksi;
    private Statement statement;
    private String classDriverOracle, urlDatabase, userDatabase, passwordDatabase;

    public Database() {
        this.classDriverOracle = "com.mysql.cj.jdbc.Driver";
        this.urlDatabase = "jdbc:mysql://localhost/penjualanhewan";
        this.userDatabase = "root";
        this.passwordDatabase = "";
        try {
            Class.forName(this.classDriverOracle);
            try {
                this.koneksi = DriverManager.getConnection(this.urlDatabase, this.userDatabase,
                        this.passwordDatabase);
                this.statement = this.koneksi.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex);
        }
    }

    public Connection getKoneksi() {
        return this.koneksi;
    }

    public Statement getStatement() {
        return this.statement;
    }
}

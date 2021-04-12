package uaspaj;

import javax.swing.*;

public class UasPaj {

    public static void main(String[] args) {
        int n = 7;
        int angka = 1;
        int temp = 0;
        String teks = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 1) {
                    if (j == 0) {
                        //temp = angka + 6;
                        temp = angka + 6;
                    }
                    teks += temp + "  ";
                    temp--;
                    if (j == n - 1) {
                        angka = angka + 7;
                    }
                } else {
                    teks += angka + "  ";
                    angka++;
                }
            }
            teks += "\n";
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(null);
        JTextArea textArea = new JTextArea(teks);
        textArea.setBounds(20, 20, 200, 200);
        frame.add(textArea);
        frame.setVisible(true);
    }
}

/**
 * PRUDENCA AHMAD DAFFA KURNIA
 * 123190005
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Tampil extends JFrame {
    JFrame frame = new JFrame("Database Karyawan");
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No", "Nama Karyawan", "Usia", "Gaji"};
    
    public JButton bKembali = new JButton("Menu Awal");
    public JButton bEdit = new JButton("Edit");
    
    public Tampil(){
        
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Karyawan");
        setSize(700, 550);
        setVisible(true);
        setLayout(null);
        add(scrollPane);
        
        scrollPane.setBounds(40, 35, 600, 400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(bKembali);
        bKembali.setBounds(40, 450,100, 30);
        
        scrollPane.setBounds(40, 35, 600, 400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(bEdit);
        bEdit.setBounds(200, 450,100, 30);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

/**
 * PRUDENCA AHMAD DAFFA KURNIA
 * 123190005
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Input extends JFrame {
    JLabel lJudul = new JLabel("Input Karyawan");
    
    JLabel lNama = new JLabel("Nama");
    JLabel lUsia = new JLabel("Usia");
    JLabel lGaji = new JLabel("Gaji");
    
   
   public JTextField tNama = new JTextField(50);
   public JTextField tUsia = new JTextField(50);
   public JTextField tGaji = new JTextField(50);
    
    public JButton btnInput = new JButton("Input");
    public JButton btnReset = new JButton("Kosongkan");
    public JButton btnEdit  = new JButton ("Edit");
    public JButton btnKembali = new JButton("Menu Awal");
    
    public Input(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Input Data Karyawan");
        setSize(400, 400);
        setLayout(null);
        
        add(lJudul);
        add(lNama);
        add(tNama);
        add(lUsia);
        add(tUsia);
        add(lGaji);
        add(tGaji);
        add(btnInput);
        add(btnReset);
        add(btnEdit);
        add(btnKembali);
        
        lJudul.setBounds(40, 35, 100, 20);
        lNama.setBounds(40, 55, 100, 20);
        tNama.setBounds(160, 55, 100, 20);
        lUsia.setBounds(40, 75, 100, 20);
        tUsia.setBounds(160, 75, 100, 20);
        lGaji.setBounds(40, 95, 100, 20);
        tGaji.setBounds(160, 95, 100, 20);
        btnInput.setBounds(80, 130, 100, 20);
        btnReset.setBounds(200, 130, 100, 20);
        btnEdit.setBounds(140, 150, 100, 20);
        btnKembali.setBounds(40, 190, 100, 20);
        
        
        
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public String getNama(){
        return tNama.getText();
    }
    
    public String getUsia(){
        return tUsia.getText();
    }
    
    public String getGaji(){
        return tGaji.getText();
    }
}

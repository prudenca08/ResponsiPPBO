/**
 * PRUDENCA AHMAD DAFFA KURNIA
 * 123190005
 */
package view;

import controller.ViewKaryawan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.LihatKaryawan;

public class Menu extends JFrame implements ActionListener {
    JLabel ljudul = new JLabel("Database Karyawan");

   public JButton btnInput = new JButton("Tambah Karyawan");
   public JButton btnLihat = new JButton("Lihat Karyawan");


    public Menu(){
        
        setTitle("Database Karyawan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setLayout(null);
        add(ljudul);
        add(btnLihat);
        add(btnInput);

        ljudul.setBounds(10,10,150,20);


        btnInput.setBounds(10,40,150,20);
        btnLihat.setBounds(10,70,150,20);
        
        btnInput.addActionListener(this);
        btnLihat.addActionListener(this);


        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == btnInput){
           Tampil tampil = new Tampil();
           tampil.dispose();
           dispose();
           Input input = new Input();
           Update update = new Update();
           update.dispose();
           LihatKaryawan md = new LihatKaryawan();
           ViewKaryawan ct = new ViewKaryawan(tampil, md,input,update);
          
        }
        if(e.getSource() == btnLihat){
           Tampil tampil = new Tampil();
           Input input = new Input();
           input.dispose();
           Update update = new Update();
           update.dispose();
           LihatKaryawan md = new LihatKaryawan();
           ViewKaryawan ct = new ViewKaryawan(tampil, md,input,update);
        }

    }
}

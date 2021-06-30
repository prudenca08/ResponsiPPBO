/**
 * PRUDENCA AHMAD DAFFA KURNIA
 * 123190005
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import model.LihatKaryawan;
import view.*;

public class ViewKaryawan {
    LihatKaryawan model1;
    Tampil tampilView1;
    Input input1;
    Update edit1;
    
    public ViewKaryawan(Tampil tampilView, LihatKaryawan model,Input input, Update edit){
        this.model1 = model;
        this.tampilView1 = tampilView;
        this.input1 = input;
        this.edit1 = edit;
        
        if(model1.getBanyakData()!=0){
            String dataKaryawan[][] = model1.readData();
            tampilView1.tabel.setModel((new JTable(dataKaryawan, tampilView1.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        
        tampilView1.bKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilView1.dispose();

            }
        });
        
        
        
        edit.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = edit.getNama();
                String id = edit.getId();
                String usia = edit.getUsia();
                String gaji =edit.getGaji();
                model.update(nama,id, usia, gaji);
                edit.dispose();
            }
        });
        edit.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cek = edit.getId();
                model.delete(cek);
                edit.dispose();
            }
        });
        edit1.btnKembalii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.dispose();
            }
        });
        
        
        input1.btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nama = input1.getNama();
                String usia = input1.getUsia();
                String gaji =input1.getGaji();
                model.insert(nama, usia, gaji);
         
                String dataKaryawan[][] = model.readData();
                tampilView1.tabel.setModel((new JTable(dataKaryawan, tampilView1.namaKolom)).getModel());
            }
        });
        
        
        
         input1.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.dispose();
                Menu menu = new Menu();
                   
            }
        });
        input1.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1.tNama.setText(null);
                input1.tUsia.setText(null);  
                input1.tGaji.setText(null);
            }
        });
        input1.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        }
        });
        
        
            tampilView1.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = tampilView1.tabel.getSelectedRow();
                
                String id = tampilView1.tabel.getValueAt(baris, 0).toString();
                String nama = tampilView1.tabel.getValueAt(baris, 1).toString();
                String usia = tampilView1.tabel.getValueAt(baris, 2).toString();
                String gaji = tampilView1.tabel.getValueAt(baris, 3).toString();
                
                tampilView1.dispose();
                Update update = new Update();
                update.ffNama.setText(nama);
                update.fId.setText(id);
                update.ffUsia.setText(usia);
                update.ffGaji.setText(gaji);
                Tampil tampil = new Tampil();
                tampil.dispose();
                Input input = new Input();
                input.dispose();
                LihatKaryawan model = new LihatKaryawan();
                ViewKaryawan control = new ViewKaryawan(tampil,model,input,update);
                System.out.println("");
                        
            }
        }
        );
    }
}

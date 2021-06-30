/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

/**
 *
 * @author mumta
 */
public class LihatKaryawan {
    Koneksi koneksi = new Koneksi();
    
    public String[][] readData(){
        try{
            int jumlah = 0;
            
            String data[][] = new String[getBanyakData()][4]; 
            
            String query = "SELECT * FROM karyawan"; 
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){
                data[jumlah][0] = resultSet.getString("id"); 
                data[jumlah][1] = resultSet.getString("nama");                
                data[jumlah][2] = resultSet.getString("usia");
                data[jumlah][3] = resultSet.getString("gaji");
                jumlah++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public int getBanyakData(){
        int jmlData = 0;
        try{
            koneksi.statement = koneksi.koneksi.createStatement();
            String query = "SELECT * FROM karyawan";
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
     
    public void insert(String nama, String umur, String gaji){
        int jumlah=1;
        try {
           String query = "SELECT * FROM karyawan"; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jumlah++;
            }
                query = "INSERT INTO karyawan VALUES('"+jumlah+"','"+nama+"','"+umur+"','"+gaji+"')";
                
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); 
                System.out.println("Data Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
         catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
       public void update(String nama,String id, String usia, String gaji){
        int jumlah=0;
         try {
           String query = "SELECT * FROM karyawan WHERE id=" + id; 
           ResultSet resultSet = koneksi.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jumlah++;
            }
           
             if (jumlah==1) {
                query = "UPDATE karyawan SET id='" + id + "', nama='" + nama + "', usia='" + usia + "', gaji='" + gaji + "' WHERE id=" + id;
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); //execute querynya
                System.out.println("Data Berhasil diganti");
                JOptionPane.showMessageDialog(null, "Data Berhasil Diganti");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void delete (String id) {
        try{
            String query = "DELETE FROM karyawan WHERE id = '"+id+"'";
            koneksi.statement = koneksi.koneksi.createStatement();
            koneksi.statement.executeUpdate(query);
            System.out.println("Data Berhasil dihapus");
            JOptionPane.showMessageDialog(null, " Data Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

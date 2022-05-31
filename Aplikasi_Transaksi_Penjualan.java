package aplikasi_toko;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
import java.util.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;


public class Aplikasi_Transaksi_Penjualan extends javax.swing.JFrame {
Connection c;
ResultSet r;
Statement s;

private Object[][]datajual=null;
private String[]label1={"Kode Barang","Nama Barang","Harga Jual","Jumlah","Total Harga","Kode Pegawai","Nama Pegawai"};
    
    public Aplikasi_Transaksi_Penjualan() {
        initComponents();
        BukaKoneksi();
        BacaTabelPenjualan();
        tkd_trans.setVisible(true);
    }
private void BukaKoneksi(){
            try {
          Class.forName("com.mysql.cj.jdbc.Driver");
   c=DriverManager.getConnection("jdbc:mysql://localhost/dbtoko","root","");
            System.out.println("Koneksi Sukses");
            } catch (Exception e) {
            System.out.println(e);
            }
        }
private void BacaTabelPenjualan(){
            try {
                s=c.createStatement();
                String sql="Select jual.kd_brg, barang.nm_brg, barang.hrg_jual, "
                        + "jual.jml, jual.tot_hrg, jual.kd_peg, pegawai.nm_peg "
                        + "From jual, barang, pegawai Where barang.kd_brg=jual.kd_brg And pegawai.kd_peg=jual.kd_peg";
                r=s.executeQuery(sql);
                ResultSetMetaData m=r.getMetaData();
                int kolom=m.getColumnCount();
                int baris=0;
                while(r.next()){
                    baris=r.getRow();
                }
               datajual=new Object[baris][kolom];
               int x=0;
               r.beforeFirst();
               while(r.next()){
                   datajual[x][0]=r.getString("kd_brg");
                   datajual[x][1]=r.getString("nm_brg");
                   datajual[x][2]=r.getString("hrg_jual");
                   datajual[x][3]=r.getString("jml");
                   datajual[x][4]=r.getString("tot_hrg");
                   datajual[x][5]=r.getString("kd_peg");
                   datajual[x][6]=r.getString("nm_peg");
                   x++;
               }
               tbl_jual.setModel(new DefaultTableModel(datajual,label1));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
private void SetTabel(){
        int row=tbl_jual.getSelectedRow();
        tkd_brg.setText((String)tbl_jual.getValueAt(row, 0));
        tnm_brg.setText((String)tbl_jual.getValueAt(row, 1));
        thrg_jual.setText((String)tbl_jual.getValueAt(row, 2));
        tjml.setText((String)tbl_jual.getValueAt(row, 3));
        thrg_tot.setText((String)tbl_jual.getValueAt(row, 4));
        tkd_peg.setText((String)tbl_jual.getValueAt(row, 5));
        tnm_peg.setText((String)tbl_jual.getValueAt(row, 6));
        
    }
    private void BersihField(){
        tkd_trans.setText("");
        ttgl.setText("");
        tkd_brg.setText("");
        tnm_brg.setText("");
        thrg_jual.setText("");
        tjml.setText("");
        thrg_tot.setText("");
        tkd_peg.setText("");
        tnm_peg.setText("");
        ltot.setText("");
        tbyr.setText("");
        lkembali.setText("");
   }
 private void SimpanData(){
        try {
            String sql="Insert into barang Values('"+tkd_brg.getText()+"','"+tnm_brg.getText()+"','"+thrg_jual.getText()+"','"+tjml.getText()+"','"+thrg_tot.getText()+"','"+tkd_peg.getText()+"','"+tnm_peg.getText()+"',)";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
            BersihField();
            BacaTabelPenjualan();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 private void TambahData(){
      try {
            String sql="Insert into barang Values('"+tkd_brg.getText()+"','"+tnm_brg.getText()+"','"+thrg_jual.getText()+"','"+tjml.getText()+"','"+thrg_tot.getText()+"','"+tkd_peg.getText()+"','"+tnm_peg.getText()+"',)";
            s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
            BersihField();
            BacaTabelPenjualan();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void HapusData(){
        try {
           String sql="Delete from jual Where kd_brg='"+tkd_brg.getText()+"'";
       s.executeUpdate(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
            BersihField();
            BacaTabelPenjualan();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void total(){
        int y=0;
        int totrec=tbl_jual.getRowCount();
        for(int z=0;z<totrec;z++){
            y=y+Integer.parseInt(tbl_jual.getValueAt(z, 4).toString());
            ltot.setText(String.valueOf(y));
        }
    }

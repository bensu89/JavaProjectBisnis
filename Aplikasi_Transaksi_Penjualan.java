package aplikasi_toko;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
/*
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
import java.util.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
*/

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
        tot_hrg.setText((String)tbl_jual.getValueAt(row, 4));
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
        tot_hrg.setText("");
        tkd_peg.setText("");
        tnm_peg.setText("");
        ltot.setText("");
        tbyr.setText("");
        lkembali.setText("");
   }
    private void SimpanData(){
        
        try {
            String sql="Insert into barang Values('"+tkd_brg.getText()+"','"+tnm_brg.getText()+"','"+thrg_jual.getText()+"','"+tjml.getText()+"','"+tot_hrg.getText()+"','"+tkd_peg.getText()+"','"+tnm_peg.getText()+"',)";
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
            String sql="Insert into barang Values('"+tkd_brg.getText()+"','"+tnm_brg.getText()+"','"+thrg_jual.getText()+"','"+tjml.getText()+"','"+tot_hrg.getText()+"','"+tkd_peg.getText()+"','"+tnm_peg.getText()+"',)";
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        tkd_trans = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ttgl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tkd_brg = new javax.swing.JTextField();
        tnm_brg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        thrg_jual = new javax.swing.JTextField();
        tjml = new javax.swing.JTextField();
        bt_total = new javax.swing.JButton();
        tot_hrg = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tkd_peg = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tnm_peg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_jual = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        bt_tot = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tbyr = new javax.swing.JTextField();
        bt_kembali = new javax.swing.JButton();
        bt_tambah = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        ltot = new javax.swing.JLabel();
        bt_simpan = new javax.swing.JButton();
        bt_cetak = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();
        lkembali = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TRANSAKSI PENJUALAN");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("TRANSAKSI PENJUALAN");

        jLabel2.setText("Kode Transaksi");

        jLabel3.setText("Tanggal Transaksi");

        jLabel4.setText("Kode Barang");

        jLabel5.setText("Nama Barang");

        jLabel6.setText("Harga Jual");

        jLabel7.setText("Jumlah Jual");

        thrg_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thrg_jualActionPerformed(evt);
            }
        });

        bt_total.setText("Total");
        bt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_totalActionPerformed(evt);
            }
        });

        jLabel8.setText("Kode Pegawai");

        jLabel9.setText("Nama Pegawai");

        tbl_jual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga Jual", "Total Harga", "Kode Pegawai", "Nama Pegawai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_jual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_jual);

        bt_tot.setText("Total Bayar");
        bt_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_totActionPerformed(evt);
            }
        });

        jLabel10.setText("Pembayaran");

        bt_kembali.setText("kembali");
        bt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kembaliActionPerformed(evt);
            }
        });

        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        ltot.setText("-");

        bt_simpan.setText("SIMPAN");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        bt_cetak.setText("CETAK");

        bt_keluar.setText("KELUAR");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        lkembali.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tkd_brg)
                                    .addComponent(tnm_brg, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_total)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(thrg_jual)
                                    .addComponent(tjml, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(tot_hrg, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(44, 44, 44)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tkd_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(tkd_peg, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel9)
                                        .addGap(35, 35, 35)
                                        .addComponent(tnm_peg, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(27, 27, 27)
                                        .addComponent(tbyr, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 45, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bt_tot)
                                        .addGap(45, 45, 45)
                                        .addComponent(ltot)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_tambah))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bt_kembali)
                                        .addGap(58, 58, 58)
                                        .addComponent(lkembali)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_hapus)))
                                .addGap(127, 127, 127)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(bt_simpan)
                .addGap(70, 70, 70)
                .addComponent(bt_cetak)
                .addGap(79, 79, 79)
                .addComponent(bt_keluar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tkd_trans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tkd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(thrg_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tnm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_total)
                            .addComponent(tot_hrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(tnm_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tkd_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tot)
                    .addComponent(bt_tambah)
                    .addComponent(ltot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tbyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_kembali)
                    .addComponent(bt_hapus)
                    .addComponent(lkembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_simpan)
                    .addComponent(bt_cetak)
                    .addComponent(bt_keluar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>                        

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {                                          
       dispose();
    }                                         

    private void bt_totalActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int a,b,harga;
        a=Integer.parseInt(thrg_jual.getText());
        b=Integer.parseInt(tjml.getText());
        harga=a*b;
        tot_hrg.setText(String.valueOf(harga));
    }                                        

    private void bt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int i,j,kembali;
        i=Integer.parseInt(ltot.getText());
        j=Integer.parseInt(tbyr.getText());
        kembali=j-i;
        lkembali.setText(String.valueOf(kembali));
    }                                          

    private void bt_totActionPerformed(java.awt.event.ActionEvent evt) {                                       
        total();
    }                                      

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        TambahData();
    }                                         

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        HapusData();
    }                                        

    private void tbl_jualMouseClicked(java.awt.event.MouseEvent evt) {                                      
       SetTabel();
    }                                     

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {                                          
       SimpanData();
    }                                         

    private void thrg_jualActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

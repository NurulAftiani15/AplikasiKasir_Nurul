/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasikasir;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.Date;
/**
 *
 * @author OWNER
 */
public class FormPenjualan extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst,pst2;
ResultSet rst;
int istok,istok2,iharga,ijumlah,kstok,tstok;
String  harga,barang,dbarang,kdDet,jam,tanggal,ssub;
    /**
     * Creates new form FormPenjualan
     */
    public FormPenjualan() {
        initComponents();
        konek= Koneksi.koneksiDB();
        tampilwaktu();
        detail();
        autonumber();
        penjumlahan();
        
    }
    public void mulai(){
        txttanggal.setEnabled(false);
        txtwaktu.setEnabled(false);
        txtIdPenjualan.setEnabled(false);
        txttotal.setEnabled(false);
        txtkembalian.setEnabled(false);
        
    }
     public void tampilwaktu(){
         Thread clock =new Thread(){
             public void run(){
                 for(;;){
                     Calendar cal = Calendar.getInstance();
                     SimpleDateFormat jam = new SimpleDateFormat("hh:mm:ss");
                     SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
                     txtwaktu.setText(jam.format(cal.getTime()));
                     txttanggal.setText(tgl.format(cal.getTime()));
                 }
             }
             };
         clock.start();
     }
     
        private void simpan(){
               String tgl=txttanggal.getText();
               String jam=txtwaktu.getText();
             try {
                   String sql="insert into tbl_penjualan (PenjualanID,DetailID,TanggalPenjualan,JamPenjualan,TotalHarga) value (?,?,?,?,?)";
                   pst=konek.prepareStatement(sql);
                   pst.setString(1, txtIdPenjualan.getText());
                   pst.setString(2, detail);
                   pst.setString(3, tgl);
                   pst.setString(4, jam);
                   pst.setString(5, txttotal.getText());
                   pst.execute();
                   JOptionPane.showMessageDialog(null, "Data Tersimpan");
               } catch (Exception e){
                   JOptionPane.showMessageDialog(null, e);
                   }
           }

           private void total(){
           int total, bayar, kembali;
               total= Integer.parseInt(txtbayar.getText());
               bayar= Integer.parseInt(txttotal.getText());
               kembali=total-bayar;
               String ssub=String.valueOf(kembali);
               txtkembalian.setText(ssub);
           }

           public void clsr(){
           txtjumlah.setText("");
           //jdis.setText("");
           }

           public void cari(){
           try {
               String sql="select * from tbl_produk where ProdukID LIKE '%"+txtidproduk.getText()+"%'";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               tblProduk.setModel(DbUtils.resultSetToTableModel(rst));
              } catch (Exception e){ JOptionPane.showMessageDialog(null, e);} 
           }

           public void kurangi_stok(){
           int qty;
           qty=Integer.parseInt(txtjumlah.getText());
           kurangistok=inputstok-qty;
           }

           private void subtotal(){
           int jumlah, sub;
                jumlah= Integer.parseInt(txtjumlah.getText());
                sub=(jumlah*inputharga);
                sub_total=String.valueOf(sub);     
           }

           public void tambah_stok(){
           tambahstok=inputJumlah+inputstok2;
               try {
               String update="update tbl_produk set Stok='"+tambahstok+"' where ProdukID='"+idproduk+"'";
               pst2=konek.prepareStatement(update);
               pst2.execute();
               }catch (Exception e){
                   JOptionPane.showMessageDialog(null, e);}
           }

           public void ambil_stock(){
           try {
           String sql="select * from tbl_produk where ProdukID='"+idproduk+"'";
           pst=konek.prepareStatement(sql);
           rst=pst.executeQuery();
           if (rst.next()) {    
           String stok=rst.getString(("Stok"));
           inputstok2= Integer.parseInt(stok);
           }
           }catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);}
           }

           public void penjumlahan(){
               int totalBiaya = 0;
               int subtotal;
               DefaultTableModel dataModel = (DefaultTableModel) tblpenjualan.getModel();
               int jumlah = tblpenjualan.getRowCount();
               for (int i=0; i<jumlah; i++){
               subtotal = Integer.parseInt(dataModel.getValueAt(i, 4).toString());
               totalBiaya += subtotal;
               }
               txttotal.setText(String.valueOf(totalBiaya));
           }

           public void autonumber(){
           try{
               String sql = "SELECT MAX(RIGHT(PenjualanID,3)) AS NO FROM tbl_penjualan";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               while (rst.next()) {
                       if (rst.first() == false) {
                           txtIdPenjualan.setText("IDP001");
                       } else {
                           rst.last();
                           int auto_id = rst.getInt(1) + 1;
                           String no = String.valueOf(auto_id);
                           int NomorJual = no.length();
                           for (int j = 0; j < 3 - NomorJual; j++) {
                               no = "0" + no;
                           }
                           txtIdPenjualan.setText("IDP" + no);
                       }
                   }
               rst.close();
               }catch (Exception e){
                   JOptionPane.showMessageDialog(null, e);}
           }

           public void detail(){
           try {
               String Kode_detail=txtIdPenjualan.getText();
               String KD="D"+Kode_detail;
               String sql="select * from tbl_detailpenjualan where DetailID='"+KD+"'";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               tblpenjualan.setModel(DbUtils.resultSetToTableModel(rst));
              } catch (Exception e){ 
                  JOptionPane.showMessageDialog(null, e);} 
           }

           public void tampilJam(){
           Thread clock=new Thread(){
               public void run(){
                   for(;;){
                       Calendar cal=Calendar.getInstance();
                       SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
                       SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
                       txtwaktu.setText(format.format(cal.getTime()));
                        txttanggal.setText(format2.format(cal.getTime()));

                   try { sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(FormPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 }
               }
             };
           clock.start();
           }

       public void tambahstok() {
       tambahstok = inputjumlah + inputstok2;
       try {
         String update= "update tbl_produk set Stok='"+tambahstok+"' where ProdukID='"+idproduk+"'";
         pst2 = konek.prepareStatement(update);
         pst2.execute();
       } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Gagal Menambah Stok");
       }
       }

       public void ambilstok() {
       try {
         String sql = "select * from tbl_produk where ProdukID='"+idproduk+"'";
         pst = konek.prepareStatement(sql);
         rst = pst.executeQuery();
         if (rst.next()) {
         String stok = rst.getString(("Stok"));
         inputstok2 = Integer.parseInt(stok);
         }
       } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Gagal Ambil Stok");
       }
       }

       public void Penjumlahan(){
               int totalBiaya = 0;
               int subtot;
               DefaultTableModel dataModel = (DefaultTableModel) tblProduk.getModel();
               int jumlah = tblProduk.getRowCount();
               for (int i=0; i<jumlah; i++){            
                   subtot = Integer.parseInt(dataModel.getValueAt(i, 5).toString());
                   totalBiaya += subtot;
               }
               txttotal.setText(String.valueOf(totalBiaya));
           }

       public void Autonumber(){
           try{
               String sql = "SELECT MAX(RIGHT(PenjualanID,3)) AS NO FROM tbl_penjualan";
               pst=konek.prepareStatement(sql);
               rst=pst.executeQuery();
               while (rst.next()) {
                       if (rst.first() == false) {
                           txtIdPenjualan.setText("IDP001");
                       } else {
                           rst.last();
                           int auto_id = rst.getInt(1) + 1;
                           String no = String.valueOf(auto_id);
                           int NomorJual = no.length();
                           for (int j = 0; j < 3 - NomorJual; j++) {
                               no = "0" + no;
                           }
                           txtIdPenjualan.setText("IDP" + no);
                       }
                   }
               rst.close();
               }catch (Exception e){JOptionPane.showMessageDialog(null, "Gagal Menambah ID Penjualan");}
           }

       public void Detail() {
       try {
         String ID_Detail = txtIdPenjualan.getText();
         String iddetail = "D" +ID_Detail;
         String sql = "select * from tbl_detailpenjualan where DetailID='"+iddetail+"'";
         pst = konek.prepareStatement(sql);
         rst = pst.executeQuery();
         tblpenjualan.setModel(DbUtils.resultSetToTableModel(rst));
       } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Gagal Menambah ID Detail");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idproduk = new javax.swing.JLabel();
        txtidproduk = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        txtjumlah = new javax.swing.JTextField();
        txtdiskon = new javax.swing.JTextField();
        txtIdPenjualan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpenjualan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        btnbayar = new javax.swing.JButton();
        btnbaru = new javax.swing.JButton();
        txtwaktu = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sale-70.png"))); // NOI18N
        jLabel1.setText("INPUT PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        idproduk.setText("Masukan nama barang");

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblprodukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduk);

        txtjumlah.setText("Jumlah");

        txtdiskon.setText("Diskon");

        jLabel3.setText("Kode Transaksi");

        jLabel4.setText("Data Transaksi");

        tblpenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblpenjualan);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Bayar");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Kembalian");

        btnbayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-transaction-20.png"))); // NOI18N
        btnbayar.setText("BAYAR");

        btnbaru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-move-out-20.png"))); // NOI18N
        btnbaru.setText("BARU");

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txtdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idproduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtidproduk))
                                .addGap(46, 46, 46)
                                .addComponent(btncari))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3)
                                .addGap(79, 79, 79)
                                .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btnbayar)
                                .addGap(55, 55, 55)
                                .addComponent(btnbaru)))))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(idproduk)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtidproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbayar)
                    .addComponent(btnbaru))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(249, 249, 249))
        );

        pack();
    }// </editor-fold>                        

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {                                        
cari();
// TODO add your handling code here:
    }                                       

    private void tblprodukMouseClicked(java.awt.event.MouseEvent evt) {                                       
try {
            int row=tblProduk.getSelectedRow();
            String tabel_klik=(tblProduk.getModel().getValueAt(row, 0).toString());
            String sql="select * from tbl_produk where ProdukID='"+tabel_klik+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if (rst.next()) {
                idproduk=rst.getString(("ProdukID"));
                String stok=rst.getString(("Stok"));
                inputStok= Integer.parseInt(stok);
                harga=rst.getString(("Harga"));
                inputharga= Integer.parseInt(harga);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdPenjualan = new javax.swing.JTextField();
        btnbayar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnbaru = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtwaktu = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpenjualan = new javax.swing.JTable();
        txttanggal = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        idproduk = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidproduk = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        txtjumlah = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnbayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-transaction-20.png"))); // NOI18N
        btnbayar.setText("BAYAR");

        jLabel3.setText("Id Penjualan");

        btnbaru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-move-out-20.png"))); // NOI18N
        btnbaru.setText("BARU");

        jLabel4.setText("Data Transaksi");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sale-70.png"))); // NOI18N
        jLabel1.setText("INPUT PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblpenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblpenjualan);

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        idproduk.setText("Masukan id produk");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total");

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduk);

        txtjumlah.setText("Jumlah");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Kembalian");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Bayar");

        btnTambah.setText("Tambah");

        btnHapus.setText("Hapus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambah)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(40, 40, 40)
                        .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnbayar)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnbaru)
                                            .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapus)))))
                        .addContainerGap(149, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(552, 552, 552)
                                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idproduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtidproduk))
                                    .addGap(46, 46, 46)
                                    .addComponent(btncari))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(jLabel3)
                                    .addGap(79, 79, 79)
                                    .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(176, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnHapus)
                                        .addGap(63, 63, 63)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnbayar)
                                    .addComponent(btnbaru))
                                .addGap(30, 30, 30)
                                .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(idproduk)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtidproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btncari))
                    .addGap(33, 33, 33)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(102, 102, 102)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addContainerGap(350, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        cari();
        // TODO add your handling code here:
    }//GEN-LAST:event_btncariActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
       try {
            int row=tblProduk.getSelectedRow();
            String tabel_klik=(tblProduk.getModel().getValueAt(row, 0).toString());
            String sql="select * from produk where ProdukID='"+tabel_klik+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if (rst.next()) {
            idproduk=rst.getString(("ProdukID"));    
            String stok=rst.getString(("Stok"));
            inputstok= Integer.parseInt(stok);
            harga=rst.getString(("Harga"));
            inputharga= Integer.parseInt(harga);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProdukMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnbaru;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncari;
    private javax.swing.JLabel idproduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTable tblpenjualan;
    private javax.swing.JTextField txtIdPenjualan;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtidproduk;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtwaktu;
    // End of variables declaration//GEN-END:variables
}

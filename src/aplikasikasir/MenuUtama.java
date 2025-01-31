/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasikasir;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author OWNER
 */
public class MenuUtama extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst;
ResultSet rst;
    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.koneksiDB();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        txtJam = new javax.swing.JTextField();
        txtJam1 = new javax.swing.JTextField();
        btnPelanggan = new javax.swing.JButton();
        btnProduk = new javax.swing.JButton();
        btnPenjualan = new javax.swing.JButton();
        Register = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtJam2 = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        btnPelanggan1 = new javax.swing.JButton();
        btnProduk1 = new javax.swing.JButton();
        btnPenjualan1 = new javax.swing.JButton();
        FormLogin = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        Usernam = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        HakAkses = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        cmbHakAkses = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JButton();
        btnMasuk = new javax.swing.JButton();
        LblUser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Beranda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        Login = new javax.swing.JMenuItem();
        Master = new javax.swing.JMenu();
        Produk = new javax.swing.JMenuItem();
        Pelanggan = new javax.swing.JMenuItem();
        Transaksi = new javax.swing.JMenu();
        Penjualan = new javax.swing.JMenuItem();
        Laporan = new javax.swing.JMenu();
        Tentang = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        btnPelanggan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-customer-20.png")); // NOI18N
        btnPelanggan.setText("Pelanggan");
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });

        btnProduk.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-product-20.png")); // NOI18N
        btnProduk.setText("Produk");

        btnPenjualan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-sale-15.png")); // NOI18N
        btnPenjualan.setText("Penjualan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtJam1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnPelanggan)
                .addGap(89, 89, 89)
                .addComponent(btnProduk)
                .addGap(70, 70, 70)
                .addComponent(btnPenjualan)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPelanggan)
                    .addComponent(btnProduk)
                    .addComponent(btnPenjualan))
                .addGap(39, 39, 39))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Register.setBackground(new java.awt.Color(153, 153, 255));
        Register.setForeground(new java.awt.Color(204, 204, 255));

        btnRegister.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-add-32.png")); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        btnPelanggan1.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-customer-20.png")); // NOI18N
        btnPelanggan1.setText("Pelanggan");
        btnPelanggan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelanggan1ActionPerformed(evt);
            }
        });

        btnProduk1.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-product-20.png")); // NOI18N
        btnProduk1.setText("Produk");
        btnProduk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduk1ActionPerformed(evt);
            }
        });

        btnPenjualan1.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-sale-15.png")); // NOI18N
        btnPenjualan1.setText("Penjualan");

        FormLogin.setVisible(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-login-70.png")); // NOI18N
        jLabel2.setText("LOGIN DISINI");

        Usernam.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-username-20.png")); // NOI18N
        Usernam.setText("Username");

        Password.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-password-20.png")); // NOI18N
        Password.setText("Password");

        HakAkses.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-access-rights-20.png")); // NOI18N
        HakAkses.setText("Hak Akses");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        cmbHakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Salah Satu-", "Admin", "Petugas", " " }));

        btnBatal.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-cancel-20.png")); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnMasuk.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-enter-32.png")); // NOI18N
        btnMasuk.setText("MASUK");
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormLoginLayout = new javax.swing.GroupLayout(FormLogin.getContentPane());
        FormLogin.getContentPane().setLayout(FormLoginLayout);
        FormLoginLayout.setHorizontalGroup(
            FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLoginLayout.createSequentialGroup()
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FormLoginLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(Usernam))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormLoginLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(Password)))
                    .addGroup(FormLoginLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(HakAkses)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbHakAkses, 0, 179, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FormLoginLayout.createSequentialGroup()
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormLoginLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnBatal)
                        .addGap(87, 87, 87)
                        .addComponent(btnMasuk))
                    .addGroup(FormLoginLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        FormLoginLayout.setVerticalGroup(
            FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormLoginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usernam)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HakAkses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(FormLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMasuk))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJam2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnPelanggan1)
                        .addGap(60, 60, 60)
                        .addComponent(btnProduk1)
                        .addGap(79, 79, 79)
                        .addComponent(btnPenjualan1)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(FormLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPelanggan1)
                    .addComponent(btnProduk1)
                    .addComponent(btnPenjualan1))
                .addGap(72, 72, 72))
        );

        LblUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LblUser.setText("Silahkan Login Disini!!!");

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterLayout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(LblUser)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(LblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addGap(64, 64, 64))
        );

        Beranda.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-home-20 (1).png")); // NOI18N
        Beranda.setText("Beranda");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-register-15.png")); // NOI18N
        jMenuItem1.setText("Register");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Beranda.add(jMenuItem1);

        Logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-logout-15.png")); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Beranda.add(Logout);

        Login.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-login-20 (2).png")); // NOI18N
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Beranda.add(Login);

        jMenuBar1.add(Beranda);

        Master.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-master-20.png")); // NOI18N
        Master.setText("Master");

        Produk.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-product-15.png")); // NOI18N
        Produk.setText("Produk");
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        Master.add(Produk);

        Pelanggan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-customer-15.png")); // NOI18N
        Pelanggan.setText("Pelanggan");
        Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PelangganActionPerformed(evt);
            }
        });
        Master.add(Pelanggan);

        jMenuBar1.add(Master);

        Transaksi.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-transaction-20.png")); // NOI18N
        Transaksi.setText("Transaksi");

        Penjualan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-sale-15.png")); // NOI18N
        Penjualan.setText("Penjualan");
        Transaksi.add(Penjualan);

        jMenuBar1.add(Transaksi);

        Laporan.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-report-20.png")); // NOI18N
        Laporan.setText("Laporan");
        jMenuBar1.add(Laporan);

        Tentang.setIcon(new javax.swing.ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-about-20.png")); // NOI18N
        Tentang.setText("Tentang");
        jMenuBar1.add(Tentang);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
        btnPelanggan :new FormPelanggan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PelangganActionPerformed
        pelanggan: new FormPelanggan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_PelangganActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        Login: FormLogin.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Logout: new MenuUtama().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Register: new FormRegister().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        try {
            String sql = "select *from login where Username='"+txtUsername.getText()+"' and Password='"+txtPassword.getText()+"' and HakAkses='" +cmbHakAkses.getSelectedItem()+"'";
            pst = konek.prepareStatement(sql);
            rst = pst.executeQuery();
            if(rst.next()){
                if(txtUsername.getText().equals(rst.getString("Username"))&& txtPassword.getText().equals(rst.getString("Password"))&& cmbHakAkses.getSelectedItem().equals(rst.getString("HakAKses"))
                );
                if(cmbHakAkses.getSelectedItem().equals("admin")) {
                    Register.setEnabled(true);
                    Logout.setEnabled(true);
                    Master.setEnabled(true);
                    Transaksi.setEnabled(true);
                    Laporan.setEnabled(true);
                    btnRegister.setEnabled(true);
                    btnProduk1.setEnabled(true);
                    btnPelanggan.setEnabled(true);
                    btnPenjualan1.setEnabled(true);
                    txtJam2.setEnabled(false);
                    txtTanggal.setEnabled(false);
                    FormLogin.setVisible(false);
                } else if (cmbHakAkses.getSelectedItem().equals("petugas")) {
                    Register.setEnabled(true);
                    Logout.setEnabled(true);
                    Master.setEnabled(true);
                    Transaksi.setEnabled(true);
                    Laporan.setEnabled(true);
                    btnRegister.setEnabled(true);
                    btnProduk.setEnabled(true);
                    btnPelanggan.setEnabled(true);
                    btnPenjualan.setEnabled(true);
                    txtJam.setEnabled(false);
                    txtTanggal.setEnabled(false);
                    FormLogin.setVisible(false);
                }
                {
                    JOptionPane.showMessageDialog(null, "Selamat Datang '"+txtUsername.getText()+"'");
                    String text = txtUsername.getText();
                    LblUser.setText("Selamat Datang, "+text);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Gagal Masuk. Periksa Kembali Username/Password/Hak Akses");
                txtUsername.setText("");
                txtPassword.setText("");
                cmbHakAkses.setSelectedItem("-Pilih Salah Satu-");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi");
        }
    }//GEN-LAST:event_btnMasukActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        btnBatal :new MenuUtama().setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnPelanggan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelanggan1ActionPerformed
        btnPelanggan :new FormPelanggan().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnPelanggan1ActionPerformed

    private void btnProduk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduk1ActionPerformed
        Produk: new FormProduk().setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_btnProduk1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Register: new FormRegister().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        Produk: new FormProduk().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_ProdukActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Beranda;
    private javax.swing.JInternalFrame FormLogin;
    private javax.swing.JLabel HakAkses;
    private javax.swing.JMenu Laporan;
    private javax.swing.JLabel LblUser;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenu Master;
    private javax.swing.JLabel Password;
    private javax.swing.JMenuItem Pelanggan;
    private javax.swing.JMenuItem Penjualan;
    private javax.swing.JMenuItem Produk;
    private javax.swing.JPanel Register;
    private javax.swing.JMenu Tentang;
    private javax.swing.JMenu Transaksi;
    private javax.swing.JLabel Usernam;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPelanggan1;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnPenjualan1;
    private javax.swing.JButton btnProduk;
    private javax.swing.JButton btnProduk1;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbHakAkses;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtJam1;
    private javax.swing.JTextField txtJam2;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

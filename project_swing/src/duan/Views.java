/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Toan
 */
public class Views extends javax.swing.JFrame {

    /**
     * Creates new form Views
     */
    Connection cnt = null;

    private String UserName;

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Views() {
        initComponents();
        setTitle("Yellow Team");
        setLocationRelativeTo(null);
        setResizable(false);
        HideButton(false);
        Lb_welcome.setVisible(false);
//        Btn_Dangxuat.setVisible(false);
        getRootPane().setDefaultButton(Btn_Dangnhap);
    }

    private void HideButton(boolean status) {
        Btn_Thongtin.setEnabled(status);
        Btn_QLLSNX.setEnabled(status);
        Btn_Dangxuat.setEnabled(status);
        Btn_Doimatkhau.setEnabled(status);
        Btn_QLSP.setEnabled(status);
        Btn_Ktht.setEnabled(status);
        Btn_Nhaphang.setEnabled(status);
        Btn_Thaydoithongtin.setEnabled(status);
        Btn_QLLH.setEnabled(status);
        Btn_QLNCC.setEnabled(status);
        Btn_Xuathang.setEnabled(status);
        Btn_QLTK.setEnabled(status);
        Btn_QLKH.setEnabled(status);
    }

    private void HideLogin(boolean status) {
//        Lb_Tendangnhap.setVisible(status);
//        Lb_Matkhau.setVisible(status);
//        Txt_Username.setVisible(status);
//        Txt_Password.setVisible(status);
//        Btn_Dangnhap.setVisible(status);
//        Btn_Huy.setVisible(status);
//        Txt_Username.setVisible(status);
//        Txt_Password.setVisible(status);
        Login.setVisible(status);
    }

    public void check_login() {
        String username = Txt_Username.getText();
        String password = Txt_Password.getText();

        boolean Status = new Model.checkLogin().Model_CheckLogin(username, password);
        if (Status == true) {
            Lb_welcome.setVisible(true);
            setUserName(username);
            int UserType = new Model.checkLogin().Model_GetUserType(username);
            if (UserType == 1) {
                HideButton(true);
                HideLogin(false);
                Btn_Thaydoithongtin.setEnabled(false);
            } else {
                HideButton(true);
                Btn_QLTK.setEnabled(false);
                Btn_QLLSNX.setEnabled(false);
                HideLogin(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        HeThong = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Btn_Dangxuat = new javax.swing.JButton();
        Btn_Thongtin = new javax.swing.JButton();
        Btn_Thaydoithongtin = new javax.swing.JButton();
        Btn_Doimatkhau = new javax.swing.JButton();
        DanhMuc = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Btn_QLLH = new javax.swing.JButton();
        Btn_QLNCC = new javax.swing.JButton();
        Btn_QLLSNX = new javax.swing.JButton();
        Btn_QLSP = new javax.swing.JButton();
        Btn_QLTK = new javax.swing.JButton();
        Btn_QLKH = new javax.swing.JButton();
        ChucNang = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Btn_Nhaphang = new javax.swing.JButton();
        Btn_Xuathang = new javax.swing.JButton();
        Btn_Ktht = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        Lb_Main = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();
        Lb_welcome = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        Lb_Tendangnhap = new javax.swing.JLabel();
        Lb_Matkhau = new javax.swing.JLabel();
        Txt_Username = new javax.swing.JTextField();
        Txt_Password = new javax.swing.JPasswordField();
        Btn_Dangnhap = new javax.swing.JButton();
        Btn_Huy = new javax.swing.JButton();
        Footer = new javax.swing.JPanel();
        Btn_Thoat = new javax.swing.JButton();
        Lb_Copyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeThong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 204));
        jLabel5.setText("Hệ Thống");

        Btn_Dangxuat.setText("Đăng xuất");
        Btn_Dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DangxuatActionPerformed(evt);
            }
        });

        Btn_Thongtin.setText("Thông tin");
        Btn_Thongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ThongtinActionPerformed(evt);
            }
        });

        Btn_Thaydoithongtin.setText("Thay đổi thông tin");
        Btn_Thaydoithongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ThaydoithongtinActionPerformed(evt);
            }
        });

        Btn_Doimatkhau.setText("Đổi mật khẩu");
        Btn_Doimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DoimatkhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeThongLayout = new javax.swing.GroupLayout(HeThong);
        HeThong.setLayout(HeThongLayout);
        HeThongLayout.setHorizontalGroup(
            HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeThongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(Btn_Dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Thongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Thaydoithongtin, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(Btn_Doimatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        HeThongLayout.setVerticalGroup(
            HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeThongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(Btn_Dangxuat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Thongtin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Thaydoithongtin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Doimatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        DanhMuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 255));
        jLabel6.setText("Danh mục");

        Btn_QLLH.setText("Quản lý loại hàng");
        Btn_QLLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QLLHActionPerformed(evt);
            }
        });

        Btn_QLNCC.setText("Quản lý nhà cung cấp");
        Btn_QLNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QLNCCActionPerformed(evt);
            }
        });

        Btn_QLLSNX.setText("Lịch sử nhập xuất");
        Btn_QLLSNX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QLLSNXActionPerformed(evt);
            }
        });

        Btn_QLSP.setText("Quản lý sản phẩm");
        Btn_QLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QLSPActionPerformed(evt);
            }
        });

        Btn_QLTK.setText("Quản lý tài khoản");
        Btn_QLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QLTKActionPerformed(evt);
            }
        });

        Btn_QLKH.setText("Quản lý Khách Hàng");
        Btn_QLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_QLKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DanhMucLayout = new javax.swing.GroupLayout(DanhMuc);
        DanhMuc.setLayout(DanhMucLayout);
        DanhMucLayout.setHorizontalGroup(
            DanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(Btn_QLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_QLNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_QLLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_QLLSNX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_QLTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_QLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DanhMucLayout.setVerticalGroup(
            DanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_QLTK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_QLLH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_QLSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_QLNCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_QLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_QLLSNX)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ChucNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 255));
        jLabel7.setText("Chức năng");

        Btn_Nhaphang.setText("Nhập hàng");
        Btn_Nhaphang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NhaphangActionPerformed(evt);
            }
        });

        Btn_Xuathang.setText("Xuất hàng");
        Btn_Xuathang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_XuathangActionPerformed(evt);
            }
        });

        Btn_Ktht.setText("Kiểm tra hàng tồn");

        javax.swing.GroupLayout ChucNangLayout = new javax.swing.GroupLayout(ChucNang);
        ChucNang.setLayout(ChucNangLayout);
        ChucNangLayout.setHorizontalGroup(
            ChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(Btn_Nhaphang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Xuathang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Ktht, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChucNangLayout.setVerticalGroup(
            ChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Nhaphang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Xuathang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Ktht)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HeThong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChucNang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, -1));

        Lb_Main.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Lb_Main.setForeground(new java.awt.Color(0, 0, 255));
        Lb_Main.setText("Quản lý kho hàng ");

        Content.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Lb_welcome.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        Lb_welcome.setForeground(new java.awt.Color(0, 102, 204));
        Lb_welcome.setText("DEVELOPED BY YELLOW TEAM");

        Lb_Tendangnhap.setText("Tên đăng nhập");

        Lb_Matkhau.setText("Mật khẩu");

        Btn_Dangnhap.setText("Đăng nhập");
        Btn_Dangnhap.setToolTipText("Đăng nhập vào hệ thống");
        Btn_Dangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DangnhapActionPerformed(evt);
            }
        });

        Btn_Huy.setText("Hủy");
        Btn_Huy.setToolTipText("Hủy thao tác");
        Btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lb_Tendangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_Matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addComponent(Btn_Dangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txt_Password)
                    .addComponent(Txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lb_Tendangnhap)
                    .addComponent(Txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lb_Matkhau)
                    .addComponent(Txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Dangnhap)
                    .addComponent(Btn_Huy))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(Lb_welcome)
                .addGap(73, 73, 73))
            .addGroup(ContentLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Lb_welcome)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(Lb_Main)
                .addGap(96, 96, 96))
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Lb_Main)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 600, -1));

        Btn_Thoat.setText("Thoát");
        Btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ThoatActionPerformed(evt);
            }
        });

        Lb_Copyright.setForeground(new java.awt.Color(153, 153, 0));
        Lb_Copyright.setText("Sản phẩm quản lý kho hàng được thiết kế bới Yellow Team");

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(Lb_Copyright)
                .addGap(159, 159, 159))
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Thoat)
                    .addComponent(Lb_Copyright))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 800, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Btn_ThoatActionPerformed

    private void Btn_QLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QLTKActionPerformed
        new QLTaiKhoan(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_QLTKActionPerformed

    private void Btn_QLLSNXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QLLSNXActionPerformed
        Object[] option = {"Lịch sử nhập hàng","Lịch sử xuất hàng"};
        
        int n = JOptionPane.showOptionDialog(null, "Bạn muốn xem lịch sử nhập hàng hay xuất", 
                "Mời bạn lựa chọn", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, option, option[1]);

        if (n == 0){
            new LSnhaphang(this,true).setVisible(true);
        } else if (n == 1){
            new LSxuathang(this,true).setVisible(true);
        }
    }//GEN-LAST:event_Btn_QLLSNXActionPerformed

    private void Btn_QLLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QLLHActionPerformed
        new QLLoaiHang(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_QLLHActionPerformed

    private void Btn_ThongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ThongtinActionPerformed
        new ThongTinUser(this, true, UserName).setVisible(true);
    }//GEN-LAST:event_Btn_ThongtinActionPerformed

    private void Btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HuyActionPerformed
        Txt_Username.setText("");
        Txt_Password.setText("");
    }//GEN-LAST:event_Btn_HuyActionPerformed

    private void Btn_DoimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DoimatkhauActionPerformed
        new DoiMatKhau(this, true, UserName).setVisible(true);
    }//GEN-LAST:event_Btn_DoimatkhauActionPerformed

    private void Btn_DangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DangnhapActionPerformed
        if (Txt_Username.getText().isEmpty() | Txt_Password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn không được bỏ trống ô");
        } else {
            check_login();
        }
    }//GEN-LAST:event_Btn_DangnhapActionPerformed

    private void Btn_QLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QLSPActionPerformed
        new QLSanPham(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_QLSPActionPerformed

    private void Btn_DangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DangxuatActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?",
                "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            Txt_Username.setText("");
            Txt_Password.setText("");
            Lb_welcome.setVisible(false);
            HideButton(false);
            HideLogin(true);
        }
    }//GEN-LAST:event_Btn_DangxuatActionPerformed

    private void Btn_QLNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QLNCCActionPerformed
        new QLNhaCC(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_QLNCCActionPerformed

    private void Btn_ThaydoithongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ThaydoithongtinActionPerformed
        int UserType = new Model.checkLogin().Model_GetUserType(UserName);
        new DoiThongTin(this, true, UserName, UserType).setVisible(true);
    }//GEN-LAST:event_Btn_ThaydoithongtinActionPerformed

    private void Btn_NhaphangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NhaphangActionPerformed
        new Phieunhap(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_NhaphangActionPerformed

    private void Btn_XuathangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_XuathangActionPerformed
        new Phieuxuat(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_XuathangActionPerformed

    private void Btn_QLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_QLKHActionPerformed
        new QLKhachHang(this, true).setVisible(true);
    }//GEN-LAST:event_Btn_QLKHActionPerformed

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
            java.util.logging.Logger.getLogger(Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Views.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Views().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Dangnhap;
    private javax.swing.JButton Btn_Dangxuat;
    private javax.swing.JButton Btn_Doimatkhau;
    private javax.swing.JButton Btn_Huy;
    private javax.swing.JButton Btn_Ktht;
    private javax.swing.JButton Btn_Nhaphang;
    private javax.swing.JButton Btn_QLKH;
    private javax.swing.JButton Btn_QLLH;
    private javax.swing.JButton Btn_QLLSNX;
    private javax.swing.JButton Btn_QLNCC;
    private javax.swing.JButton Btn_QLSP;
    private javax.swing.JButton Btn_QLTK;
    private javax.swing.JButton Btn_Thaydoithongtin;
    private javax.swing.JButton Btn_Thoat;
    private javax.swing.JButton Btn_Thongtin;
    private javax.swing.JButton Btn_Xuathang;
    private javax.swing.JPanel ChucNang;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel DanhMuc;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel HeThong;
    private javax.swing.JLabel Lb_Copyright;
    private javax.swing.JLabel Lb_Main;
    private javax.swing.JLabel Lb_Matkhau;
    private javax.swing.JLabel Lb_Tendangnhap;
    private javax.swing.JLabel Lb_welcome;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Menu;
    private javax.swing.JPasswordField Txt_Password;
    private javax.swing.JTextField Txt_Username;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}

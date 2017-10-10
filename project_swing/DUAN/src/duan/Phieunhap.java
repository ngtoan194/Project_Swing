/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan;

import connectDB.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Phieunhap extends javax.swing.JDialog {

    Connection cnt = new connectDB().getConnection();
    DefaultTableModel tblModel;
    Vector<String> colHeaders;
    Vector<String> row;
    Vector<Vector> data;

    public Phieunhap(JFrame parent,boolean modal) {
        super(parent,modal);
        initComponents();
        loadTbl();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Phiếu nhập kho");
        loadNhaCC();
    }
    private void loadTbl(){
        colHeaders = new Vector<>();
        colHeaders.add("Mã phiếu nhập");
        colHeaders.add("Tên sản phẩm ");
        colHeaders.add("Loại hàng");
        colHeaders.add("Nhà cung cấp");
        colHeaders.add("Ngày nhập");
        colHeaders.add("Nhân viên");
        colHeaders.add("Đơn giá");
        colHeaders.add("Số lượng");
        colHeaders.add("Thành tiền");
        row = new Vector<>();
        data = new Vector<>();
        tblModel = new DefaultTableModel(data, colHeaders);
        tblPhieuNhap.setModel(tblModel);
        
    }
    private void loadNhaCC() {
        try {
            try (PreparedStatement stm = cnt.prepareStatement("SELECT MANHACC FROM NHACC")) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    cbCC.addItem(rs.getString(1));
                }
                rs.close();
                stm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Phieunhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void loadLH() {
        try {
            cbLH.removeAllItems();
            cbLH.addItem("----------------Chọn----------------");
            Statement stm = cnt.createStatement();
            String sql = "SELECT tenLH from LoaiHang inner join ccLoaiHang on LoaiHang.maLH=ccLoaiHang.maLH"
                    + " where ccLoaiHang.maNhaCC=N'" + cbCC.getSelectedItem()+ "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cbLH.addItem(rs.getString(1));
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Phieunhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSP() {
        try {
            cbHH.removeAllItems();
            cbHH.addItem("----------------Chọn----------------");
            String sql = "select tenSP from SanPham inner join LoaiHang on "
                    + "SanPham.maLH = LoaiHang.maLH where maNhaCC = N'"
                    + this.cbCC.getSelectedItem() + "' and tenLH = N'"
                    + this.cbLH.getSelectedItem()+ "'";
            PreparedStatement ps = cnt.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.cbHH.addItem(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ád");
        }
    }
    private void loadPN(){
        txtMaNK.setText("");
        txtMaNK.enable();
        cbCC.setSelectedIndex(0);
        cbLH.setSelectedIndex(0);
        cbCC.enable();
        cbHH.setSelectedIndex(0);
        txtNgay.setText("");
        txtGia.setText("");
        txtNV.setText("");
        spSL.setValue(0);
        txtVAT.setText("");
        lbTT.setText("0");
        lbHD.setText("0");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        screenChinh = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMaNK = new javax.swing.JTextField();
        txtNV = new javax.swing.JTextField();
        txtNgay = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        spSL = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        txtVAT = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbCC = new javax.swing.JComboBox<>();
        lbTT = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbHH = new javax.swing.JComboBox<>();
        cbLH = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        lbHD = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btTinh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btLuu = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        btNhap = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        screenChinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu nhập kho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 32))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Mã phiếu nhập");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Nhà cung cấp ");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Loại hàng");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Tên sản phẩm");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Ngày nhập");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setText("Đơn giá ");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Nhân viên");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Số lượng");

        txtMaNK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaNKMouseClicked(evt);
            }
        });
        txtMaNK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNKActionPerformed(evt);
            }
        });

        txtNV.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtNgay.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayMouseClicked(evt);
            }
        });

        txtGia.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGiaMouseClicked(evt);
            }
        });
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        spSL.setFont(new java.awt.Font("Times New Roman", 1, 12));
        spSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spSLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                spSLMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spSLMousePressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Thuế VAT");

        txtVAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVATMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Thành Tiền");

        cbCC.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------Chọn----------------" }));
        cbCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCCActionPerformed(evt);
            }
        });

        lbTT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTT.setText("0");
        lbTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTTMouseClicked(evt);
            }
        });
        lbTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbTTKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setText("$");

        cbHH.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbHH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------Chọn----------------" }));
        cbHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHHActionPerformed(evt);
            }
        });

        cbLH.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbLH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------Chọn----------------", "Quần Áo" }));
        cbLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLHActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setText("Tổng hóa đơn");

        lbHD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbHD.setText("0");
        lbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHDMouseClicked(evt);
            }
        });
        lbHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbHDKeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setText("$");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("$");

        btTinh.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btTinh.setText("Tính tiền");
        btTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbHH, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbLH, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaNK))
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(txtNV, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(spSL, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbHD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(txtMaNK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel19)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)
                                .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spSL)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel21)
                                .addComponent(cbLH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lbHD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Phập", "Mã Hàng Hóa", "Nhà cung cấp", "Nhân viên", "Ngày nhập", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);
        if (tblPhieuNhap.getColumnModel().getColumnCount() > 0) {
            tblPhieuNhap.getColumnModel().getColumn(7).setResizable(false);
        }

        btLuu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btLuu.setText("Lưu & In");
        btLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuActionPerformed(evt);
            }
        });

        btHuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btHuy.setText("Hủy bỏ");
        btHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyActionPerformed(evt);
            }
        });

        btNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btNhap.setText("Nhập");
        btNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btLuu)
                .addGap(39, 39, 39)
                .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout screenChinhLayout = new javax.swing.GroupLayout(screenChinh);
        screenChinh.setLayout(screenChinhLayout);
        screenChinhLayout.setHorizontalGroup(
            screenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(screenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenChinhLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)
                    .addGroup(screenChinhLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        screenChinhLayout.setVerticalGroup(
            screenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenChinhLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(screenChinh, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayMouseClicked
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy ");
        String show = format.format(time.getTime());
        txtNgay.setText(show);
    }//GEN-LAST:event_txtNgayMouseClicked

    private void txtGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaMouseClicked
        String hh = (String) cbHH.getSelectedItem();
        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("Select CAST(GiaNhap AS int) from SanPham Where tenSP='" + hh + "'");
            while (rs.next()) {
                String gia = rs.getString(1);
                txtGia.setText(gia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Có lỗi khi Lấy dữ liệu từ database!");
        }
    }//GEN-LAST:event_txtGiaMouseClicked

    private void txtMaNKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNKMouseClicked
        Random rd = new Random();
        String ma = "PN" + String.valueOf(rd.nextInt(100000));
        txtMaNK.setText(ma);
        txtMaNK.enable(false);
    }//GEN-LAST:event_txtMaNKMouseClicked
    private void btNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapActionPerformed
         Vector<String> ob = new Vector<>();
                ob.add(txtMaNK.getText());
                ob.add(cbHH.getSelectedItem().toString());
                ob.add(cbLH.getSelectedItem().toString());
                ob.add(cbCC.getSelectedItem().toString());
                ob.add(txtNgay.getText());
                ob.add(txtNV.getText());
                ob.add(txtGia.getText());
                ob.add(spSL.getValue().toString());                
                ob.add(lbTT.getText());
                data.add(ob);
                tblPhieuNhap.updateUI();
                double tong=Double.parseDouble(lbHD.getText())+Double.parseDouble(lbTT.getText());
                lbHD.setText(String.valueOf(tong));
        lbTT.setText("0");
    }//GEN-LAST:event_btNhapActionPerformed

    private void spSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSLMouseClicked
    }//GEN-LAST:event_spSLMouseClicked

    private void spSLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSLMouseEntered

    }//GEN-LAST:event_spSLMouseEntered

    private void spSLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSLMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_spSLMousePressed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        try {
            Statement stm=cnt.createStatement();
            String sql="Select GiaNhap from SanPham where tenSP='+"+cbHH.getSelectedItem()+"'";
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
                txtGia.setText(rs.getString(sql));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Phieunhap.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_txtGiaActionPerformed

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
      try{
          Statement stm=cnt.createStatement();
          String sql="EXEC spPhieuNhap '"+tblPhieuNhap.getValueAt(0,0).toString()+"','"
              +tblPhieuNhap.getValueAt(0,5).toString()+"','"+tblPhieuNhap.getValueAt(0,3).toString()+
              "','"+tblPhieuNhap.getValueAt(0,4).toString()+"'";
          int count=stm.executeUpdate(sql); 
          for(int i = 0;i<=tblPhieuNhap.getRowCount();i++){ 
          String sql1="Exec spPhieuNhapCT '"+tblPhieuNhap.getValueAt(i,0).toString()+"',N'"+tblPhieuNhap.getValueAt(i,1).toString()+"','"
              +tblPhieuNhap.getValueAt(i,7)+"','"+tblPhieuNhap.getValueAt(i,6)+"','"+tblPhieuNhap.getValueAt(i,8)+"'";
          int count1=stm.executeUpdate(sql1);
          }
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Lỗi!");       
      }catch(Exception ex){          
      }
          JOptionPane.showMessageDialog(rootPane,"Thành công!");
          loadTbl();
          loadPN();
    }//GEN-LAST:event_btLuuActionPerformed

    private void cbCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCCActionPerformed
        loadLH();        
        cbCC.enable(false);
    }//GEN-LAST:event_cbCCActionPerformed
    private void spSLActionPerformed(java.awt.event.ActionEvent evt) {
        double ttien = spSL.getValue().hashCode() * Double.parseDouble(txtGia.getText()) + Double.parseDouble(txtVAT.getText());
        lbTT.setText(String.valueOf(ttien));
    }
    private void cbHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHHActionPerformed

    }//GEN-LAST:event_cbHHActionPerformed

    private void cbLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLHActionPerformed
        loadSP();
    }//GEN-LAST:event_cbLHActionPerformed

    private void txtMaNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNKActionPerformed

    private void btHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyActionPerformed
////      txtMaNK.enable();
////      cbCC.enable();
////      loadPN();
////      loadTbl();  
//    JOptionPane.showMessageDialog(rootPane,txtMaNK.getText());
//    JOptionPane.showMessageDialog(rootPane,txtGia.getText());
//    JOptionPane.showMessageDialog(rootPane,txtNV.getText());
//    JOptionPane.showMessageDialog(rootPane,txtVAT.getText());
//    JOptionPane.showMessageDialog(rootPane,txtNgay.getText());
//    JOptionPane.showMessageDialog(rootPane,cbCC.getSelectedItem().toString());
//    JOptionPane.showMessageDialog(rootPane,cbLH.getSelectedItem().toString());
//    JOptionPane.showMessageDialog(rootPane,cbHH.getSelectedItem().toString());
//    JOptionPane.showMessageDialog(rootPane,spSL.getValue().hashCode());
    loadPN();
    loadTbl();
    }//GEN-LAST:event_btHuyActionPerformed

    private void lbTTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbTTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTTKeyPressed

    private void lbTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTTMouseClicked

    }//GEN-LAST:event_lbTTMouseClicked

    private void txtVATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVATMouseClicked
    txtVAT.setText("0");
    }//GEN-LAST:event_txtVATMouseClicked

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        int row = tblPhieuNhap.getSelectedRow();
        String id = tblPhieuNhap.getValueAt(row, 0).toString();      
        data.remove(tblPhieuNhap.getSelectedRow());
        tblPhieuNhap.updateUI();
    }//GEN-LAST:event_btXoaActionPerformed

    private void lbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbHDMouseClicked

    private void lbHDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbHDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbHDKeyPressed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        this.cbCC.setSelectedItem(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(), 3));
        this.cbLH.setSelectedItem(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(), 2));
        this.cbHH.setSelectedItem(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(),1));
        txtNgay.setText(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(),4).toString());
        txtNV.setText(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(),5).toString());
        txtGia.setText(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(),6).toString());
        spSL.setValue(Double.parseDouble(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(),7).toString()));
        lbTT.setText(tblPhieuNhap.getValueAt(tblPhieuNhap.getSelectedRow(),8).toString());
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void btTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTinhActionPerformed
        double ttien = spSL.getValue().hashCode() * Double.parseDouble(txtGia.getText()) +
                Double.parseDouble(txtVAT.getText());  
        lbTT.setText(String.valueOf(ttien)); 
    }//GEN-LAST:event_btTinhActionPerformed
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Phieunhap().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btNhap;
    private javax.swing.JButton btTinh;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbCC;
    private javax.swing.JComboBox<String> cbHH;
    private javax.swing.JComboBox<String> cbLH;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHD;
    private javax.swing.JLabel lbTT;
    private javax.swing.JPanel screenChinh;
    private javax.swing.JSpinner spSL;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaNK;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
}

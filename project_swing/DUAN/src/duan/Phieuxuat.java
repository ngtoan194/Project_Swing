
package duan;

import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Phieuxuat extends javax.swing.JDialog {
   Connection cnt = new connectDB.connectDB().getConnection();
    DefaultTableModel tblModel;
    Vector<String> colHeaders;
    Vector<String> row;
    Vector<Vector> data;

    public Phieuxuat(JFrame parent,boolean modal) {
        super(parent,modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Phiếu xuất kho");
        loadTbl();
        loadNhaCC();
    }
        private void loadTbl(){
        colHeaders = new Vector<>();
        colHeaders.add("Mã phiếu xuất");
        colHeaders.add("Tên sản phẩm ");
        colHeaders.add("Loại hàng");
        colHeaders.add("Nhà cung cấp");
        colHeaders.add("Ngày nhập");
        colHeaders.add("Nhân viên");
        colHeaders.add("Khách hàng");
        colHeaders.add("Đơn giá");
        colHeaders.add("Số lượng");
        colHeaders.add("Thành tiền");
        row = new Vector<>();
        data = new Vector<>();
        tblModel = new DefaultTableModel(data, colHeaders);
        tblPhieuXuat.setModel(tblModel);
        
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
            JOptionPane.showMessageDialog(this, "Lỗi!");
        }
    }
    private void loadPX(){
        txtMaNK.setText("");
        txtMaNK.enable();
        cbCC.setSelectedIndex(0);
        cbCC.enable();
        cbLH.setSelectedIndex(0);
        cbHH.setSelectedIndex(0);
        txtNgay.setText("");
        txtGia.setText("");
        txtNV.setText("");
        spSL.setValue(0);
        txtVAT.setText("");
        lbTT.setText("0");
        lbHD.setText("0");
        txtKH.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        screenChinh = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuXuat = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btNhap = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        btLuu1 = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        txtKH = new javax.swing.JTextField();
        btTinh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        screenChinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu xuất kho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 32))); // NOI18N

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPhieuXuat);
        if (tblPhieuXuat.getColumnModel().getColumnCount() > 0) {
            tblPhieuXuat.getColumnModel().getColumn(7).setResizable(false);
        }

        btNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btNhap.setText("Nhập");
        btNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapActionPerformed(evt);
            }
        });

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

        btLuu1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btLuu1.setText("Xóa");
        btLuu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
        jLabel18.setText("Ngày xuất");

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
        txtNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Khách hàng");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(txtNV)
                        .addComponent(txtNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addComponent(spSL, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbHD, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(lbTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(38, 38, 38)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel25))
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtKH))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(txtMaNK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel19)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spSL, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel21)
                                .addComponent(cbLH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel20)
                        .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbHH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(lbHD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout screenChinhLayout = new javax.swing.GroupLayout(screenChinh);
        screenChinh.setLayout(screenChinhLayout);
        screenChinhLayout.setHorizontalGroup(
            screenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(screenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(screenChinhLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 468, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenChinhLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        screenChinhLayout.setVerticalGroup(
            screenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenChinhLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
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
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(screenChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
      try{
      Statement stm=cnt.createStatement();
          String sql="EXEC spPhieuXuat '"+tblPhieuXuat.getValueAt(0,0).toString()+"','"
              +tblPhieuXuat.getValueAt(0,5).toString()+"',N'"+tblPhieuXuat.getValueAt(0,6).toString()+
              "','"+tblPhieuXuat.getValueAt(0,4).toString()+"'";
      int count=stm.executeUpdate(sql);   
      for(int i = 0;i<=tblPhieuXuat.getRowCount();i++){    
      String sql1="Exec spPhieuXuatCT '"+tblPhieuXuat.getValueAt(i,0)+"',N'"+tblPhieuXuat.getValueAt(i,1)+"','"
              +tblPhieuXuat.getValueAt(i,8)+"','"+tblPhieuXuat.getValueAt(i,7)+"','"+tblPhieuXuat.getValueAt(i,9)+"'";
      int count1=stm.executeUpdate(sql1);
      }
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Lỗi!");
      } catch(Exception ex){          
      }
      loadTbl();
      loadPX();
      JOptionPane.showMessageDialog(this,"Thành công!");
    }//GEN-LAST:event_btLuuActionPerformed

    private void txtMaNKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNKMouseClicked
        Random rd = new Random();
        String ma = "PX" + String.valueOf(rd.nextInt(100000));
        txtMaNK.setText(ma);
        txtMaNK.enable(false);
    }//GEN-LAST:event_txtMaNKMouseClicked

    private void txtMaNKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNKActionPerformed

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
            ResultSet rs = stm.executeQuery("Select CAST(GiaXuat AS int) from SanPham Where tenSP='"+hh+"'");
            while (rs.next()) {
                String gia = rs.getString(1);
                txtGia.setText(gia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Có lỗi khi Lấy dữ liệu từ database!");
        }
    }//GEN-LAST:event_txtGiaMouseClicked

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed

    }//GEN-LAST:event_txtGiaActionPerformed

    private void spSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSLMouseClicked

    }//GEN-LAST:event_spSLMouseClicked

    private void spSLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSLMouseEntered
//        JOptionPane.showMessageDialog(rootPane, "hihi");
    }//GEN-LAST:event_spSLMouseEntered

    private void spSLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spSLMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_spSLMousePressed

    private void txtVATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVATMouseClicked
        txtVAT.setText("0");
    }//GEN-LAST:event_txtVATMouseClicked

    private void cbCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCCActionPerformed
        loadLH();
        cbCC.enable(false);
    }//GEN-LAST:event_cbCCActionPerformed

    private void lbTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTTMouseClicked
        
    }//GEN-LAST:event_lbTTMouseClicked

    private void lbTTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbTTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTTKeyPressed

    private void cbHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHHActionPerformed

    }//GEN-LAST:event_cbHHActionPerformed

    private void cbLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLHActionPerformed
        loadSP();
    }//GEN-LAST:event_cbLHActionPerformed

    private void lbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbHDMouseClicked

    private void lbHDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbHDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbHDKeyPressed

    private void btLuu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuu1ActionPerformed
        int row = tblPhieuXuat.getSelectedRow();
        String id = tblPhieuXuat.getValueAt(row, 0).toString();      
        data.remove(tblPhieuXuat.getSelectedRow());
        tblPhieuXuat.updateUI(); 
    }//GEN-LAST:event_btLuu1ActionPerformed
    private void btNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapActionPerformed
         Vector<String> ob = new Vector<>();
                ob.add(txtMaNK.getText());
                ob.add(cbHH.getSelectedItem().toString());
                ob.add(cbLH.getSelectedItem().toString());
                ob.add(cbCC.getSelectedItem().toString());
                ob.add(txtNgay.getText());
                ob.add(txtNV.getText());
                ob.add(txtKH.getText());
                ob.add(txtGia.getText());
                ob.add(spSL.getValue().toString());                
                ob.add(lbTT.getText());                
                data.add(ob);
                tblPhieuXuat.updateUI();
                double tong=Double.parseDouble(lbHD.getText())+Double.parseDouble(lbTT.getText());
                lbHD.setText(String.valueOf(tong));
    }//GEN-LAST:event_btNhapActionPerformed

    private void btHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyActionPerformed
        txtMaNK.enable();
        cbCC.enable();
        loadTbl();
        loadPX();
    }//GEN-LAST:event_btHuyActionPerformed

    private void txtNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayActionPerformed

    private void btTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTinhActionPerformed
        double ttien = spSL.getValue().hashCode() * Double.parseDouble(txtGia.getText()) +
        Double.parseDouble(txtVAT.getText());
        lbTT.setText(String.valueOf(ttien));
    }//GEN-LAST:event_btTinhActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Phieuxuat().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btLuu1;
    private javax.swing.JButton btNhap;
    private javax.swing.JButton btTinh;
    private javax.swing.JComboBox<String> cbCC;
    private javax.swing.JComboBox<String> cbHH;
    private javax.swing.JComboBox<String> cbLH;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtMaNK;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
}

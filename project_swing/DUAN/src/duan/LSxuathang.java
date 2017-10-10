/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan;

import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Toan
 */
public class LSxuathang extends javax.swing.JDialog {

    private Connection cnt = new connectDB.connectDB().getConnection();

    public LSxuathang(JFrame parent, boolean modal) {
        super(parent, modal);
        setTitle("Lịch Sử Xuất Hàng");
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        Loadhistory();
    }

    private void Loadhistory() {
        Vector Title = new Vector();
        Vector HisInput = new Vector();
        Title.add("ID Phiếu xuất");
        Title.add("Người bán");
        Title.add("Người mua");
        Title.add("ID Sản phẩm");
        Title.add("Số lượng");
        Title.add("Đơn giá");
        Title.add("Ngày bán");
        Title.add("Thành tiền");

        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT CTPHIEUXUAT.MAPX,HOTEN,TENKH,MASP,SOLUONG,DONGIA,NGAYXUAT,THANHTIEN FROM PHIEUXUAT INNER JOIN TAIKHOAN ON TAIKHOAN.TENTK=PHIEUXUAT.TENTK INNER JOIN CTPHIEUXUAT ON PHIEUXUAT.MAPX=CTPHIEUXUAT.MAPX INNER JOIN KHACHHANG ON KHACHHANG.MAKH=PHIEUXUAT.MAKH WHERE PHIEUXUAT.STATUS = 1 ORDER BY CTPHIEUXUAT.MAPX;");
            while (rs.next()) {
                Vector HisData = new Vector();
                HisData.add(rs.getString(1));
                HisData.add(rs.getString(2));
                HisData.add(rs.getString(3));
                HisData.add(rs.getString(4));
                HisData.add(rs.getString(5));
                HisData.add(rs.getString(6) + " $");
                HisData.add(rs.getString(7));
                HisData.add(rs.getString(8) + " $");
                HisInput.add(HisData);
            }
        } catch (Exception e) {
        }

        DefaultTableModel tblmodel = new DefaultTableModel(HisInput, Title) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        Tbl_History.setModel(tblmodel);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Txt_Search = new javax.swing.JTextField();
        Lb_Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_History = new javax.swing.JTable();
        Tb_Search = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_SearchKeyReleased(evt);
            }
        });

        Lb_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lb_Title.setForeground(new java.awt.Color(51, 102, 255));
        Lb_Title.setText("Lịch sử xuất hàng");

        Tbl_History.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tbl_History);

        Tb_Search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tb_Search.setText("Nhập từ khóa tìm kiếm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1316, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(Tb_Search)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lb_Title)
                    .addComponent(Txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lb_Title)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tb_Search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_SearchKeyReleased
        if (!Txt_Search.getText().isEmpty()) {
            Vector Title = new Vector();
            Vector HisInput = new Vector();
            Title.add("ID Phiếu xuất");
            Title.add("Người bán");
            Title.add("Người mua");
            Title.add("ID Sản phẩm");
            Title.add("Số lượng");
            Title.add("Đơn giá");
            Title.add("Ngày bán");
            Title.add("Thành tiền");

            String KeyWord = Txt_Search.getText();
            try {
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery("SELECT CTPHIEUXUAT.MAPX,HOTEN,TENKH,MASP,SOLUONG,DONGIA,NGAYXUAT,THANHTIEN FROM PHIEUXUAT INNER JOIN TAIKHOAN ON TAIKHOAN.TENTK=PHIEUXUAT.TENTK INNER JOIN CTPHIEUXUAT ON PHIEUXUAT.MAPX=CTPHIEUXUAT.MAPX INNER JOIN KHACHHANG ON KHACHHANG.MAKH=PHIEUXUAT.MAKH WHERE PHIEUXUAT.MAPX LIKE N'%"+KeyWord+"%' AND PHIEUXUAT.STATUS = 1 OR TAIKHOAN.HOTEN LIKE N'%"+KeyWord+"%' AND PHIEUXUAT.STATUS = 1 OR PHIEUXUAT.TENTK LIKE N'%"+KeyWord+"%' AND PHIEUXUAT.STATUS = 1 OR CTPHIEUXUAT.MASP LIKE N'%"+KeyWord+"%' AND PHIEUXUAT.STATUS = 1 ORDER BY CTPHIEUXUAT.MAPX;");

                while (rs.next()) {
                    Vector HisData = new Vector();
                    HisData.add(rs.getString(1));
                    HisData.add(rs.getString(2));
                    HisData.add(rs.getString(3));
                    HisData.add(rs.getString(4));
                    HisData.add(rs.getString(5));
                    HisData.add(rs.getString(6) + " $");
                    HisData.add(rs.getString(7));
                    HisData.add(rs.getString(8) + " $");
                    HisInput.add(HisData);
                }
            } catch (Exception e) {
            }

            DefaultTableModel tblmodel = new DefaultTableModel(HisInput, Title) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            Tbl_History.setModel(tblmodel);
        } else {
            Loadhistory();
        }
    }//GEN-LAST:event_Txt_SearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lb_Title;
    private javax.swing.JLabel Tb_Search;
    private javax.swing.JTable Tbl_History;
    private javax.swing.JTextField Txt_Search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

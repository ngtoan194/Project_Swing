/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan;

import java.sql.*;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Toan
 */
public class CTLSnhaphang extends javax.swing.JDialog {

    private Connection cnt = new connectDB.connectDB().getConnection();
    private String MaPn;

    public CTLSnhaphang(JDialog parent, boolean modal,String MaPn) {
        super(parent, modal);
        initComponents();
        setTitle("Lịch Sử Nhập Hàng");
        setLocationRelativeTo(null);
        setResizable(false);
        this.MaPn = MaPn;
    }

    private void Loadhistory() {
        Vector Title = new Vector();
        Vector HisInput = new Vector();
        Title.add("ID Phiếu nhập");
        Title.add("Người nhập");
        Title.add("Ngày nhập");

        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT DISTINCT MAPN,HOTEN,CONVERT(NVARCHAR,NGAYNHAP,101)FROM PHIEUNHAP INNER JOIN TAIKHOAN ON TAIKHOAN.TENTK=PHIEUNHAP.TENTK WHERE CTPHIEUNHAP.MAPN = '"+this.MaPn+"' PHIEUNHAP.STATUS = 1;");
            while (rs.next()) {
                Vector HisData = new Vector();
                HisData.add(rs.getString(1));
                HisData.add(rs.getString(2));
                HisData.add(rs.getString(3));
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
        Lb_Search = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_SearchKeyReleased(evt);
            }
        });

        Lb_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Lb_Title.setForeground(new java.awt.Color(51, 102, 255));
        Lb_Title.setText("Chi tiết lịch sử nhập hàng");

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
        Tbl_History.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_HistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_History);

        Lb_Search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Lb_Search.setText("Nhập từ khóa tìm kiếm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Lb_Search)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(Lb_Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(Lb_Search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            String KeyWord = Txt_Search.getText();
            Vector Title = new Vector();
            Vector HisInput = new Vector();
            Title.add("ID Phiếu nhập");
            Title.add("Người nhập");
            Title.add("Ngày nhập");

            try {
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery("SELECT MAPN,HOTEN,CONVERT(NVARCHAR,NGAYNHAP,101) FROM PHIEUNHAP INNER JOIN TAIKHOAN ON TAIKHOAN.TENTK=PHIEUNHAP.TENTK WHERE MAPN LIKE '%"+KeyWord+"%' AND PHIEUNHAP.STATUS = 1 OR HOTEN LIKE N'%"+KeyWord+"%' AND PHIEUNHAP.STATUS = 1 OR CONVERT(NVARCHAR,NGAYNHAP,112) LIKE '%"+KeyWord+"%' AND PHIEUNHAP.STATUS = 1;");
                while (rs.next()) {
                    Vector HisData = new Vector();
                    HisData.add(rs.getString(1));
                    HisData.add(rs.getString(2));
                    HisData.add(rs.getString(3));
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

    private void Tbl_HistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_HistoryMouseClicked
        System.out.println(Tbl_History.getValueAt(Tbl_History.getSelectedRow(), 0));
    }//GEN-LAST:event_Tbl_HistoryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lb_Search;
    private javax.swing.JLabel Lb_Title;
    private javax.swing.JTable Tbl_History;
    private javax.swing.JTextField Txt_Search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

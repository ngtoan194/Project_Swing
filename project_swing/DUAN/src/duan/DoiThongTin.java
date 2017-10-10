/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan;

import Object.Taikhoan;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class DoiThongTin extends javax.swing.JDialog {
    
    private String UserName;
    
    public DoiThongTin(JFrame parent,boolean modal,String UserName,int UserType) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.UserName = UserName;
        setTitle("Thay đổi thông tin tài khoản "+UserName);
        ShowUserInfo();
        if(UserType == 0){
            Txt_Tentaikhoan.setEditable(false);
        }
    }

    
    public void ShowUserInfo(){
        Taikhoan UserInfo = new Model.ThongTinUser().LoadUserInfo(UserName);
        Txt_Tentaikhoan.setText(UserInfo.getUserName());
        Txt_Hovaten.setText(UserInfo.getHoTen());
        if(UserInfo.getGioiTinh().equalsIgnoreCase("nam")){
            Cbb_Gioitinh.setSelectedIndex(0);
        }else Cbb_Gioitinh.setSelectedIndex(1);
        Txt_Diachi.setText(UserInfo.getDiaChi());
        Txt_Sdt.setText(UserInfo.getSdt());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        Txt_Tentaikhoan = new javax.swing.JTextField();
        Txt_Hovaten = new javax.swing.JTextField();
        Lb_Title = new javax.swing.JLabel();
        Txt_Diachi = new javax.swing.JTextField();
        Txt_Sdt = new javax.swing.JTextField();
        Lb_Mataikhoan = new javax.swing.JLabel();
        Lb_Tentaikhoan = new javax.swing.JLabel();
        Lb_Gioitinh = new javax.swing.JLabel();
        Lb_Diachi = new javax.swing.JLabel();
        Lb_Sdt = new javax.swing.JLabel();
        Btn_Doithongtin = new javax.swing.JButton();
        Cbb_Gioitinh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Txt_Tentaikhoan.setEditable(false);

        Lb_Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Lb_Title.setForeground(new java.awt.Color(0, 102, 255));
        Lb_Title.setText("Đổi Thông Tin Tài Khoản");

        Lb_Mataikhoan.setText("Tên tài khoản:");

        Lb_Tentaikhoan.setText("Họ và tên:");

        Lb_Gioitinh.setText("Giới tính:");

        Lb_Diachi.setText("Địa chỉ:");

        Lb_Sdt.setText("Số điện thoại:");

        Btn_Doithongtin.setText("Đổi thông tin");
        Btn_Doithongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DoithongtinActionPerformed(evt);
            }
        });

        Cbb_Gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lb_Diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lb_Mataikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lb_Tentaikhoan)
                            .addComponent(Lb_Gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_Diachi)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(Cbb_Gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Txt_Hovaten)
                            .addComponent(Txt_Tentaikhoan)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Btn_Doithongtin))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(Lb_Sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(Txt_Sdt)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                .addGap(0, 82, Short.MAX_VALUE)
                .addComponent(Lb_Title)
                .addGap(69, 69, 69))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Lb_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(Txt_Tentaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txt_Hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(Lb_Mataikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lb_Tentaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lb_Gioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cbb_Gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lb_Diachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lb_Sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_Sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Doithongtin)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_DoithongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DoithongtinActionPerformed
        if(Txt_Hovaten.getText().isEmpty() | Txt_Diachi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Không được bỏ trống các ô!");
        }else {
            boolean Status = new Model.ThongTinUser().ChangeMemberInfo(UserName,Txt_Hovaten.getText(), Cbb_Gioitinh.getSelectedItem().toString(), Txt_Diachi.getText(), Txt_Sdt.getText());
            if(Status == true){
                JOptionPane.showMessageDialog(null, "Đổi thông tin thành công!");
            }else JOptionPane.showMessageDialog(null, "Đổi thông tin thất bại!");
        }
    }//GEN-LAST:event_Btn_DoithongtinActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ThongTinUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongTinUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongTinUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongTinUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThongTinUser().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Doithongtin;
    private javax.swing.JComboBox<String> Cbb_Gioitinh;
    private javax.swing.JLabel Lb_Diachi;
    private javax.swing.JLabel Lb_Gioitinh;
    private javax.swing.JLabel Lb_Mataikhoan;
    private javax.swing.JLabel Lb_Sdt;
    private javax.swing.JLabel Lb_Tentaikhoan;
    private javax.swing.JLabel Lb_Title;
    private javax.swing.JPanel Main;
    private javax.swing.JTextField Txt_Diachi;
    private javax.swing.JTextField Txt_Hovaten;
    private javax.swing.JTextField Txt_Sdt;
    private javax.swing.JTextField Txt_Tentaikhoan;
    // End of variables declaration//GEN-END:variables
}

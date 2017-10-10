/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Toan
 */
public class NhaCC {

    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public boolean themNhaCC(String idNhacc, String DC, String SDT) {
        boolean Status = false;
        if (idNhacc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền thông tin mã nhà cung cấp");
        } else if (DC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền thông tin địa chỉ nhà cung cấp");
        } else if (SDT.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền thông tin số điện thoại nhà cung cấp");
        } else if (!idNhacc.isEmpty() && !DC.isEmpty() && !SDT.isEmpty()) {
            try {
                Statement stm = cnt.createStatement();
                stm.executeUpdate("insert into nhacc values ('" + idNhacc + "',N'" + DC + "','" + SDT + "',1)");
                Status = true;
                JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công");
            } catch (Exception e) {
                Status = true;
                Object[] option = {"Có", "Không"};
                int n = JOptionPane.showOptionDialog(null, "Nhà cung cấp này đã từng tồn tại có thêm lại không?",
                        "Lựa chọn", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, option, option[1]);

                if (n == 0) {
                    try {
                        Statement stm = cnt.createStatement();
                        stm.executeUpdate("update nhacc set status = 1 where maNhacc = '" + idNhacc + "'");
                        JOptionPane.showMessageDialog(null, "Sử dụng lại nhà cung cấp " + idNhacc + " thành công!!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Lỗi.....");
                    }
                } else if (n == 1) {
                    JOptionPane.showMessageDialog(null, "Hãy suy nghĩ lại =))");
                }
            }
        }

        return Status;
    }

    public boolean xoaNhacc(String id) {
        boolean status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update nhacc set status = 0 where maNhacc = '" + id + "'");
            status = true;
        } catch (SQLException ex) {
            status = false;
            JOptionPane.showMessageDialog(null, "Lỗi!");
        }
        return status;
    }

    public boolean suaLoaiHang(String id, String DC, String SDT) {
        boolean Status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update nhacc set DiaChi = N'" + DC + "'"
                    + ", SDT ='" + SDT + "', status = 1 where maNhacc = '" + id + "'");
            JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thành công...");
            Status = true;
        } catch (Exception e) {
            Status = false;
            JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp lỗi...");
        }
        return Status;
    }
}

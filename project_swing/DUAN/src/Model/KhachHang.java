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
public class KhachHang {

    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public boolean themKH(String idKH, String tenKH, String DC, String SDT) {
        boolean Status = false;
        if (idKH.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền mã khách hàng!");
        } else if (tenKH.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền tên khách hàng!");
        } else if (DC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền địa chỉ khách hàng!");
        } else if (SDT.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền SĐT khách hàng!");
        } else if (!idKH.isEmpty() && !tenKH.isEmpty() && !DC.isEmpty() && !SDT.isEmpty()) {
            try {
                Statement stm = cnt.createStatement();
                stm.executeUpdate("Insert into KhachHang values ('" + idKH + "',N'" + tenKH + "'"
                        + ",N'" + DC + "','" + SDT + "',1)");
                Status = true;
                JOptionPane.showMessageDialog(null, "Thêm nhà khách hàng thành công");
            } catch (Exception e) {
                Status = true;
                Object[] option = {"Có", "Không"};
                int n = JOptionPane.showOptionDialog(null, "Khách hàng này đã từng tồn tại có thêm lại không?",
                        "Lựa chọn", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, option, option[1]);

                if (n == 0) {
                    try {
                        Statement stm = cnt.createStatement();
                        stm.executeUpdate("update KhachHang set status = 1 where maKH = '" + idKH + "'");
                        JOptionPane.showMessageDialog(null, "Sử dụng lại khách hàng " + idKH + " thành công!!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Lỗi.....");
                    }
                } else if (n == 1) {
                    
                }
            }
        }

        return Status;
    }

    public boolean xoaKH(String id) {
        boolean status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update KhachHang set status = 0 where maKH = '" + id + "'");
            status = true;
        } catch (SQLException ex) {
            status = false;
            JOptionPane.showMessageDialog(null, "Lỗi!");
        }
        return status;
    }

    public boolean suaLoaiHang(String id, String tenKH, String DC, String SDT) {
        boolean Status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update KhachHang set tenKH = N'" + tenKH + "', DiaChi = N'" + DC + "'"
                    + ", SDT ='" + SDT + "', status = 1 where maKH = '" + id + "'");
            JOptionPane.showMessageDialog(null, "Sửa khách hàng thành công...");
            Status = true;
        } catch (Exception e) {
            Status = false;
            JOptionPane.showMessageDialog(null, "Sửa khách hàng lỗi...");
        }
        return Status;
    }
}

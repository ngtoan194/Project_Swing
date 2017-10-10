/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Toan
 */
public class LoaiHang {

    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public boolean themLoaiHang(String idLH, String tenLH, String nhaCC) {
        boolean status = false;

        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("insert into LoaiHang values ('" + idLH + "',N'" + tenLH + "',1);"
                    + "insert into ccLoaiHang values('" + nhaCC + "','" + idLH + "')");
            status = true;
            JOptionPane.showMessageDialog(null, "Thêm loại hàng thành công");
        } catch (Exception e) {
            status = false;
            Object[] option = {"Có", "Không"};
            int n = JOptionPane.showOptionDialog(null, "Mã loại hàng này đã từng tồn tại bạn có muốn sử dụng lại k?",
                    "Lựa chọn", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, option, option[1]);

            if (n == 0) {
                try {
                    Statement stm = cnt.createStatement();
                    stm.executeUpdate("update LoaiHang set status = 1 where maLH = '" + idLH + "'");
                    JOptionPane.showMessageDialog(null, "Sử dụng lại mã loại hàng " + idLH + " thành công");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hehe");
                }
            }
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Nếu không sử dụng mã loại này thì nên đặt một mã loại mới");
            }
        }
        
        return status;
    }

    public boolean xoaLoaiHang(String id) {
        boolean status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update LoaiHang set status = 0 where maLH = '" + id + "'");
            status = true;
        } catch (SQLException ex) {
            status = false;
            JOptionPane.showMessageDialog(null, "Lỗi!");
        }
        return status;
    }

    public boolean suaLoaiHang(String id, String tenLH) {
        boolean Status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update LoaiHang set tenLH = N'" + tenLH + "' where maLH = '" + id + "'");
            JOptionPane.showMessageDialog(null, "Sửa loại hàng thành công...");
            Status = true;
        } catch (Exception e) {
            Status = false;
            JOptionPane.showMessageDialog(null, "Lỗi..." + e);
        }
        return Status;
    }

}

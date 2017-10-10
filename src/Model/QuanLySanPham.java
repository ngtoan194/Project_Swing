/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class QuanLySanPham {

    private Connection cnt = new connectDB.connectDB().getConnection();

    public boolean ThemSanPham(String MaSp, String TenSp, String MaLh, String MaNhaCC, String DonVi, String GiaNhap, String GiaXuat) {
        Statement stm = null;
        boolean Status = false;
        int count = 0;

        try {
            stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(MASP) FROM SANPHAM WHERE MASP = '" + MaSp + "'");
            while (rs.next()) {
                count = rs.getInt(1);
            }

            if (count > 0) {
                int themsanpham = JOptionPane.showConfirmDialog(null, "Mã sản phẩm thuộc về một sản phẩm đã ngừng bán\nBạn có muốn mở bán lại không?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
                if (themsanpham == JOptionPane.YES_OPTION) {
                    try {
                        stm.executeUpdate("UPDATE SANPHAM SET STATUS = 1 WHERE MASP = '" + MaSp + "'");
                        Status = true;
                    } catch (Exception e) {
                        Status = false;
                    }
                } else if (themsanpham == JOptionPane.NO_OPTION) {
                    try {
                        stm.executeUpdate("UPDATE SANPHAM SET TENSP = N'" + TenSp + "',MALH = '" + MaLh + "',MANHACC = N'" + MaNhaCC + "',DONVI = N'" + DonVi + "',SOLUONG = 0,GIANHAP = " + GiaNhap + ",GIAXUAT = " + GiaXuat + ",STATUS = 1 WHERE MASP = '" + MaSp + "'");
                        Status = true;
                    } catch (Exception e) {
                        Status = false;
                    }
                }
            } else if (count == 0) {
                try {
                    stm.executeQuery("Insert into SanPham values ('" + MaSp + "',N'" + TenSp + "','" + MaLh + "',N'" + MaNhaCC + "',N'" + DonVi + "',0," + GiaNhap + "," + GiaXuat + ",1);");
                } catch (Exception e) {
                }
                Status = true;
            }
        } catch (Exception e) {
        }

        return Status;
    }

    public boolean XoaSanPham(String MaSp) {
        boolean Status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("UPDATE SANPHAM SET STATUS = 0 WHERE MASP = '" + MaSp + "'");
            Status = true;
        } catch (SQLException ex) {
            Status = false;
        }

        return Status;
    }

    public boolean SuaSanPham(String MaSp, String TenSp, String MaLh, String MaNhaCC, String DonVi, String GiaNhap, String GiaXuat) {
        Statement stm = null;
        boolean Status = false;

        try {
            stm = cnt.createStatement();
            stm.executeUpdate("UPDATE SANPHAM SET TENSP = N'"+TenSp+"',MALH = '"+MaLh+"',MANHACC = N'"+MaNhaCC+"',DONVI = N'"+DonVi+"',GIANHAP = '"+GiaNhap+"',GIAXUAT = "+GiaXuat+" WHERE MASP = '"+MaSp+"';");
            Status = true;
        } catch (Exception e) {
            Status = false;
        }

        return Status;
    }
}

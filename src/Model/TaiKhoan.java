/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import duan.QLTaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import sun.awt.windows.ThemeReader;

/**
 *
 * @author Nguyen Toan
 */
public class TaiKhoan {

    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public boolean themTaiKhoan(String idUser, String userName,
            String Sex, String Address, String Phone, int typeUser) {
        boolean Status = false;
        
        System.out.println(typeUser);

        if (idUser.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền thông tin Mã nhân viên");
            Status = false;
        } else if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa điền họ tên nhân viên");
            Status = false;
        } else if (typeUser <=0) {
            JOptionPane.showMessageDialog(null, "Chưa phân quyền");
            Status = false;
        } else if (!idUser.isEmpty() && !userName.isEmpty() && typeUser >0) {
            Status = true;
            try {
                Status = true;
                Statement stm = cnt.createStatement();
                int Count = stm.executeUpdate("INSERT INTO TaiKhoan values ('" + idUser + "',N'" + userName + "','123',N'" + Sex
                        + "',N'" + Address + "','" + Phone + "'," + typeUser + ",1)");
                if (Count > 0) {
                    Status = true;
                    JOptionPane.showMessageDialog(null, "Thêm tài khoản mới thành công");
                }
            } catch (Exception e) {
                Status = true;
                Object[] option = {"Có", "Không"};
                int n = JOptionPane.showOptionDialog(null, "Tài khoản này đã tồn tại bạn có muốn sử dụng lại không?",
                        "Lựa chọn", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, option, option[1]);

                if (n == 0) {
                    try {
                        Statement stm = cnt.createStatement();
                        stm.executeUpdate("update TaiKhoan  set status = 1 where tenTK = '" + idUser + "'");
                        JOptionPane.showMessageDialog(null, "Sử dụng lại mã tài khoản " + idUser + " thành công");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Lỗi....");
                    }
                }
                if (n == 1) {
                    JOptionPane.showMessageDialog(null, "Nếu không sử dụng mã tài khoản này thì nên đặt một mã tài khoản mới");
                }
            }
        }
        return Status;
    }
    
    public boolean xoaTaiKhoan(String id) {
        boolean status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("update taikhoan set status = 0 where tenTK = '" + id + "'");
            status = true;
        } catch (SQLException ex) {
            status = false;
            JOptionPane.showMessageDialog(null, "Lỗi!");
        }
        return status;
    }

    public boolean suaTaiKhoan(String id, String userName,
            String Sex, String Address, String Phone, int typeUser) {
        boolean Status = false;
        try {
            Statement stm = cnt.createStatement();
            int count = stm.executeUpdate("update TaiKhoan set HoTen = N'" + userName + "', GioiTinh =N'" + Sex
                    + "',DiaChi= N'" + Address + "' , SDT ='" + Phone + "',typeUser = " + typeUser + " , status = 1 where tenTK = '" + id + "'");
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Sửa tài khoản thành công...");
                Status = true;
            } else if (count < 0) {
                Status = false;
            }
        } catch (Exception e) {
            Status = false;
            JOptionPane.showMessageDialog(null, "Sửa tài khoản lỗi...");
        }
        return Status;
    }

    public boolean datlaiMK(String id) {
        boolean Status = false;

        try {
            Statement stm = cnt.createStatement();
            String pass = "";
            stm.executeUpdate("update TaiKhoan  set MatKhau = '123' where tenTK = '" + id + "'");
            JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu về chế độ mặc định thành: 123");
            Status = true;
        } catch (Exception e) {
            Status = false;
            JOptionPane.showMessageDialog(null, "Đặt mật khẩu về mặc định thất bại!!");
        }
        return Status;
    }

    public String xemMK(String id) {
        try {
            String pass = "";
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("select MatKhau from taiKhoan where tenTK = '" + id + "'");
            while (rs.next()) {
                pass = rs.getString(1);
            }
            JOptionPane.showMessageDialog(null, "Mật khẩu là: " + pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy về được mật khẩu");
        }
        return id;
    }

    public boolean timkiemDong(String TK) {
        boolean Status = false;
        try {
            String sql = "Select tenTK, Hoten,GioiTinh,DiaChi,SDT, "
                    + "+case when typeUser = 1 then N'Quản lý' else N'Thủ kho' end  from TaiKhoan "
                    + "where tenTK like '%" + TK + "%' "
                    + "or HoTen like N'%" + TK + "%' "
                    + "or GioiTinh like N'%" + TK + "%' "
                    + "or DiaChi like N'%" + TK + "%' "
                    + "or SDT like '%" + TK + "%' and status = 1";

            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            Status = true;
        } catch (Exception e) {
            Status = false;
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        return Status;
    }
}

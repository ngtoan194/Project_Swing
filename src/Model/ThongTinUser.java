/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Object.Taikhoan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class ThongTinUser {

    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public Taikhoan LoadUserInfo(String Username) {
        
        Taikhoan UserInfo = null;

        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM TAIKHOAN WHERE tenTK = '" + Username + "'");
            while (rs.next()) {
                UserInfo = new Taikhoan(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            
        }
        
        if(UserInfo.getTypeUser().equals("0") && UserInfo.getTypeUser() != null){
            UserInfo.setTypeUser("Thủ kho");
        }else UserInfo.setTypeUser("Quản lý");

        return UserInfo;
    }
    
    public boolean ChangeMemberInfo(String Username,String HoTen,String GioiTinh,String DiaChi,String Sdt){
        boolean Status = false;
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("UPDATE TAIKHOAN SET HOTEN = N'"+HoTen+"', GIOITINH = N'"+GioiTinh+"', DIACHI = N'"+DiaChi+"',SDT = '"+Sdt+"' WHERE TENTK = '"+Username+"'");
            Status = true;
        } catch (Exception e) {
            Status = false;
        }
        return Status;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Toan
 */
public class checkLogin {
    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public boolean Model_CheckLogin(String Username,String Password){
        boolean Status = false;

        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MatKhau FROM TAIKHOAN WHERE tenTK = '"+Username+"' AND STATUS = 1");
            while(rs.next()){
                if(Password.equalsIgnoreCase(rs.getString(1))){
                    Status = true;
                }else Status = false;
            }
        } catch (Exception e) {
            Status = false;
        }
        
        return Status;
    }
    
    public int Model_GetUserType(String Username){
        int UserType = 0;
        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT TYPEUSER FROM TAIKHOAN WHERE tenTK = '"+Username+"' AND STATUS = 1");
            while(rs.next()){
                UserType = rs.getInt(1);
            }
        } catch (Exception e) {
            UserType = 0;
        }
        return UserType;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class DoiMatKhau {
    
    private Connection cnt = new connectDB.connectDB().getConnection();
    
    public boolean ChangePass(String Username,String Password){
        boolean Status = false;
        
        try {
            Statement stm = cnt.createStatement();
            stm.executeUpdate("UPDATE TAIKHOAN SET MATKHAU = '"+Password+"' WHERE TENTK = '"+Username+"'");
            Status = true;
        } catch (Exception e) {
            Status = false;
        }
        
        return Status;
    }
    
    public boolean CheckOldPass(String Username,String Password){
        boolean Status = false;
        
        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MATKHAU FROM TAIKHOAN WHERE TENTK = '"+Username+"'");
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
}

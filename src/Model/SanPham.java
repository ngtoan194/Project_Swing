/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class SanPham {
    
    private Connection cnt = null;
    
    public Vector LoadSanPham(){
        Vector<String> ListSanPham = null;
        
        try {
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery("SELECT *,TenLh FROM SANPHAM INNER JOIN LOAIHANG ON SANPHAM.MALH=LOAIHANG.MALH;");
            while(rs.next()){
                ListSanPham.add(rs.getString(1));
                ListSanPham.add(rs.getString(2));
                ListSanPham.add(rs.getString(3));
                ListSanPham.add(rs.getString(4));
                
            }
        } catch (Exception e) {
        }
        
        return ListSanPham;
    }
            
}

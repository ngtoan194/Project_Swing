/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Toan
 */
public class connectDB {
    
    public Connection getConnection(){
        Connection cn = null;
        
        String user = "sa";
        String pass = "123";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYKHO";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url,user,pass);
//            System.out.println("OK");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không kết nối được Database!");
        }
        return cn;
    }
    
//    public static void main(String[] args) {
//        System.out.println(connectDB.getConnection());
//    }
}

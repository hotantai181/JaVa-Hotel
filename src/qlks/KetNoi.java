/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class KetNoi {
    public Connection con;
    private String connectionURL;
    public KetNoi(String sqlInstanceName, String database, String userName,String password){       

        try {               
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");            
        }catch (ClassNotFoundException ex) {
                Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        con=null;
        this.connectionURL="jdbc:sqlserver://" + sqlInstanceName + ":1433" + ";databaseName=" 
                + database +";user="+userName+";password="+password;       
    }
    public Connection OpenConnection(){     
        try {
            if(con!=null && con.isClosed()==false)
                return con;
            con = DriverManager.getConnection(this.connectionURL);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public void CloseConnection(){     
        try {
            if(con!=null)
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

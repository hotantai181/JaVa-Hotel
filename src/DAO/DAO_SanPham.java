/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */
public class DAO_SanPham {
     KetNoi kn;
    public DAO_SanPham()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
public void LaySanPham(Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "select namesp,priceSP \n" +
"from SanPham\n" +
"where id  != 1";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String id = rs.getString("namesp");
                String tenKh=rs.getString("priceSP");   
                Vector<String> v = new Vector<String>();
                v.add(id);
                v.add(tenKh);

                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_SanPham.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
      public Vector LayMa()
    {
         Statement stmt ;
         Vector vdata = new Vector();
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
           String sql = "SELECT TOP 1 id FROM DatPhong ORDER BY id DESC ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String key = rs.getString("id");
                vdata.add(key);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_SanPham.class.getName()).log(Level.SEVERE,null,ex);
        }
        return vdata;
    }
}

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
import pojo.pojo_KhachHang;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */
public class DAO_KhachHang {
    KetNoi kn;
    public DAO_KhachHang()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
    public void LayKhachHang (Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "Select * from KHACHHANG";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String Gt = rs.getString("Gt");
                String CMND = rs.getString("CMND");
                String DTLH = rs.getString("DTLH");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String nhanphong = rs.getString("nhanphong");
              
                Vector<String> v = new Vector<String>();
                v.add(id);
                v.add(name);
                v.add(Gt);
                v.add(CMND);
                v.add(DTLH); 
                v.add(Email);
                v.add(Password);
                v.add(nhanphong);
               
                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
     public Vector LayKH()
    {
         Statement stmt ;
         Vector vdata = new Vector();
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
           String sql = "Select name from KhachHang";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String key = rs.getString("name");
                vdata.add(key);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE,null,ex);
        }
        return vdata;
    }
     public void ThemKH(pojo_KhachHang x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String name = x.Getname();
            String Gt = x.GetGT();
            String CMND = x.GetCMND();
            String DTLH = x.GetDTLH();
            String Email = x.GetEmail();
            String Password = x.GetPass();
            Statement stmt = kn.con.createStatement();
            String sqlInsert = "SET IDENTITY_INSERT KHACHHANG ON;Insert into KHACHHANG(id,name,Gt,CMND,DTLH,Email,Password)" 
                    + "Values('"+id+"',N'"+name+"',N'"+Gt+"','"+CMND+"','"+DTLH+"','"+Email+"','"+Password+"');SET IDENTITY_INSERT KHACHHANG OFF";
            int rs = stmt.executeUpdate(sqlInsert);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     
    public void SuaKH(pojo_KhachHang x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String name = x.Getname();
            String Gt = x.GetGT();
            String CMND = x.GetCMND();
            String DTLH = x.GetDTLH();
            String Email = x.GetEmail();
            String Password = x.GetPass();     
            Statement stmt = kn.con.createStatement();
            String sqlUpdate = "update KHACHHANG set id='"+id+"' , name =N'"+name+"', Gt = N'"+Gt+"' , CMND='"+CMND+"',DTLH='"
                    +DTLH+"',Email='" +Email+"' ,Password='"+Password+"' where id ='"+id+"'";
            int rs = stmt.executeUpdate(sqlUpdate);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void XoaKH(pojo_KhachHang x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();    
            Statement stmt = kn.con.createStatement();
            String sqlDelete = "delete from KHACHHANG where id='"+id+"' ";
            int rs = stmt.executeUpdate(sqlDelete);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

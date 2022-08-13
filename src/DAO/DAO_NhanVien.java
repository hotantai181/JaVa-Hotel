/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.pojo_NhanVien;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */
public class DAO_NhanVien {
     KetNoi kn;
    public DAO_NhanVien()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
    public void LayNhanVien(Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "Select * from Account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("Dislayname");
                String Ns = rs.getString("NgaySinh");
                String Gt = rs.getString("Gt");
                String username  = rs.getString("Username");
                String Password = rs.getString("Password");
                String type = rs.getString("Type");
                Vector<String> v = new Vector<String>();
                v.add(id);
                v.add(name);
                v.add(Ns);
                v.add(Gt);
                v.add(username); 
                v.add(Password);
                v.add(type); 
                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
     public void ThemKH(pojo_NhanVien x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String name = x.Getname();
            String NgaySinh  = x.GetNgSinh();
            String Gt = x.GetGT();
            String Username= x.Getusername();
            String Password = x.GetPass();
            String Type = x.GetType();
            Statement stmt = kn.con.createStatement();
            String sqlInsert = "SET IDENTITY_INSERT Account ON;Insert into Account(id,Displayname,NgaySinh,Gt,Username,PassWord,Type)" 
                    + "Values('"+id+"',N'"+name+"',N'"+NgaySinh+"','"+Gt+"','"+Username+"','"+Password+"','"+Type+"');SET IDENTITY_INSERT Account OFF";
            int rs = stmt.executeUpdate(sqlInsert);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     
    public void SuaNV(pojo_NhanVien x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String name = x.Getname();
            String NgaySinh  = x.GetNgSinh();
            String Gt = x.GetGT();
            String Username= x.Getusername();
            String Password = x.GetPass();
            String Type = x.GetType();
    
            Statement stmt = kn.con.createStatement();
            String sqlUpdate = "update Account set id='"+id+"' , name =N'"+name+"', NgaySinh = N'"+NgaySinh+"' , Gt='"+Gt+"',Username='"
                    +Username+"',Password='"+Password+"',Type='"+Type+"'    where id ='"+id+"'";
            int rs = stmt.executeUpdate(sqlUpdate);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void XoaNV(pojo_NhanVien x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();    
            Statement stmt = kn.con.createStatement();
            String sqlDelete = "delete from Account where id='"+id+"' ";
            int rs = stmt.executeUpdate(sqlDelete);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
         public String TaiKhoanNv(pojo_NhanVien x)
    {
        Statement st;
        String key="";
        try{
            kn.OpenConnection();
            st = kn.con.createStatement();
            String sql = "select Username From Account where id ='"+ x.Getid()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                key = rs.getString("Username");
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE,null,ex);
        }
        return key;
    }
        
        
         public boolean KiemtraTk(String tk , String mk)
         {
            try{
            kn.OpenConnection();
            Statement st = kn.con.createStatement();
            String sql = "select Username, PassWord From Account"+ "where Username=? AND Password =? ";
            PreparedStatement ps = kn.con.prepareStatement(sql);
            ps.setString(1, tk);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }  
        }
         
         public Vector LayTKList()
    {
         Statement stmt ;
         Vector vdata = new Vector();
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "select Username From Account ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String key = rs.getString("Username");
                vdata.add(key);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE,null,ex);
        }
        return vdata;
    }
    
}

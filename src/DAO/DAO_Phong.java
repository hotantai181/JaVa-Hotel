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
import pojo.pojo_NhanVien;
import pojo.pojo_Phong;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */

public class DAO_Phong {
    KetNoi kn;
    public DAO_Phong    ()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
        public Vector LayDanhSachPhong()
    {
         Statement stmt ;
         Vector vdata = new Vector();
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
           String sql = "Select namep,status from Phong";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String key = rs.getString("namep") + "_" + rs.getString("status");
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
    public Vector LayPhong()
    {
         Statement stmt ;
         Vector vdata = new Vector();
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
           String sql = "Select id,namep from Phong";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String key =  rs.getString("id") + "_" + rs.getString("namep");
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
    public Vector LayPhongTheoHD()
    {
         Statement stmt ;
         Vector vdata = new Vector();
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
           String sql = "select Phong.id ,Phong.namep \n" +
"from HoaDon , Phong \n" +
"where HoaDon.idPhong = Phong.id ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String key =  rs.getString("id") + "_" + rs.getString("namep");
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
    public void ThemPhong(pojo_Phong x )
        {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String name = x.Getname();
            String maloai  = x.Getmaloai();
            String loaiphong = x.Getloaiphong();
            String status= x.Getstatus();
            String price = x.Getprice();
            String anh = x.Getanh();
            Statement stmt = kn.con.createStatement();
            String sqlInsert = "SET IDENTITY_INSERT Phong ON;Insert into Phong(id,namep,MALOAI,loaiphong,status,price,anh)" 
                    + "Values('"+id+"',N'"+name+"',N'"+maloai+"',N'"+loaiphong+"',N'"+status+"','"+price+"','"+anh+"');SET IDENTITY_INSERT Phong OFF";
            int rs = stmt.executeUpdate(sqlInsert);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE,null,ex);
        }
    }   
    public void SuaPhong(pojo_Phong x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String name = x.Getname();
            String maloai  = x.Getmaloai();
            String loaiphong = x.Getloaiphong();
            String status= x.Getstatus();
            String price = x.Getprice();
            String anh = x.Getanh();
            Statement stmt = kn.con.createStatement();
            String sqlUpdate = "update Phong set id='"+id+"' , namep =N'"+name+"', MALOAI = N'"+maloai+"' , loaiphong='"+loaiphong+"',status='"
                    +status+"',price='"+price+"',anh='"+anh+"'    where id ='"+id+"'";
            int rs = stmt.executeUpdate(sqlUpdate);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void XoaPhong(pojo_Phong x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();    
            Statement stmt = kn.con.createStatement();
            String sqlDelete = "delete from Phong where id='"+id+"' ";
            int rs = stmt.executeUpdate(sqlDelete);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void CapNhatTinhTrangPhong(String x,String y )
    {
        try
        {
            kn.OpenConnection();
            String id = x;
            String status = y;
            Statement stmt = kn.con.createStatement();
            String sqlUpdate = "update Phong set status=N'"
                    +status+"'    where id ='"+id+"'";
            int rs = stmt.executeUpdate(sqlUpdate);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

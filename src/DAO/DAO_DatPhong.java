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
import pojo.pojo_DatPhong;
import pojo.pojo_KhachHang;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */
public class DAO_DatPhong{
    KetNoi kn;
    public DAO_DatPhong()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
public void LayDSDP (Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "Select  DatPhong.id , KhachHang.name,Phong.namep,DatPhong.DateCheckin,DateCheckout \n" +
"from DatPhong , KhachHang, Phong\n" +
"WHERE DatPhong.idKh = KhachHang.id and Phong.id = DatPhong.idPhong";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String id = rs.getString("id");
                String tenKh=rs.getString("name");
                String idPhong = rs.getString("namep");
                String DateCheckin = rs.getString("DateCheckin");
                String DateCheckout = rs.getString("DateCheckout");    
                Vector<String> v = new Vector<String>();
                v.add(id);
                v.add(tenKh);
                v.add(idPhong);
                v.add(DateCheckin);
                v.add(DateCheckout); 

                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_DatPhong.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(DAO_DatPhong.class.getName()).log(Level.SEVERE,null,ex);
        }
        return vdata;
    }
     public void DatPhong(pojo_DatPhong x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String idKh = x.GetidKh();
            String idPhong = x.Getidphong();
            String DCIn = x.Getdatecheckin();
            String DNout = x.Getdatecheckout();
            Statement stmt = kn.con.createStatement();
            String sqlInsert = "SET IDENTITY_INSERT DatPhong ON;Insert into DatPhong(id,idKh,idPhong,DateCheckin,DateCheckout)" 
                    + "Values('"+id+"','"+idKh+"',N'"+idPhong+"','"+DCIn+"','"+DNout+"');SET IDENTITY_INSERT DatPhong OFF";
            int rs = stmt.executeUpdate(sqlInsert);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_DatPhong.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     
    public void SuaDatPhong(pojo_KhachHang x )
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
            Logger.getLogger(DAO_DatPhong.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void XoaDatPhong(String id )
    {
        try
        {
            kn.OpenConnection();    
            Statement stmt = kn.con.createStatement();
            String sqlDelete = "delete from DatPhong where idPhong='"+id+"' ";
            int rs = stmt.executeUpdate(sqlDelete);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

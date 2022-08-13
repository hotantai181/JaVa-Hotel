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
import pojo.pojo_HoaDon;
import pojo.pojo_Phong;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */
public class DAO_HoaDon {
    KetNoi kn;
    public DAO_HoaDon()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
    public void LayHoaDon (Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "Select HoaDon.id , KhachHang.name ,Phong.namep, HoaDon.DateCheckIn , HoaDon.DateCheckOut,HoaDon.tongtien \n" +
                        "From HoaDon , KhachHang ,DatPhong , Phong\n" +
                        "where DatPhong.idPhong = HoaDon.idPhong and DatPhong.idKh = KhachHang.id and DatPhong.idPhong = Phong.id and HoaDon.status=0";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String id = rs.getString("id");
                String tenKh=rs.getString("name");
                String idPhong = rs.getString("namep");
                String DateCheckin = rs.getString("DateCheckIn");
                String DateCheckout = rs.getString("DateCheckOut");
                String tongtien= rs.getString("tongtien");
                Vector<String> v = new Vector<String>();
                v.add(id);
                v.add(tenKh);
                v.add(idPhong);
                v.add(DateCheckin);
                v.add(DateCheckout); 
                v.add(tongtien);
                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     public String LayPhong(String id)
    {
         String key="";
        try
        {
            kn.OpenConnection();
            Statement stmt = kn.con.createStatement();
            String sql = "Select idPhong from HoaDon where  id ='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                key =  rs.getString("idPhong");
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_Phong.class.getName()).log(Level.SEVERE,null,ex);
        }
        return key;
    }
    public void ThemHD(pojo_HoaDon x )
        {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String ngayden = x.Getdatecheckin();
            String ngaydi  = x.Getdatecheckout();
            String idphong = x.Getidphong();
            String status= x.Getstatus();
            String price = x.Getprice();
            Statement stmt = kn.con.createStatement();
            String sqlInsert = "SET IDENTITY_INSERT  HoaDon ON;Insert into HoaDon(id,DateCheckIn,DateCheckOut,idPhong,status,tongtien)" 
                    + "Values('"+id+"',"+ngayden+"',"+ngaydi+"','"+idphong+"','"+status+"','"+price+"');SET IDENTITY_INSERT HoaDon OFF";
            int rs = stmt.executeUpdate(sqlInsert);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }   
    public void SuaHD(pojo_HoaDon x )
    {
        try
        {
            kn.OpenConnection();
             String id = x.Getid();
            String name = x.Getdatecheckin();
            String maloai  = x.Getdatecheckout();
            String status= x.Getstatus();
            String price = x.Getprice();
            Statement stmt = kn.con.createStatement();
            String sqlUpdate = "update HoaDon set DateCheckIn =N'"+name+"', DateCheckOut = N'"+maloai+"' ,status='"
                    +status+"',tongtien='"+price+"' where id ='"+id+"'";
            int rs = stmt.executeUpdate(sqlUpdate);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void XoaPhong(pojo_HoaDon x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();    
            Statement stmt = kn.con.createStatement();
            String sqlDelete = "delete from HoaDon where id='"+id+"' ";
            int rs = stmt.executeUpdate(sqlDelete);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

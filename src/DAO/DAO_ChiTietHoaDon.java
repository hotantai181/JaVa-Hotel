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
import pojo.pojo_ChiTietHoaDon;
import pojo.pojo_DatPhong;
import pojo.pojo_KhachHang;
import qlks.KetNoi;

/**
 *
 * @author Administrator
 */
public class DAO_ChiTietHoaDon {
     KetNoi kn;
    public DAO_ChiTietHoaDon()
    {
        kn = new KetNoi("ASUS-00I\\SQLEXPRESS","QuanLyKS(HC)","sa","12");
    }
public void LayDichVu (Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "select  Phong.namep , DichVu.namedv ,DichVu.priceDv\n" +
                        "from ChiTietHoaDon , Phong ,DichVu \n" +
                        "where ChiTietHoaDon.idPhong = Phong.id and ChiTietHoaDon.idDichVu = DichVu.id and priceDv !=0";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String namep = rs.getString("namep");
                String tenKh=rs.getString("namedv");
                String idPhong = rs.getString("priceDv");      
                Vector<String> v = new Vector<String>();
                
                v.add(namep);
                v.add(tenKh);
                v.add(idPhong);

                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_ChiTietHoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     public void LaySanPham (Vector vdata)
    {
        Statement stmt ;
        vdata.removeAllElements();
        try
        {
            kn.OpenConnection();
            stmt = kn.con.createStatement();
            String sql = "select Phong.namep , SanPham.namesp , SanPham.priceSP\n" +
"from ChiTietHoaDon , Phong ,SanPham\n" +
"where ChiTietHoaDon.idPhong = Phong.id and ChiTietHoaDon.idSanPham = SanPham.id and priceSP !=0";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String namep = rs.getString("namep");
                String tenKh=rs.getString("namesp");
                String idPhong = rs.getString("priceSP");      
                Vector<String> v = new Vector<String>();
                
                v.add(namep);
                v.add(tenKh);
                v.add(idPhong);

                vdata.add(v);
            }
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_ChiTietHoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     public void DatPhong(pojo_ChiTietHoaDon x )
    {
        try
        {
            kn.OpenConnection();
            String id = x.Getid();
            String idKh = x.GetidHoaDon();
            String idPhong = x.Getidphong();
            String DCIn = x.GetidDichvu();
            String DNout = x.GetidSanPham();
            String cont = x.Getcount();
            String tongtien = x.Getprice();
            Statement stmt = kn.con.createStatement();
            String sqlInsert = "SET IDENTITY_INSERT DatPhong ON;Insert into DatPhong(id,idKh,idPhong,DateCheckin,DateCheckout)" 
                    + "Values('"+id+"',N'"+idKh+"',N'"+idPhong+"','"+DCIn+"','"+DNout+"');SET IDENTITY_INSERT DatPhong OFF";
            int rs = stmt.executeUpdate(sqlInsert);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_ChiTietHoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     
    public void SuaDatPhong(pojo_ChiTietHoaDon x )
    {
        try
        {
                        kn.OpenConnection();
            String id = x.Getid();
            String idHd = x.GetidHoaDon();
            String idPhong = x.Getidphong();
            String idDv = x.GetidDichvu();
            String idSp = x.GetidSanPham();
            String cont = x.Getcount();
            String tongtien = x.Getprice();  
            Statement stmt = kn.con.createStatement();
            String sqlUpdate = "update KHACHHANG set id='"+id+"' , name =N'"+idHd+"', Gt = N'"+idPhong+"' , CMND='"+idDv+"',DTLH='"
                    +idSp+"',Email='" +cont+"' ,Password='"+tongtien+"' where id ='"+id+"'";
            int rs = stmt.executeUpdate(sqlUpdate);
            kn.CloseConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DAO_ChiTietHoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        public void XoaDatPhong(pojo_ChiTietHoaDon x )
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
            Logger.getLogger(DAO_ChiTietHoaDon.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}

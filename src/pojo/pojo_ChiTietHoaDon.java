/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Administrator
 */
public class pojo_ChiTietHoaDon {
    private String id,idHoaDon, idPhong,idDichvu ,idSanPham,count,tongtien;
    public pojo_ChiTietHoaDon(){ id =idHoaDon=idPhong=idDichvu=idSanPham=count=tongtien="";}
    public pojo_ChiTietHoaDon(String id ,String datecheckin, String datecheckout , String idphong , String status,String tongtien)
    {
        this.id =id;
        this.idHoaDon = idHoaDon;
        this.idPhong =idPhong;
        this.idDichvu = idDichvu;
        this.idSanPham = idSanPham;
        this.count = count;
        this.tongtien = tongtien;
    }
    public pojo_ChiTietHoaDon(pojo_ChiTietHoaDon x)
    {
        this.id =x.id;
        this.idHoaDon = x.idHoaDon;
        this.idPhong =x.idPhong;
        this.idDichvu = x.idDichvu;
        this.idSanPham = x.idSanPham;
        this.count = x.count;
        this.tongtien = x.tongtien;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
    public String GetidHoaDon(){return idHoaDon;}
    public void SetidHoaDon(String idHoaDon) {this.idHoaDon = idHoaDon ;}
    public String Getidphong(){return idPhong;}
    public void Setidphong(String idPhong){this.idPhong=idPhong;}
    public String GetidDichvu(){return idDichvu;}
    public void SetidDichvu(String idDichvu){this.idDichvu = idDichvu ; }
    public String GetidSanPham(){return idSanPham;}
    public void SetidSanPham(String idSanPham){this.idSanPham = idSanPham ; }
    public String Getcount(){return count;}
    public void Setcount(String count){ this.count = count;}
    public String Getprice(){return tongtien;}
    public void Setprice(String tongtien){ this.tongtien = tongtien;}
}

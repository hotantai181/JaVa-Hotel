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
public class pojo_HoaDon {
    private String id,datecheckin, datecheckout,idphong ,status,tongtien;
    public pojo_HoaDon(){ id =datecheckin=datecheckout=idphong=status=tongtien="";}
    public pojo_HoaDon(String id ,String datecheckin, String datecheckout , String idphong , String status,String tongtien)
    {
        this.id =id;
        this.datecheckin = datecheckin;
        this.datecheckout =datecheckout;
        this.idphong = idphong;
        this.status = status;
        this.tongtien = tongtien;
    }
    public pojo_HoaDon(pojo_HoaDon x)
    {
        this.id = x.id;
        this.datecheckin = x.datecheckin;
        this.datecheckout= x.datecheckout;
        this.idphong = x.idphong;
        this.status = x.status;
        this.tongtien = x.tongtien;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
    public String Getdatecheckin(){return datecheckin;}
    public void Setdatecheckin(String datecheckin) {this.datecheckin = datecheckin ;}
    public String Getdatecheckout(){return datecheckout;}
    public void Setdatecheckout(String datecheckout){this.datecheckout = datecheckout ; }
    public String Getidphong(){return idphong;}
    public void Setidphong(String idphong){this.idphong=idphong;}
    public String Getstatus(){return status;}
    public void Setstatus(String status){ this.status = status;}
    public String Getprice(){return tongtien;}
    public void Setprice(String tongtien){ this.tongtien = tongtien;}
}

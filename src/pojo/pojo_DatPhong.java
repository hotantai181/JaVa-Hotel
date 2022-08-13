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
public class pojo_DatPhong {
     private String id,idKh,idPhong ,datecheckin, datecheckout;
    public pojo_DatPhong(){ id =idKh=idPhong=datecheckin=datecheckout="";}
    public pojo_DatPhong(String id ,String idKh, String idPhong,String datecheckin, String datecheckout)
    {
        this.id =id;
        this.idKh = idKh;
        this.idPhong = idPhong;
        this.datecheckin = datecheckin;
        this.datecheckout =datecheckout;
    }
    public pojo_DatPhong(pojo_DatPhong x)
    {
        this.id =x.id;
        this.idKh = x.idKh;
        this.idPhong = x.idPhong;
        this.datecheckin = x.datecheckin;
        this.datecheckout =x.datecheckout;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
     public String GetidKh(){return idKh;}
    public void SetidKh(String idKh){this.idKh=idKh;}
    public String Getidphong(){return idPhong;}
    public void Setidphong(String idPhong){this.idPhong=idPhong;}
    public String Getdatecheckin(){return datecheckin;}
    public void Setdatecheckin(String datecheckin) {this.datecheckin = datecheckin ;}
    public String Getdatecheckout(){return datecheckout;}
    public void Setdatecheckout(String datecheckout){this.datecheckout = datecheckout ; }

}

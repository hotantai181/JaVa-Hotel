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
public class pojo_Phong {
       private String id,name, maloai, loaiphong,status,price,anh;
    public pojo_Phong(){ id =name=maloai=loaiphong=status=price=anh="";}
    public pojo_Phong(String id ,String name, String maloai , String loaiphong , String status,String price,String anh)
    {
        this.id =id;
        this.name = name;
        this.maloai =maloai;
        this.loaiphong = loaiphong;
        this.status = status;
        this.price = price;
        this.anh =anh;
    }
    public pojo_Phong(pojo_Phong x)
    {
        this.id =x.id;
        this.name = x.name;
        this.maloai =x.maloai;
        this.loaiphong = x.loaiphong;
        this.status = x.status;
        this.price = x.price;
        this.anh =x.anh;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
    public String Getname(){return name;}
    public void Setname(String name) {this.name = name ;}
    public String Getmaloai(){return maloai;}
    public void Setmaloai(String maloai){this.maloai = maloai ; }
    public String Getloaiphong(){return loaiphong;}
    public void Setloaiphong(String loaiphong){this.loaiphong=loaiphong;}
    public String Getstatus(){return status;}
    public void Setstatus(String status){ this.status = status;}
    public String Getprice(){return price;}
    public void Setprice(String price){ this.price = price;}
    public String Getanh(){return anh;}
    public void Setanh(String password){ this.anh = anh;}
}

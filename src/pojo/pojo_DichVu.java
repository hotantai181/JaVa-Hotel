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
public class pojo_DichVu {
    private String id,name, soluong, gia;
    public pojo_DichVu(){ id =name=soluong=gia="";}
    public pojo_DichVu(String id ,String name, String soluong , String gia )
    {
        this.id =id;
        this.name = name;
        this.soluong =soluong;
        this.gia = gia;
    }
    public pojo_DichVu(pojo_DichVu x)
    {
        this.id =x.id;
        this.name = x.name;
        this.soluong =x.soluong;
        this.gia = x.gia;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
    public String Getname(){return name;}
    public void Setname(String name) {this.name = name ;}
    public String Getsoluong(){return soluong;}
    public void Setsoluong(String soluong){this.soluong = soluong ; }
    public String Getgia(){return gia;}
    public void Setgia(String loaiphong){this.gia=gia;}
}

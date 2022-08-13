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
public class pojo_NhanVien {
     private String id,Dislayname, ngaysinh , gt, username,password,type;
    public pojo_NhanVien(){ id =Dislayname= ngaysinh=gt=username=password=type="";}
    public pojo_NhanVien(String id ,String Dislayname, String ngaysinh , String gt , String username,String password,String type)
    {
        this.id =id;
        this.Dislayname = Dislayname;
        this.ngaysinh = ngaysinh;
        this.gt =gt;
        this.username = username;
        this.password = password;
        this.type =type;
    }
    public pojo_NhanVien(pojo_NhanVien x)
    {
        this.id =x.id;
        this.Dislayname = x.Dislayname;
        this.ngaysinh = x.ngaysinh;
        this.gt =x.gt;
        this.username = x.username;
        this.password = x.password;
        this.type =x.type;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
    public String Getname(){return Dislayname;}
    public void Setname(String Dislayname) {this.Dislayname = Dislayname ;}
    public String GetNgSinh(){return ngaysinh;}
    public void SetNgSinh(String ngaysinh){this.ngaysinh=ngaysinh;}
    public String GetGT(){return gt;}
    public void SetGT(String gt){this.gt = gt ; }  
    public String Getusername(){return username;}
    public void SetUsername(String username){ this.username = username;}
    public String GetPass(){return password;}
    public void SetPass(String password){ this.password = password;}
    public String GetType(){return type;}
    public void SetType(String type){ this.type = type;}
}

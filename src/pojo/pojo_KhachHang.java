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
public class pojo_KhachHang {
     private String id,name, gt , cmnd, dtlh,email,password,nhanphong;
    public pojo_KhachHang(){ id =name= gt=cmnd=dtlh=email=password=nhanphong="";}
    public pojo_KhachHang(String id ,String name, String gt , String cmnd , String dtlh,String email,String password,String nhanphong)
    {
        this.id =id;
        this.name = name;
        this.gt =gt;
        this.cmnd = cmnd;
        this.dtlh = dtlh;
        this.email = email;
        this.password = password;
        this.nhanphong = nhanphong;
    }
    public pojo_KhachHang(pojo_KhachHang x)
    {
        this.id =x.id;
        this.name = x.name;
        this.gt =x.gt;
        this.cmnd = x.cmnd;
        this.dtlh = x.dtlh;
        this.email = x.email;
        this.password = x.password;
        this.nhanphong = x.nhanphong;
    }
    public String Getid(){return id;}
    public void Setid(String id){ this.id = id ; }
    public String Getname(){return name;}
    public void Setname(String name) {this.name = name ;}
    public String GetGT(){return gt;}
    public void SetGT(String gt){this.gt = gt ; }
    public String GetCMND(){return cmnd;}
    public void SetCMND(String cmnd){this.cmnd=cmnd;}
    public String GetDTLH(){return dtlh;}
    public void SetDTLH(String dtlh){ this.dtlh = dtlh;}
    public String GetEmail(){return email;}
    public void SetEmail(String email){ this.email = email;}
    public String GetPass(){return password;}
    public void SetPass(String password){ this.password = password;}
    public String GetPNP(){return nhanphong;}
    public void SetNP(String nhanphong){ this.nhanphong = nhanphong;}
}

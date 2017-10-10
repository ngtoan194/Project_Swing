/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Administrator
 */
public class Taikhoan {
    private String UserName;
    private String HoTen;
    private String GioiTinh;
    private String DiaChi;
    private String Sdt;
    private String TypeUser;

    public Taikhoan(String UserName, String HoTen, String GioiTinh, String DiaChi, String Sdt, String TypeUser) {
        this.UserName = UserName;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.TypeUser = TypeUser;
    }

    public String getUserName() {
        return UserName;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String TypeUser) {
        this.TypeUser = TypeUser;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class InvoiceRevenue072 extends Invoice072{
    private double tongDoanhThu;

    public InvoiceRevenue072(double tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public InvoiceRevenue072() {
    }

    public InvoiceRevenue072(double tongDoanhThu, int id, int idSuatChieu, int idKhachHang, int soLuongVe, double giaTien, Date ngayMua) {
        super(id, idSuatChieu, idKhachHang, soLuongVe, giaTien, ngayMua);
        this.tongDoanhThu = tongDoanhThu;
    }
    
    public void setId(int id){
        super.setId(id);
    }
    
    public void setIdKhachhang(int id){
        super.setIdKhachHang(id);
    }
    
    public void setSoLuongVe(int soLuongVe){
        super.setSoLuongVe(soLuongVe);
    }
    
    public void setGiaVe(double giaVe){
        super.setGiaTien(giaVe);
    }
    
    public void setNgayMua(Date ngayMua){
        super.setNgayMua(ngayMua);
    }
    
    public int getId(){
        return super.getId();
    }
    
    public int getidKhachHang(){
        return super.getIdKhachHang();
    }
    
    public Date getNgayMua(){
        return super.getNgayMua();
    }
    
    public double getTongTien(){
        return super.getGiaTien();
    }
    
    public int getSoLuongVe(){
        return super.getSoLuongVe();
    }
}

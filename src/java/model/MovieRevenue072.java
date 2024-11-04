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
public class MovieRevenue072 extends Movie072{
    private double tongDoanhthu;

    public MovieRevenue072(double tongDoanhthu) {
        this.tongDoanhthu = tongDoanhthu;
    }

    public double getTongDoanhthu() {
        return tongDoanhthu;
    }

    public void setTongDoanhthu(double tongDoanhthu) {
        this.tongDoanhthu = tongDoanhthu;
    }

    public MovieRevenue072() {
    }

    public MovieRevenue072(double tongDoanhthu, int id, String tenPhim, String theLoai, String daoDien, int thoiLuong, Date ngayPhathanh) {
        super(id, tenPhim, theLoai, daoDien, thoiLuong, ngayPhathanh);
        this.tongDoanhthu = tongDoanhthu;
    }
    
    public void setId(int id) {
        super.setId(id); 
    }

    public void setTenPhim(String tenPhim) {
        super.setTenPhim(tenPhim); 
    }
    
    
}

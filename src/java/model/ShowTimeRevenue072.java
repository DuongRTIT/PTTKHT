/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ShowTimeRevenue072 extends ShowTime072{
    private double tongDoanhThu;

    public ShowTimeRevenue072() {
    }

    public ShowTimeRevenue072(double tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public ShowTimeRevenue072(double tongDoanhThu, int id, int idPhim, int idPhong, Date ngayChieu, Time gioBatDau, Time gioKetThuc) {
        super(id, idPhim, idPhong, ngayChieu, gioBatDau, gioKetThuc);
        this.tongDoanhThu = tongDoanhThu;
    }

    public double getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(double tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
    
    public void setId(int id){
        super.setId(id);
    }
    
    public int getId(){
        return super.getId();
    }
    
    public void setIdPhim(int idPhim){
        super.setIdPhim(idPhim);
    }
    
    public int getIdPhim(){
        return super.getIdPhim();
    }
    
    public void setGioBatDau(Time t){
        super.setGioBatDau(t);
    }
    
    public Time getGioBatDau(){
        return super.getGioBatDau();
    }
    
    public void setGioKetThuc(Time t){
        super.setGioKetThuc(t);
    }
    
    public Time getGioKetThuc(){
        return super.getGioKetThuc();
    }
    
    public String getTenPhim(){
        return super.getTenPhim();
    }
    
    public void setScreeningRoom(String s){
        super.setScreeningRoom(s);
    }
    
    public String getScreeningRoom(){
        return super.getScreeningRoom();
    }
}

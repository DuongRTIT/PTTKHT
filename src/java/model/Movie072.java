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
public class Movie072 {
    private int id;
    private String tenPhim;
    private String theLoai;
    private String daoDien;
    private int thoiLuong;
    private Date ngayPhathanh;

    public Movie072(int id, String tenPhim, String theLoai, String daoDien, int thoiLuong, Date ngayPhathanh) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.daoDien = daoDien;
        this.thoiLuong = thoiLuong;
        this.ngayPhathanh = ngayPhathanh;
    }

    public Movie072() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayPhathanh() {
        return ngayPhathanh;
    }

    public void setNgayPhathanh(Date ngayPhathanh) {
        this.ngayPhathanh = ngayPhathanh;
    }
    
    
}

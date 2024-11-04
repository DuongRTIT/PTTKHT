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
public class Ticket072 {
    private int id;
    private int idSuatChieu;
    private int idKhachHang;
    private int idHoaDon;
    private int soLuongVe;
    private double giaTien;
    private Date ngayMua;

    public Ticket072() {
    }

    public Ticket072(int id, int idSuatChieu, int idKhachHang, int idHoaDon, int soLuongVe, double giaTien, Date ngayMua) {
        this.id = id;
        this.idSuatChieu = idSuatChieu;
        this.idKhachHang = idKhachHang;
        this.idHoaDon = idHoaDon;
        this.soLuongVe = soLuongVe;
        this.giaTien = giaTien;
        this.ngayMua = ngayMua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSuatChieu() {
        return idSuatChieu;
    }

    public void setIdSuatChieu(int idSuatChieu) {
        this.idSuatChieu = idSuatChieu;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
    
    
}

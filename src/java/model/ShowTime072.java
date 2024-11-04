/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.sql.Time;


/**
 *
 * @author ADMIN
 */
public class ShowTime072 extends Movie072{
    private int id; 
    private int idPhim;
    private int idPhong; 
    private Date ngayChieu; 
    private Time gioBatDau; 
    private Time gioKetThuc; 
    public String screeningRoom;

    public ShowTime072(int id, int idPhim, int idPhong, Date ngayChieu, Time gioBatDau, Time gioKetThuc) {
        this.id = id;
        this.idPhim = idPhim;
        this.idPhong = idPhong;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }

    public ShowTime072() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPhim() {
        return idPhim;
    }

    public void setIdPhim(int idPhim) {
        this.idPhim = idPhim;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
    
    public String getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(String screeningRoom) {
        this.screeningRoom = screeningRoom;
    }
    
}

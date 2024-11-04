/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ScreeningRoom072 {
    private int id;
    private String tenPhong;
    private int sucChua;
    private String loaiPhong;

    public ScreeningRoom072() {
    }

    public ScreeningRoom072(int id, String tenPhong, int sucChua, String loaiPhong) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.sucChua = sucChua;
        this.loaiPhong = loaiPhong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
    
    
}

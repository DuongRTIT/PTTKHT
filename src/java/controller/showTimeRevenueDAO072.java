package controller;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ShowTimeRevenue072;

public class showTimeRevenueDAO072 extends dbDAO072 {
    Connection connection = getConnection();

    public List<ShowTimeRevenue072> getShowTimesByMovieId(String movieId) {
        List<ShowTimeRevenue072> ShowTimeList = new ArrayList<>();
        String sql = """
                                    SELECT 
                                        s.id AS ShowTimeId, 
                                        s.gioBatDau, 
                                        s.gioKetThuc,
                                        s.ngayChieu,
                                        CONCAT(s.ngayChieu, ' ', s.gioBatDau) AS ShowTime,
                                        p.tenPhong AS ScreeningRoom,  
                                        SUM(h.tongTien) AS totalRevenue
                                    FROM 
                                        tblsuatchieu072 s
                                    LEFT JOIN 
                                        tblhoadon072 h ON s.id = h.idSuatChieu
                                    LEFT JOIN 
                                        tblphongChieu072 p ON s.idPhong = p.id  
                                    WHERE 
                                        s.idPhim = ? AND h.tongTien != 0
                                    GROUP BY 
                                        s.id, s.ngayChieu, s.gioBatDau, p.tenPhong; 
                     """;

        try (
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, movieId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ShowTimeRevenue072 ShowTime = new ShowTimeRevenue072();
                ShowTime.setId(rs.getInt("ShowTimeId"));
                ShowTime.setGioBatDau(rs.getTime("gioBatDau"));
                ShowTime.setGioKetThuc(rs.getTime("gioKetThuc"));
                ShowTime.setNgayChieu(rs.getDate("ngayChieu"));
                ShowTime.setScreeningRoom(rs.getString("ScreeningRoom"));
                ShowTime.setTongDoanhThu(rs.getDouble("totalRevenue"));
                ShowTimeList.add(ShowTime);
            }
        } catch (SQLException e) {
            //System.out.println("Lỗi");
            e.printStackTrace();
        }
            return ShowTimeList;
    }
    
    public String getMovieNameById(int movieId) {
        String movieName = null;
        String sql = "SELECT tenPhim FROM tblphim072 WHERE id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                movieName = rs.getString("tenPhim");
                //System.out.println(movieName);
            }
        } catch (SQLException e) {
            //System.out.println("Lỗi");
            e.printStackTrace();
        }
        return movieName;
    }
}


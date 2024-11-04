/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MovieRevenue072;
/**
 *
 * @author ADMIN
 */
public class movieRevenueDAO072 extends dbDAO072{
    Connection connection = getConnection();
    public List<MovieRevenue072> getRevenueByDateRange(String startDate, String endDate) {
        //System.out.println(startDate+ " " + endDate);
        
        List<MovieRevenue072> revenues = new ArrayList<>();
        
        
        
        String sql = """
                     SELECT p.id, p.tenPhim, SUM(h.tongTien) AS totalRevenue
                     FROM tblhoadon072 h
                     JOIN tblsuatchieu072 s ON h.idSuatChieu = s.id
                     JOIN tblphim072 p ON s.idPhim = p.id
                     WHERE h.ngayLap BETWEEN STR_TO_DATE(?, '%Y-%m-%d') AND STR_TO_DATE(?, '%Y-%m-%d')
                     GROUP BY p.id, p.tenPhim
                     ORDER BY totalRevenue DESC;""";
        try (
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                MovieRevenue072 revenue = new MovieRevenue072();
                revenue.setId(rs.getInt("id"));
                revenue.setTenPhim(rs.getString("tenPhim"));
                revenue.setTongDoanhthu(rs.getDouble("totalRevenue"));
                revenues.add(revenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(revenues);
        return revenues;
    }
    
 }   



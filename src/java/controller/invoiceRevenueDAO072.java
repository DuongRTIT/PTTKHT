/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ADMIN
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.InvoiceRevenue072;


public class invoiceRevenueDAO072 extends dbDAO072 {
    
    public List<InvoiceRevenue072> getInvoicesByShowTimeId(int showTimeId) {
        List<InvoiceRevenue072> invoiceList = new ArrayList<>();
        String sql = """
                     SELECT 
                         h.id AS InvoiceId, 
                         h.idKhachHang, 
                         h.ngayLap, 
                         h.soLuongVe, 
                         h.tongTien
                     FROM 
                         tblhoadon072 h
                     WHERE 
                         h.idSuatChieu = ?
                     """;
        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
             
            ps.setInt(1, showTimeId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                InvoiceRevenue072 invoice = new InvoiceRevenue072();
                invoice.setId(rs.getInt("InvoiceId"));
                invoice.setIdKhachHang(rs.getInt("idKhachHang"));
                invoice.setNgayMua(rs.getDate("ngayLap"));
                invoice.setSoLuongVe(rs.getInt("soLuongVe"));
                invoice.setGiaTien(rs.getDouble("tongTien"));
                invoiceList.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceList;
    }
       
    public String getShowTimeById(int id) {
    String sql = """
                SELECT 
                    s.id AS showTimeId, 
                    s.ngayChieu
                FROM 
                    tblsuatchieu072 s
                WHERE 
                    s.id = ?
                """;

    try (Connection connection = getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
         
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        // Kiểm tra nếu có dữ liệu trả về từ truy vấn
        if (rs.next()) {
            // Lấy các thông tin suất chiếu
            return rs.getDate("ngayChieu").toString();

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
}


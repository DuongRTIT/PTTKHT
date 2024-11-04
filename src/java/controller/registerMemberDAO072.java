package controller;

import controller.dbDAO072;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class registerMemberDAO072 extends dbDAO072{

    public Integer isMember(String customerId) {
        Integer membershipCardStatus = 0;
        try (Connection connection = getConnection()) {
            String sql = "SELECT thethanhvien FROM tblkhachhang072 WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                membershipCardStatus = rs.getInt("thethanhvien"); // Lấy giá trị thẻ thành viên
            }
            } 
        catch (Exception e) {
                e.printStackTrace();
        }
        return membershipCardStatus;
    }
 
    
    public boolean checkCustomerExists(String name, String dayOfBirth,String address, String phone) {
        try {Connection connection = getConnection();
            String sql = "SELECT * FROM tblkhachhang072 WHERE ten = ?  AND ngaySinh = ?AND diachi=? AND sdt = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name.trim());
            java.sql.Date sqlDate = java.sql.Date.valueOf(dayOfBirth.trim());
            statement.setDate(2, sqlDate);
            statement.setString(3, address.trim());
            statement.setString(4, phone.trim());
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String getCustomerId(String name,String dayOfBirth,String address, String phone) {
        String customerId = null;
        try {
            Connection connection = getConnection();
            String sql = "SELECT id FROM tblkhachhang072 WHERE ten = ?  AND ngaySinh = ? AND diachi=? AND sdt = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name.trim());
            java.sql.Date sqlDate = java.sql.Date.valueOf(dayOfBirth.trim());
            statement.setDate(2, sqlDate);
            statement.setString(3, address.trim());
            statement.setString(4, phone.trim());
            

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                customerId = rs.getString("id");
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerId;
    }

    public boolean createMembershipCard(String customerId,String name, String createDate) {
        try {Connection connection = getConnection();
            String sql = "INSERT INTO tblthethanhvien072 (id,idKhachHang, chuThe, ngayTao) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "TTV" + customerId);
            statement.setString(2, customerId);
            statement.setString(3, name);
            statement.setString(4, createDate);

            return statement.executeUpdate() > 0; // Trả về true nếu thêm thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateMemberStatus(String customerId) {
    try {
        Connection connection = getConnection();
        String sql = "UPDATE tblkhachhang072 SET thethanhvien = 1 WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customerId);
        return statement.executeUpdate() > 0; // Trả về true nếu cập nhật thành công
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}

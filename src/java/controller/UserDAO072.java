package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO072 extends dbDAO072{

    // Kiểm tra thông tin tài khoản và mật khẩu
    public String validateUser(String username, String password) throws ClassNotFoundException {
        String sql = "SELECT vaitro FROM tblnguoidung072 WHERE taikhoan = ? AND matkhau = ?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return rs.getString("vaitro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về false nếu không tìm thấy
    }
    //lấy tên khách hàng
    public String getFullName(String username, String password) throws ClassNotFoundException {
        String sql = "SELECT hoten FROM tblnguoidung072 WHERE taikhoan = ? AND matkhau = ?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return rs.getString("hoten");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về false nếu không tìm thấy
    }
    
    public String getFullNameById(int UserId) throws ClassNotFoundException {
        String sql = "SELECT hoten FROM tblnguoidung072 WHERE id=?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, UserId);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return rs.getString("hoten");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về false nếu không tìm thấy
    }
}

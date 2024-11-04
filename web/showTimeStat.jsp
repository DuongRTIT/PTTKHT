<%@page import="java.util.Date"%>
<%@ page import="model.ShowTimeRevenue072" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Time" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Lấy thông tin từ session
    List<ShowTimeRevenue072> showTimeList = (List<ShowTimeRevenue072>) session.getAttribute("showTimeList");
    String idPhim = (String)session.getAttribute("idPhim");
    String tenPhim = (String) session.getAttribute("tenPhim");
    String idSuatChieu =(String) session.getAttribute("idSuatChieu");
    double totalRevenue = 0;
    int totalShowTimes = 0;
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Suất Chiếu Cho Phim <%= tenPhim %></title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <h1>Chi Tiết Suất Chiếu Cho Phim: <%= tenPhim %></h1>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID Suất Chiếu</th>
                <th>Tên Phòng </th>
                <th>Giờ Bắt Đầu</th>
                <th>Giờ Kết Thúc</th>
                <th>Ngày Chiếu</th>
                <th>Tổng Doanh Thu (VND)</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (showTimeList != null && !showTimeList.isEmpty()) {
                    for (ShowTimeRevenue072 showTime : showTimeList) {
                        totalShowTimes++;
                        int id = showTime.getId() ;
                        Time gioBatDau =showTime.getGioBatDau() ;
                        Time gioKetThuc= showTime.getGioKetThuc()  ;
                        Date ngayChieu= showTime.getNgayChieu() ;
                        double doanhThu=showTime.getTongDoanhThu() ;
                        String tenPhong =showTime.getScreeningRoom();
                        totalRevenue+=doanhThu;
                    
            %>
            <tr>
                <td><%= id %></td>
                <td> <%= tenPhong %> </td>
                <td><%= gioBatDau %> </td>
                <td> <%= gioKetThuc %> </td>
                <td> <%= ngayChieu %> </td>
                <td><%= doanhThu %></td>
                <td>
                <form action="invoiceRevenue" method="POST">
                        <input type="hidden" name="idSuatChieu" value="<%= id %>">
                        <input type="hidden" name="gioBatDau" value="<%=gioBatDau %>">
                        <input type="hidden" name="gioKetThuc" value="<%=gioKetThuc %>">
                        <input type="hidden" name="ngayChieu" value="<%=ngayChieu %>">
                        <input type="hidden" name="tenPhim" value="<%=tenPhim %>">
                        <input type="hidden" name="idPhim" value="<%=idPhim %>">
                        <button type="submit" class="btn btn-info">Xem Chi Tiết</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">Không có dữ liệu</td>
            </tr>
            <%
                }
            %>
        </tbody>
        <!-- Hàng tổng cộng -->
        <tfoot>
            <tr> 
 
                <td>Tổng cộng : <%= totalShowTimes %> suất chiếu</td>
                <td></td>
                <td </td>
                <td </td>
                <td </td>
                <td><%= totalRevenue %></td>
               
            </tr>
        </tfoot>
    </table>
    <div>
        <a href="movieRevenueStatResult.jsp?id=<%= idPhim %>" class="btn btn-secondary">Quay Lại</a>
    </div>
</body>
</html>

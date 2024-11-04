<%@page import="model.MovieRevenue072"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%
    // Lấy thông tin từ session
    List<MovieRevenue072> movieRevenueList = (List<MovieRevenue072>) session.getAttribute("revenues");
    String startDate = (String) session.getAttribute("startDate");
    String endDate = (String) session.getAttribute("endDate");
    double totalRevenue=0;
    int totalMovie=0;
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thống Kê Doanh Thu Phim</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <h1>Thống Kê Doanh Thu Phim Từ <%= startDate %> Đến <%= endDate %></h1>
    <table>
        <thead>
            <tr>
                <th>ID Phim</th>
                <th>Tên Phim</th>
                <th>Tổng Doanh Thu (VND)</th>
                <th>Xem Chi Tiết</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (movieRevenueList != null) {
                    for (MovieRevenue072 movieRevenue : movieRevenueList) {
                        totalMovie++;
                        int idPhim = movieRevenue.getId();
                        String tenPhim = movieRevenue.getTenPhim();
                        double tongDoanhThu = movieRevenue.getTongDoanhthu();
                        totalRevenue+=tongDoanhThu;
            %>
            <tr>
                
                <td><%= idPhim %></td>
                <td><%= tenPhim %></td>
                <td><%= tongDoanhThu %></td>
                <td>
                    <form action="showTimeRevenue" method="POST">
                        <input type="hidden" name="idPhim" value="<%= idPhim %>">
                        <input type="hidden" name="tenPhim" value="<%= tenPhim %>">
                        <button type="submit" class="btn btn-info">Xem Chi Tiết</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4">Không có dữ liệu</td>
            </tr>
            <%
                }
            %>
        </tbody>
        <tfoot>
            <tr> 

                <td>Tổng cộng : <%= totalMovie %> Phim</td>
                <td </td>
                <td><%= totalRevenue %></td>
               
            </tr>
        </tfoot>
    </table>
    <div>
        <a href="movieRevenueStat.jsp" class="btn btn-secondary">Quay Lại</a>
    </div>
</body>
</html>

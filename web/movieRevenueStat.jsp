<%-- 
    Document   : movieRevenueStat
    Created on : Oct 28, 2024, 3:47:02 PM
    Author     : ADMIN
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thống Kê Doanh Thu Phim</title>
    <link rel="stylesheet" href="css/bootstrap.css"> 
</head>
<body>
    <% 
                String message = (String) request.getAttribute("message");
                if (message != null) { 
            %>
                <div class="alert alert-info text-center" role="alert">
                    <%= message %>
                </div>
            <% 
                } 
            %>
    <div class="container">
        <h1>Thống Kê Doanh Thu Phim</h1>

        <form action="movieRevenueStat" method="post">
            <div class="form-group">
                <label for="startDate">Chọn Ngày Bắt Đầu:</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="endDate">Chọn Ngày Kết Thúc:</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>
            <div>
                <button type="submit" href="movieRevenueStatResult.jsp"class="btn btn-primary">Thống Kê</button>
                <a href="stat.jsp" class="btn btn-secondary">Quay Lại</a>
            </div>
        </form>
    </div>

    <script src="css/bootstrap.js"></script>
</body>
</html>


<%@page import="controller.UserDAO072"%>
<%@page import="java.util.Date"%>
<%@page import="model.InvoiceRevenue072"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Time"%>
<%@page contentType="text/html;charset=UTF-8"%>

<%
    // Lấy thông tin từ session
    List<InvoiceRevenue072> invoiceList = (List<InvoiceRevenue072>) session.getAttribute("invoiceList");
    String ngayChieu = (String) session.getAttribute("ngayChieu");
    String tenPhim = (String) session.getAttribute("tenPhim");
    String idSuatChieu = (String) session.getAttribute("idSuatChieu");
    String gioBatDau = (String) session.getAttribute("gioBatDau");
    String gioKetThuc = (String) session.getAttribute("gioKetThuc"); 
    double totalRevenue = 0;
    int totalInvoice = 0;
%>


<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Các Hoá Đơn</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
        body {
            padding: 20px;
            background-color: #f8f9fa;
        }
        table {
            width: 100%;
            border-collapse: collapse; /* Gộp các đường viền lại với nhau */
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #343a40; /* Đường viền màu đen */
            text-align: left;
            padding: 10px; /* Thêm khoảng cách bên trong ô */
        }
        th {
            background-color: #343a40; /* Màu nền cho tiêu đề bảng */
            color: #ffffff; /* Màu chữ cho tiêu đề bảng */
        }
        tr:hover {
            background-color: #e9ecef; /* Hiệu ứng khi di chuột qua hàng */
        }
        .btn-custom {
            background-color: #007bff;
            color: #ffffff;
        }
        .btn-custom:hover {
            background-color: #0056b3;
            color: #ffffff;
        }
    </style>
</head>
<body>
    <h1>Chi Tiết Các Hoá Đơn Cho Phim: <%= tenPhim %></h1>
     
    <h3>Suất Chiếu: <%= gioBatDau %> - <%= gioKetThuc %> Ngày : <%= ngayChieu %></h3>
    
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID Hoá Đơn</th>
                <th>ID Khách Hàng</th>
                <th>Tên khách hàng</th>
                <th>Ngày Lập Hoá Đơn</th>
                <th>Số Lượng Vé</th>
                <th>Tổng Tiền (VND)</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (invoiceList != null && !invoiceList.isEmpty()) {
                    for (InvoiceRevenue072 invoice : invoiceList) {
                        totalInvoice++;
                        int id = invoice.getId();
                        int idKhachHang = invoice.getIdKhachHang();
                        UserDAO072 userdao=new UserDAO072();
                        String tenKhachHang= userdao.getFullNameById(idKhachHang);
                        Date ngayLap = invoice.getNgayMua();
                        int soVe = invoice.getSoLuongVe();
                        double doanhThu = invoice.getGiaTien();
                        totalRevenue += doanhThu;
            %>
            <tr>
                <td><%= id %></td>
                <td><%= idKhachHang %></td>
                <td><%= tenKhachHang %></td>
                <td><%= ngayLap %></td>
                <td><%= soVe %></td>
                <td><%= doanhThu %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">Không có hóa đơn nào.</td>
            </tr>
            <%
                }
            %>
        </tbody>
        <tfoot>
            <tr> 
 
                <td>Tổng cộng : <%= totalInvoice %> suất chiếu</td>
                <td </td>
                <td </td>
                <td></td>
                <td </td>
                <td><%= totalRevenue %></td>
               
            </tr>
        </tfoot>
    </table>

 

    <div>
        <a href="showTimeStat.jsp?id=<%= idSuatChieu %>.jsp" class="btn btn-custom">Quay Lại</a>
    </div>

</body>
</html>

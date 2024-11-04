package controller;

import model.InvoiceRevenue072;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/invoiceRevenue")
public class invoiceRevenueServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String idSuatChieu = request.getParameter("idSuatChieu");
        String gioBatDau =request.getParameter("gioBatDau");
        String gioKetThuc = request.getParameter("gioKetThuc");
        String idKhachHang =request.getParameter("idKhachHang");
        String ngayChieu=request.getParameter("ngayChieu");
        

        //System.out.println(idKhachHang);
        // Khởi tạo DAO để lấy danh sách hóa đơn dựa trên id suất chiếu
        invoiceRevenueDAO072 invoiceDao = new invoiceRevenueDAO072();
        List<InvoiceRevenue072> invoiceList = invoiceDao.getInvoicesByShowTimeId(Integer.parseInt(idSuatChieu));
        

        // Lưu danh sách hóa đơn vào session để hiển thị trên trang JSP
        
        session.setAttribute("invoiceList", invoiceList);
        session.setAttribute("idSuatChieu", idSuatChieu);
        session.setAttribute("gioBatDau", gioBatDau);
        session.setAttribute("gioKetThuc", gioKetThuc);
        session.setAttribute("ngayChieu", ngayChieu);



        // Chuyển hướng đến trang JSP hiển thị danh sách hóa đơn
        response.sendRedirect("invoiceStat.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

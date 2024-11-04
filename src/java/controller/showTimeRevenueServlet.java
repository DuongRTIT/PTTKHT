package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ShowTimeRevenue072;

@WebServlet("/showTimeRevenue")
public class showTimeRevenueServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String idPhim = request.getParameter("idPhim");
        String tenPhim =request.getParameter("tenPhim");


        // Khởi tạo DAO và lấy danh sách suất chiếu
        showTimeRevenueDAO072 showTimeDAO = new showTimeRevenueDAO072();
        List<ShowTimeRevenue072> showTimeList = showTimeDAO.getShowTimesByMovieId(idPhim);

        // Đặt thuộc tính cho request để truyền sang JSP
        session.setAttribute("showTimeList", showTimeList);
        session.setAttribute("idPhim", idPhim);
        session.setAttribute("tenPhim", showTimeDAO.getMovieNameById(Integer.parseInt(idPhim)));
        // Chuyển tiếp request tới showTimeStat.jsp
        response.sendRedirect("showTimeStat.jsp");
    }
}

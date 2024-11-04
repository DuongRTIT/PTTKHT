package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MovieRevenue072;

@WebServlet("/movieRevenueStat")
public class movieRevenueStatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        //System.out.println(startDate+" "+ endDate);

        if(endDate.compareTo(startDate) <=0){
            request.setAttribute("message", "ngày tháng nhập vào không hợp lệ, vui lòng thử lại");
            request.getRequestDispatcher("movieRevenueStat.jsp").forward(request, response);
            return;
        }

        // Khởi tạo DAO để lấy doanh thu
        movieRevenueDAO072 revenueDAO = new movieRevenueDAO072();
        List<MovieRevenue072> revenues = revenueDAO.getRevenueByDateRange(startDate, endDate);
        
        // Thêm vào request để kiểm tra trong JSP
        session.setAttribute("revenues", revenues);
        session.setAttribute("startDate", startDate);
        session.setAttribute("endDate", endDate);
 
        // Chuyển tiếp đến JSP để hiển thị kết quả
        response.sendRedirect("movieRevenueStatResult.jsp");
    }
}

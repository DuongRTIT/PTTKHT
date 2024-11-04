package controller;

import controller.registerMemberDAO072;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/registerMember")
public class registerMemberServlet extends HttpServlet {
    private registerMemberDAO072 dao = new registerMemberDAO072();
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("day_of_birth");
        String phone = request.getParameter("phone");
        String address=request.getParameter("address");
        String createDate = request.getParameter("createDate");
        //System.out.println(name+" "+dayOfBirth+" "+address+" "+phone);
        boolean exists = dao.checkCustomerExists(name, dayOfBirth,address, phone);
        //System.out.println(exists) -true
        if (exists) {
            // Lấy ID khách hàng từ CSDL
        String customerId = dao.getCustomerId(name,dayOfBirth,address, phone);
        
        if (customerId != null) { // Kiểm tra xem ID có hợp lệ không
            int isMember = dao.isMember(customerId);
            if (isMember == 0){
                  boolean created = dao.createMembershipCard(customerId, name, createDate);
                      if (created) {
                        boolean update=dao.updateMemberStatus(customerId);
                        if (update){
                            request.setAttribute("message", "Đăng ký thẻ thành viên thành công!");
                            }
                        }
                      else{
                request.setAttribute("message", "bạn đã có thẻ thành viên rồi!");
                }
                    } 
                
            }
            else {
            request.setAttribute("message", "Không thể lấy ID khách hàng!");
        }
    } else {
        request.setAttribute("message", "Thông tin khách hàng không tồn tại trong hệ thống.Vui lòng kiểm tra lại");
    }
    request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
 }

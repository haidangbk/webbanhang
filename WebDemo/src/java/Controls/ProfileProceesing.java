/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.JDBCConnection;
import Models.Member;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HaiDang
 */
public class ProfileProceesing extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Member user = (Member) session.getAttribute("memberAccount");
        String action = request.getParameter("action");
//        clear thông báo trước đó khi người dùng thay đổi thông tin thành công
//        và load lại trang này
        session.setAttribute("error", null);
        if (action != null && action.equals("update-profile")) {
            String accountUser = user.getUser();
            int position = user.getPosition();
            String email = request.getParameter("myEmail");
            String numberPhone = request.getParameter("myPhoneNumber");
            String avatar = user.getAvatar();
            String address = request.getParameter("myAddress");
            String password = user.getPassword();

            Member mb = new Member(accountUser, password, email, numberPhone,position ,avatar , address);
            boolean result = JDBCConnection.updateMember(mb);
            if (!result) {
                session.setAttribute("error", "Cannot update! Try again");
            } else {
                // fai sửa lại thông tin user trong session đang làm việc
                session.setAttribute("error", "Thay đổi thông tin thành công");
                session.setAttribute("memberAccount", mb);
            }
        }
        if (user != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Profile");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

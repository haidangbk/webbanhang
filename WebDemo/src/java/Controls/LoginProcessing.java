/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.CheckLogin;
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
public class LoginProcessing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String user = request.getParameter("user");
        String password = request.getParameter("password");
    
        JDBCConnection jdbcc = new JDBCConnection();
        CheckLogin checkLogin = new CheckLogin();
        if (jdbcc.CheckUserExist(user)) {
            if (checkLogin.checkLogin(user, password)) {
                //  Tạo ra 1 seesion để lưu trạng thái người dùng
                Member profile = jdbcc.getMember(user, password);
                if (profile != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("memberAccount", profile);
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
//                    dispatcher.forward(request, response);
                    response.sendRedirect("Index.jsp");
                }
            } else {
                request.setAttribute("errorUser", "Tk mk không chính xác");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("errorUser", "Người dùng không tồn tại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

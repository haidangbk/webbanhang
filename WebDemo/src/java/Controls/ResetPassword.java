/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.CheckUserAllMethod;
import static DAO.JDBCConnection.recoveryPassword;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hai Dang
 */
public class ResetPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("recoveryEmail");
        String newPassword = request.getParameter("resetPassword");

        CheckUserAllMethod check = new CheckUserAllMethod();
        if (check.CheckPasswordRegex(newPassword)) {
            boolean kq = recoveryPassword(email, newPassword);
            request.setAttribute("notification", null);
            if (kq) {
                session.invalidate();
                request.setAttribute("notification", "thay đổi mật khẩu thành công");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("notification", "error!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("ResetPassword.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("notification", "Mật khẩu không hợp lệ!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ResetPassword.jsp");
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

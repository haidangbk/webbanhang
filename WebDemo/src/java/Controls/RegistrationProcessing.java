/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.CheckUserAllMethod;
import DAO.JDBCConnection;
import Models.Member;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HaiDang
 */
public class RegistrationProcessing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String email = request.getParameter("email");
        String numberPhone = request.getParameter("numberPhone");
        // Check regular exepression
        CheckUserAllMethod checkRegex = new CheckUserAllMethod();
        // Kiểm tra tên tài khoản
        if (user.equals("")) {
            request.setAttribute("errorUser", "Tên tài khoản không được để trống");
        } else if (!checkRegex.CheckUserRegex(user)) {
            request.setAttribute("errorUser", "Tên tài khoản không hợp lệ");
        }
        // Kiểm tra mật khẩu
        if (password.equals("")) {
            request.setAttribute("errorPassword", "Mật khẩu không được để trống");
        } else if (!checkRegex.CheckPasswordRegex(password)) {
            request.setAttribute("errorPassword", "Mật khẩu không hợp lệ");
        }
        // Kiểm tra re-password
        if (rePassword.equals("")) {
            request.setAttribute("errorRePassword", "Mật khẩu không được để trống");
        } else if (!checkRegex.CheckRePassword(password, rePassword)) {
            request.setAttribute("errorRePassword", "Mật khẩu không trùng khớp");
        }
        //Kiểm tra email
        if ("".equals(email)) {
            request.setAttribute("errorEmail", "");
        } else if (!checkRegex.CheckEmailRegex(email)) {
            request.setAttribute("errorEmail", "Email không hợp lệ");
        }
        // Kiểm tra số điện thoại
        if ("".equals(numberPhone)) {
            request.setAttribute("errorNumberPhone", "");
        } else if (!checkRegex.CheckNumberPhoneRegex(numberPhone)) {
            request.setAttribute("errorNumberPhone", "Số điện thoại không đúng");
        }

        // kiểm tra database đã tồn tại tên người dùng chưa
        JDBCConnection jdbcc = new JDBCConnection();
        if (jdbcc.CheckUserExist(user)) {
            request.setAttribute("errorUser", "Tên người dùng đã tồn tại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);
        } else if (!jdbcc.CheckUserExist(user)) {
            if (checkRegex.CheckUserRegex(user)
                    && checkRegex.CheckPasswordRegex(password)
                    && checkRegex.CheckRePassword(password, rePassword)
                    && (checkRegex.CheckEmailRegex(email) || email.equals(""))
                    && (checkRegex.CheckNumberPhoneRegex(numberPhone) || numberPhone.equals(""))) {
                Member nmb = new Member(user, password, email, numberPhone, null, "");
                boolean kq = jdbcc.AddUserDatabase(nmb);
                if (kq) {
                    response.sendRedirect("Login.jsp");
                } else {
                    request.setAttribute("error", "Lỗi xảy ra khi đăng ký");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("error", "Thông tin nhập không hợp lệ");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

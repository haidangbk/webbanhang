/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hai Dang
 */
public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = null;
        String action = request.getParameter("action");
        switch (action) {
            case "register":
                dispatcher = request.getRequestDispatcher("XuLyDangKy");
                dispatcher.forward(request, response);
                break;
            case "login":
                dispatcher = request.getRequestDispatcher("XuLyDangNhap");
                dispatcher.forward(request, response);
                break;
            case "profile":
                response.sendRedirect("ProfileProceesing");
                break;
            case "update-profile":
                dispatcher = request.getRequestDispatcher("ProfileProceesing");
                dispatcher.forward(request, response);
                break;
            case "logout":
                response.sendRedirect("XuLyDangXuat");
                break;
            case "sendEmail":
                dispatcher = request.getRequestDispatcher("SendEmail");
                dispatcher.forward(request, response);
                break;
            case "maXacNhan":
                dispatcher = request.getRequestDispatcher("XuLyMaXacNhan");
                dispatcher.forward(request, response);
                break;
            case "resetPassword":
                dispatcher = request.getRequestDispatcher("ResetPassword");
                dispatcher.forward(request, response);
                break;
            case "danhSachThanhVien":
                response.sendRedirect("AdminQuanLyThanhVien");
                break;
            case "xoaThanhVien":
                request.setAttribute("userAction", request.getParameter("userAction"));
                dispatcher = request.getRequestDispatcher("AdminAllMethod?action=delete");
                dispatcher.forward(request, response);
                break;
            case "upLevel":
                request.setAttribute("userAction", request.getParameter("userAction"));
                dispatcher = request.getRequestDispatcher("AdminAllMethod?action=upLevel");
                dispatcher.forward(request, response);
                break;
            case "downLevel":
                request.setAttribute("userAction", request.getParameter("userAction"));
                dispatcher = request.getRequestDispatcher("AdminAllMethod?action=downLevel");
                dispatcher.forward(request, response);
                break;
            case "Index":
                response.sendRedirect("Index.jsp");
                break;
            case "productDetails":
                request.getRequestDispatcher("ProductDetails").forward(request, response);
                break;
            case "showAllProduct":
                request.getRequestDispatcher("ShowAllProductByCategory.jsp").forward(request, response);
                break;
            case "inCart":
//                String url = request.getRequestURI();
//                request.setAttribute("url", url);
                dispatcher = request.getRequestDispatcher("CartProcessing");
                dispatcher.forward(request, response);
                break;
            default:
                break;
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

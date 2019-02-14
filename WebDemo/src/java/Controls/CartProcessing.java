/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import DAO.JDBCSanPham;
import Models.Cart;
import Models.Item;
import Models.SanPham;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HaiDang
 */
@WebServlet(name = "CartProcessing", urlPatterns = {"/CartProcessing"})
public class CartProcessing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String cartProcessing = request.getParameter("cartProcessing");
        String idSanPham = request.getParameter("idSanPham");

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            int idSanPhamInt = Integer.valueOf(idSanPham);
            SanPham sp = JDBCSanPham.getSanPham(idSanPhamInt);
            switch (cartProcessing) {
                case "addToCart":
                    if (cart.getCart().containsKey(idSanPhamInt)) {
                        cart.plusToCart(idSanPhamInt, new Item(sp, cart.getCart().get(idSanPhamInt).getSoLuong()));
                    } else {
                        cart.plusToCart(idSanPhamInt, new Item(sp, 1));
                    }
                    break;
                case "subTheCart":
                    cart.SubTheCart(idSanPhamInt, new Item(sp, cart.getCart().get(idSanPhamInt).getSoLuong()));
                    break;
                case "ofTheCart":
                    cart.offTheCart(idSanPhamInt, new Item(sp, cart.getCart().get(idSanPhamInt).getSoLuong()));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String url = (String) request.getAttribute("url");
        session.setAttribute("cart", cart);
        response.sendRedirect("Cart.jsp");
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

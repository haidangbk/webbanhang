<%-- 
    Document   : Cart
    Created on : Jan 5, 2019, 1:51:40 PM
    Author     : Hai Dang
--%>



<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Collection"%>
<%@page import="Models.Item"%>
<%@page import="Models.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.image.SampleModel"%>
<%@page import="Models.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% DecimalFormat df = new DecimalFormat("###,###.##");%>
<html>
    <head>
        <jsp:include page="WEB-INF/head_tag.jsp">
            <jsp:param name="title" value="Giỏ hàng"/>
        </jsp:include>
        <link href="css/Cart.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/top_nav.jspf" %>
        <div class="container">
            <div class="contentCart">
                <form action="Bill.jsp">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Sản Phẩm</th>
                                <th>Tên Sản Phẩm</th>
                                <th>Giá Sản Phẩm</th>
                                <th>Số Lượng</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <%for (Map.Entry<Integer, Item> item : cart.getCart().entrySet()) {%>  
                            <% SanPham sp = item.getValue().getSanPham();%>
                            <tr>
                                <td><img class="imageProduct" src="<%= sp.getAnhSanPham()%>"/></td>
                                <td class="infoProduct"><%= sp.getTenSanPham()%></td>

                                <td class="infoProduct"><%= df.format(sp.getGiaSanPham())%></td>
                                <td class="infoProduct">
                                    <a href="FrontController?action=inCart&cartProcessing=subTheCart&idSanPham=<%=sp.getIdSanPham()%>"><i class="fas fa-minus"></i></a>
                                        <%= item.getValue().getSoLuong()%>
                                    <a href="FrontController?action=inCart&cartProcessing=addToCart&idSanPham=<%=sp.getIdSanPham()%>"><i class="fas fa-plus"></i></a>
                                </td>
                                <td class="infoProduct"><a href="FrontController?action=inCart&cartProcessing=ofTheCart&idSanPham=<%=sp.getIdSanPham()%>"><i class="fas fa-trash-alt"></i></a></td>
                            </tr>
                            <%}%>    
                        </tbody>
                    </table>
                    <div>Tổng số tiền = <%= df.format(cart.totalCart())%>₫</div>
                    <button name="action" value="pay">Thanh toán</button>    
                </form>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : Bill
    Created on : Jan 8, 2019, 3:27:21 PM
    Author     : Hai Dang
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Models.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% DecimalFormat df = new DecimalFormat("###,###.##");%>
<html>
    <head>
        <jsp:include page="WEB-INF/head_tag.jsp" >
            <jsp:param name="title" value="Hóa đơn"/>
        </jsp:include>
        <link href="css/Bill.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/top_nav.jspf" %>
        <div class="container">
            <div style="margin-top: 80px;">
                <form action="" method="">
                    <div class="form-group col-12 col-md-8">
                        <label for="myAccount">Họ và tên</label>
                        <input class="form-control" type="text" name="name" value=""/>
                    </div>

                    <div class="form-group col-12 col-md-8">
                        <label for="myAccount">Điện thoại</label>
                        <input class="form-control" type="text" name="numberPhone" value="<%=profile.getNumberPhone()%>"/>
                    </div>

                    <div class="form-group col-12 col-md-8">
                        <label for="myAccount">Đại chỉ</label>
                        <textarea class="form-control" name="myAddress" value=""><%=profile.getAddress()%></textarea>
                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Sản Phẩm</th>
                                <th>Tên Sản Phẩm</th>
                                <th>Giá Sản Phẩm</th>
                                <th>Số Lượng</th>
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
                                    <%= item.getValue().getSoLuong()%>
                                </td>
                            </tr>
                            <%}%>    
                        </tbody>
                    </table>
                    <div>Tổng số tiền: <%= df.format(cart.totalCart())%>₫</div>
                    <button name="action" value="payment">Thanh toán</button>    
                </form>
            </div>
        </div>
    </body>
</html>

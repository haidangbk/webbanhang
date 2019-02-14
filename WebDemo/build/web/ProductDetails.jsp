<%-- 
    Document   : ProductDetails
    Created on : Jan 2, 2019, 1:48:58 PM
    Author     : HaiDang
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Models.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="WEB-INF/head_tag.jsp">
            <jsp:param value="Thông tin chi tiết" name="title"/>
        </jsp:include>
        <link href="css/ProductDetails.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/top_nav.jspf" %>
        <% SanPham sp = (SanPham) request.getAttribute("ProductDetails");%>
        <div class="container">

            <div class="details"><%=sp.getTenSanPham()%></div>
            
            <div class="row hang1">
                <img class="imageProduct" src="<%=sp.getAnhSanPham()%>"/>
                <div class="textProduct">
                    <% DecimalFormat df = new DecimalFormat("###,###.##");%>
                    <div class="priceProduct "><%= df.format(sp.getGiaSanPham())%>₫</div>
                    <div class=""><%=sp.getCmtSanPham()%></div>
                    <label>Chương trình khuyến mãi</label>
                    <p>Tặng phiếu giảm giá lên tới 100.000đ</p>
                    <p>15 ngày dùng thử miễn phí, 1 đổi 1 trong vòng 30 ngày</p>
                    <p>Tặng Sạc & Cáp iPhone cao cấp trị giá 150.000đ</p>
                    <p>Tặng dán lưng Carbon cao cấp trị giá 50.000đ</p>
                    <p>Hỗ trợ mua dán cường lực 5D chỉ 90.000đ</p>
                    <p>Hỗ trợ mua Tai nghe iPhone xịn chính hãng với giá 350.000đ</p>
                </div>
            </div>
            <div class="addToCart">
                <a class="btn btn-success" href="FrontController?action=inCart&cartProcessing=addToCart&idSanPham=<%=sp.getIdSanPham()%>"> Add To Cart</a>
            </div>

        </div>
    </body>
</html>

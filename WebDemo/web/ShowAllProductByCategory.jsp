<%-- 
    Document   : ShowAllProductByCategory
    Created on : Jan 2, 2019, 10:58:12 PM
    Author     : HaiDang
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Models.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String category = request.getParameter("category");
    ArrayList<SanPham> listSP = JDBCSanPham.getListSanPham(category);
%>
<html>
    <head>
        <jsp:include page="WEB-INF/head_tag.jsp">
            <jsp:param name="title" value="<%=category%>"/>
        </jsp:include>
        <link href="css/ShowAllProductByCategory.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="WEB-INF/top_nav.jspf" %>
        <div class="container">
            <div class="nameList">
                <%= category%>
            </div>
            <div class="row hang1">
                <%for (SanPham sp : listSP) {%>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <a href="FrontController?action=productDetails&idSanPham=<%= sp.getIdSanPham()%>"><img class="imageProduct" src="<%= sp.getAnhSanPham()%>" /></a>
                    <a href="FrontController?action=productDetails&idSanPham=<%= sp.getIdSanPham()%>" class="nameProduct"><%= sp.getTenSanPham()%></a>
                    <% DecimalFormat df = new DecimalFormat("###,###.##");%>
                    <div class="priceProduct"><%= df.format(sp.getGiaSanPham())%>₫</div>
                    <div><%= sp.getCmtSanPham()%></div>
                </div>
                <%}%>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : resetPassword
    Created on : Dec 19, 2018, 12:40:27 PM
    Author     : Hai Dang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Đặt lại mật khẩu</h1>
        <% String notification = (String) request.getAttribute("notification");%>
            <% if(notification!= null){%>
            <p><%= notification%></p>    
        <%}%>
        <form action="FrontController" method="get">
            <p>Nhập mật khẩu mới</p>
            <input type="text" name="resetPassword" />
            <button name="action" value="resetPassword">Xác nhận</button> 
        </form>   
    </body>
</html>

<%-- 
    Document   : FogotPassword
    Created on : Dec 18, 2018, 12:07:15 AM
    Author     : HaiDang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quên mật khẩu</title>
        <script src="js/FogotPassword.js" type="text/javascript"></script>
    </head>
    <body>
        <% if (request.getAttribute("Notification") != null) {%>
        <p><%= request.getAttribute("Notification")%></p>
        <%}%>
        <form action="FrontController" method="get">
            <p>Nhập tên đăng nhập</p>
            <input type="text" name="accountUser" placeholder="Tên tài khoản" />
            <p>Nhập Email</p>
            <input type="text" name="recoveryEmail" placeholder="Email khôi phục"/>
            <button id="btnsendEmail" name="action" value="sendEmail" onclick="disableBtn()">
                Xác nhận</button>
        </form>

    </body>
</html>

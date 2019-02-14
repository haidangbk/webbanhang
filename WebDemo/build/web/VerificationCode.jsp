<%-- 
    Document   : VerificationCode
    Created on : Dec 18, 2018, 12:30:01 AM
    Author     : HaiDang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhập mã xác minh</title>
    </head>
    <body>
        <form action="FrontController" method="get">
            <p>Nhập mã xác minh được gửi vào email của bạn</p>
            <input type="text" name="maXacNhan" value="" />
            <button name="action" value="maXacNhan">xác nhận</button>
        </form>
        
    </body>
</html>

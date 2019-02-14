<%-- 
    Document   : Login
    Created on : Nov 24, 2018, 6:40:55 PM
    Author     : HaiDang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form class="formLogin" action="FrontController" method="post">
            <div class="labelForm"><label>Form Login</label></div>
            <div class="contentForm">
                <p>${requestScope.errorUser}</p>
                <div class="divInput">
                    <input type="text" name="user" value="${param.user}" required="" placeholder="Username"/>
                    <div class="gachChan"></div>
                </div>
                <div class="divInput">          
                    <input type="password" name="password" required="" placeholder="Password"/>
                    <div class="gachChan"></div>
                </div>
                <div class="forwardPage">
                    <a href="Register.jsp" title="Đăng ký">Đăng ký</a>
                    <a href="FogotPassword.jsp" title="Quên mật khẩu">Quên mật khẩu</a>
                </div>
                <div class="divBtnSubmit">
                    <button class="btnSubmit" name="action" value="login">
                        Đăng nhập</button>
                </div>
            </div>
        </form>
    </body>
</html>

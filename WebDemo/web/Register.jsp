<%-- 
    Document   : Register
    Created on : Nov 24, 2018, 7:00:19 PM
    Author     : HaiDang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form class="formRegister" action="FrontController" method="post">
            <div class="labelForm">
                Form Register
            </div>
            <div class="contentForm">
                <div class="userInfomation">
                    <p>${requestScope.errorUser}</p>
                    <label class="label">Tên tài khoản</label>
                    <!--Sử dụng regular expression để kiểm tra tính hợp lệ ngay trên client
                    có thể dùng js để tùy biến thêm-->
                    <div class="divInput">
                        <input class="input" type="text" name="user" value="${param.user}"
                               placeholder="User" required="" pattern="[a-zA-Z0-9_-]{6,45}"
                               title="Tên người dùng phải là chữ cái hoặc số từ 6-45 ký tự">
                        <div class="gachChan"></div>
                    </div>
                    <div class="a"></div>
                </div>
                <div class="userInfomation">
                    <p>${requestScope.errorPassword}</p>
                    <label class="label">Mật khẩu</label>
                    <div class="divInput">
                        <input class="input" type="password" name="password" value="${param.password}"
                               placeholder="Password" required=""/>
                        <div class="gachChan"></div>
                    </div>
                    <div class="a"></div>
                </div>
                <div class="userInfomation">
                    <p>${requestScope.errorRePassword}</p>
                    <label class="label">Nhập lại mật khẩu</label>
                    <div class="divInput">
                        <input class="input" type="password" name="rePassword" placeholder="Password" required=""/>
                        <div class="gachChan"></div>
                    </div>
                    <div class="a"></div>
                </div>
                <div class="userInfomation">
                    <p>${requestScope.errorEmail}</p>
                    <label class="label">Email</label>
                    <div class="divInput">
                        <input class="input" type="text" name="email" value="${param.email}" placeholder="Email"/>
                        <div class="gachChan"></div>
                    </div>
                    <div class="a"></div>
                </div>
                <div class="userInfomation">
                    <p>${requestScope.errorNumberPhone}</p>
                    <label class="label">Số điện thoại</label>
                    <div class="divInput">
                        <input class="input" type="text" name="numberPhone" value="${param.numberPhone}" placeholder="Số điện thoại"/>
                        <div class="gachChan"></div>
                    </div>
                    <div class="a"></div>
                </div>
                <div class="divBtnSubmit"><button class="btnSubmit" type="submit" name="action" value="register">Đăng ký</button></div>
            </div>
        </form>
    </body>
</html>

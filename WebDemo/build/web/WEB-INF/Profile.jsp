<%-- 
    Document   : Profile
    Created on : Nov 30, 2018, 10:04:52 PM
    Author     : HaiDang
--%>
<%@page import="Models.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/head_tag.jsp">
            <jsp:param name="title" value="Profile"/>
        </jsp:include>
        <link href="css/Profile.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--top_nav(menu)-->
        <%@include file="top_nav.jspf" %>
        <!--nội dung profile-->
        <!--Do top_nav đã lấy profile rồi nên không cần lấy lại tại đây-->
        <h2>Profile</h2>
        <img src="" alt="Avatar để đây"/>
        <h3><%=profile.getUser()%></h3>
        <% if (session.getAttribute("error") != null) { %>
        <div class="alert alert-danger col-12 col-md-8 ">
            ${sessionScope.error}
        </div>
        <%}%>
        <form action="FrontController" method="post">
            <div class="form-group col-12 col-md-8">
                <!--for === id thì khi click vào label tự động nhảy vào input-->
                <label for="myAccount" >Tên tài khoản</label>
                <input type="text" class="form-control" disabled=""
                       name="myAccount"
                       id="myAccount" value="<%= profile.getUser()%>"/>
            </div>
            <div class="form-group col-12 col-md-8">
                <label for="myEmail">Email</label>
                <input type="text" id="myEmail" class="form-control" 
                       name="myEmail" value="<%= profile.getEmail()%>"
                       >
            </div>
            <div class="form-group col-12 col-md-8">
                <label for="myPhoneNumber">Số điện thoại</label>
                <input type="text" class="form-control" name="myPhoneNumber"
                       id="myPhoneNumber" value="<%= profile.getNumberPhone()%>">
            </div>
            <div class="form-group col-12 col-md-8">
                <label for="address">Địa chỉ</label>
                <textarea rows="4" cols="85%" class="form-control" name="myAddress" id="myAddress" value=""><%=profile.getAddress()%></textarea>
            </div>
            <div class="form-group col-12 col-md-8">
                <label for="myPassword">Mật khẩu</label>
                <input type="password" class="form-control"
                       name="myPassword"
                       id="myPassword" value="">
            </div>
            <div class="btnForm">
                <button type="submit" name="action" value="update-profile">Save</button>
            </div>
        </form>

    </body>
</html>

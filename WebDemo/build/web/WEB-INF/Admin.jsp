
<%@page import="Models.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head_tag.jsp">
            <jsp:param name="title" value="Admin"/>
        </jsp:include>
        <link href="css/AdminMenu.css" rel="stylesheet" type="text/css"/>
        <link href="css/Admin.css" rel="stylesheet" type="text/css"/>
    </head>

    <div>
        <%@include file="Admin_Menu.jspf" %>
    </div>
    <% ArrayList<Member> listMember = (ArrayList<Member>) session.getAttribute("listMember"); %>
    <% if (listMember != null) { %>
    <div class="tableMember">
        <h2 style="text-align: center;">DANH SÁCH THÀNH VIÊN</h2>
        <!--Thông báo khi xóa thành viên-->
        <% String s = request.getParameter("userDelete");
            String a = ""; %>
        <% if (s != null) {%>
        <% if (s.equals("true")) {%>
        <%  a = "Xóa thành công";%>
        <%} else if (s.equals("false")) {%>
        <%  a = "Xóa thất bại";%>
        <%}%>
        <p class="notificationDeleteUser"><%= a%></p>
        <% }%>
        <!--Thông báo khi tăng level thành viên-->
        <%  s = request.getParameter("userUpLevel");
            a = ""; %>
        <% if (s != null) {%>
        <% if (s.equals("true")) {%>
        <%  a = "Tăng level thành công";%>
        <%} else if (s.equals("false")) {%>
        <%  a = "Tăng level thất bại";%>
        <%}%>
        <p class="notificationDeleteUser"><%= a%></p>
        <% }%>
        <!--Thông báo hạ level thành viên-->
        <%  s = request.getParameter("userDownLevel");
            a = ""; %>
        <% if (s != null) {%>
        <% if (s.equals("true")) {%>
        <%  a = "Hạ level thành công";%>
        <%} else if (s.equals("false")) {%>
        <%  a = "Hạ level thất bại";%>
        <%}%>
        <p class="notificationDeleteUser"><%= a%></p>
        <% }%>
        <table class="table">
            <thead>
                <tr>
                    <th>Tên tài khoản</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th colspan="2">Position</th>
                </tr>
            </thead>
            <tbody>
                <% for (Member mb : listMember) {
                        String position = "";%>
                <tr>
                    <td><%= mb.getUser()%></td>
                    <% request.setAttribute("userAction", mb.getUser());%>
                    <td><%= mb.getEmail()%></td>
                    <td><%= mb.getNumberPhone()%></td>
                    <%if (mb.getPosition() == 1) {
                            position = "Member";
                        } else {
                            position = "Admin";
                        }
                    %>
                    <td><%= position%></td>
                    <% if (mb.getPosition() >= profile.getPosition()) { %>
                    <td><a class="not-active" href="FrontController?action=xoaThanhVien&userAction=${userAction}">
                            <i class="fas fa-trash-alt"></i>
                            <i class="fas fa-ban"></i>
                        </a>
                    </td>
                    <%} else {%>
                    <td><a href="FrontController?action=xoaThanhVien&userAction=${userAction}">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                        <%if (profile.getPosition() > (mb.getPosition() + 1)) {%>
                        <a href="FrontController?action=upLevel&userAction=${userAction}">
                            <i class="fas fa-level-up-alt"></i>
                        </a>
                        <%}%>

                        <%if (mb.getPosition() != 1) {%>
                        <a href="FrontController?action=downLevel&userAction=${userAction}">
                            <i class="fas fa-level-down-alt"></i>
                        </a>
                        <%}%>
                    </td>
                    <%}%>
                </tr>
                <%}%> 
            </tbody>
        </table>
    </div>
    <%}%>
</html>

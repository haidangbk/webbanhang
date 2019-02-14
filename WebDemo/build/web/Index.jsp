<%-- 
    Document   : Index
    Created on : Nov 26, 2018, 9:14:47 PM
    Author     : HaiDang
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Models.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--chỉ định 1 file jsp-->
        <jsp:include page="WEB-INF/head_tag.jsp">
            <jsp:param name="title" value="Index"/>
        </jsp:include>
        <link href="css/Index.css" rel="stylesheet" type="text/css"/>
        <script src="js/Index.js" type="text/javascript"></script>

    </head>
    <body>

        <!--Thanh menu-->
        <%@include file="WEB-INF/top_nav.jspf" %>

        <% String notification = (String) request.getAttribute("notification");%>
        <% if (notification != null) {%>
        <script> nofitication();</script>
        <%}%>
        <!-- Nội dung web-->
        <div class="container">
            <div class="slideShow_video row">
                <!--        SLIDE SHOW
            carousel-fade: tạo hiệu ứng mờ khi chuyển slide
            slide giúp tạo ra chuyển động khi nhảy trang
            data-interval="3000" thiết lập thời gian tự chuyển slide, mặc định = 5000-->
                <div id="mySlideShow" class="carousel slide carousel-fade col-lg-8 col-md-12" 
                     data-ride="carousel" data-interval="3000">
                    <!--Indicators--> 
                    <ul class="carousel-indicators">
                        <li data-target="#mySlideShow" data-slide-to="0" class="active">1</li>
                        <li data-target="#mySlideShow" data-slide-to="1" >2</li>
                        <li data-target="#mySlideShow" data-slide-to="2">3</li>
                    </ul>
                    <!--The slideshow--> 
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <!--d-block w-100 có tác dụng responsive cho slideShow-->
                            <a href="#">
                                <img class="anhSlideShow d-block w-100" src="slideShow/0406anhdao.jpg" alt="Hoa anh đào"/>
                            </a>
                            <!--carousel-caption để hiển thị chữ, d-sm-block và d-none để ẩn chữ khi mh nhỏ-->
                            <div class="carousel-caption d-md-block d-none">
                                <h3>Tiêu đề</h3>
                                <p>Thank you, Đây là hoa anh đào!</p>
                            </div> 
                        </div>
                        <div class="carousel-item">
                            <a href="#">
                                <img class="anhSlideShow d-block w-100" src="slideShow/tiaSet.jpg" alt="Tia sét"/>
                            </a>
                        </div>
                        <div class="carousel-item">
                            <a href="#">
                                <img class="anhSlideShow d-block w-100" src="slideShow/traiTimXanh.jpg" alt="Trái tim"/>
                            </a>
                        </div>
                    </div>
                    <!--Left and right controls--> 
                    <a class="carousel-control-prev" href="#mySlideShow" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#mySlideShow" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
                <!--d-none d-lg-block chỉ hiển thị khi màn hình >= lg-->
                <div id="rightSlideShow" class="col-lg-4 d-none d-lg-block">
                    <!--responsive video bằng embed-responsive embed-responsive-16by9-->
                    <div class="topRightSlideShow embed-responsive embed-responsive-16by9">
                        <!--để video tự động chạy thêm autoplay muted do chrome chặn phát video có âm thanh-->
                        <video controls="" >
                            <source src="video/video.mp4" type="video/mp4">
                        </video>
                    </div>
                    <div class="bottomRightSlideShow">
                        <a href="#"><img class="img-fluid" src="image/bh-xiaomi-15th_1538472797_1542335195.png" /></a>
                    </div>
                </div>
            </div>


            <!--Hiển thị thông tin các sản phẩm-->

            <div class="contentProtect">
                <%for (DanhMucSanPham dmsp : listDmsp) {%>
                <div class="nameList row">
                    <div class="divIconNameList"><i class="fas fa-mobile-alt iconNameList"></i></div>
                    <div class="nameList1"><%= dmsp.getTen_danh_muc()%></div> 
                </div>
                <% ArrayList<SanPham> listSPTop = jdbcSP.getTopSanPham(dmsp.getTen_danh_muc(), 4); %>
                <div class="row hang1">
                    <%for (SanPham sp : listSPTop) {%>
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <div><a href="FrontController?action=productDetails&idSanPham=<%= sp.getIdSanPham()%>"><img class="imageProduct" src="<%= sp.getAnhSanPham()%>" /></a></div>
                        <div><a href="FrontController?action=productDetails&idSanPham=<%= sp.getIdSanPham()%>" class="nameProduct"><%= sp.getTenSanPham()%></a></div>
                        <% DecimalFormat df = new DecimalFormat("###,###.##"); %>
                        <div class="priceProduct"><%=df.format(sp.getGiaSanPham())%>₫</div>
                        <div><%= sp.getCmtSanPham()%></div>
                    </div>
                    <%}%>
                </div>
                <%}%>
            </div>
            <a href="LoginExist?action=home">Home</a>
            <p><a href="FrontController?action=logout">Đăng xuất</a></p>
        </div>
    </body>
</html>

<%-- 
    Document   : client
    Created on : 14 Jan 2020, 5:02:27 PM
    Author     : NKAZIMULO
--%>

<%@page import="java.sql.Connection,java.sql.*,java.util.*,java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Class.forName("com.mysql.jdbc.Driver");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="generator" content="Mobirise v4.6.4, mobirise.com">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
        <link rel="shortcut icon" href="assets/images/20191218_085100.jpg" type="image/x-icon">
        <meta name="description" content="">
        <title>Home</title>
        <link rel="stylesheet" href="asseth/web/assets/mobirise-icons/mobirise-icons.css">
        <link rel="stylesheet" href="asseth/tether/tether.min.css">
        <link rel="stylesheet" href="asseth/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="asseth/bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="asseth/bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="asseth/socicon/css/styles.css">
        <link rel="stylesheet" href="asseth/datatables/data-tables.bootstrap4.min.css">
        <link rel="stylesheet" href="asseth/dropdown/css/style.css">
        <link rel="stylesheet" href="asseth/theme/css/style.css">
        <link rel="stylesheet" href="asseth/mobirise/css/mbr-additional.css" type="text/css">
    </head>
    <body>
        <section class="menu cid-rFxexeix0p" once="menu" id="menu1-z">



            <nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <div class="hamburger">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </button>
                <div class="menu-logo">
                    <div class="navbar-brand">
                        <span class="navbar-logo">
                            <a href="index.html">
                                <img src="assets/images/20191218_085100.jpg" alt="Mobirise" style="height: 3.8rem; width: 100px;">
                            </a>
                        </span>
                        <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="https://mobirise.com"></a></span>
                    </div>
                </div>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
                        <li class="nav-item">
                            <a class="nav-link link text-white display-4" href="index.html">
                                Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link link text-white display-4" href="contact.html">
                                Contact Us
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link link text-white display-4" href="https://mobirise.com">
                                About Us
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link link text-white display-4" href="LogoutServlet.do">
                                logout
                            </a>
                        </li>
                    </ul>

                </div>
            </nav>
        </section>

        <section class="engine"><a href="https://mobirise.ws">Mobirise</a></section><section class="section-table cid-rNyKT2o6k3" id="table1-12">



            <div class="container container-table">
                <h2 class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">Clients information</h2>
                <h3 class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5"></h3>
                <div class="table-wrapper">
                    <div class="container">
                        <div class="row search">
                            <div class="col-md-6"></div>
                            <div class="col-md-6">
                                <div class="dataTables_filter">
                                    <label class="searchInfo mbr-fonts-style display-7">Search:</label>
                                    <input class="form-control input-sm" disabled="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="container scroll">
                        <table class="table isSearch" cellspacing="0">
                            <thead>
                                <tr class="table-heads ">




                                    <th class="head-item mbr-fonts-style display-7">
                                        NAME</th><th class="head-item mbr-fonts-style display-7">
                                        PHONE</th><th class="head-item mbr-fonts-style display-7">
                                        TIME</th><th class="head-item mbr-fonts-style display-7">
                                        MESSAGE</th></tr>
                            </thead>

                            <tbody>


                                <%
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctordb?zeroDateTimeBehavior=convertToNull", "root",""); 
                                    String sql = "select name, surname, phone, time, message from tblreg";
                                    PreparedStatement pst = con.prepareStatement(sql);
                                    ResultSet rs = pst.executeQuery();
                                    
                                    while(rs.next()){%>
                                    
                                    <tr><td class="body-item mbr-fonts-style display-7"><%=rs.getString(1) +" "+rs.getString(2)%></td><td class="body-item mbr-fonts-style display-7"><%=rs.getString(3)%></td><td class="body-item mbr-fonts-style display-7"><%=rs.getString(4)%></td><td class="body-item mbr-fonts-style display-7"><%=rs.getString(5)%></td></tr>
                                    <%}%>
                                

                                




                                    




                                    
                        </table>
                    </div>
                    <div class="container table-info-container">
                        <div class="row info">
                            <div class="col-md-6">
                                <div class="dataTables_info mbr-fonts-style display-7">
                                    <span class="infoBefore"></span>
                                    <span class="inactive infoRows"></span>
                                    <span class="infoAfter"></span>
                                    <span class="infoFilteredBefore">&nbsp;</span>
                                    <span class="inactive infoRows"></span>
                                    <span class="infoFilteredAfter"></span>
                                </div>
                            </div>
                            <div class="col-md-6"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="cid-rF5AD8K1ws" id="footer1-w">





            <div class="container">
                <div class="media-container-row content text-white">
                    <div class="col-12 col-md-3 mbr-fonts-style display-7">
                        <h5 class="pb-3">
                            Address
                        </h5>
                        <p class="mbr-text">Erf 12535 Ivory Park<br>Ivory Park<br>1693</p>
                    </div>
                    <div class="col-12 col-md-3 mbr-fonts-style display-7">
                        <h5 class="pb-3">
                            Contacts
                        </h5>
                        <p class="mbr-text">
                            Email: phakamani@gmail.com
                            <br>Phone: 0662306456<br><br></p>
                    </div>
                    <div class="col-12 col-md-3 mbr-fonts-style display-7">
                        <h5 class="pb-3">Pages</h5>
                        <p class="mbr-text"><a href="index.html">Home</a><br><a href="contact.html">Contact Us</a><br><a href="patience.html">Clients</a><br><br></p>
                    </div>
                </div>
                <div class="footer-lower">
                    <div class="media-container-row">
                        <div class="col-sm-12">
                            <hr>
                        </div>
                    </div>
                    <div class="media-container-row mbr-white">
                        <div class="col-sm-6 copyright">
                            <p class="mbr-text mbr-fonts-style display-7">
                                © phakamani dlongolo</p>
                        </div>
                        <div class="col-md-6">
                            <div class="social-list align-right">
                                <div class="soc-item">
                                    <a href="https://twitter.com" target="_blank">
                                        <span class="socicon-twitter socicon mbr-iconfont mbr-iconfont-social"></span>
                                    </a>
                                </div>
                                <div class="soc-item">
                                    <a href="https://www.facebook.com" target="_blank">
                                        <span class="socicon-facebook socicon mbr-iconfont mbr-iconfont-social"></span>
                                    </a>
                                </div>
                                <div class="soc-item">
                                    <a href="https://instagram.com" target="_blank">
                                        <span class="socicon-instagram socicon mbr-iconfont mbr-iconfont-social"></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="asseth/web/assets/jquery/jquery.min.js"></script>
        <script src="asseth/popper/popper.min.js"></script>
        <script src="asseth/tether/tether.min.js"></script>
        <script src="asseth/bootstrap/js/bootstrap.min.js"></script>
        <script src="asseth/datatables/jquery.data-tables.min.js"></script>
        <script src="asseth/datatables/data-tables.bootstrap4.min.js"></script>
        <script src="asseth/dropdown/js/script.min.js"></script>
        <script src="asseth/touchswipe/jquery.touch-swipe.min.js"></script>
        <script src="asseth/smoothscroll/smooth-scroll.js"></script>
        <script src="asseth/theme/js/script.js"></script>


    </body>
</html>

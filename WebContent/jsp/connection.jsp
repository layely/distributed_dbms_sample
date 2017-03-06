<%@page import="metier.Logement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

        <meta charset="utf-8">
        <title>Accueil</title>
        <style type="text/css">
            body{
                background-color: red;
            }
            .site-header{
                padding-top             : 50px;
                padding-bottom          : 20px;
                position                : relative;
            }
            .site-header .header-logo{
                float                   : left;
                margin-right            : 15px;
            }
            .site-header .header-menu .mobile-menu{
                display                 : none;
                width                   : 30px;
                height                  : 30px;
                padding                 : 0;
                margin                  : 0;
                border                  : none;
                outline                 : none;
                background-color        : #fff;
                position                : absolute;
                top                     : 50px;
                right                   : 30px;
            }
            .site-header .header-menu ul{
                list-style-type         : none;
                margin                  : 0;
                padding                 : 0;
            }
            .site-header .header-menu ul li{
                position                : relative;
                z-index                 : 999;
            }
            .site-header .header-menu ul li a{
                display                 : block;
                white-space             : nowrap;
                font-family             : 'Code Bold';
                font-size               : 11px;
                letter-spacing          : 3px;
            }
            .site-header .header-menu ul li .down{
                display                 : none;
                width                   : 30px;
                height                  : 30px;
                cursor                  : pointer;
                background              : url("../img/ico-up-down.png") no-repeat scroll 0 0 #ebebeb;
                position                : absolute;
                top                     : 0;
                right                   : 0;
            }
            .site-header .header-menu ul li .down.opened{
                background-position     : 0 -30px;
            }
            .site-header .header-menu ul li.active > a{
                color                   : #c5a35b;
            }
            body {
                background-color: #685d59;
            }

            a:hover, a:focus {
                color: #c5a35b;
                text-decoration: none;
            }

            .container {
                /*width: 1140px;*/
                padding: 0px;
                box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.5);
            }

            /* Header */
            .header-logo a img {
                width: 180px;
                height: 20px
            }
            .site-header {
                padding: 30px;
            }

            .site-header .header-menu {
                margin-top: 15px;
                margin-right: 15px;
                float: right;
            }
            .site-header .header-menu > ul > li > ul {
                padding-top: 41px;
            }
            .site-header .header-menu ul li a {
                font-size: 12px;
            }
            .site-header .header-menu{
                margin-top              : 11px;
                float                   : left;
            }
            .site-header .header-menu ul li a{
                padding                 : 0 15px;
            }
            .site-header .header-menu ul li ul{
                position                : absolute;
                visibility              : hidden;
                opacity                 : 0;
                filter                  : alpha(opacity=0);
                background-color        : #fff;
            }
            .site-header .header-menu ul li ul li{
                height                  : 0;
                -webkit-transition      : height 200ms ease-in;
                -moz-transition         : height 200ms ease-in;
                -o-transition           : height 200ms ease-in;
                transition              : height 200ms ease-in;
            }
            .site-header .header-menu ul li ul li a{
                height                  : 30px;
                line-height             : 30px;
                border-bottom           : 1px solid #FFF;
            }
            .site-header .header-menu ul li ul li ul{
                top                     : 0;
                left                    : 100%;
                border-top              : 1px solid #ebebeb;
                border-right            : 1px solid #ebebeb;
                border-bottom           : 1px solid #ebebeb;
            }
            .site-header .header-menu ul li ul li ul li a{
                border-left             : 1px solid #ebebeb;
            }
            .site-header .header-menu ul li ul li ul li:first-child a{
                border-color            : #FFF;
            }
            .site-header .header-menu ul li:hover > a{
                color                   : #c5a35b;
            }
            .site-header .header-menu ul li:hover > ul{
                visibility              : visible;
                opacity                 : 1;
                filter                  : alpha(opacity=100);
            }
            .site-header .header-menu ul li:hover > ul > li{
                height                  : 30px;
            }
            .site-header .header-menu > ul > li{
                float                   : left;
            }
            .site-header .header-menu > ul > li > a{
                height                  : 15px;
                line-height             : 18px;
            }
            .site-header .header-menu > ul > li > ul{
                top                     : 15px;
                padding-top             : 21px;
            }
            .site-header .header-menu > ul > li > ul li:hover > a{
                border-bottom-color     : #ebebeb;
            }
            .site-footer .footer-top{
                padding                 : 50px 30px 20px 30px;
            }
            .site-footer .footer-top .col-md-4{
                margin-bottom           : 30px;
            }
            .site-footer .footer-bottom{
                padding                 : 20px 30px;
            }
            .site-footer .footer-bottom .nav-default{
                margin-bottom           : 10px;
            }
            .site-footer .footer-bottom .nav-default li a{
                padding                 : 0 10px;
            }
            .site-footer .footer-bottom .nav-default li:first-child a{
                padding-left            : 0;
            }
            .site-footer .title-border{
                border-bottom           : 1px solid #d9d9d9;
            }
            .site-footer .title-border:after{
                height                  : 1px;
                bottom                  : -1px;
                width                   : 50%;
            }
            .site-footer .latest-posts .latest-item{
                margin-bottom           : 10px;
            }
            .site-footer .latest-posts .post-image{
                border                  : 5px solid #FFF;
                float                   : left;
                margin-right            : 10px;
            }
            .site-footer .latest-posts .post-title,
            .site-footer .latest-posts .post-desc,
            .site-footer .latest-posts .post-date{
                font-size               : 12px;
                display                 : block;
                white-space             : nowrap;
                overflow                : hidden;
                text-overflow           : ellipsis;
                margin-bottom           : 3px;
            }
            .site-footer .latest-posts .post-date{
                font-size               : 11px;
                color                   : #666;
            }
            /* Footer */
            .site-footer ul {
                list-style: square;
                padding: 0;
                color: #c5a35b;
            }
            .site-footer ul li {
                padding-left: 3px;
                margin-left: 12px;
                margin-bottom: 8px;
            }
            .footer-bottom {
                background-color: #181819;
                color: #fff;
                text-align: center;
            }
            .footer-bottom a {
                color: #c5a35b;
            }
            .site-footer .footer-top .col-md-4:last-child {
                margin-bottom: 5px;
            }
            /*box*/
            .box-grey{
                background-color        : #f2f2f2;
            }
            .box-grey .owl-buttons div{
                background-color        : #fff !important;
            }
            .box-grey .owl-buttons div:hover{
                background-color        : #ebebeb !important;
            }


            .section-collection{
                padding-bottom          : 0;
            }
            .section-collection .collection-item{
                position                : relative;
                padding                 : 20px 20px 20px 170px;
                margin-bottom           : 30px;
                height                  : 170px;
            }
            .section-collection .collection-item .collection-image{
                width                   : 150px;
                height                  : 150px;
                overflow                : hidden;
                position                : absolute;
                top                     : 0;
                left                    : 0;
            }
            .section-collection .collection-item .collection-image:after{
                position                : absolute;
                display                 : inline-block;
                content                 : '';
                top                     : 50%;
                -webkit-transform      : translateY(-50%);
                -ms-transform           : translateY(-50%);
                transform               : translateY(-50%);
                right                   : 0;
                width                   : 0;
                height                  : 0;
                border-top              : 15px solid transparent;
                border-right            : 15px solid #f2f2f2;
                border-bottom           : 15px solid transparent;
            }
            .collection-desc {
                max-height: 120px;
                overflow: hidden;
            }




            .title-border{
                font-family             : 'Code Bold';
                font-size               : 14px;
                text-align              : left;
                letter-spacing          : 3px;
                padding-bottom          : 10px;
                margin-bottom           : 20px;
                position                : relative;
            }
            .title-border .line{
                font-family:Arial, Helvetica, sans-serif;
            }
            .title-border:after{
                content                 : " ";
                position                : absolute;
                bottom                  : 0;
                left                    : 0;
                width                   : 20px;
                height                  : 2px;
                background-color        : #c5a35b;
            }
            .title-border.right{
                display                 : inline-block;
                padding-right           : 30px;
                padding-bottom          : 0;
            }
            .title-border.right:after{
                top                     : 50%;
                margin-top              : -2px;
                right                   : 0;
                bottom                  : inherit;
                left                    : inherit;
            }
            .title-border.left{
                padding-left            : 30px;
                padding-bottom          : 0;
            }
            .title-border.left:after{
                margin-top              : -2px;
                top                     : 50%;
                left                    : 0;
                bottom                  : inherit;
            }

            /*slider*/
            .site-slider .slide-caption{
                position                : absolute;
                top                     : 0;
                left                    : 0;
                background              : #000\9;
                background              : rgba(0, 0, 0, 0.50);
                width                   : 100%;
                height                  : 100%;
            }
            .site-slider .slide-caption .caption-wrap{
                color                   : #fff;
                display                 : block;
                padding                 : 0 120px;
                text-align              : center;
                position                : relative;
                top                     : 50%;
                -webkit-transform      : translateY(-50%);
                -ms-transform           : translateY(-50%);
                transform               : translateY(-50%);
            }
            .site-slider .slide-caption .caption-big,
            .site-slider .slide-caption .caption-small{
                font-family             : 'Roboto Slab', serif;
                font-weight             : 700;
                margin                  : 0;
            }
            .site-slider .slide-caption .caption-big{
                font-size               : 36px;
                margin-bottom           : 10px;
            }
            .site-slider .slide-caption .caption-small{
                display                 : inline-block;
                position                : relative;
                font-size               : 30px;
                font-weight             : 400;
                padding                 : 0 30px;
            }
            .site-slider .slide-caption .caption-small:before,
            .site-slider .slide-caption .caption-small:after{
                content                 : " ";
                position                : absolute;
                top                     : 50%;
                width                   : 20px;
                height                  : 2px;
                background-color        : #c5a35b;
            }
            .site-slider .slide-caption .caption-small:before{
                left                    : 0;
            }
            .site-slider .slide-caption .caption-small:after{
                right                   : 0;
            }

        </style>



        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class='container'>
            <!-- Header -->
            <header class="site-header box-white padding-all clearfix">

                <div class="header-logo"><a href="#"><img src="img/logo.png" alt="Espace"></a></div>

                <div class="header-menu">
                    <button class="mobile-menu"><i class="fa fa-bars fa-2x"></i></button>

                    <ul class="clearfix">
                        <li><a href="index.php?action=tout">Accueil</a>
                        </li>
                        <li><a href="presentation.html">Présentation</a>
                        </li>
                        <li><a href="#">Nos Logement</a>
                            <ul>
                                <li><a href="appartement.php?action=appartement">Appartement </a></li>
                                <li><a href="batiment.php?action=batiment">Batiment</a></li>

                            </ul>
                        </li>
                        </li>
                        <li><a href="../jsp/contact.html">Contact</a>
                        </li>
                        <li class="active"><tt/><a><b class='glyphicon glyphicon-log-in'></b>       connection</a></li>
                    </ul>







                </div>
                <div class="row">
                    <div class="col-md-8">
                        <form class="form-horizontal" method="post" action="ajout.php?action=Enregistrer">
                            <br><br>
                            <div class="form-group">
                                <label for="nom" class="col-sm-4 control-label">Entrer votre Nom</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="prenom" class="col-sm-4 control-label">Entrer votre Prenom</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="fist name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address" class="col-sm-4 control-label">Adresse</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="address" name="address" placeholder="address">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="tel" class="col-sm-4 control-label">Entrer votre numero de telephone</label>
                                <div class="col-sm-8">
                                    <input type="numb" class="form-control" id="tel" name="telephone" placeholder="telephone">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail" class="col-sm-4 control-label">Entrer votre Address email</label>
                                <div class="col-sm-8">
                                    <input type="mail" class="form-control" id="mail" name="mail" placeholder="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-4 control-label">Entrer votre password</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="conf" class="col-sm-4 control-label">confirmation</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="conf" name="confPassword" placeholder="ConfPassword">
                                </div>
                            </div>
                            <br>
                            <input type="submit" class="btn btn-info col-sm-12" id ="enregistrer" value="enregistrer">
                        </form>
                    </div>
                    <div class="col-md-4">
                        Connection avec un compte existant
                        <form method="post" action="">
                            <br/><br/>
                            <div class="form-group">
                                <label for="email_authentification" class="col-sm-12 control-label">Email</label>
                                <div class="col-sm-12">
                                    <input type="text" class="form-control" id="email_authentification" name="email_authentification" placeholder="Authentification">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password_authentification" class="col-sm-12 control-label">Mot de Passe</label>
                                <div class="col-sm-12">
                                    <input type="password" class="form-control" id="compte" name="password_authentification" placeholder="Authentification">
                                    <br>
                                </div>


                            </div>
                            <br>

                            <button type="button" class="btn btn-info col-sm-12" id ="enregistrer" >Enregistrer</button>
                        </form>
                    </div>
                </div>
            </header>

            <!-- Footer -->
            <footer class="site-footer">
                <div class="footer-top box-grey padding-all">
                    <div class="row">

                        <div class="col-md-4">
                            <div class="title-border">A propos</div>
                            <p>Noter structures FUTURA IMMO size à Thies est le meilleur endroit pour le logement propice. Nous disposons une variété d’appartement et de bâtiment dans    tous la zone de Thiès.
                                A noter aussi que les prix sont abordables.
                            </p><p>Notre équipe est en place depuis le début de cette aventure et <b>la fidélité de nos clients est à nos yeux, la plus belle marque de reconnaissance...</b></p><div class="text-center"><div class="fb_button" data-url="https://www.facebook.com"><i class="fa fa-facebook-square"></i>Partager sur Facebook</div></div>               </div>

                        <div class="col-md-4">
                            <div class="title-border">Liens</div>
                            <ul><li><a rel="" target="_self" href="#">Location-vente à Dakar</a></li><li><a rel="" target="_self" href="#">Appartement à vendre à Dakar</a></li><li><a rel="" target="_self" href="#">Devenir propriétaire au Sénégal</a></li><li><a rel="" target="_self" href="#">Conseil achat immobilier à Dakar<br></a></li><li><a rel="nofollow" target="_blank" href="#">Espace Ataya Properties sur Facebook<br></a></li></ul>               </div>

                        <div class="col-md-4">
                            <div class="title-border">Contact</div>
                            <p>FUTURA IMMO <br>BP 221 - BP 222 - THIES - SENEGAL</p><p>Tel : (+221) 33 888 88 88</p><br>
                            <div class="fb-page" data-href="#" data-small-header="true" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/" class="fb-xfbml-parse-ignore"><a href="">GARMY</a></blockquote></div>
                        </div>

                    </div>
                </div>
                <div class="footer-bottom">
                    ©2017 <a href="#">Espace FUTURA IMMO  Thies Sénégal</a>. Tous droits réservés.
                    Site réalisé par <a href="#" target="_blank">Garmy</a>.
                </div>
            </footer>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script   src="https://code.jquery.com/jquery-3.1.1.js"   integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="   crossorigin="anonymous"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWiJmMgeXIvpQzFSOBfjsgnXfykL-vvBk&signed_in=true&callback=initMap"
        async defer></script>
        <script type="text/javascript" src="bxslider.js"></script>

    </body>
</html>
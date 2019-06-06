<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Python在线教学系统</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/swiper.min.css">
    <link rel="stylesheet" href="css/certify.css">
    <script src="js/swiper.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div id="certify">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="images/swiper/certify01.png" /><p>Python学习</p></div>
            <div class="swiper-slide"><img src="images/swiper/certify02.png" /><p>Python学习</p></div>
            <div class="swiper-slide"><img src="images/swiper/certify03.png" /><p>Python学习</p></div>
            <div class="swiper-slide"><img src="images/swiper/certify04.png" /><p>Python学习</p></div>
            <div class="swiper-slide"><img src="images/swiper/certify05.png" /><p>Python学习</p></div>
        </div>
    </div>
    <div class="swiper-pagination"></div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>

<script>
    certifySwiper = new Swiper('#certify .swiper-container', {
        watchSlidesProgress: true,
        slidesPerView: 'auto',
        centeredSlides: true,
        loop: true,
        loopedSlides: 5,
        autoplay: true,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        pagination: {
            el: '.swiper-pagination',
            //clickable :true,
        },
        on: {
            progress: function(progress) {
                for (i = 0; i < this.slides.length; i++) {
                    var slide = this.slides.eq(i);
                    var slideProgress = this.slides[i].progress;
                    modify = 1;
                    if (Math.abs(slideProgress) > 1) {
                        modify = (Math.abs(slideProgress) - 1) * 0.3 + 1;
                    }
                    translate = slideProgress * modify * 260 + 'px';
                    scale = 1 - Math.abs(slideProgress) / 5;
                    zIndex = 999 - Math.abs(Math.round(10 * slideProgress));
                    slide.transform('translateX(' + translate + ') scale(' + scale + ')');
                    slide.css('zIndex', zIndex);
                    slide.css('opacity', 1);
                    if (Math.abs(slideProgress) > 3) {
                        slide.css('opacity', 0);
                    }
                }
            },
            setTransition: function(transition) {
                for (var i = 0; i < this.slides.length; i++) {
                    var slide = this.slides.eq(i)
                    slide.transition(transition);
                }

            }
        }

    })
</script>
</body>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>
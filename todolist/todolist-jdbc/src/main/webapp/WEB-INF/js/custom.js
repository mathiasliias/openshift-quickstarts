

  /*-------------------------------------------------------------------------------
    PRE LOADER
  -------------------------------------------------------------------------------*/

  $(window).load(function(){
    $('.preloader').fadeOut(1000); // set duration in brackets    
  });

    
  function myMap() {
    var heinaX = {lat: 59.440288, lng: 24.721752};
      var mapOptions = {
          center: heinaX,
          zoom: 16,
          mapTypeId: google.maps.MapTypeId.ROADMAP
      }
      var map = new google.maps.Map(document.getElementById("map"), mapOptions);
      var marker = new google.maps.Marker({
        position: heinaX,
        map: map
      });
  }


  /* HTML document is loaded. DOM is ready. 
  -------------------------------------------*/

  $(document).ready(function() {


  /*-------------------------------------------------------------------------------
    Navigation - Hide mobile menu after clicking on a link
  -------------------------------------------------------------------------------*/

    $('.navbar-collapse a').click(function(){
        $(".navbar-collapse").collapse('hide');
    });


//    $(window).scroll(function() {
//    if ($(".navbar").offset().top > 50) {
//       $(".navbar-fixed-top").addClass("top-nav-collapse");
//    } else {
//        $(".navbar-fixed-top").removeClass("top-nav-collapse");
//    }
//  });



  /*-------------------------------------------------------------------------------
    jQuery Parallax
  -------------------------------------------------------------------------------*/

    function initParallax() {
    $('#home').parallax("100%", 0.1);
    $('#about').parallax("100%", 0.3);
    $('#service').parallax("100%", 0.2);
    $('#experience').parallax("100%", 0.3);
    $('#education').parallax("100%", 0.1);
    $('#quotes').parallax("100%", 0.3);
    $('#contact').parallax("100%", 0.1);
    $('footer').parallax("100%", 0.2);

  }
  initParallax();



  /*-------------------------------------------------------------------------------
    smoothScroll js
  -------------------------------------------------------------------------------*/
  
    $(function() {
        $('.custom-navbar a, #home a').bind('click', function(event) {
            var $anchor = $(this);
            $('html, body').stop().animate({
                scrollTop: $($anchor.attr('href')).offset().top - 49
            }, 1000);
            event.preventDefault();
        });
    });

  /*-------------------------------------------------------------------------------
    wow js - Animation js
  -------------------------------------------------------------------------------*/

  new WOW({ mobile: false }).init();


  });


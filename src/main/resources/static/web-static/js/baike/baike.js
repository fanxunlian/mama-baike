/**
 * Created by fanxunlian on 2018/6/30.
 */
$(document).ready(function(){

    $(".baike-nav").mouseover(function(){
        $(".baike-sub-title").show();
    });
    $(".baike-nav").mouseout(function(){
        $(".baike-sub-title").hide();
    });


    $(".baike-sub-title").mouseover(function(){
        $(".baike-sub-title").show();
    });
    $(".baike-sub-title").mouseout(function(){
        $(".baike-sub-title").hide();
    });

    $(".baike-sub-title .main").mouseover(function(){
        $(".baike-sub-title .main").addClass("active");
    });
    $(".baike-sub-title .main").mouseout(function(){
        $(".baike-sub-title .main").removeClass("active");
    });

    $(".baike-sub-title .baby").mouseover(function(){
        $(".baike-sub-title .baby").addClass("active")
    });
    $(".baike-sub-title .baby").mouseout(function(){
        $(".baike-sub-title .baby").removeClass("active")
    });

    $(".baike-sub-title .education").mouseover(function(){
        $(".baike-sub-title .education").addClass("active")
    });
    $(".baike-sub-title .education").mouseout(function(){
        $(".baike-sub-title .education").removeClass("active")
    });

    $(".baike-sub-title .disease").mouseover(function(){
        $(".baike-sub-title .disease").addClass("active")
    });
    $(".baike-sub-title .disease").mouseout(function(){
        $(".baike-sub-title .disease").removeClass("active")
    });

    $(".baike-sub-title .life").mouseover(function(){
        $(".baike-sub-title .life").addClass("active")
    });
    $(".baike-sub-title .life").mouseout(function(){
        $(".baike-sub-title .life").removeClass("active")
    });

    $(".baike-sub-title .lady").mouseover(function(){
        $(".baike-sub-title .lady").addClass("active")
    });
    $(".baike-sub-title .lady").mouseout(function(){
        $(".baike-sub-title .lady").removeClass("active")
    });

    $(".baike-sub-title .useage").mouseover(function(){
        $(".baike-sub-title .useage").addClass("active")
    });
    $(".baike-sub-title .useage").mouseout(function(){
        $(".baike-sub-title .useage").removeClass("active")
    });
});
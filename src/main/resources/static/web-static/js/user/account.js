/**
 * Created by fanxunlian on 2018/6/30.
 */
var timer = null;
$(document).ready(function(){

    $("#account").mouseover(function(){
        $(".account-account").show()
    });
    $("#account").mouseout(function(){
        $(".account-account").hide()

    });

    $(".account-account").mouseover(function(){
        $(".account-account").show()
    });
    $(".account-account").mouseout(function(){
        $(".account-account").hide()
    });

    $("#circle-list").click(function(){
        $(".circle-list").show();
        $(".send-list").hide();
        $(".message-list").hide();

        $("#circle-list").addClass("active");
        $("#send-list").removeClass("active");
        $("#message-list").removeClass("active");

        $.ajax({
            type: "POST",
            url: "/api/topic/user/list",
            data: JSON.stringify({"userId":1}),
            contentType: "application/json",
            dataType: "json",
            success: function(data){
               /* $('#resText').empty();   //清空resText里面的所有内容
                var html = '';
                $.each(data, function(commentIndex, comment){
                    html += '<div class="comment"><h6>' + comment['username']
                        + ':</h6><p class="para"' + comment['content']
                        + '</p></div>';
                });
                $('#resText').html(html);*/
                console.log(result)
            }
        });

    });
    $("#send-list").click(function(){
        $(".circle-list").hide();
        $(".send-list").show();
        $(".message-list").hide();

        $("#circle-list").removeClass("active");
        $("#send-list").addClass("active");
        $("#message-list").removeClass("active");
    });
    $("#message-list").click(function(){
        $(".circle-list").hide();
        $(".send-list").hide();
        $(".message-list").show();

        $("#circle-list").removeClass("active");
        $("#send-list").removeClass("active");
        $("#message-list").addClass("active");
    });



});
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
    getCircleList();


    $("#id-circle-list").click(function(){

        clickTitle("circle")
        getCircleList();
    });
    $("#id-send-list").click(function(){
        clickTitle("sendTopic")
    });
    $("#id-message-list").click(function(){
        clickTitle("message")
    });


    function getCircleList() {
        var circleLine = "";
        $.ajax({
            type: "POST",
            url: "/api/topic/user/list",
            data: JSON.stringify({"userId":1}),
            contentType: "application/json",
            dataType: "json",
            success: function(result){

                $.each(result.data,function (index,val) {
                    circleLine+='<div class="line-block">';
                    circleLine+='<a href="/topic/forum?id='+val.topicEntity.id+'">';
                    circleLine+='<img  src="/api/upload/img/index?imgeName='+val.topicEntity.imageUid+'"/>';
                    circleLine+='</a>';
                    circleLine+='<div class="circle-title">';
                    circleLine+='<a href=/topic/forum?id='+val.topicEntity.id+'><span>'+val.topicEntity.name+'</span></a>';
                    circleLine+='</div>';
                    circleLine+='<div class="remark"><a href=/topic/forum?id='+val.topicEntity.id+'><span>'+val.topicEntity.remark+'</span></a></div>';
                    circleLine+='</div>';
                });


                $('.account-circle-list').html(circleLine);
                console.log(data)
            }
        });
    }

    function clickTitle( obj ) {
        if(obj == "circle")
        {
            $(".account-circle-list").show();
            $(".account-send-list").hide();
            $(".account-message-list").hide();

            $("#id-circle-list").addClass("active");
            $("#id-send-list").removeClass("active");
            $("#id-message-list").removeClass("active");
        }
        else if(obj == "sendTopic")
        {
            $(".account-circle-list").hide();
            $(".account-send-list").show();
            $(".account-message-list").hide();

            $("#id-circle-list").removeClass("active");
            $("#id-send-list").addClass("active");
            $("#id-message-list").removeClass("active");
        }
        else if(obj == "message")
        {
            $(".account-circle-list").hide();
            $(".account-send-list").hide();
            $(".account-message-list").show();

            $("#id-circle-list").removeClass("active");
            $("#id-send-list").removeClass("active");
            $("#id-message-list").addClass("active");
        }
    }



});
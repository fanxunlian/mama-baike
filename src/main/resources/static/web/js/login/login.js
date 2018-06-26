$(".login-btn").click(function(){
    var userName = $("#username").val();
    var userPass = $("#userpass").val();
    var data = {"mobile":userName,"verifyCode":userPass};
    console.log(data);
    $.ajax(
        {
            type: "post",
            url: "/user/login",
            dataType: "json",
            data: data,
            success: function (res) {
                if(res.data){
                }
                if (res['code'] == 200) {
                    console.log("登录成功");
                    window.location.href = "/web/index.html";
                } else{

                }
            }
        }
    );
});
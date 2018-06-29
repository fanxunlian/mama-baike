$(".login-btn").click(function(){
    var userName = $("#username").val();
    var userPass = $("#userpass").val();
    var data = {"userName":userName,"userPass":userPass};
    console.log(data);
    $.ajax(
        {
            type: "post",
            url: "/api/user/login-by-pass",
            dataType: "json",
            data: data,
            success: function (res) {
                if(res.data){
                }
                if (res['code'] == 200) {
                    console.log("登录成功");
                    window.location.href = "/";
                } else{
                    alert(res['message']);

                }
            }
        }
    );
});


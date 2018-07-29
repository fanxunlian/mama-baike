//获取验证码
function getVerify(obj){
    obj.src =   "/api/user/getVerify";
}

$(".sign-btn-panel").click(function(){
    var userName = $("#username").val();
    var userPass = $("#userpass").val();
    var verifyCode = $("#verifycode").val();
    var data = {"userName":userName,"userPass":userPass,"verifyCode":verifyCode};
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
                    window.location.href = "/user/account";
                } else{
                    alert(res['message']);

                }
            }
        }
    );
});


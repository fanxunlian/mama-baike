/**
 * Created by fanxunlian on 2018/6/24.
 */

$.post("http://localhost:6395/user/login",
    {
        mobile:"135",
        verifyCode:"222"
    },
    function(result)
    {
    $("span").html(result);
    }
);

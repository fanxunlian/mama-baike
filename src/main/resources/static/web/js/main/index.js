/**
 * Created by fanxunlian on 2018/6/24.
 */

$.ajax(
    {
        type: "post",
        url: "/user/test",
        dataType: "json",
        data: {},
        success: function (res) {
            if(res.data){
            }
            if (res['code'] == 200) {
                console.log(res);
            } else{

            }
        }
    }
);

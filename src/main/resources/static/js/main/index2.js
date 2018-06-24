/**
 * Created by fanxunlian on 2018/6/24.
 */

$.post("http://localhost:6395/baike/catalog/index",
    {
    },
    function(result)
    {
        $("span").html(result);
    }
);

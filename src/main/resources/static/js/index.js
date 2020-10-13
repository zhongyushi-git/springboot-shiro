$(function() {
    let layer;
    layui.use('layer', function() {　　
        layer = layui.layer;

    })

    //退出按钮的监听，退出确认
    $("#exitBtn").click(function() {
        layer.confirm("确定要退出系统吗？", {
                btn2: function(index, layero) {}
            },
            function(index, layero) {
                get("/logout", null, function(data) {
                    if (data.status) {
                        window.location.href = "login.html"
                    } else {
                        console.log(data.msg)
                    }
                })
            }
        );
    })
})


function changeHtml(page){
    $("#iframe").attr("src","html/"+page)
}

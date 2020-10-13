　
$(function() {
    //设置默认的用户名和密码
    $("input[name='username']").val("admin")
    $("input[name='password']").val("1234")

    //回车事件监听
    $("input[name='password']").keydown(function(e) {
        if (e.keyCode == 13) {
            $('#loginForm').submit();
        }
    });

    layui.use(['form'], function() {
        const form = layui.form;
        //自定义表单验证规则
        form.verify({
            username: function(value) {
                if (value == null || value == "") {
                    return '用户名不能为空';
                } else if (value.length < 4 || value.length > 18) {
                    return '用户名长度在4到18位之间';
                } else if (!usernameReg(value)) {
                    return '用户名只能包含大写、小写、数字和下划线';
                }
            },
            password: function(value) {
                if (value == null || value == "") {
                    return '密码不能为空';
                } else if (value.length < 4 || value.length > 15) {
                    return '密码长度在4到15位之间';
                } else if (!usernameReg(value)) {
                    return '密码只能包含大写、小写、数字和下划线';
                }
            }


        });
        //监听表单提交
        form.on('submit(formDemo)', function(data) {
            post("/login", data.field, function(data) {
                    if (data.status) {
                        window.location.href = "index.html"
                    } else {
                        $("#errMsg").text(data.msg)
                    }
                })
                //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            return false;
        });
    });



});
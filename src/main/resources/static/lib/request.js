//对ajax的封装

//get请求
function get(url, data, callback, async = true) {
    $.ajax({
        url,
        async,
        type: 'get',
        data,
        //成功的回调
        success(res, textStatus, xhr) {
            callback(res)
        },
        //失败的回调
        error() {
            console.log("发送请求时出现错误！")
        },
    })
}
//post请求，默认方法
function post(url, data, callback, async = true) {
    $.ajax({
        url,
        async,
        type: 'post',
        data,
        //成功的回调
        success(res) {
            callback(res)
        },
        //失败的回调
        error() {
            console.log("发送请求时出现错误！")
        }
    })
}
//post请求，传递json字符串，后台使用@RequestBody接收
function postJson(url, data, callback, async = true) {
    $.ajax({
        url,
        async,
        type: 'post',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        //成功的回调
        success(res) {
            callback(res)
        },
        //失败的回调
        error() {
            console.log("发送请求时出现错误！")
        }
    })
}
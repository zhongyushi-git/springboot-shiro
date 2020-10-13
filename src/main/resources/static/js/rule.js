//规则验证
//包含大写、小写、数字和下划线
const username = /^[a-zA-Z0-9_]+$/

function usernameReg(value) {
    return username.test(value)
}
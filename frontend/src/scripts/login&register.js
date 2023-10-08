export const loginScript = {
    login(userName, password) {
        let result = {
            state: NaN,
            code: NaN,
            message: NaN
        }
        if (userName == "") {
            result.state = false
            result.code = 1000
            result.message = "请输入用户名！"
            return result
        } else if (password == "") {
            result.state = false
            result.code = 2000
            result.message = "请输入密码！"
            return result
        } else {
            result.state = true
            result.code = 3000
            result.message = {
                userName,
                password
            }
            return result
        }
    }
}
export const registerScript = {
    register(userName, password, replyPassword) {
        let result = {
            state: NaN,
            code: NaN,
            message: NaN
        }
        if (userName == "") {
            result.state = false
            result.code = 1000
            result.message = "请输入用户名！"
            return result
        } else if (password == "") {
            result.state = false
            result.code = 2000
            result.message = "请输入密码！"
            return result
        } else if (password != replyPassword) {
            console.log(password, replyPassword);
            result.state = false
            result.code = 2001
            result.message = "两次密码不一致！"
            return result
        } else {
            result.state = true
            result.code = 3000
            result.message = {
                userName,
                password
            }
            return result
        }
    }
}

export let createRandCode = () => {
    let chars = ['1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k']
    let randcode = ""
    for (let i = 0; i < 4; i++) {
        let randpos = Math.floor(Math.random() * (chars.length - 1))
        randcode += chars[randpos]
    }
    return randcode
}
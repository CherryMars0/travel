<template>
    <div class="signupContainer animate__animated animate__fadeInLeft">
        <p class="signupTitle animate__animated animate__fadeInLeft">Sign Up</p>
        <div class="signup animate__animated animate__fadeInLeft">
            <form class="signupForm" onsubmit="return false">
                <div class="inputBox">
                    <p>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
                        </svg>
                    </p>
                    <input v-model="userName" type="text" placeholder="userName" />
                </div>
                <div class="inputBox">
                    <p>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-key"
                            viewBox="0 0 16 16">
                            <path
                                d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z" />
                            <path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
                        </svg>
                    </p>
                    <input v-model="userPassword" type="password" placeholder="password" />
                </div>
                <div class="inputBox">
                    <p>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-key"
                            viewBox="0 0 16 16">
                            <path
                                d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z" />
                            <path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
                        </svg>
                    </p>
                    <input v-model="replyUserPassword" type="password" placeholder="password" />
                </div>
                <div class="inputBox">
                    <p>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-file-ppt" viewBox="0 0 16 16">
                            <path
                                d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z" />
                            <path
                                d="M6 5a1 1 0 0 1 1-1h1.188a2.75 2.75 0 0 1 0 5.5H7v2a.5.5 0 0 1-1 0V5zm1 3.5h1.188a1.75 1.75 0 1 0 0-3.5H7v3.5z" />
                        </svg>
                    </p>
                    <input v-model="verifyInput" type="text" placeholder="Captcha" />
                </div>
                <div class="inputCaptcha">
                    <p>CaptchaVerify(区分大小写):</p>
                    <div class="code" @click="refleshCode()">{{ verifyCode }}</div>
                </div>
                <p class="errorTab" v-show="isError">{{ errorTip }}</p>
            </form>
            <button class="signupBtn" @click="register()">注册</button>
            <div class="signupContainer-bottom">
                <ul>
                    <li><router-link to="/">首页</router-link></li>
                    <li></li>
                    <li @click="toLogin"><a>登录</a></li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script setup>
import { registerScript, createRandCode } from "../scripts/login&register"
import { ref, onMounted } from 'vue'
import { useStore } from 'vuex'
let store = useStore()
let verifyCode = ref()
let verifyInput = ref()
let userName = ref()
let userPassword = ref()
let replyUserPassword = ref()
let isError = ref(false)
let errorTip = ref("none")

const register = () => {
    if (verifyCode.value == verifyInput.value) {
        let isRegister = registerScript.register(userName.value, userPassword.value, replyUserPassword.value)
        if (!isRegister.state) {
            isError.value = true
            errorTip.value = isRegister.message
        } else {
            isError.value = false
            store.dispatch("register", isRegister)
        }
    } else {
        isError.value = true
        errorTip.value = "验证码错误"
    }
}

const refleshCode = () => verifyCode.value = createRandCode()
const toLogin = () => store.commit("isLoging", false)
onMounted(() => verifyCode.value = createRandCode())

</script>
<style scoped lang="css">
.signupTitle {
    font-size: 32px;
    line-height: 32px;
    text-align: center;
    font-family: 'Merienda', cursive;
}

.signupContainer {
    padding-top: 100px !important;
    width: 300px;
    height: 100%;
    background-color: white;
    opacity: 0.9;
    box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 5px 0px, rgba(0, 0, 0, 0.1) 0px 0px 1px 0px;
}

.signupContainer-bottom {
    width: 100%;
    height: 60px;
}

.signup {
    width: 100%;
    height: 500px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.inputBox {
    border-bottom: 1px solid #4e4e4e;
    width: 245px;
    height: 22px;
    margin-bottom: 20px !important;
    display: flex;
    align-items: center;
    justify-content: space-around;
}

.inputBox p {
    text-align: center;
    line-height: 22px;
    width: 20px;
    height: 21px;
    margin-bottom: -5px !important;
    display: flex;
    align-content: center;
    justify-content: center;
}

.signupContainer-bottom {
    width: 100%;
    height: 60px;
    display: flex;
    justify-content: space-around;
    margin-top: 100px !important;
}

.signupContainer-bottom ul {
    width: 85px;
    height: 25px;
    display: flex;
    justify-content: space-around;
}

.signupContainer-bottom ul li {
    height: 25px;
    line-height: 30px;
}

.signupContainer-bottom ul li:nth-child(2) {
    border: 1px solid black;
}

.signupContainer-bottom a {
    color: black;
    font-size: 18px;
    line-height: 25px;
}

.signupBtn {
    width: 180px;
    height: 40px;
    border-radius: 5px;
    border: none;
    background-color: black;
    color: white;
    cursor: pointer;
    font-size: 20px;
    transition: all ease-in-out 0.5s;
}

.signupBtn:hover {
    background-color: #e4e4e4;
    color: black;
}

.signupForm {
    margin-top: 30px !important;
    width: 100%;
    height: 400px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.signupForm input {
    height: 20px;
    width: 180px;
    border-radius: 5px;
    outline: none;
    vertical-align: baseline;
    padding: 2px;
    border: none;
}

.signupForm button {
    width: 80px;
    height: 30px;
    border: none;
    border-radius: 5px;
    background-color: white;
    cursor: pointer;
}

.errorTab {
    margin-top: 10px !important;
    width: 100%;
    height: 30px;
    line-height: 30px;
    text-align: center;
    color: red;
    font-size: 14px;
}

.code {
    text-align: center;
    width: 60px;
    height: 30px;
    font-size: 18px;
    line-height: 30px;
    letter-spacing: 5px;
    cursor: pointer;
    User-select: none;
}

.inputCaptcha {
    text-align: center;
    width: 100%;
    height: 30px;
    display: flex;
    align-items: center;
    justify-content: space-around;
    font-size: 12px;
    cursor: default;
}
</style>

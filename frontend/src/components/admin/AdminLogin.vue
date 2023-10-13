<template>
    <div class="adminLogin">
        <div class="loginTitle">
            <p>admin Login</p>
        </div>
        <div class="loginForm">
            <div>
                <label>userName:</label>
                <input type="text" v-model="userName">
            </div>
            <div>
                <label>password:</label>
                <input type="password" v-model="password">
            </div>
        </div>
        <div class="loginBtn">
            <button @click="adminLogin">enter</button>
        </div>

    </div>
</template>
<script setup>
import { ref } from "vue"
import { useStore } from "vuex"
const store = useStore()
const userName = ref()
const password = ref()
const adminLogin = () => {
    store.dispatch("adminLogin", {
        name: userName.value,
        password: password.value
    })
}
</script>
<style scoped lang="sass">
.adminLogin
    width: 420px
    height: 220px
    background-color: #e4e4e4
    padding: 10px !important
    border-radius: 5px
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
    opacity: 0.8
    display: flex
    flex-direction: column
    align-items: center
    justify-content: space-around

    .loginTitle,.loginBtn
        width: 100%
        height: 50px
        text-align: center
        line-height: 50px

        button
            width: 80px
            border-radius: 5px
            background-color: white

    .loginForm
        width: 100%
        height: 150px
        display: flex
        flex-direction: column
        align-items: center
        justify-content: space-around

        div
            width: 80%
            display: flex
            align-items: center
            justify-content: space-around

            input
                border: none
                padding: 5px !important
                padding-left: 10px !important
                border-radius: 5px



</style>
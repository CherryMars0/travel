<template>
    <div class="navigation animate__animated animate__fadeInDown">
        <ul class="items">
            <li class="city">
                <LoadingMy v-if="loading()" />
                <p v-if="!loading()">{{ address.province }}</p>
                <p v-if="!loading()">{{ address.city }}</p>
            </li>
            <li :class="router.currentRoute.value.path == '/' ? 'selected' : 'disSelected'"><router-link
                    to="/">首页</router-link></li>
            <li :class="router.currentRoute.value.path == '/ScenicView' ? 'selected' : 'disSelected'"><router-link
                    to="/ScenicView">景点</router-link></li>
            <li :class="router.currentRoute.value.path == '/GuideView' ? 'selected' : 'disSelected'"><router-link
                    to="/GuideView">热门导游</router-link></li>
            <li :class="router.currentRoute.value.path == '/PlanView' ? 'selected' : 'disSelected'"><router-link
                    to="/PlanView">自助游</router-link></li>
            <ul v-if="!isLogin" class="userCenter">
                <li :class="router.currentRoute.value.path == '/UserView' && !isLoginPage ? 'selected' : 'disSelected'">
                    <router-link @click="toLogin" to="/UserView">登录</router-link>
                </li>
                |
                <li :class="router.currentRoute.value.path == '/UserView' && isLoginPage ? 'selected' : 'disSelected'">
                    <router-link @click="toSignup" to="/UserView">注册</router-link>
                </li>
            </ul>
            <li v-if="isLogin" :class="router.currentRoute.value.path == '/center' ? 'selected' : 'disSelected'">
                <router-link to="/center">{{ userName }}</router-link>
            </li>
        </ul>
    </div>
</template>
<script setup>
import { computed } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'
const router = useRouter()
import LoadingMy from './Loading-my.vue'
const store = useStore()
let address = computed(() => store.state.local.currentLocation)
let userName = computed(() => store.state.User.userName)
let isLogin = computed(() => store.state.User.isLoging)
let toLogin = () => store.commit("isLoging", false)
let toSignup = () => store.commit("isLoging", true)
let isLoginPage = computed(() => store.state.views.User.isLoging)
let loading = () => {
    let flag = address.value.province == "定位中..."
    store.commit("locationLoad", flag)
    return flag
}

</script>
<style scoped lang="sass">
$navHight: 50px

.selected
    background-color: rgba(0, 218, 212, 1)

.disSelected
    background-color: #fff

.navigation
    width: 100%
    height: $navHight
    background-color: #fff
    z-index: 9999
.navigation ul
    display: flex
    align-items: center
    justify-content: space-around
    height: $navHight

.navigation>ul
    width: 100%
    padding: 10px !important
    box-shadow: rgba(50, 50, 93, 0.25) 0px 3px 9px -5px, rgba(0, 0, 0, 0.3) 0px 2px 3px -4px;

.navigation>ul>li
    width: 100px
    font-size: 18px
    text-align: center
    border-radius: 10px
    transition: all linear .1s

.navigation ul li a
    display: block
    width: 100%
    height: 100%
    color: black
    outline: none
    text-decoration: none

.city
    font-size: 12px !important
    margin-left: -30px !important
    margin-right: -100px !important

.userCenter
    width: 125px
    li
        width: 60px
        text-align: center
        border-radius: 5px

</style>
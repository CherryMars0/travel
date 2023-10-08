<template>
    <div class="navigation">
        <ul class="items">
            <li class="city">
                <LoadingMy v-if="loading()" />
                <p v-if="!loading()">{{ address.province }}</p>
            </li>
            <li><router-link to="/">首页</router-link></li>
            <li><router-link to="/ScenicView">景点</router-link></li>
            <li><router-link to="/GuideView">导游预定</router-link></li>
            <li><router-link to="/PlanView">自助规划</router-link></li>
            <ul class="items" v-if="!isLogin">
                <li><router-link to="/UserView">登录</router-link>|</li>
                <li><router-link to="/UserView">注册</router-link></li>
            </ul>
            <li v-if="isLogin">
                <router-link to="/center">{{ userName }}</router-link>
            </li>
        </ul>
    </div>
</template>
<script setup>
import { computed } from 'vue'
import { useStore } from 'vuex'
import LoadingMy from './Loading-my.vue'
const store = useStore()
let address = computed(() => store.state.local.currentLocation)
let userName = computed(() => store.state.User.userName)
let isLogin = computed(() => store.state.User.isLoging)
let loading = () => {
    let flag = address.value.province == "定位中..."
    store.commit("locationLoad", flag)
    return flag
}

</script>
<style scoped lang="sass">
$navHight: 50px

.navigation
    width: 100%
    height: $navHight
    background-color: #fff
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
.navigation ul li a
    color: black
    outline: none
    text-decoration: none

.city
    font-size: 12px !important
    margin-left: -30px !important
    margin-right: -100px !important

</style>
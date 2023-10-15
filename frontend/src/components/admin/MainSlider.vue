<template>
    <div class="mainSlider">
        <ul class="items">
            <p class="title">admin:{{ userName }}</p>
            <li @click="scenicInfo" :class="isSelected == 0 ? 'selected' : ''">景区信息管理</li>
            <li @click="hotalInfo" :class="isSelected == 1 ? 'selected' : ''">酒店预定管理</li>
            <li @click="userInfo" :class="isSelected == 2 ? 'selected' : ''">用户信息管理</li>
            <li @click="guideInfo" :class="isSelected == 3 ? 'selected' : ''">导游信息管理</li>
            <li @click="logout">用户登出</li>
        </ul>
    </div>
</template>
<script setup>
import { ref } from "vue"
import { useStore } from "vuex"
const store = useStore()
const userName = ref(localStorage.getItem("adminName"))
const isSelected = ref(0)
const logout = () => {
    store.commit("adminState", false)
    localStorage.removeItem("adminName")
}
const scenicInfo = () => {
    isSelected.value = 0
    store.commit("mainView", 0)
}
const hotalInfo = () => {
    isSelected.value = 1
    store.commit("mainView", 1)
}
const userInfo = () => {
    isSelected.value = 2
    store.commit("mainView", 2)
}

const guideInfo = () => {
    isSelected.value = 3
    store.commit("mainView", 3)
}
</script>
<style scoped lang="sass">
.selected
    background-color: rgb(115,150,190)

.mainSlider
    width: 220px
    height: 100%
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px
    float: left

    .items
        width: 100%
        height: 100%
        background-color: #344058
        font-family: Helvetica Neue

        .title
            font-family: Helvetica Neue
            text-align: center
            height: 50px
            line-height: 50px
            color: #fff
            border-bottom: 1px solid black


        li
            width: 100%
            height: 50px
            color: #fff
            font-size: 14px
            line-height: 50px
            text-align: center
            border-bottom: 1px solid black
            cursor: pointer
            transition: all linear .2s

        li:hover
            background-color: rgb(115,150,190)

</style>
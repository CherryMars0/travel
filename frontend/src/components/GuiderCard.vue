<template>
    <div class="guiderCard">
        <div class="hot">{{ guiderData.hot }}</div>
        <div class="guiderImg">
            <img :src="imgSrc[guiderData.sex]" :alt="guiderData.name" @mouseover="showDesc = true"
                @mouseleave="showDesc = false">
        </div>
        <div class="guiderDesc">
            <p>{{ guiderData.name }}</p>
            <p>业务范围：{{ guiderData.scope }}</p>
            <p>业务地址：{{ guiderData.address }}</p>
        </div>
        <div class="guiderBtn">
            <button @click="reserveGuider(guiderData)">预定该导游</button>
            <button @click="contactGuider(guiderData)">联系该导游</button>
        </div>
        <transition enter-active-class="animate__animated animate__fadeInUp"
            leave-active-class="animate__animated animate__fadeOutDown">
            <div class="desc" v-if="showDesc">
                <p>{{ guiderData.name }}{{ guiderData.desc }}</p>
            </div>
        </transition>
    </div>
</template>
<script setup>
import { toRefs, defineProps, ref } from "vue"
const props = defineProps({ guiderData: Object })
const { guiderData } = toRefs(props)
const contactGuider = (e) => window.location.href = `tencent://message/?uin=${e.QQ}`
let showDesc = ref(false)
const imgSrc = {
    man: require("../assets/images/man.png"),
    woman: require("../assets/images/woman.png"),
}
const reserveGuider = (e) => {
    console.log(e)
}
</script>
<style scoped lang="sass">
.guiderCard
    margin-top: 20px !important
    margin-bottom: 20px !important
    width: 333px
    height: 333px
    border-radius: 10px
    background-color: #fff
    display: flex
    flex-direction: column
    align-items: center
    position: relative
    opacity: 0.9
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
    overflow: hidden
    font-family: tahoma !important

    .desc
        bottom: 0
        right: 0
        position: absolute
        width: 100%
        height: 103px
        font-size: 14px
        background-color: #e4e4e4
        padding: 10px !important
    .hot
        top: -1px
        right: -1px
        position: absolute
        width: 100px
        height: 50px
        border-radius: 5px
        background-image: url("../assets/images/level.jpeg")
        background-repeat: no-repeat
        background-size: 152% 100%
        background-position: -53px
        text-align: center
        line-height: 50px
        font-size: 20px
        color: white
        opacity: 0.8

    .guiderImg
        margin-top: 10px !important
        width: 188px
        height: 188px

        img
            width: 100%
            height: 100%

    .guiderDesc
        margin-top: 5px !important
        width: 300px
        height: 83px
        text-align: center

        p:nth-of-type(1)
            font-size: 20px
            font-weight: bold

        p:nth-of-type(2)
            margin-top: 5px !important
            font-size: 14px

        p:nth-of-type(3)
            margin-top: 5px !important
            font-size: 14px

    .guiderBtn
        width: 100%
        height: 40px
        display: flex
        justify-content: space-around
        align-items: center

        button
            border-radius: 5px
            background-color: #e4e4e4
</style>
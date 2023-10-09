<template>
    <div class="travelRecommend">
        <div class="banner">
            <p>国内热门政策聚焦</p>
        </div>
        <div class="container">
            <ul>
                <li v-for="item in travelRecommendData" :key="item.id">
                    <p class="title" @mouseover="mouseHover = item.id">{{ item.title }}</p>
                    <p class="words" :class="mouseHover == item.id ? 'show' : 'disShow'">
                        &nbsp;&nbsp;&nbsp;{{ item.word }}
                    </p>
                </li>
            </ul>
        </div>
    </div>
</template>
<script setup>
import { ref } from "vue"
import { travelRecommendData } from "../../data/travelRecommend"
const mouseHover = ref(0)

setInterval(() => {
    if (mouseHover.value !== travelRecommendData.length - 1)
        mouseHover.value = mouseHover.value + 1
    else
        mouseHover.value = 0
}, 3000)

</script>
<style scoped lang="sass">
.show
    height: 95px

.disShow
    height: 0

.travelRecommend
    width: 550px
    height: 300px
    border-radius: 5px
    box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px
    .banner
        width: 100%
        height: 30px
        background-color: rgba(0, 218, 212, 1)
        font-family: tahoma !important
        font-size: 20px
        line-height: 30px
        padding-left: 10px !important
        color: white
        opacity: 0.8
        border-top-left-radius: 5px
        border-top-right-radius: 5px
    .container
        width: 100%
        height: 270px
        border-bottom-right-radius: 5px 
        border-bottom-left-radius: 5px
        padding: 10px !important

        .title
            width: 100%
            height: 25px
            overflow: hidden
            text-overflow: ellipsis
            white-space: nowrap
            cursor: pointer
            padding-left: 10px !important
            font-family: Microsoft YaHei

        .words
            width: 90%
            margin-left: 5% !important
            font-size: 12px
            overflow: hidden
            text-overflow: ellipsis
            cursor: pointer
            margin-bottom: 5px !important
            font-family: Microsoft YaHei
            transition: all linear .2s
            box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;

</style>
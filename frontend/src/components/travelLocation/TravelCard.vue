<template>
    <div class="TravelCard">
        <p class="banner">{{ travelData.title }}</p>
        <div class="TravelCardItems">
            <div class="TravelCardItem">
                <ul class="city">
                    <p>城市&nbsp;</p>
                    <li v-for="(city, index) in travelData.city" :key="index">{{ city }}|</li>
                </ul>
                <ul class="scenic">
                    <p>景点&nbsp;</p>
                    <li v-for="(scenic, index) in travelData.scenics" :key="index">{{ scenic }}|</li>
                </ul>
                <ul class="hot">
                    <p>热门&nbsp;</p>
                    <li v-for="(hot, index) in travelData.hots" :key="index">{{ hot }}|</li>
                </ul>
            </div>
            <div class="cityImg">
                <img :src="travelData.imgUrl">
                <div class="cityName">{{ travelData.cityName }}</div>
            </div>
        </div>
    </div>
</template>
<script setup>
import { toRefs, defineProps } from "vue"

const props = defineProps({
    travelData: Object
})

const { travelData } = toRefs(props)
</script>
<style scoped lang="sass">
.TravelCard
    width: 350px
    height: 190px
    box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px
    border-top-left-radius: 5px
    border-top-right-radius: 5px

    .banner
        width: 100%
        height: 30px
        background-color: rgba(75, 164, 235, 0.9)
        font-family: tahoma !important
        font-size: 20px
        line-height: 30px
        padding-left: 10px !important
        color: white
        opacity: 0.8
        border-top-left-radius: 5px
        border-top-right-radius: 5px
    .TravelCardItems
        width: 100%
        height: calc(100% - 30px)
        display: flex
        align-items: center
        justify-content: space-around

        .TravelCardItem
            width: 200px
            height: 150px
            display: flex
            flex-direction: column
            justify-content: space-around

        ul
            display: flex

        ul>p
            font-size: 12px

        ul>li
            font-size: 12px
            cursor: pointer

        .cityImg
            width: 100px
            height: 120px
            background-color: rgb(246, 246, 246)
            cursor: pointer

            img
                width: 100%
                height: 90px

            .cityName
                width: 100%
                height: 20px
                text-align: center
                font-size: 18px
</style>
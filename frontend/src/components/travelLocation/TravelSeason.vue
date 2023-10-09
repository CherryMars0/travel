<template>
    <div class="TravelSeason">
        <p class="banner">本季节推荐</p>
        <div class="TravelSeasonItems">
            <div class="TravelSeasonItem">
                <TravelCard v-for="(travelData, index) in travelDatasSeason " :key="index" :travelData="travelData" />
            </div>
        </div>
    </div>
</template>
<script setup>
import TravelCard from './TravelCard.vue'
import { travelDatasSeason } from '../../data/travelDatas'
</script>
<style scoped lang="sass">
.TravelSeason
    width: 100%
    height: 250px
    margin-top: 10px !important
    border-radius: 5px
    box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
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

    .TravelSeasonItems
        width: 1280px
        height: 220px
        border-bottom-right-radius: 5px 
        border-bottom-left-radius: 5px

        .TravelSeasonItem
            width: 1280px
            height: 100%
            display: flex
            justify-content: space-around
            align-items: center
</style>
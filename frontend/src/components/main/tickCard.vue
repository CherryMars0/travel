<template>
    <div class="tickCard">
        <div class="tickItems">
            <ul>
                <li v-for="(tick, index) in ticks" :key="index" @click="tickItems = index"
                    :class="tickItems === index ? 'itemChose' : 'none'">{{ tick }}</li>
            </ul>
        </div>
        <div class="tickInfomations">
            <Loading v-if="loading" />
            <div class="tickInfomationsCart" v-if="!loading">
                <PlaneTick :class="tickItems === 0 ? 'visable' : 'inVisable'"></PlaneTick>
                <HotalTick :class="tickItems === 1 ? 'visable' : 'inVisable'"></HotalTick>
                <TrainTick :class="tickItems === 2 ? 'visable' : 'inVisable'"></TrainTick>
                <VacationTick :class="tickItems === 3 ? 'visable' : 'inVisable'"></VacationTick>
                <ScenicTick :class="tickItems === 4 ? 'visable' : 'inVisable'"></ScenicTick>
                <TotalTick :class="tickItems === 5 ? 'visable' : 'inVisable'"></TotalTick>
                <FreeTravelTick :class="tickItems === 6 ? 'visable' : 'inVisable'"></FreeTravelTick>
            </div>
        </div>
    </div>
</template>
<script setup>
import PlaneTick from "../tickInfomations/PlaneTick.vue"
import FreeTravelTick from "../tickInfomations/FreeTravelTick.vue"
import HotalTick from "../tickInfomations/HotalTick.vue"
import ScenicTick from "../tickInfomations/ScenicTick.vue"
import TotalTick from "../tickInfomations/TotalTick.vue"
import VacationTick from "../tickInfomations/VacationTick.vue"
import TrainTick from "../tickInfomations/TrainTick.vue"
import Loading from "../Loading-my.vue"
import { useStore } from "vuex"
import { ref, computed } from "vue"
let tickItems = ref(0)
const store = useStore()
const loading = computed(() => store.state.loading)
let ticks = ["机票", "酒店", "火车票", "度假", "门票", "团购", "自由行"]
</script>
<style scoped lang="sass">
.tickCard
    padding: 5px !important
    width: 700px
    height: 300px
    background-color: rgba(0, 218, 212, 1)
    display: flex
    border-radius: 5px
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;

.tickItems
    width: 80px
    height: 100%

.tickItems>ul
    width: 80px
    height: 100%
    color: white
    display: flex
    flex-direction: column
    align-items: center
    justify-content: space-around

.tickItems>ul>li
    width: 100%
    height: 100%
    line-height: 35px
    text-align: center
    cursor: pointer
    border-top-left-radius: 5px
    border-bottom-left-radius: 5px
    transition: all ease-in-out 0.2s

.tickInfomations
    width: calc( 100% - 80px)
    background-color: white
    height: 100%
    display: flex
    align-items: center
    justify-content: space-around
    border-top-right-radius: 5px
    border-bottom-right-radius: 5px
.itemChose
    background-color: white
    color: rgb(0, 218, 212)

.tickInfomationsCart
    width: 100%
    height: 100%
.inVisable
    display: none

.visable
    display: block
</style>

<template>
    <div class="planeTick">
        <div class="tickKinds">
            <ul>
                <li @click="tickKinds = 0" :class="tickKinds === 0 ? 'tickChose' : 'none'">国内机票</li>
                <li @click="tickKinds = 1" :class="tickKinds === 1 ? 'tickChose' : 'none'">国际机票</li>
            </ul>
        </div>
        <div>
            <DomesticTick :class="tickKinds === 0 ? 'visable' : 'inVisable'"></DomesticTick>
            <CountrySideTick :class="tickKinds === 1 ? 'visable' : 'inVisable'"></CountrySideTick>
        </div>
    </div>
</template>
<script setup>
import CountrySideTick from "./PlaneKinds/CountrySideTick.vue"
import DomesticTick from "./PlaneKinds/DomesticTick.vue"
import { ref } from "vue"
let tickKinds = ref(0)

</script>
<style scoped lang="sass">
.planeTick
    padding: 10px !important
    padding-top: 0 !important
    width: 100%
    height: 100%
    background-color: white
    border-radius: 5px

.tickKinds
    width: 100%
    padding: 10px !important

.tickKinds>ul
    border-bottom: 1px solid rgb(0, 218, 212)
    display: flex

.tickKinds>ul>li
    width: 80px
    height: 30px
    text-align: center
    line-height: 30px
    cursor: pointer

.tickKinds>ul>li:hover
    background-color: rgb(0, 218, 212)

.tickChose
    border-bottom: 1px solid rgb(0, 218, 212)

.inVisable
    display: none

.visable
    display: block
</style>

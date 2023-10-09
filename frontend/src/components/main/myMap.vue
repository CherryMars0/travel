<template>
    <div class="myMap animate__animated animate__fadeInRightBig" :class="!mapShow ? 'myMapIn' : 'myMapInOut'" id="myMap">
        <div class="mapContainer" v-if="!mapLoading">
            <baidu-map class="map" :center="{ lng: userPoint.lng, lat: userPoint.lat }" :zoom="zoom" @ready="mapOnload()">
                <bm-marker :position="{ lng: userPoint.lng, lat: userPoint.lat }" :dragging="false"
                    :icon="{ url: positionImgUrl, size: { width: 50, height: 50 } }">
                    <bm-label content="" :offset="{ width: 19, height: 40 }" />
                </bm-marker>
                <slot></slot>
                <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT" :offset="{ width: -20, height: 10 }"></bm-navigation>
            </baidu-map>
        </div>
        <div class="mapLoading" v-if="mapLoading">
            <LoadingMy />
        </div>
        <div class="mapSwitch" @click="mapSwitch">M</div>
    </div>
</template>
<script setup>
import { ref, computed } from "vue"
import LoadingMy from '../Loading-my.vue'
import { useStore } from "vuex"
const positionImgUrl = require("../../assets/images/location-pin.gif")
const store = useStore()
let mapShow = ref(false)

const userPoint = computed(() => store.state.local.ln)
const mapSwitch = () => mapShow.value = !mapShow.value
const mapLoading = computed(() => store.state.loading)
const zoom = computed(() => store.state.map.ZOOM)
const mapOnload = () => mapShow.value = true
</script>
<style scoped lang="sass">
.myMapIn
    right: -395px
    .mapSwitch
        transform: rotate(-90deg)
        
.myMapInOut
    right: 5px
    .mapSwitch
        transform: rotate(0deg)
.myMap
    z-index: 9999
    transition: all linear 0.5s
    position: fixed
    width: 400px
    height: 400px
    display: flex
    align-items: center
    justify-content: center
    top: calc( 50% - 200px)
    border-radius: 8px
    background-color: #e4e4e4
    box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;

    .mapSwitch
        height: 40px
        width: 40px
        background-color: white !important
        text-align: center
        line-height: 40px
        border-radius: 50%
        position: absolute
        top: calc( 50% - 20px)
        left: -20px
        box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
        cursor: pointer
        transition: all linear 0.5s
    .mapLoading
        width: 50%
        height: 50%
        display: flex
        align-items: center
        justify-content: center
        transform-origin: center
        transform: scale(200%)

    .mapContainer
        width: 100%
        height: 100%

        .map
            width: 100%
            height: 100%


        
</style>
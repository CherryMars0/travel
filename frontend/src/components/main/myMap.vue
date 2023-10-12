<template>
    <div class="myMap animate__animated animate__fadeInRightBig" :class="!mapShow ? 'myMapIn' : 'myMapInOut'" id="myMap">
        <div class="mapContainer" v-if="!mapLoading">
            <baidu-map :scroll-wheel-zoom="true" class="map" :center="{ lng: centerPoint.lng, lat: centerPoint.lat }"
                :zoom="zoom" @ready="mapOnload()" @moving="syncCenterAndZoom" @moveend="syncCenterAndZoom"
                @zoomend="syncCenterAndZoom">
                <bm-marker :position="{ lng: userPoint.lng, lat: userPoint.lat }" :dragging="false"
                    :icon="{ url: positionImgUrl, size: { width: 50, height: 50 } }">
                    <bm-label content="你的位置" :offset="{ width: 0, height: 40 }" />
                </bm-marker>
                <bm-marker v-for="(point, index) in points" :key="index"
                    :position="{ lng: point.pointTemplate[0], lat: point.pointTemplate[1] }" :dragging="false"
                    :icon="{ url: positionImgUrl, size: { width: 50, height: 50 } }" @click="pointClick(index)">
                    <bm-label :content="point.name" :offset="{ width: 0, height: 40 }" />
                </bm-marker>
                <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT" :offset="{ width: -20, height: 10 }" />
                <div v-if="drivingMode">
                    <bm-driving :start="{ lng: centerPoint.lng, lat: centerPoint.lat }"
                        :end="{ lng: userPoint.lng, lat: userPoint.lat }" :auto-viewport="true" :panel="drivingMode"
                        policy="BMAP_DRIVING_POLICY_LEAST_DISTANCE">
                    </bm-driving>
                </div>
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
import { useRouter } from "vue-router"
import LoadingMy from '../Loading-my.vue'
import { useStore } from "vuex"
const positionImgUrl = require("../../assets/images/location-pin.gif")
const router = useRouter()
const store = useStore()
const mapShow = ref(false)
const drivingMode = computed(() => store.state.map.driving)
const centerPoint = computed(() => store.state.map.center)
const points = computed(() => store.state.map.point)
const userPoint = computed(() => store.state.local.ln)
const mapSwitch = () => mapShow.value = !mapShow.value
const mapLoading = computed(() => store.state.loading)
const zoom = computed(() => store.state.map.ZOOM)


const mapOnload = () => mapShow.value = true
const syncCenterAndZoom = (e) => store.commit("changeMapZOOM", e.target.getZoom())
const pointClick = (index) => {
    if (points.value[index] !== undefined) {
        store.commit("changeMapZOOM", 30)
        router.push("/ScenicView/ScenicInfoView")
        store.dispatch("getScenicById", points.value[index].id)
        store.dispatch("getScenicInfo", points.value[index].name)
    }
}

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
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px !important;
    padding: 5px !important

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
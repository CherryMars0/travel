<template>
    <div class="scenicCard" @mouseover="hoverCard = true" @mouseleave="hoverCard = false">
        <img :src="provinceImg" :alt="province">
        <p>{{ province }}</p>
        <transition name="slide-bottom" enter-active-class="animate__animated animate__fadeInUp"
            leave-active-class="animate__animated animate__fadeOutDown">
            <div class="cardBlurBottom" v-if="hoverCard"
                :class="showallScenics ? 'cardBlurBottomLarge' : 'cardBlurBottomDefault'">
                <div class="btns">
                    <button @click="toCitysInfoOnMap">在地图上显示{{ province }}Top10景区</button>
                    <button @click="showallScenics = !showallScenics">{{ showallScenics ? "查看更少景区" : "查看更多景区" }}</button>
                </div>
                <div class="allScenics" v-if="showallScenics">
                    <ul class="moreCityItems" v-for="(city, index) in provinceInfo" :key="index">
                        <li @click="toOnesCityInfoOnMap(city)">{{ city.name }}</li>
                    </ul>
                </div>
            </div>
        </transition>
    </div>
</template>
<script setup>
import { onMounted, ref } from 'vue'
import { useStore } from 'vuex'
import { toRefs, defineProps } from "vue"
const props = defineProps({ province: String })
const { province } = toRefs(props)
const store = useStore()
let provinceInfo = ref()
let provinceImg = ref()
let hoverCard = ref()

const toOnesCityInfoOnMap = (e) => {
    store.commit("showScience", [{
        id: e.id,
        name: e.name,
        pointTemplate: e.point.split(",")
    }])
    store.commit("changeMapZOOM", 5)
}

const toCitysInfoOnMap = () => {
    const sciences = []
    let flag = 0
    provinceInfo.value.forEach((e) => {
        if (flag <= 9) {
            const science = {
                id: null,
                name: null,
                pointTemplate: null
            }
            science.id = e.id
            science.name = e.name
            science.pointTemplate = e.point.split(",")
            sciences.push(science)
            flag++
        } else return
    })
    store.commit("showScience", sciences)
    store.commit("changeMapZOOM", 5)
}

const showallScenics = ref(false)

onMounted(() => store.dispatch("getScenicByCityName", province.value).then(res => {
    provinceInfo.value = res.data
    provinceImg.value = res.data[1].img
}))

</script>
<style scoped lang="sass">
.scenicCard
    margin-top: 10px !important
    margin-bottom: 10px !important
    width: 400px
    height: 400px
    border: none
    border-radius: 10px
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px
    position: relative
    overflow: hidden

    img
        border-top-left-radius: 10px
        border-top-right-radius: 10px
        width: 100%
        height: 360px
    
    p
        text-align: center
        font-family: tahoma
        font-size: 20px

    .cardBlurBottom
        position: absolute
        width: 100%
        background-color: #e4e4e4
        padding: 10px !important
        bottom: 0
        border-bottom-left-radius: 10px
        border-bottom-right-radius: 10px
        transition:  all linear 1s
    .cardBlurBottomDefault
        height: 40px

    .cardBlurBottomLarge
        height: 300px
</style>
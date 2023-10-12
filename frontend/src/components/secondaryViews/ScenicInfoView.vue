<template>
    <div class="scenicInfoView">
        <p>{{ scenicInfo.name }}</p>
        <img :src="scenicInfo.img" />
        <p>{{ scenicInfo.hot.substring(0, 7) }}</p>
        <p>{{ scenicInfo.intro }}</p>
        <p>{{ scenicInfo.address }}</p>
        <p>{{ scenicInfo.level }}</p>
        <p>{{ scenicInfo.sold }}</p>
        <div>
            <button @click="showMap(scenicInfo)">地图中显示此处</button>
            <button @click="searchHotal(scenicInfo)">寻找附近酒店</button>
        </div>
        <div class="hotalCard" v-for="(hotalInfo, index) in hotalInfos" :key="index">
            <p>{{ hotalInfo.name }}</p>
            <p>地址：{{ hotalInfo.address }}</p>
            <button @click="showMap(hotalInfo)">地图中显示此处</button>
        </div>
    </div>
</template>
<script setup>
import { ref, computed } from 'vue'
import { useStore } from 'vuex'
const store = useStore()

let hotalInfos = ref()
let scenicInfo = computed(() => store.state.views.Scenic.CardInfo)

const showMap = (e) => {
    let point = null
    if (e.location) point = String(e.location.lat + "," + e.location.lng).split(",").reverse()
    else {
        point = e.point.split(",")
        store.commit("driving", true)
    }
    store.commit("showScience", [{
        id: e.id,
        name: e.name,
        pointTemplate: point
    }])
    store.commit("changeCenter", {
        lng: point[0],
        lat: point[1],
    })
    store.commit("changeMapZOOM", 15)
}

const searchHotal = (e) => {
    let payload = {
        name: "酒店",
        point: String(e.point.split(",").reverse()),
        radius: "10000"
    }
    store.dispatch("searchPOI", payload).then(res => {
        if (res.success) hotalInfos.value = JSON.parse(res.data).results
    })
}

</script>
<style scoped lang="scss"></style>
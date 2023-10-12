<template>
    <div class="scenicInfoView">
        <div class="scenicInfo" :class="!showhotalInfos ? '' : 'highInfo'">
            <div class="info">
                <p>{{ scenicInfo.name }}</p>
                <div class="infoImg">
                    <img :src="scenicInfo.img" />
                </div>
                <p>{{ scenicInfo.intro }}</p>
                <p>{{ scenicInfo.hot }}</p>
                <p>景区地址：{{ scenicInfo.address }}</p>
                <p>景区等级：{{ scenicInfo.level }}</p>
                <p>票价：{{ scenicInfo.sold }}￥</p>
            </div>
            <p class="desc">&nbsp;&nbsp;&nbsp;&nbsp;{{ scenicDesc }}</p>
            <div class="btn">
                <button @click="showMap(scenicInfo)">地图中显示到此处的路线图</button>
                <button @click="searchHotal(scenicInfo)">寻找附近酒店</button>
            </div>
            <div class="hotalCards" v-show="showhotalInfos">
                <div class="hotalCard" v-for="(hotalInfo, index) in hotalInfos" :key="index">
                    <p>{{ hotalInfo.name }}</p>
                    <p>tel:{{ hotalInfo.telephone }}</p>
                    <p>地址：{{ hotalInfo.address }}</p>
                    <div class="btn">
                        <button @click="showMap(hotalInfo)">地图中显示此处</button>
                        <button @click="reserveHotal(hotalInfo)">预定酒店</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup>
import { ref, computed, onUnmounted } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'
const store = useStore()
const router = useRouter()

let hotalInfos = ref()
let userInfo = computed(() => store.state.User)
let showhotalInfos = ref(false)
let scenicInfo = computed(() => store.state.views.Scenic.CardInfo)
let scenicDesc = computed(() => {
    if (store.state.views.Scenic.scenicInfo != undefined) return store.state.views.Scenic.scenicInfo.list[0].content
    else return ""
})

const showMap = (e) => {
    let point = null
    if (e.location) {
        point = String(e.location.lat + "," + e.location.lng).split(",").reverse()
        store.commit("driving", false)
    }
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

onUnmounted(() => store.commit("driving", false))

const searchHotal = (e) => {
    showhotalInfos.value = true
    let payload = {
        name: "酒店",
        point: String(e.point.split(",").reverse()),
        radius: "10000"
    }
    store.dispatch("searchPOI", payload).then(res => {
        if (res.success) hotalInfos.value = JSON.parse(res.data).results
    })
}

const reserveHotal = (e) => {
    if(!userInfo.value.isLoging){
        alert("请先登录，即将跳转到登录页面！")
        router.push("/UserView")
    }else{
        console.log(userInfo.value);
        console.log(e)
    }
}

</script>
<style scoped lang="sass">
.highInfo
    height: 1000px !important
button
    border-radius: 5px
.scenicInfoView
    min-width: 1280px
    display: flex
    justify-content: center
    
    .scenicInfo
        margin: 15px !important
        padding: 15px !important
        border-radius: 5px
        transition: all linear 0.2s
        width: 1280px
        height: 700px
        box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;

    .desc
        width: 100%
        height: 200px
        overflow: hidden
        overflow-y: auto

    .hotalCards
        width: 100%
        height: 300px
        overflow: hidden
        overflow-y: auto
        display: flex
        justify-content: space-around
        align-items: center
        flex-wrap: wrap
        border-radius: 10px
        box-shadow: rgba(0, 0, 0, 0.12) 0px 1px 3px, rgba(0, 0, 0, 0.24) 0px 1px 2px;

        .hotalCard
            margin: 10px !important
            padding: 10px !important
            width: 300px
            height: 180px
            border-radius: 5px
            box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px

            p:nth-of-type(1)
                font-size: 18px
                margin-bottom: 10px !important
                font-weight: bold

            p
            text-align: center
            font-size: 14px

            button
                margin-top: 20px !important
                padding: 10px !important

    .btn
        width: 300px
        height: 50px
        display: flex
        align-items: center
        justify-content: space-around

    .info
        width: 500px
        height: 400px
        margin-left: 380px !important

        .infoImg
            width: 500px
            text-align: center
        
        p
            text-align: center

        p:nth-of-type(1)
            font-size: 32px
            margin-bottom: 10px !important
</style>
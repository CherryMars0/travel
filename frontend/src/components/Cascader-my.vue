<template>
    <div class="cascader">
        <slot></slot>
        <select @change="getCity(chooseProvince)" v-model="chooseProvince">
            <option v-for="(item, index) in provinces" :key="index" :value="item">{{ item }}</option>
        </select>
        <select @change="getUrban(chooseCity)" v-model="chooseCity" v-show="citys">
            <option v-for="(item, index) in citys" :key="index" :value="item">{{ item }}</option>
        </select>
        <select v-model="chooseUrban" v-show="urbans">
            <option v-for="(item, index) in urbans" :key="index" :value="item">{{ item }}</option>
        </select>
    </div>
</template>
<script setup>
import { ref, onMounted, defineExpose } from "vue"
import { useStore } from "vuex";
import { ChineseDistricts } from "../data/ChineseDistricts"

const provinces = Object.keys(ChineseDistricts)
const store = useStore()
const citys = ref()
const urbans = ref()
const chooseProvince = ref()
const chooseCity = ref()
const chooseUrban = ref()

defineExpose({
    chooseProvince,
    chooseCity,
    chooseUrban
})

let getCity = (province) => {
    citys.value = Object.keys(ChineseDistricts[province])
    urbans.value = ""
}
let getUrban = (city) => urbans.value = ChineseDistricts[chooseProvince.value][city]

onMounted(() => {
    chooseProvince.value = store.state.local.currentLocation.province
    getCity(store.state.local.currentLocation.province)
    chooseCity.value = store.state.local.currentLocation.city
    getUrban(store.state.local.currentLocation.city)
    chooseUrban.value = store.state.local.currentLocation.district
})
</script>
<style scoped lang="sass">
.cascader
    width: 100%
    select
        margin-left: 10px !important
        border: none
        cursor: pointer
        border: 1px solid rgb(0, 218, 212)
        border-radius: 5px
        height: 22px
</style>
<template>
    <div class="scenicView">
        <div class="ScenicCard">
            <ScenicCards v-for="(province, index) in provinces" :key="index" :province="province" />
        </div>

    </div>
</template>
<script setup>
import ScenicCards from "../components/main/ScenicCards"
import { provinces } from "../data/province"
</script>
<style scoped lang="sass">
.scenicView
    padding: 10px !important
    display: flex
    justify-content: center
    min-width: 1280px

    .ScenicCard
        width: 1280px
        display: flex
        flex-wrap: wrap
        justify-content: space-around
</style>

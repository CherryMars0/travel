<template>
    <div class="scenicView">
        <ScenicCards />
        <ScenicCards />
        <ScenicCards />
        <ScenicCards />
        <ScenicCards />
        <ScenicCards />
        <ScenicCards />
        <ScenicCards />
    </div>
</template>
<script setup>
import ScenicCards from "../components/main/ScenicCards"
</script>
<style scoped lang="sass">
.scenicView
    padding: 10px !important
    display: flex
    flex-wrap: wrap
    justify-content: space-around
</style>

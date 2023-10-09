<template>
    <div class="indexView">
        <div class="indexTop">
            <TickCard />
            <TravelRecommend />
        </div>
        <div class="indexMiddle">
            <TravelTop10 />
        </div>
        <div class="indexBottom">
            <TravelSeason />
        </div>
    </div>
</template>
<script setup>
import TickCard from "../components/main/TickCard"
import TravelRecommend from "../components/main/TravelRecommend"
import TravelSeason from "../components/travelLocation/TravelSeason"
import TravelTop10 from "../components/travelLocation/TravelTop10"
</script>
<style scoped lang="sass">
.indexView
    padding: 10px !important
    width: 100%
    display: flex
    align-items: center
    flex-direction: column
    min-width: 1280px
    
    .indexTop,
    .indexMiddle,
    .indexBottom
        margin-top: 5px !important
        width: 1280px
        display: flex
        justify-content: space-between
</style>

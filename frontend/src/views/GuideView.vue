<template>
  <div class="guideView">
    <div class="GuiderCards">
      <GuiderCard v-for="(guiderData, index) in guiderDatas" :key="index" :guiderData="guiderData" />
    </div>
  </div>
</template>
<script setup>
import GuiderCard from '@/components/GuiderCard.vue'
import { guiderDatas } from "../data/guiderDatas"

</script>
<style scoped lang="sass">
.guideView
    padding: 10px !important
    min-width: 1280px
    display: flex
    justify-content: center

    .GuiderCards
      width: 1280px
      display: flex
      flex-wrap: wrap
      justify-content: space-around
</style>
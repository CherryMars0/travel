<template>
  <div class="guideView">
    <div class="GuiderCards">
      <GuiderCard v-for="(guiderData, index) in guidesInfo" :key="index" :guiderData="guiderData" />
    </div>
  </div>
</template>
<script setup>
import GuiderCard from '@/components/GuiderCard.vue'
import { onMounted,computed } from "vue"
import { useStore } from "vuex"
const store = useStore()
const guidesInfo = computed(()=>store.state.views.Guide.GuidesInfo)
onMounted(() => store.dispatch("getGuides"))
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
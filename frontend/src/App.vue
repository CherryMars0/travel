<template>
  <div class="App">
    <navigationBar />
    <router-view id="chain" />
  </div>
</template>
<script setup>
import navigationBar from "./components/navigationBar.vue"
import { onMounted } from "vue"
import { useStore } from 'vuex'
const store = useStore()
onMounted(() => store.dispatch("getCurrentPosition"))

</script>
<style scoped lang="sass">
#chain
  height: calc( 100vh - 50px)
  width: 100%
  overflow-x: hidden !important
  overflow-y: auto !important
</style>
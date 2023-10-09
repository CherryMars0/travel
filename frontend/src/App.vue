<template>
  <div class="App">
    <NavigationBar />
    <myMap>{{ point }}</myMap>
    <router-view id="chain" class="animate__animated animate__fadeIn" />
  </div>
</template>
<script setup>
import NavigationBar from "./components/NavigationBar.vue"
import { loadScript } from "./bmp.js"
import myMap from "./components/main/myMap.vue"
import { onMounted, computed } from "vue"
import { useStore } from 'vuex'
const store = useStore()
const point = computed(() => store.state.map.point)
onMounted(() => {
  loadScript("GrFlDsENnXr41SXSg0eGC4fkmLifBIxA")
  store.dispatch("getCurrentPosition")
  if (localStorage.getItem("userName") !== null && localStorage.getItem("userID") !== null && localStorage.getItem('token') !== null) {
    store.state.User.isLoging = true
    store.state.User.userName = localStorage.getItem("userName")
    store.state.User.userId = localStorage.getItem("userID")
    store.state.User.token = localStorage.getItem("token")
    store.state.User.newUse = localStorage.getItem("newUse")
  } else {
    store.state.User.isLoging = false
    store.state.User.userName = null
    store.state.User.userId = null
    store.state.User.token = null
    store.state.User.newUse = null
    localStorage.removeItem("userName")
    localStorage.removeItem("userID")
    localStorage.removeItem("token")
    localStorage.removeItem("newUse")
  }
})

</script>
<style scoped lang="sass">
#chain
  height: calc( 100vh - 54px)
  width: 100%
  overflow-x: hidden !important
  overflow-y: auto !important
</style>
<template>
    <div class="adminMain">
        <MainSlider />
        <div class="mainView">
            <ScenicInfo v-if="mainView == 0" />
            <HotalInfo v-if="mainView == 1" />
            <UserInfo v-if="mainView == 2" />
            <GuideInfo v-if="mainView == 3" />
        </div>
    </div>
</template>
<script setup>
import MainSlider from "./MainSlider.vue"
import GuideInfo from "./GuideInfo.vue"
import ScenicInfo from "./ScenicInfo.vue"
import HotalInfo from "./HotalInfo.vue"
import UserInfo from "./UserInfo.vue"
import { computed } from "vue"
import { useStore } from "vuex"
const store = useStore()
const mainView = computed(() => store.state.views.admin.mainView)

</script>
<style scoped lang="sass">
.adminMain
    width: 100%
    height: 100%

    .mainView
        height: 100%
        width: calc( 100% - 220px)
        float: right
</style>
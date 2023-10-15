<template>
    <div class="adminViews">
        <AdminLogin v-if="!isLoging" />
        <AdminMain v-if="isLoging" />
    </div>
</template>
<script setup>
import AdminLogin from "../components/admin/AdminLogin.vue"
import AdminMain from "../components/admin/AdminMain.vue"
import { computed, onMounted } from "vue"
import { useStore } from "vuex"
const store = useStore()
const isLoging = computed(() => store.state.admin.isLoging)
onMounted(() => {
    if (localStorage.getItem("adminName") !== null) store.commit("adminState", true)
    else store.commit("adminState", false)
})
</script>
<style scoped lang="sass">
.adminViews
    width: 100%
    height: 100%
    display: flex
    justify-content: center
    align-items: center
    min-width: 1550px
</style>
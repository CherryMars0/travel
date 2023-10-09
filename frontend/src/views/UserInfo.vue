<template>
    <div>
        <p>{{ User.userName }}</p>
        <NewUserForm v-if="JSON.parse(User.newUse)" />
        <p>您所有的规划</p>
        <ul>
            <li @click="logout">
                <router-link to="/UserView">登出</router-link>
            s</li>
        </ul>
    </div>
</template>
<script setup>
import { computed } from "vue"
import { useStore } from "vuex"
import NewUserForm from "../components/NewUserForm.vue"
const store = useStore()
let User = computed(() => store.state.User)
let logout = () => {
    store.state.User.isLoging = false
    localStorage.removeItem("userName")
    localStorage.removeItem("userID")
    localStorage.removeItem("token")
    localStorage.removeItem("newUse")
    store.state.User.userName = null
    store.state.User.userId = null
    store.state.User.token = null
    store.state.User.newUse = null
}
</script>
<style scoped lang="scss"></style>
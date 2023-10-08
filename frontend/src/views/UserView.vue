<template>
    <div class="userView">
        <LoginForm v-if="!isLoging" />
        <RegisterForm v-if="isLoging" />
    </div>
</template>
<script setup>
import LoginForm from '@/components/LoginForm.vue'
import RegisterForm from '@/components/RegisterForm.vue'
import { computed } from 'vue'
import { useStore } from 'vuex'
let store = useStore()
let isLoging = computed(() => store.state.views.User.isLoging)
</script>
<style scoped lang="sass">
.userView
    width: 100%
    height: 100%
    position: relative
    z-index: 1

.userView::after
    position: absolute
    width: 100%
    height: 100%
    top: 0
    left: 0
    content: ""
    z-index: -1
    background-image: url("../assets/images/bg.jpg")
    background-repeat: no-repeat
    background-size: 200% 200%
    filter: blur(5px)
</style>
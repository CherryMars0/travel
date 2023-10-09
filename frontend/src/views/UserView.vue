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
    margin-top: 1px !important
    width: 100%
    height: 100%
    position: relative
    background-color: rgba(0, 218, 212, 0.1)
</style>
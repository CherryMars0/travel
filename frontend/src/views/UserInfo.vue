<template>
    <div>
        <p>{{ userName }}</p>
    </div>
</template>
<script setup>
import { computed } from "vue";
import { useStore } from "vuex";
const store = useStore()
let userName = computed(() => store.state.User.userName)

</script>
<style scoped lang="scss"></style>
<template>
    <div class="scenicView">
        <scenicCards />
        <scenicCards />
        <scenicCards />
        <scenicCards />
        <scenicCards />
        <scenicCards />
        <scenicCards />
        <scenicCards />
    </div>
</template>
<script setup>
import scenicCards from "../components/main/scenicCards"
</script>
<style scoped lang="sass">
.scenicView
    padding: 10px !important
    display: flex
    flex-wrap: wrap
    justify-content: space-around
</style>

<template>
    <div class="donut"></div>
</template>
<style scoped lang="css">
@keyframes donut-spin {
    0% {
        transform: rotate(0deg);
    }

    100% {
        transform: rotate(360deg);
    }
}

.donut {
    display: inline-block;
    border: 4px solid rgba(0, 0, 0, 0.1);
    border-left-color: #59a782;
    border-radius: 50%;
    margin-top: 5px !important;
    width: 30px;
    height: 30px;
    animation: donut-spin 1.2s linear infinite;
}
</style>
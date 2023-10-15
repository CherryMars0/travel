<template>
    <div class="scenicInfo">
        <p class="countNumber">总收录景区数量:{{ scenicCount }}</p>
        <div class="scenics">
            <ul>
                <li>
                    <p class="name">景点名称:</p>
                    <p class="address">地址:</p>
                    <p class="hot">热度:</p>
                    <p class="intro">标签:</p>
                    <p class="level">景区等级:</p>
                    <p class="point">地理坐标:</p>
                </li>
                <li v-for="(scneic, index) in scenics" :key="index">
                    <p class="name">
                        <input type="text" :disabled="!(isChangeScenicNumber == index)"
                            :class="isChangeScenicNumber == index ? 'isChangeScenic' : ''" v-model="scneic.name">
                    </p>
                    <p class="address">
                        <input type="text" :disabled="!(isChangeScenicNumber == index)"
                            :class="isChangeScenicNumber == index ? 'isChangeScenic' : ''" v-model="scneic.address">
                    </p>
                    <p class="hot">
                        <input type="text" :disabled="!(isChangeScenicNumber == index)"
                            :class="isChangeScenicNumber == index ? 'isChangeScenic' : ''" v-model="scneic.hot">
                    </p>
                    <p class="intro">
                        <input type="text" :disabled="!(isChangeScenicNumber == index)"
                            :class="isChangeScenicNumber == index ? 'isChangeScenic' : ''" v-model="scneic.intro">
                    </p>
                    <p class="level">
                        <input type="text" :disabled="!(isChangeScenicNumber == index)"
                            :class="isChangeScenicNumber == index ? 'isChangeScenic' : ''" v-model="scneic.level">
                    </p>
                    <p class="point">
                        <input type="text" :disabled="!(isChangeScenicNumber == index)"
                            :class="isChangeScenicNumber == index ? 'isChangeScenic' : ''" v-model="scneic.point">
                    </p>
                    <p class="btn">
                        <button @click="changeScenic(scneic, index)">{{ isChangeScenicNumber == index && changeScenicButton
                            ? "确定" : "修改" }}</button>
                        <button @click="deleteScenic(scneic)">删除</button>
                    </p>
                </li>
            </ul>
            <div class="count">
                <ul class="countItems">
                    <li @click="getScenic(1)">1</li>
                    <li @click="getScenic(2)">2</li>
                    <li @click="getScenic(3)">3</li>
                    <li @click="getScenic(4)">4</li>
                    <li @click="getScenic(5)">5</li>
                    <li @click="getScenic(6)">6</li>
                    <li @click="getScenic(7)">7</li>
                    <li @click="getScenic(8)">8</li>
                    <li @click="getScenic(9)">9</li>
                    <li @click="getScenic(10)">10</li>
                    <li>....</li>
                    <li @click="getScenic(9143)">9143</li>
                    <div @click="getScenic(jumpNumber)">
                        <input type="text" v-model="jumpNumber">
                        <button>跳转</button>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</template>
<script setup>
import { ref } from "vue"
import { useStore } from 'vuex'
const store = useStore()

const scenics = ref([])
const jumpNumber = ref(1)
const scenicCount = ref(0)
const isChangeScenicNumber = ref(-1)
const changeScenicButton = ref(false)

store.dispatch("getScenicCount").then(res => scenicCount.value = res.data)
store.dispatch("getScenicByCount", {
    start: 0,
    end: 9
}).then(res => scenics.value = res.data)

const getScenic = (count) => {
    jumpNumber.value = count
    store.dispatch("getScenicByCount", {
        start: (count - 1) * 9,
        end: 9
    }).then(res => scenics.value = res.data)
}
const deleteScenic = (e) => {
    console.log(e);
}

const changeScenic = (e, i) => {
    isChangeScenicNumber.value = i
    changeScenicButton.value = !changeScenicButton.value
    if (!changeScenicButton.value) {
        isChangeScenicNumber.value = -1
        console.log(e)
    }
}
</script>
<style lang="sass" scoped>
.isChangeScenic
    border: 1px solid black !important
.countNumber
    position: absolute
    z-index: 9999
    bottom: 0


.scenicInfo
    width: 100%
    height: 100%
    background-color: #e4e4e4
    padding: 10px !important
    display: flex
    align-items: center
    justify-content: center

    .scenics
        background-color: #fff
        padding: 10px !important
        border-radius: 5px
        opacity: 0.9
        width: 1310px
        height: 560px
        position: relative

        ul
            width: 1290px
            height: 500px
            position: relative

            li
                width: 100%
                display: flex

                p
                    display: block
                    width: 263px
                    height: 50px
                    overflow: hidden
                    text-overflow: ellipsis
                    white-space: nowrap
                    cursor: pointer
                    line-height: 50px

                    input
                        border: none
                        font-size: 16px
                        background-color: rgba(0,0,0,0)
                        width: 80%
                        border-radius: 3px
                        color: black

                .level,.id,.btn,.hot
                    width: 100px
                    text-align: center
                
                .name
                    width: 200px

                .btn
                    width: 100px
                    height: 50px

                    button
                        width: 45px
                        height: 30px
                        margin: 2.5px !important
                        border-radius: 5px
                        background-color: #555
                        color: white
                        line-height: 15px

.count
    width: 100%
    height: 40px
    display: flex
    justify-content: center
    align-items: center
    
    .countItems
        height: 40px !important
        width: 800px !important
        padding-left: 20px !important
        padding-right: 20px !important
        display: flex
        align-items: center
        background-color: #4e4e4e
        border-radius: 20px
        color: white


        li
            width: 20px
            height: 20px
            text-align: center
            line-height: 20px
            cursor: pointer

        div
            display: flex
            align-items: center
            justify-content: space-around

            input
                height: 20px
                width: 20px
                text-align: center
                line-height: 20px
                border-radius: 5px

            button
                border-radius: 2px
                padding: 0  !important
                margin: 0 !important
                height: 20px
                width: 40px
                line-height: 20px !important
                font-size: 12px
                border: none
                margin-left: 10px !important
</style>
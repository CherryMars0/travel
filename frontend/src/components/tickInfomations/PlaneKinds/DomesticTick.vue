<template>
    <div class="Domestic">
        <div class="frequency">
            <input type="radio" checked value="one" name="frequency" v-model="oneMore">
            <label for="one">单程</label>
            &nbsp;
            <input type="radio" value="double" name="frequency" v-model="oneMore">
            <label for="double">往返</label>
        </div>
        <div class="dest">
            <div class="destName">
                <div>
                    <Cascader ref="SetOffLocation">
                        <label>出发:</label>
                    </Cascader>
                </div>
                <div>
                    <Cascader ref="ArriveLocation">
                        <label>到达:</label>
                    </Cascader>
                </div>
            </div>
            <div class="destTime">
                <div>
                    <label>出发时间: </label>
                    <date-picker v-model:value="SetOffTime"></date-picker>
                </div>
                <div>
                    <label>到达时间: </label>
                    <date-picker v-model:value="ArriveTime"></date-picker>
                </div>
            </div>
        </div>
        <button class="btn" @click="SubmitTick()">立即搜索</button>
    </div>
</template>
<script setup>
import { ref } from "vue"
import DatePicker from 'vue-datepicker-next'
import 'vue-datepicker-next/index.css'
import Cascader from "../../Cascader-my.vue"
const SetOffTime = ref(new Date())
const ArriveTime = ref(new Date())
const oneMore = ref("one")
const SetOffLocation = ref()
const ArriveLocation = ref()

let SubmitTick = () => {
    let tickTarget = {
        oneMore: oneMore.value,
        setoff: {
            id: "setoff",
            province: SetOffLocation.value.chooseProvince,
            city: SetOffLocation.value.chooseCity,
            urban: SetOffLocation.value.chooseUrban,
            date: SetOffTime.value
        },
        arrive: {
            id: "arrive",
            province: ArriveLocation.value.chooseProvince,
            city: ArriveLocation.value.chooseCity,
            urban: ArriveLocation.value.chooseUrban,
            date: ArriveTime.value
        }
    }
    console.log(tickTarget)
}
</script>
<style scoped lang="sass">
.Domestic
    padding: 20px !important
    width: 100%
    height: 100%
    position: relative

    .frequency
        width: 188px
        margin-bottom: 10px !important

        input
            cursor: pointer
    
    .dest
        width: 100%
        height: 150px
        display: flex
        flex-direction: column
        justify-content: space-around

        .destName,.destTime
            width: 100%
            height: 75px
            display: flex
            flex-direction: column
            justify-content: space-around

    .btn
        width: 150px
        height: 40px
        position: absolute
        top: 150px
        right: 50px
        line-height: 15px
        border-radius: 5px
        background-color: black
        color: white
        transition: all linear .2s

        &:hover
            background-color: rgb(0, 218, 212)
            color: black
</style>

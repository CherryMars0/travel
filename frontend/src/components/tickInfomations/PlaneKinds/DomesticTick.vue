<template>
    <div class="Domestic">
        <div class="frequency">
            <input type="radio" name="frequency" value="1" checked>单程
            <input type="radio" name="frequency" value="2">往返
        </div>
        <div class="dest">
            <div class="destName">
                <div>
                    <Cascader ref="SetOffLocation">出发:</Cascader>
                </div>
                <div>
                    <Cascader ref="ArriveLocation">到达:</Cascader>
                </div>
            </div>
            <div class="destTime">
                <div>
                    出发时间:
                    <date-picker v-model:value="SetOffTime"></date-picker>
                </div>
                <div>
                    到达时间:
                    <date-picker v-model:value="ArriveTime"></date-picker>
                </div>
            </div>
        </div>
        <div>
            <button @click="SubmitTick()">立即搜索</button>
        </div>
    </div>
</template>
<script setup>
import { ref } from "vue"
import DatePicker from 'vue-datepicker-next'
import 'vue-datepicker-next/index.css'
import Cascader from "../../Cascader-my.vue"
const SetOffTime = ref(new Date())
const ArriveTime = ref(new Date())
const SetOffLocation = ref()
const ArriveLocation = ref()

let SubmitTick = () => {
    let tick = {
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
    console.log(tick)
}
</script>
<style scoped lang="sass">
.Domestic
    padding: 20px !important
    width: 100%
    height: 100%
</style>

<template>
    <div class="mains">
        <div class="map">
            <div class="maps" ref="baiduRef"></div>
            <div class="employeeList">
                <div class="item" v-for="(employee, index) in employees" :key="index" @click="checkMap(index)"
                    :id="employee.employeeId">
                    <input type="checkBox" ref="checkBox" :checked="employee.check">
                    <label>&nbsp;{{ employee.userName }}</label>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup>
import store from '@/store'
import BMap from 'BMap'
import { onMounted, ref, computed } from 'vue'
const baiduRef = ref()
const map = ref()
const CenterPoint = ref()
const checkBox = ref()
const points = ref([])
let driving



const auth = computed(() => {
    return store.state.user.auth
})

let initMap = (lng = location.value[0].latitude, lat = location.value[0].longitude) => {
    map.value = new BMap.Map(baiduRef.value)
    CenterPoint.value = new BMap.Point(lng, lat)
    map.value.addControl(new BMap.NavigationControl())
    map.value.addControl(new BMap.ScaleControl())
    map.value.addControl(new BMap.OverviewMapControl())
    map.value.centerAndZoom(CenterPoint.value, 15)
    map.value.enableScrollWheelZoom(true)
    let marker = new BMap.Marker(CenterPoint.value)
    let label = new BMap.Label("company", {
        position: CenterPoint.value,
        offset: new BMap.Size(0, 5)
    })
    map.value.addOverlay(label)
    map.value.addOverlay(marker)
    let Origin = {
        latitude: CenterPoint.value.lat,
        longitude: CenterPoint.value.lng
    }
    employees.value.forEach(employee => {
        employee.check = false
        let Target = {
            longitude: location.value[employee.locationId - 1].latitude,
            latitude: location.value[employee.locationId - 1].longitude
        }
        store.dispatch("mapGuide", { auth, Origin, Target, employeeId: Number(employee.employeeId) })
    })
}

let location = computed(() => {
    return store.state.location
})

let employees = computed(() => {
    return store.state.employee
})

let distances = computed(() => {
    return store.state.distance
})

let addMarker = (id, lat, lng, content) => {
    let point = new BMap.Point(lat, lng)
    let marker = new BMap.Marker(point)
    let label = new BMap.Label(content, {
        position: point,
        offset: new BMap.Size(0, 5)
    })
    points.value[id] = { point, marker, label }
    map.value.addOverlay(label)
    map.value.addOverlay(marker)
    driving.search(point, CenterPoint.value)
}

let removeMarker = (id) => {
    map.value.removeOverlay(points.value[id].marker)
    map.value.removeOverlay(points.value[id].label)
    driving.search(CenterPoint.value, CenterPoint.value)
    points.value.splice[id, 1]
}

let checkMap = (index) => {
    let lu = location.value[employees.value[index].locationId - 1]
    if (employees.value[index].check) {
        removeMarker(index)
        employees.value[index].check = false
    } else {
        let name = 'name:' + employees.value[index].userName
        let gender = '<br >gender:' + employees.value[index].gender
        let address = ' <br >address:' + lu.locationName
        let distance = ' <br >distance:' + distances.value[index + 1] + "m"
        let baseSalary = ' <br >baseSalary:' + employees.value[index].baseSalary
        let subsidies = ' <br >subsidies:' + String(distances.value[index + 1] > 20000 ? 500 : 0)
        let totalSalary = ' <br >totalSalary:' + (Number(employees.value[index].baseSalary) + Number(distances.value[index + 1] > 20000 ? 500 : 0))
        let content = name + gender + address + distance + baseSalary + subsidies + totalSalary
        addMarker(index, lu.latitude, lu.longitude, content)
        employees.value[index].check = true
    }
}

onMounted(() => {
    initMap()
    driving = new BMap.DrivingRoute(map.value, {
        renderOptions: {
            map: map.value,
            autoViewport: true
        }
    })
})
</script>
<style scoped lang="scss">
.mains {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    padding: 2px !important;
    background-color: #ccc;

    .map {
        width: 100%;
        height: 100%;
        display: flex;

        .maps {
            width: 85%;
            height: 100%;
        }

        .employeeList {
            width: 15%;
            height: 100%;
            overflow-y: auto;
            background-color: #ccc;

            .item {
                width: 100%;
                min-height: 50px;
                text-align: center;
                line-height: 50px;

                label {
                    cursor: pointer;
                }
            }
        }
    }
}
</style>
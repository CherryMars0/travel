<template>
    <div class="mains">
        <div class="chart">
            <div id="container" ref="chart_area_left"></div>
            <div id="container" ref="chart_area_right"></div>
            <div class="add_button">
                <button @click="EmployeeBox(null, 'insert')">add employee</button>
            </div>
        </div>
        <div class="mainContext">
            <table class="table table-bordered rounded-3">
                <thead class="table-header table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>BaseSalary</th>
                        <th>Age</th>
                        <th>Location</th>
                        <th>Operation</th>
                    </tr>
                </thead>
                <tbody class="tableBody">
                    <tr v-for="employee in employees" :key="employee.employeeId">
                        <td>{{ employee.employeeId }}</td>
                        <td>{{ employee.userName }}</td>
                        <td>{{ employee.gender }}</td>
                        <td>{{ employee.baseSalary }}</td>
                        <td>{{ employee.age }}</td>
                        <td>{{ locationName(employee.locationId) }}</td>
                        <td class="btn">
                            <button @click="EmployeeBox(employee.employeeId, 'update')">update</button>
                            <button @click="deleteEmployee(employee.employeeId)">delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="userForm animate__animated" :class="{ animate__backInRight: employeeForm }" v-if="employeeForm">
            <div class="userForm_top">
                <div class="closeForm" @click="employeeForm = false">x</div>
            </div>
            <div class="userForm_middle">
                <div>
                    <label>ID:</label>
                    <input disabled type="text" :placeholder="focusEmployee.employeeId">
                </div>
                <div>
                    <label>Name:</label>
                    <input type="text" :placeholder="focusEmployee.userName" v-model="submitEmployee.userName">
                </div>
                <div>
                    <label>Gender:</label>
                    <select v-model="submitEmployee.gender">
                        <option value="man">man</option>
                        <option value="woman">woman</option>
                    </select>
                </div>
                <div>
                    <label>BaseSalary:</label>
                    <input type="text" :placeholder="focusEmployee.baseSalary" v-model="submitEmployee.baseSalary">
                </div>
                <div>
                    <label>Age:</label>
                    <input type="text" :placeholder="focusEmployee.age" v-model="submitEmployee.age">
                </div>
                <div>
                    <label>Location:</label>
                    <select v-model="focusEmployee.locationId">
                        <option v-for="(loc, index) in location" :key="index" :value="loc.locationId">{{
                            loc.locationName }}</option>
                    </select>
                </div>
            </div>
            <div class="userForm_bottom">
                <button @click="updateSubmit">submit</button>
                <button @click="employeeForm = false">cancel</button>
            </div>
        </div>
    </div>
</template>
<script setup>
import { watch, computed, reactive, ref, onMounted } from 'vue'
import { ageOptions, genderOptions } from "../EchartData"
import * as echarts from 'echarts'
import { useStore } from 'vuex'
const store = useStore()
const chart_area_left = ref()
const chart_area_right = ref()
let employeeForm = ref(false)
let myEcharts = reactive({})
let focusEmployee = ref({})
let submitEmployee = ref({})

const auth = computed(() => {
    return store.state.user.auth
})

const employees = computed(() => {
    return store.state.employee
})

const location = computed(() => {
    return store.state.location
})

const init = (chart, option) => {
    myEcharts = echarts.init(chart)
    myEcharts.setOption(option)
    window.onresize = () => {
        myEcharts.resize()
    }
}

const deleteEmployee = (id) => {
    let trunk = { id, auth }
    store.dispatch("deleteEmployee", trunk)
}

const gender = computed(() => {
    return store.state.gender
})

const age = computed(() => {
    return store.state.age
})

const EmployeeBox = (id, method) => {
    if (method == "update") {
        employeeForm.value = false
        focusEmployee.value = employees.value[id - 1]
        submitEmployee.value = employees.value[id - 1]
        employeeForm.value = true
    } else if (method == 'insert') {
        employeeForm.value = false
        let trunk = {
            employeeId: null,
            userName: '',
            gender: '',
            baseSalary: '',
            age: '',
        }
        focusEmployee.value = trunk
        submitEmployee.value = trunk
        employeeForm.value = true
    }
}

const updateSubmit = () => {
    let id = submitEmployee.value.employeeId
    if (id) {
        let data = { id, submitEmployee, auth }
        store.dispatch("updateEmployee", data)
    } else {
        submitEmployee.value.employeeId = Number(employees.value[employees.value.length - 1].employeeId) + 1
        let data = { submitEmployee, auth }
        store.dispatch("insertEmployee", data)
    }
    employeeForm.value = false
}

const locationName = (index) => {
    if (location.value[index - 1]) {
        return location.value[index - 1].locationName
    } else {
        return null
    }
}

watch(gender, (newVal) => {
    init(chart_area_right.value, genderOptions(newVal.man, newVal.woman))
})

watch(age, (newVal) => {
    init(chart_area_left.value, ageOptions(newVal))
})

onMounted(() => {
    init(chart_area_left.value, ageOptions(age.value))
    init(chart_area_right.value, genderOptions(gender.value.man, gender.value.woman))
})
</script>
<style scoped lang="scss">
.mains {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 2px !important;
    background-color: #2c343c;
    position: relative;
    overflow-x: hidden;

    .userForm {
        top: 450px;
        position: absolute;
        width: 400px;
        height: 350px;
        background-color: #e4e4e4;
        opacity: 0.95;
        border-radius: 5px;
        display: flex;
        flex-direction: column;

        .userForm_top {
            width: 100%;
            height: 30px;
            display: flex;
            justify-content: flex-end;
            align-items: center;

            .closeForm {
                width: 25px;
                height: 25px;
                border-radius: 50%;
                background-color: #2c343c;
                color: white;
                text-align: center;
                line-height: 25px;
                cursor: pointer;
                transition: all linear 0.3s;
                margin-right: 5px !important;
                margin-top: 2px !important;
            }

            .closeForm:hover {
                background-color: black;
                color: white;
            }
        }

        .userForm_middle {
            width: 100%;
            height: 280px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-around;

            div {

                label {
                    width: 105px;
                    text-align: center;
                }

                input,
                select {
                    width: 220px;
                    border: none;
                    padding: 5px !important;
                    outline: none;
                    border-radius: 5px;
                }

                select {
                    cursor: pointer;
                }
            }
        }

        .userForm_bottom {
            width: 100%;
            height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;

            button {
                border: none;
                background-color: #2c343c;
                border-radius: 5px;
                color: #ccc;
                height: 30px;
                margin-left: 5px !important;
                line-height: 30px;
                width: 70px;
            }
        }
    }

    .chart {
        width: 100%;
        height: 40%;
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;

        #container {
            box-sizing: border-box;
            height: 100%;
            width: 50%;
        }

        .add_button {
            position: absolute;
            width: 200px;
            height: 25px;
            bottom: -20px;
            left: 5px;

            button {
                width: 200px;
                height: 25px;
                font-size: 16px !important;
                background-color: #ccc;
                border: none;
                border-radius: 5px;
                color: #2c343c !important;
                transition: all linear 0.4s;
            }

            button:hover {
                background-color: #fff;
                color: #2c343c !important;
            }
        }
    }


    .mainContext {
        width: calc(100% - 5px);
        height: 500px;
        overflow-y: auto;
        background-color: #ccc;

        .table {
            width: 100%;
            height: auto;
            text-align: center;

            .tableBody {
                width: 100%;
                overflow-y: auto;

                tr {
                    td {
                        height: 50px;
                        line-height: 50px;
                    }
                }

                .btn {
                    button {
                        border: none;
                        background-color: #2c343c;
                        border-radius: 5px;
                        color: #ccc;
                        height: 40px;
                        margin-left: 5px !important;
                        line-height: 40px;
                        width: 80px;
                    }

                    button:hover {
                        background-color: black;
                        color: #fff;
                    }
                }
            }
        }
    }
}
</style>
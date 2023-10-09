<template>
    <div class="newUserForm animate__animated animate__fadeInLeft">
        <p class="title">&nbsp;&nbsp;在开始您的旅行之前，请先帮助我们填写您的必要信息，以便我们在今后的服务中更好的帮助到您，我们将会妥善保管您的个人信息。当然您也可以直接关闭此窗口，跳过填写您个人的详细信息。
        </p>
        <div class="infoForm">
            <div class="infoInput infoInputSex">
                <p>&nbsp;性别:</p>
                <div>
                    <input type="radio" value="man" name="sex" v-model="sex">&nbsp;
                    <label for="man">男</label>
                </div>
                <div>
                    <input type="radio" value="woman" name="sex" v-model="sex">&nbsp;
                    <label for="woman">女</label>
                </div>
            </div>
            <div class="infoInput">
                <p>详细地址:</p>
                <input type="text" v-model="address">
            </div>
            <div class="infoInput">
                <p>E-Mail:</p>
                <input type="text" v-model="EMail">
            </div>
            <div class="infoInput">
                <p>&nbsp;QQ:</p>
                <input type="text" v-model="QQ">
            </div>
            <div class="infoInput">
                <p>手机号:</p>
                <input type="text" v-model="MobilePhone">
            </div>
            <div class="btns">
                <button @click="submit">确认</button>
                <button @click="cancel">取消</button>
            </div>
        </div>
    </div>
</template>
<script setup>
import { ref } from "vue"
import { useStore } from 'vuex'
const store = useStore()
let sex = ref()
let address = ref()
let QQ = ref()
let EMail = ref()
let MobilePhone = ref()

const submit = () => {
    console.log(store)
}

const cancel = () => {

}

</script>
<style scoped lang="sass">
.newUserForm
    width: 400px
    height: 300px
    padding: 10px !important
    position: fixed
    top: calc( 50% - 150px )
    left: calc( 50% - 200px )
    border-radius: 15px
    border: 2px solid #4e4e4e
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    .title
        font-size: 14px
        font-family: serif

    .infoForm
        width: 100%
        height: 200px

        .infoInput
            margin-top: 5px !important
            padding: 5px !important
            margin-left: 57.5px !important
            width: 70%
            display: flex
            align-items: center
            justify-content: space-between

            input
                border: none
                height: 20px
                padding-left: 5px !important
                border-radius: 5px
                outline: none
                vertical-align: baseline
                transition: all linear .2s
                background-color: #e4e4e4

                &:focus
                    background-color: rgb(0, 218, 212)
                    color: white
        .btns
            margin-top: 5px !important
            width: 100%
            display: flex
            justify-content: space-around
            align-items: center

            button
                width: 80px
                height: 30px
                line-height: 15px
                border-radius: 5px
                background-color: black
                color: white
                transition: all linear .2s
                
                &:hover
                    background-color: rgb(0, 218, 212)
                    color: black

</style>
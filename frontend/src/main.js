import { createApp } from 'vue'
import App from './App.vue'
import "./assets/sass/default.sass"
import 'animate.css/animate.min.css'
import store from './store'
import router from './router'
import BaiduMap from 'vue-baidu-map-3x'


const app = createApp(App)
app.use(router).use(store).use(BaiduMap, {
    ak: 'GrFlDsENnXr41SXSg0eGC4fkmLifBIxA'
}).mount('#app')
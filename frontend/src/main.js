import { createApp } from 'vue'
import App from './App.vue'
import "./assets/sass/default.sass"
import 'animate.css/animate.min.css'
import store from './store'
import router from './router'
createApp(App).use(router).use(store).mount('#app')
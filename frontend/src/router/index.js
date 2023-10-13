import { createRouter, createWebHashHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import ScenicView from '../views/ScenicView.vue'
import GuideView from '../views/GuideView.vue'
import UserView from "../views/UserView.vue"
import UserInfo from "../views/UserInfo.vue"
import AdminView from "../views/AdminView.vue"
import ScenicInfoView from "../components/secondaryViews/ScenicInfoView.vue"
import store from "../store/index"

const routes = [
  {
    path: '/',
    name: 'index',
    component: IndexView,
    beforeEnter: (to, from, next) => {
      store.commit("navIsShow",true)
      next()
    },
  },
  {
    path: '/center',
    name: 'centerView',
    component: UserInfo,
    beforeEnter: (to, from, next) => {
      if (localStorage.getItem('userID') !== null && localStorage.getItem('userName') !== null && localStorage.getItem('token') !== null) {
        next()  //放行
      } else {
        alert('access denied !')
        next("/UserView")
      }
    },
  },
  {
    path: '/GuideView',
    name: 'GuideView',
    component: GuideView,
    beforeEnter: (to, from, next) => {
      store.commit("navIsShow",true)
      next()
    },
  },
  {
    path: '/ScenicView',
    name: 'ScenicView',
    component: ScenicView,
    beforeEnter: (to, from, next) => {
      store.commit("navIsShow",true)
      next()
    },
  },
  {
    path: '/UserView',
    name: 'UserView',
    component: UserView,
    beforeEnter: (to, from, next) => {
      store.commit("navIsShow",true)
      next()
    },
  },
  {
    path: '/ScenicView/ScenicInfoView',
    name: 'ScenicInfoView',
    component: ScenicInfoView,
    beforeEnter: (to, from, next) => {
      store.commit("navIsShow",true)
      next()
    },
  },
  {
    path: '/admin',
    name: 'admin',
    component: AdminView,
    beforeEnter: (to, from, next) => {
      store.commit("navIsShow",false)
      next()
    },
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

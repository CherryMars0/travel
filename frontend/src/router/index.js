import { createRouter, createWebHashHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import ScenicView from '../views/ScenicView.vue'
import GuideView from '../views/GuideView.vue'
import PlanView from '../views/PlanView.vue'
import UserView from "../views/UserView.vue"
import UserInfo from "../views/UserInfo.vue"
const routes = [
  {
    path: '/',
    name: 'index',
    component: IndexView
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
    component: GuideView
  },
  {
    path: '/PlanView',
    name: 'PlanView',
    component: PlanView
  },
  {
    path: '/ScenicView',
    name: 'ScenicView',
    component: ScenicView
  },
  {
    path: '/UserView',
    name: 'UserView',
    component: UserView,
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

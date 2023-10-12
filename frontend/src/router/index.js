import { createRouter, createWebHashHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import ScenicView from '../views/ScenicView.vue'
import GuideView from '../views/GuideView.vue'
import UserView from "../views/UserView.vue"
import UserInfo from "../views/UserInfo.vue"
import ScenicInfoView from "../components/secondaryViews/ScenicInfoView.vue"
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
    path: '/ScenicView',
    name: 'ScenicView',
    component: ScenicView
  },
  {
    path: '/UserView',
    name: 'UserView',
    component: UserView,
  },
  {
    path: '/ScenicView/ScenicInfoView',
    name: 'ScenicInfoView',
    component: ScenicInfoView,
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router

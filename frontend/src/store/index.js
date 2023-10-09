import { createStore } from 'vuex'
import router from '@/router'
import req from '../axios/requestStatus'
import { BMPGL } from "../bmp"
export default createStore({
  state: {
    views: {
      User: {
        login: false
      }
    },
    map: {
      ZOOM: 30,
      point: ""
    },
    local: {
      currentLocation: {
        country: "",
        province: "定位中...",
        city: "",
        district: "",
      },
      ln: {
        lng: 0,
        lat: 0
      }
    },
    loading: true,
    User: {
      isLoging: false,
      userName: null,
      newUse: null,
      userId: null,
      token: null,
    },

  },
  mutations: {
    locationLoad(state, payload) {
      state.loading = payload
    },
    isLoging(state, payload) {
      state.views.User.isLoging = payload
    },
    loginSuccess(state, payload) {
      state.User.isLoging = true
      state.User.userName = payload.userName
      state.User.userId = payload.id
      localStorage.setItem("userName", payload.userName)
      localStorage.setItem("userID", payload.id)
      localStorage.setItem("newUse", false)
    },
    registerSuccess(state, payload) {
      state.User.isLoging = true
      state.User.userName = payload.userName
      state.User.userId = payload.id
      localStorage.setItem("userName", payload.userName)
      localStorage.setItem("newUse", true)
      localStorage.setItem("userID", payload.id)
    },
    authSuccess(state, payload) {
      state.User.token = payload
      localStorage.setItem("token", payload)
      router.push("/center")
    },


    distance(state, payload) {
      let { data, employeeId } = payload
      state.distance[employeeId] = (data)
    },
  },
  actions: {
    getCurrentPosition() {
      BMPGL("GrFlDsENnXr41SXSg0eGC4fkmLifBIxA").then(BMapGL => {
        new BMapGL.Geolocation().getCurrentPosition(r => {
          this.state.local.currentLocation = r.address
          this.state.local.ln = r.point
        })
      })
    },
    login(context, payload) {
      let { message } = payload
      req.post.login(message).then(res => {
        if (res.success) {
          context.commit("loginSuccess", res.data)
          req.post.auth(res.data).then((res) => {
            context.commit("authSuccess", res.data)
          })
        } else alert(res)
      }).catch(err => alert(err))
    },
    register(context, payload) {
      let { message } = payload
      req.post.signup(message).then(res => {
        if (res.success) {
          context.commit("registerSuccess", res.data)
          req.post.auth(res.data).then((res) => {
            context.commit("authSuccess", res.data)
          })
        } else alert(res)
      }).catch(err => alert(err))
    },


    mapGuide(context, payload) {
      let { auth, Origin, Target, employeeId } = payload
      req.post.mapGuide(auth.value, { Origin, Target }).then(res => {
        context.commit("distance", { data: JSON.parse(res.data).result.routes[0].distance, employeeId })
      }).catch(err => {
        alert(err)
      })
    }
  }
})

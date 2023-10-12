import { createStore } from 'vuex'
import router from '@/router'
import req from '../axios/requestStatus'
import { BMPGL } from "../bmp"
export default createStore({
  state: {
    views: {
      User: {
        login: false
      },
      Scenic: {
        CardInfo: {
          hot: "10000000000"
        },
        scenicInfo: {
          list: [
            {
              content: null
            }
          ]
        }
      },
      Guide: {
        GuidesInfo: []
      }
    },
    map: {
      ZOOM: 30,
      point: null,
      driving: false,
      center: {
        lng: 0,
        lat: 0
      }
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
    locationLoad: (state, payload) => state.loading = payload,
    isLoging: (state, payload) => state.views.User.isLoging = payload,
    loginSuccess: (state, payload) => {
      state.User.isLoging = true
      state.User.userName = payload.userName
      state.User.userId = payload.id
      localStorage.setItem("userName", payload.userName)
      localStorage.setItem("userID", payload.id)
      localStorage.setItem("newUse", false)
    },
    registerSuccess: (state, payload) => {
      state.User.isLoging = true
      state.User.userName = payload.userName
      state.User.userId = payload.id
      localStorage.setItem("userName", payload.userName)
      localStorage.setItem("newUse", true)
      localStorage.setItem("userID", payload.id)
    },
    authSuccess: (state, payload) => {
      state.User.token = payload
      localStorage.setItem("token", payload)
      router.push("/center")
    },
    showScience: (state, payload) => state.map.point = payload,
    clearOverLay: (state) => state.map.point = null,
    changeMapZOOM: (state, payload) => state.map.ZOOM = payload,
    driving: (state, payload) => state.map.driving = payload,
    changeScenicCardInfo: (state, payload) => state.views.Scenic.CardInfo = payload,
    setScenicInfo: (state, payload) => state.views.Scenic.scenicInfo = payload,
    setGuides: (state, payload) => state.views.Guide.GuidesInfo = payload,
    changeCenter: (state, payload) => {
      state.map.center.lng = payload.lng
      state.map.center.lat = payload.lat
    },
  },
  actions: {
    getCurrentPosition: (context) => BMPGL("GrFlDsENnXr41SXSg0eGC4fkmLifBIxA")
      .then(BMapGL => new BMapGL.Geolocation().getCurrentPosition(r => {
        context.state.local.currentLocation = r.address
        context.state.local.ln = r.point
        context.commit("changeCenter", r.point)
      })),

    login: (context, payload) => req.post.login(payload['message'])
      .then(res => {
        if (res.success) {
          context.commit("loginSuccess", res.data)
          req.post.auth(res.data).then(res => context.commit("authSuccess", res.data))
        } else alert(res)
      }).catch(err => alert(err)),

    register: (context, payload) => req.post.signup(payload['message'])
      .then(res => {
        if (res.success) {
          context.commit("registerSuccess", res.data)
          req.post.auth(res.data).then(res => context.commit("authSuccess", res.data))
        } else alert(res)
      }).catch(err => alert(err)),

    getScenicByCityName: (context, payload) => req.get.getScenicByCityName(payload),
    getScenicById: (context, payload) => req.get.getScenicById(payload).then(res => context.commit("changeScenicCardInfo", res.data)),
    searchPOI: (context, payload) => req.post.searchPOI(payload),
    getScenicInfo: (context, payload) => req.get.getScenicInfo(payload).then(res => context.commit("setScenicInfo", JSON.parse(res.data).result)),
    getGuides: (content) => req.get.getGuides().then(res => content.commit("setGuides", res.data)),
  }
})

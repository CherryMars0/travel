import { createStore } from 'vuex'
import req from '../axios/requestStatus'
import { BMPGL } from "../bmp"
export default createStore({
  state: {
    local: {
      currentLocation: {
        country: "",
        province: "定位中...",
        city: "",
        district: ""
      },
    },
    loading: true,
    User: {
      isLoging: false
    },





    user: {
      userInfo: {},
      auth: null
    },
    errorMessage: null,
    employee: {},
    location: {},
    distance: [],
    age: [0, 0, 0, 0],
    gender: {},
  },
  mutations: {
    locationLoad(state, payload) {
      state.loading = payload
    },
    isLoging(state, payload) {
      state.User.isLoging = payload
    },




    userInfo(state, payload) {
      state.user.userInfo = payload
    },
    auth(state, payload) {
      state.user.auth = payload
    },
    error(state, payload) {
      state.errorMessage = payload
    },
    employee(state, payload) {
      let man = 0
      let woman = 0
      let age = [0, 0, 0, 0]
      payload.map(el => {
        if (el.gender == "man") man++
        else woman++
        if (20 <= el.age && el.age < 30) age[0]++
        if (30 <= el.age && el.age < 40) age[1]++
        if (40 <= el.age && el.age < 50) age[2]++
        if (50 <= el.age && el.age < 60) age[3]++
      })
      state.gender = { man, woman }
      state.age = age
      state.employee = payload
    },
    location(state, payload) {
      state.location = payload
    },
    distance(state, payload) {
      let { data, employeeId } = payload
      state.distance[employeeId] = (data)
    },
  },
  actions: {
    getCurrentPosition() {
      BMPGL("GrFlDsENnXr41SXSg0eGC4fkmLifBIxA").then(BMapGL => {
        let geoc = new BMapGL.Geolocation()
        geoc.getCurrentPosition(r => this.state.local.currentLocation = r.address)
      })
    },
    login(context, payload) {
      let { user, router } = payload
      req.post.login(user).then(res => {
        if (res.success) {
          req.post.auth(user).then(res => {
            localStorage.setItem('token', res.data)
            localStorage.setItem('userName', user.username)
            context.commit('auth', res.data)
            router.push({ name: 'main', params: { auth: res.data } })
          })
        }
      }).catch(err => {
        context.commit('error', err)
      })
    },

    signup(context, payload) {
      let { user, router } = payload
      req.post.signup(user).then(res => {
        if (res.success) {
          localStorage.setItem('token', res.data)
          localStorage.setItem('userName', user.username)
          context.commit('auth', res.data)
          router.push("/main")
        }
      }).catch(err => {
        context.commit('error', err)
      })
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

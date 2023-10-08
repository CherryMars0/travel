import { createStore } from 'vuex'
import req from '../axios/requestStatus'
import { BMPGL } from "../bmp"
export default createStore({
  state: {
    views: {
      User: {
        login: false
      }
    },
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
      isLoging: false,
      userName: NaN,
      userId: NaN
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
      state.views.User.isLoging = payload
    },
    loginSuccess(state,payload){
      state.User.isLoging = true
      state.User.userName = payload.userName
      state.User.userId = payload.id
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
      let { message } = payload
      console.log(message);
      req.post.login(message).then(res => {
        if(res.success){
          context.commit("loginSuccess",res.data)
        }
      }).catch(err => {
        console.log(err);
      })
    },

    register(context, payload) {
      let { message } = payload
      req.post.signup(message).then(res => {
        console.log(res);
      }).catch(err => {
        console.log(err);
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

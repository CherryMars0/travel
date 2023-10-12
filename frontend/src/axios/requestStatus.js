import request from './index.js'
import url from './url.js'
const req = {
    get: {
        getScenicByCityName(name) {
            return request({
                url: url.get.getScenicByCityName + "/" + name,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                },
            })
        },
        getScenicById(id) {
            return request({
                url: url.get.getScenicById + "/" + id,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                },
            })
        }
    },

    post: {
        login(data) {
            return request({
                url: url.post.login,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                },
                data
            })
        },
        signup(data) {
            return request({
                url: url.post.signup,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                },
                data,
            })
        },
        auth(data) {
            return request({
                url: url.post.auth,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                },
                data,
            })
        },
        searchPOI(data) {
            return request({
                url: url.post.searchPOI,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                },
                data,
            })
        },




        mapGuide(auth, data) {
            return request({
                url: url.post.locationDriver,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + auth,
                },
                data
            })
        },

    },
}
export default req
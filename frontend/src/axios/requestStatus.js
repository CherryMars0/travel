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
        },
        getScenicInfo(name) {
            return request({
                url: url.get.getScenicInfo + "/" + name,
                method: 'GET',
                headers: {
                    'Content-Type': "application/x-www-form-urlencoded",
                },
            })
        },
        getGuides() {
            return request({
                url: url.get.getGuides,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                },
            })
        },
        getScenicCount() {
            return request({
                url: url.get.getScenicCount,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                },
            })
        },
        getScenicByCount(start,end) {
            return request({
                url: url.get.getScenicByCount + "/" + start + "/" + end,
                method: 'GET',
                headers: {
                    'Content-Type': "application/x-www-form-urlencoded",
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
        adminLogin(data) {
            return request({
                url: url.post.adminLogin,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                },
                data,
            })
        }
    },
}
export default req
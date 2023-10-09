import request from './index.js'
import url from './url.js'
const req = {
    get: {
        allEmployee(auth) {
            return request({
                url: url.get.allEmployee,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + auth,
                },
            })
        },
        allLocation(auth) {
            return request({
                url: url.get.allLocation,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + auth,
                },
            })
        },
        deleteEmployee(auth, id) {
            return request({
                url: url.get.deleteEmployee + "/" + id,
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + auth,
                },
            })
        },
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
        updateEmployee(auth, data) {
            let { id, employee } = data
            return request({
                url: url.post.updateEmployee + "/" + id,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + auth,
                },
                data: employee
            })
        },
        insertEmployee(auth, data) {
            return request({
                url: url.post.insertEmployee,
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + auth,
                },
                data
            })
        }
    },
}
export default req
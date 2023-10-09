import axios from "axios"

const baseURL = "http://localhost:8080/api/v1"
const instance = axios.create({
	baseURL,
	timeout: 100000,
})

instance.interceptors.response.use(
	response => {
		const res = response.data
		if (res.success) {
			return res
		}
		return Promise.reject(res.data)
	},
	error => {
		return Promise.reject(error)
	},
)
instance.interceptors.request.use(
	config => {
		return config
	},
	error => {
		return Promise.reject(error)
	},
)


export default instance
const urlGroup = {
	post: {
		login: "/User/login",
		signup: "/User/signup",
		auth: "/User/auth",
		searchPOI: "/Scenic/searchHotal",
		adminLogin: "/Admin/login"
	},
	get: {
		getScenicByCityName: "/Scenic/getScenicByCityName",
		getScenicById: "Scenic/getScenicById",
		getScenicInfo: "Scenic/getScenicInfo",
		getGuides: "Guide/getGuides",
		getScenicCount: "Scenic/getScenicCount",
		getScenicByCount:"Scenic/selectScenicByCount"
	}
}
export default urlGroup
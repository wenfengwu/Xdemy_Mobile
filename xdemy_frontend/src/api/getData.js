
import axios from '../request'

//All APIs

//register
export const registerApi = (phone, pwd , name)=> axios.post("/api/v1/pri/user/register",{
    "phone":phone,
    "pwd":pwd,
    "name":name
})

//login
export const loginApi = (phone, pwd) => axios.post("/api/v1/pri/user/login",{
    phone,
    pwd
})


//carousel
export const getCarousel = () => axios.get("/api/v1/pub/video/list_carousel")

//video list
export const getVideoList = ()=> axios.get("/api/v1/pub/video/list")


//video detail
export const getVideoDetail = (vid)=> axios.get("/api/v1/pub/video/find_detail_by_id?",{
    params: {
        video_id:vid
    }
})

//video order
export const saveOrder = (token, vid)=>axios.post("/api/v1/pri/order/create",{
    "video_id":vid
},{
    headers:{
        "token":token
    }
})

//order list
export const getOrderList = (token)=>axios.get("/api/v1/pri/order/list",{
    params:{
        "token":token
    }
})

//user information
export const getUserInfo = (token)=>axios.get("/api/v1/pri/user/find_by_token",{
    params:{
        "token":token
    }
})
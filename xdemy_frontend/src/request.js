import axios from 'axios'


//Base API to backend head
const service = axios.create({
    //url = base url + reqeust url
    baseURL : "http://127.0.0.1:8089",
    
    //request time out
    timeout: 5000
})



export default service
import Vue from 'vue'
import './cube-ui'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

//Route interception
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem("token");

  //private route, token needed
  if(to.matched.some(record => record.meta.requiresAuth)){
    if(token){
      next()
    }else{
      //if does not login, redirect to login page
      next({path:'/login'})
    }
  }
  else{
    next();
  }
})


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

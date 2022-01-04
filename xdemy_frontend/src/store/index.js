import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: localStorage.getItem("token") || ""
  },
  //Synchronously modify the value in state
  mutations: {
    SET_TOKEN:(state, token)=>{
      state.token = token
    }
  },

  //Call the method in mutations asynchronously
  //contxt.commit uses context to trigger a method of mutations
  // This.$store.dispatch in vue code triggers the method defined in action
  actions: {
    setToken(context,token){
      context.commit('SET_TOKEN',token)
    },

    clearToken(context){
      context.commit('SET_TOKEN','')
    }

  },
  modules: {
  }
})

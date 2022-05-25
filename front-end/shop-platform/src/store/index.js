import { createStore } from 'vuex'

export default createStore({
  state: {
    goods:[],
    token: '',
  },
  getters: {
    goodsList(state){
      return state.goods;
    },
    getToken(state){
      return state.token;
    }
  },
  mutations: {
    setGoods(state, payload){
      state.goods = payload;
    },
    setToken(state, payload){
      state.token = payload;
    }
  },
  actions: {
    async fetchGoods({ commit }){
      let token = "Bearer " + localStorage.getItem('Authorization')
      var myHeaders = new Headers();
      myHeaders.append("Authorization", "Bearer "+token);
      myHeaders.append("Content-Type","application/json");
      var requestOptions = {
        method: 'GET',
        headers: myHeaders
      };
      console.log('token',token)
      const json = await fetch('http://localhost:8080/goods', requestOptions)
                        .then( (res) => res.json() );
                        console.log('json', json);
      console.log('fetchGoods json',json)
      commit('setGoods',json);
    },
    async loginAction({commit},user){
      var myHeaders = new Headers();
      myHeaders.append("Content-Type","application/json");
      var raw = JSON.stringify({
        "account": user.account,
        "password": user.password
      });
      var requestOptions = {
        method: 'POST',
        header: myHeaders,
        body: raw,
      };
      let token = await fetch('http://localhost:8080/auth/login', requestOptions)
            .then( (res) => res.headers )
            .then( (headers) => headers.get('Authorization') );
      localStorage.setItem('Authorization',token)
      commit('setToken',token)
    }
  },
  modules: {
  }
})

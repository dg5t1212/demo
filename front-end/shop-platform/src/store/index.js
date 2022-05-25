import { createStore } from 'vuex'

export default createStore({
  state: {
    goods:[],
    token: '',
    resturants:[
      { isOff: true, chip_content: 30, imgUrl: '', name: 'Starbucks', star: 4.5, price: 20, remark: 'Cofee, set menu • 15 - 20 min' },
      { isOff: true, chip_content: 30, imgUrl: '', name: 'Mughal Masala Masala Masala Masala', star: 4.5, price: 20, remark: 'Cofee, set menu • 15 - 20 min' },
      { isOff: false, chip_content: 0, imgUrl: '', name: 'Woondal', star: 4.5, price: 20, remark: 'Cofee, set menu • 15 - 20 min' },
      { isOff: true, chip_content: 30, imgUrl: '', name: 'Red Chillies', star: 4.5, price: 20, remark: 'Cofee, set menu • 15 - 20 min' },
    ],
  },
  getters: {
    goodsList(state){
      return state.goods;
    },
    getToken(state){
      return state.token;
    },
    resturantList(state){
      return state.resturants;
    },
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

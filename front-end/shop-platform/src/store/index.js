import { createStore } from 'vuex'

export default createStore({
  state: {
    goods:[],
    token: localStorage.getItem("token"),
    cartJsonStr: localStorage.getItem("cart"),
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
    cartList(state){
      return JSON.parse(state.cartJsonStr)
    }
  },
  mutations: {
    setGoods(state, payload){
      state.goods = payload;
    },
    setToken(state, payload){
      state.token = payload;
    },
    pushCartItem(state, payload){

    },
    updateCartItem(state, payload){
      state.cartJsonStr = payload
    },
    removeCartItem(state, payload){

    },
    checkOutCart(state, payload){
      state.cartJsonStr = payload;
    }

  },
  actions: {
    async fetchGoods({ commit }){
      let token = "Bearer " + localStorage.getItem('Authorization')
      let myHeaders = new Headers();
      myHeaders.append("Authorization", "Bearer "+token);
      myHeaders.append("Content-Type","application/json");
      let requestOptions = {
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
      let myHeaders = new Headers();
      myHeaders.append("Content-Type","application/json");
      let raw = JSON.stringify({
        "account": user.account,
        "password": user.password
      });
      let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
      };
      let token = await fetch('http://localhost:8080/auth/login', requestOptions)
            .then( (res) => res.headers )
            .then( (headers) => headers.get('Authorization') );
      localStorage.setItem('Authorization',token)
      commit('setToken',token)
    },
    addToCartAction({commit},foods){
      let vCart = localStorage.getItem("cart")
      if(vCart != null){
        let isnew = true;
        vCart = JSON.parse(vCart)

        for(let i = 0; i < vCart.length ; i++){
          if( foods.name == vCart[i].name ){
              isnew = false
              vCart[i].qty += foods.qty;
              break
          }
        }
        if(isnew){
          vCart.push(foods)
        }
      } else {
        vCart = [foods]
      }
      localStorage.setItem("cart", JSON.stringify(vCart))
      commit('updateCartItem', JSON.stringify(vCart))
    },
    removeToCart({commit},food){

    },
    async checkOutCartAction({commit}){
      
      let token = "Bearer " + localStorage.getItem('Authorization')
      let cartStr = localStorage.getItem('cart')
      let cart = JSON.parse(cartStr)

      if(cart !== null && cart.length > 0){
        let myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer "+token);
        myHeaders.append("Content-Type","application/json");
        let raw = JSON.stringify(cart);
        let requestOptions = {
          method: 'POST',
          headers: myHeaders,
          body: raw,
        };
        let json = await fetch('http://localhost:8080/order', requestOptions)
          .then( (res) => res.json() );
        console.log('json', json);
        localStorage.removeItem('cart');
  
        commit('checkOutCart',"{}");
      }else{
        console.log('不上傳');
      }
    }
  },
  modules: {
  }
})

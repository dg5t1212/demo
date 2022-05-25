<template>
  <div class="test v-application v-application--is-ltr theme--light">
    <div id="maskLayout" class="v-overlay v-overlay--active" v-show="isShowLoginView" style="z-index: 201">
      <div v-on:click="switchLoginView" class="v-overlay__scrim" style="opacity: 0.46; background-color: rgb(33, 33, 33); border-color: rgb(33, 33, 33);"></div>
    </div>
    <div class="v-application--wrap">
      <!-- hero-section -->
      <div class="hero-section">
        <div>
          <div class="container">
            <div class="d-flex align-center mt-6 mb-10 navbar-container">
              <a aria-current="page">
                <div class="v-avatar rounded-0" style="height: 48px; min-width: 48px; width: 48px">
                  <img src="https://foodhub-nuxt.vercel.app/_nuxt/img/logo.4a3964e.png" alt/>
                </div>
              </a>
              <div class="spacer"></div>
              <button @click="switchLoginView" type="button" class="v-btn v-btn--text theme--dark v-size--default">
                <span class="v-btn__content">
                  <i class="v-icon notranslate me-0 me-sm-3 mdi mdi-account-circle-outline theme--dark" />
                  <span>Account</span>
                </span>
              </button>
              <button @click="switchCart" type="button" class="me-2 v-btn v-btn--text v-btn--tile theme--light v-size--default">
                <span class="v-btn__content">
                  <i class="v-icon notranslate mdi mdi-cart-outline theme--dark white--text" style="font-size:16px">
                    (8)
                  </i>
                </span>
              </button>
              <button type="button" class="v-app-bar__nav-icon rounded v-btn v-btn--icon v-btn--round v-btn--tile theme--dark v-size--default"></button>
              <Cart @update="updateIsShowCart" 
                    v-bind:vIsShowCart="isShowCart"></Cart>
            </div>
          </div>
        </div>
        <div class="container"></div>
      </div>
      <!-- content -->
      <div class="content">
        <router-view />
        <Footer></Footer>
      </div>
    </div>
    <LightBox v-show="isShowLoginView"></LightBox>
  </div>
</template>
<script>
import LightBox from "@/components/light-box.vue";
import Footer from "@/components/footer.vue";
import Cart from "@/components/cart.vue";

import "@mdi/font/css/materialdesignicons.css";

export default {
  name : "app",
  data: () => ({
    isShowLoginView: false,
    isShowCart: false,
    maskClassList: [""],
  }),
  methods: {
    switchCart(){
      this.isShowCart = true;
      
    },
    switchLoginView() {
      const htmlTag = document.querySelector("HTML");
      if (this.isShowLoginView) {
        this.isShowLoginView = false;
        htmlTag.classList.remove("overflow-y-hidden");
      } else {
        this.isShowLoginView = true;
        htmlTag.classList.add("overflow-y-hidden");
      }
    },
    updateIsShowCart(val){
      this.isShowCart = val
    }
  },
  components: {
    LightBox, Footer, Cart
  }
}
</script>

<style>
.hero-section {
  background-image: url(https://foodhub-nuxt.vercel.app/_nuxt/img/header-bg.d39c465.png);
  background-size: cover;
}
.hero-section .nav {
  display: none;
}
</style>

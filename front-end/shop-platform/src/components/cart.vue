<template>
  <aside v-show="vIsShowCart" :class="classStr" style="height: 100%; top: 0px; transform: translateX(0%); width: 320px;">
      <div class="v-navigation-drawer__content">
          <div>
              <div class="d-flex justify-space-between align-center ps-4 pe-3 mt-3 mb-2">
                  <div class="d-flex align-center">
                      <i class="v-icon notranslate me-1 mdi mdi-shopping-outline theme--light"></i>
                      <h4 class="mb-0 grey--text text--darken-1 f-600">1 Item</h4>
                  </div>
                  <CancelButtonUI :clickFunc="cancelCartView">
                      <i class="v-icon notranslate mdi mdi-close theme--light primary--text"></i>
                  </CancelButtonUI>
              </div>
              <hr class="v-divider theme--light">
              <div class="navbar-scroll">
                  <CartItem v-for="(cartItem, index) in cartList"
                            :key="index"
                            v-bind="cartItem" />
              </div>
          </div>
      </div>
      <div class="v-navigation-drawer__append">
          <div class="pa-2">
              <ButtonUI :clickFunc="checkOut">直接結帳</ButtonUI>
          </div>
      </div>
      <div></div>
  </aside>
</template>

<script>
import ButtonUI from '@/components/buttonUI.vue'
import CancelButtonUI from '@/components/cancelButtonUI.vue'
import CartItem from '@/components/cart-item.vue'
import { mapActions, mapGetters } from 'vuex';
export default {
    naem: "Cart",
    data() {
        return{
            classStr: 'v-navigation-drawer v-navigation-drawer--fixed v-navigation-drawer--is-mobile v-navigation-drawer--open v-navigation-drawer--right v-navigation-drawer--temporary theme--light',
        }
    },
    props :['vIsShowCart'],
    computed: {
        ...mapGetters(['cartList']),
    },
    components: {
        ButtonUI, CancelButtonUI, CartItem,
    },
    methods: {
        ...mapActions(['checkOutCartAction']),
        checkOut(){
            console.log('check out click')
            this.checkOutCartAction();
        },
        cancelCartView(){
            this.isShowCart = false;
            this.$emit('update',this.isShowCart);
        }
    }
}
</script>

<style>

</style>
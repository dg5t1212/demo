<template>
  <div class="v-window-item v-window-item--active" id="tab1">
    <div class="row">
      <div class="col-xl-12 col-12">
        <div class="box-wrapper">
          <div class="box-sidebar border-r">
            <div>
              <div class="d-flex flex-column">
                <div class="mb-5 food-menu-link active nuxt-link-exact-active nuxt-link-active">
                  Recomended (40)
                </div>
                <div class="mb-5 food-menu-link nuxt-link-exact-active nuxt-link-active">
                  DPB Special Combos (10)
                </div>
              </div>
            </div>
          </div>
          <div class="box-content">
            <div>
              <div class="px-8">
                <FoodsMenuCard
                  v-for="(goods, index) in goodsList"
                  :key="index"
                  :foodName="goods.name"
                  :imgUrl="goods.desc"
                  :tagName="defaultInfo.tagName"
                  :avgStars="defaultInfo.avgStars"
                  :countEvaluator="defaultInfo.countEvaluator"
                  :orgPrice="defaultInfo.orgPrice"
                  :curPrice="defaultInfo.curPrice"
                  :discountRate="defaultInfo.discountRate"
                  :foodContent="defaultInfo.foodContent"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FoodsMenuCard from '@/components/foods-menu-card.vue';
import { mapActions, mapGetters } from 'vuex';
export default {
    name: "tab-order-online",
    components: {
        FoodsMenuCard,
    },
    data() {
        return{
            defaultInfo : { 
                tagName : 'MUST TRY', 
                avgStars : 5, 
                countEvaluator : 57, 
                orgPrice : 25,
                curPrice : 22.5, 
                discountRate : '10% off',
                foodContent: '(4 Pcs mutton in chicken keema gravy)'
            }
        }
    },
    computed:{
        ...mapGetters(['goodsList'])
    },
    methods: {
        ...mapActions(["fetchGoods"]),
    },
    mounted() {
        this.fetchGoods();
    },
};
</script>

<style scoped>
.mobile-box-btn-sidebar{
    display:none
}
@media(max-width:960px){
    .mobile-box-btn-sidebar{
        display:block
    }
}
.hidden{
    visibility:hidden
}
.visible{
    visibility:visible
}
.box-wrapper{
    display:flex;position:relative
}
.box-wrapper .box-sidebar{
    background-color:#fff;width:280px;transition:all .3s ease-in
}
@media(max-width:960px){
    .box-wrapper .box-sidebar{
        position:fixed;padding:20px;height:100vh;overflow-y:scroll;top:0;left:-300px;z-index:10
    }
    .box-wrapper .box-sidebar.open{
        left:0
    }
    .box-wrapper .box-content .mobile-box-btn{
        display:block
    }
    .box-wrapper .box-content{
        width:100%
    }
}
.box-wrapper .box-overlay{
    position:fixed;display:none;width:100%;height:100%;top:0;left:0;right:0;bottom:0;background-color:rgba(0,0,0,.5);z-index:9;cursor:pointer
}
.box-wrapper .box-overlay.open{
    display:block
}
.box-wrapper .box-content{
    width:calc(100% - 280px)
}
.box-wrapper .box-content .mobile-box-btn{
    display:none
}
</style>
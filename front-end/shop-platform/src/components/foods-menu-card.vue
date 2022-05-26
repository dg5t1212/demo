<template>
    <div class="col col-12">
        <div class="d-flex justify-space-between align-center flex-wrap">
            <div class="d-flex flex-wrap">
                <div class="v-avatar me-3 rounded-0" style="height: 150px; min-width: 150px; width: 150px;">
                    <img :src="this.imgUrl" alt="" style="border-radius: 4px;">
                </div>
                <div>
                    <h5 class="f-600 mb-3">{{this.foodName}}</h5>
                    <span class="text-uppercase mb-2 v-chip theme--light v-size--small grey lighten-4 secondary--text">
                        <span class="v-chip__content">{{this.tagName}}</span>
                    </span>
                    <div class="d-flex mb-3">
                        <i v-for="(i, index) in this.avgStars" :key='index' class="v-icon notranslate mdi mdi-star theme--light amber--text" style="font-size: 16px;"></i>
                        <h6 class="ms-3 grey--text text--darken-1 font-weight-light">{{this.countEvaluator}}</h6>
                    </div>
                    <div class="d-flex mb-1">
                        <p class="text-14 grey--text text--darken-1 text-decoration-line-through me-2 mb-0">${{this.orgPrice}}</p>
                        <p class="text-14 me-2 mb-0">${{this.curPrice}}</p>
                        <p class="text-14 primary--text mb-0">{{this.discountRate}}</p>
                    </div>
                    <div class="text-14 grey--text text--darken-1">{{this.foodContent}}</div>
                </div>
            </div>
            <div>
                <button @click="addToCart" type="button" class="v-btn v-btn--outlined theme--light v-size--small primary--text">
                    <span class="v-btn__content">ADD
                        <i class="v-icon notranslate v-icon--right mdi mdi-plus theme--light"></i>
                    </span>
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
    name: 'FoodsMenuCard',
    data() {
        return{
            img :'https://foodhub-nuxt.vercel.app/_nuxt/img/4.780fc7d.png',
            foods: {
                name : this.foodName,
                price : this.curPrice,
                qty : 1,
            }
        }
    },
    props:['foodName', 'imgUrl', 'tagName', 'avgStars', 'countEvaluator', 'orgPrice', 'curPrice', 'discountRate', 'foodContent'],
    methods: {
        ...mapActions(["addToCartAction"]),
        addToCart(){
            console.log('addToCart',this.foods)
            this.addToCartAction(this.foods);
            console.log('addToCart2')
        }
    },
}
</script>
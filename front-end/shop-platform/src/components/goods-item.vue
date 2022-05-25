<template>
    <div class="col-sm-6 col-md-4 col-12">
        <router-link to="/foodsMenu" class="text-decoration-none">
            <div  class="br-10 o-hidden theme--light v-sheet--outlined v-card">
                <div class="v-image v-responsive">
                    <div class="v-responsive__sizer" style="padding-bottom: 66.5625%">
                        <div class="v-image__image--contain v-image__image" 
                            v-bind:style="{ 'background-image' : 'url(' + goodsImgUrl + ')', 'background-position' :  'center center' }">
                        </div>
                        
                    </div>
                </div>
                <div class="pa-4 text-center">
                    <h3 class="me-3">{{ goodsName }}</h3>
                </div>
            </div>
        </router-link>
    </div>
</template>

<script>
export default {
  name: "GoodsItem",
  props: ['goodsName','goodsImgUrl']
};
</script>
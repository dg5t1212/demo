<template>
    <div>
        <div class="d-flex align-center justify-space-between pa-3 mb-4">
            <div class="d-flex align-center">
                <div class="text-center me-3">
                    <IconButtonUI>
                        <i class="v-icon notranslate mdi mdi-plus theme--light"></i>
                    </IconButtonUI>
                    <p class="my-1">{{this.qty}}</p>
                    <IconButtonUI>
                        <i class="v-icon notranslate mdi mdi-minus theme--light"></i>
                    </IconButtonUI>
                </div>
                <div class="v-avatar me-4 rounded-0" style="height: 64px; min-width: 64px; width: 64px;">
                    <img src="https://foodhub-nuxt.vercel.app/_nuxt/img/1.d289046.png" class="br-10">
                </div>
                <div>
                    <h5 class="text-truncate d-inline-block mw-120 mb-0 f-600">Mughal Masala Order Food Online With 50% Off</h5>
                    <p class="text-12 mb-0">${{this.price}} x {{this.qty}}</p>
                    <h5 class="primary--text">{{this.price * this.qty}}</h5>
                </div>
            </div>
            <CancelButtonUI>
                <i class="v-icon notranslate mdi mdi-close theme--light primary--text" />
            </CancelButtonUI>
        </div>
    </div>
</template>

<script>

import CancelButtonUI from '@/components/cancelButtonUI.vue'
import IconButtonUI from '@/components/icon-button-ui.vue' 
export default {
    name: "CartItem",
    props:['name','price','qty'],
    components: {
        CancelButtonUI, IconButtonUI
    },
}
</script>

<style>

</style>
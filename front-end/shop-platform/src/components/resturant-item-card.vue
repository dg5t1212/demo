<template>
  <div class="col-sm-6 col-md-4 col-lg-4 col-xl-4 col-12">
      <a href="/" class="text-decoration-none">
        <div class="o-hidden v-card v-sheet v-sheet--outlined theme--light elevation-0">
            <div class="position-relative">
                <div class="v-image v-responsive btr-10 theme--light" style="width:100%">
                    <div class="v-responsive__sizer" style="padding-bottom: 66.5625%;"></div>
                    <div class="v-image__image v-image__image--cover" style="background-image: url('https://foodhub-nuxt.vercel.app/_nuxt/img/15.15c95d2.jpg'); background-position: center center;"></div>
                    <div class="v-responsive__content" style="width: 640px;"></div>
                </div>
                <div>
                    <span v-if="this.isOff" class="p-absolute top-0 rounded-r-xl rounded-l-0 mt-3 v-chip v-chip--label theme--light v-size--default primary">
                        <span class="v-chip__content">Flat {{this.chip_content}}% Off</span>
                    </span>
                </div>
            </div>
            <div class="pa-4 d-flex justify-space-between align-center">
                <span class="d-inline-block text-truncate me-3 f-600 text-18 card-title">
                    {{this.name}}
                </span>
                <div class="d-flex align-center card-rating">
                    <i class="v-icon notranslate me-1 mdi mdi-star theme--light yellow--text text--darken-2" style="font-size:16px"></i>
                    <div>
                        <span class="font-weight-bold text-14">{{this.star}}</span>
                        <span class="grey--text text--darken-1 text-14">/5</span>
                    </div>
                </div>
            </div>
            <p class="px-4 grey--text text--darken-1">
                ${{this.price}}
                <span class="primary--text f-600 me-1"></span>
                 • {{this.remark}}
            </p>

        </div>
      </a>
  </div>
</template>

<script>
export default {
    name: "ResturantItemCard",
    props: ['isOff','chip_content', 'imgUrl', 'name', 'star', 'price', 'remark'],
}
</script>

<style scoped>
</style>
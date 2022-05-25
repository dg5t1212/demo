<template>
  <div>
    <div class="container py-15">
      <div class="row">
        <GoodsTitle
          :titleName="goodsTitle[0].titleName"
          :titleDetails="goodsTitle[0].titleDetails"
        >
        </GoodsTitle>
        <GoodsItem
          v-for="(goods, index) in goodsList"
          :key="index"
          :goodsName="goodsList[index].name"
          :goodsImgUrl="goodsList[index].desc"
        >
        </GoodsItem>
      </div>
    </div>
  </div>
</template>

<script>
import GoodsTitle from "@/components/goods-title.vue";
import GoodsItem from "@/components/goods-item.vue";

import { mapActions, mapGetters } from "vuex";
export default {
  name: "HomeView",
  data: () => ({
    goodsTitle: [
      {
        titleName: "Goods",
        titleDetails:
          "Explore curated lists of top restaurants, cafes, pubs, and bars in New York, based on trends",
      },
    ],
    
  }),
  computed: {
    ...mapGetters(["goodsList"]),
  },
  methods: {
    ...mapActions(["fetchGoods"]),
    
  },
  components: {
    GoodsTitle,
    GoodsItem,
  },
  mounted() {
    this.fetchGoods();
  },
};
</script>
<style scoped>

</style>

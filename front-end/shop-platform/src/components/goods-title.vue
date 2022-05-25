<template>
    <div class="col col-12">
        <div class="d-flex justify-space-between align-end flex-wrap">
            <div>
                <h2>{{ titleName }}</h2>
                <h6>{{ titleDetails }}</h6>
            </div>
            <div>
                <a href="/#" class="text-decoration-none">觀看更多</a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: "GoodsTitle",
  props: ['titleName','titleDetails'],
};
</script>
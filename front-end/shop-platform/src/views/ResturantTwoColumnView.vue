<template>
    <div class="container">
        <div class="d-flex justify-space-between flex-wrap flex-sm-nowrap mb-3">
            <TabBar v-bind:tabs="tabs"/>
            <button @click="doFilter" type="button" class="mb-3 v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary">
                <span class="v-btn__content">Filter</span>
            </button>
        </div>
        <div class="row">
            <div class="col-xl-12 col-12">
                <div class="box-wrapper">
                    <div class="box-sidebar border-r">

                    </div>
                    <div class="box-content">
                        <div>
                            <div class="px-8">
                                <div class="row">
                                    <div class="col col-12">
                                        <h5 class="text-18 test-color">184 Delivery Restaurants in New York</h5>
                                    </div>
                                    <ResturantItemCard 
                                        v-for="(resturant, index) in resturantList" 
                                        :key="index"
                                        v-bind="resturant" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-overlay">

                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script>
import TabBar from '@/components/tab-bar.vue';
import ResturantItemCard from '@/components/resturant-item-card.vue';
import { mapGetters } from 'vuex';
export default {
    name : "ResturantTwoColumnView",
    data() {
        return{
            tabs: [
                {name: 'Delivery'},
                {name: 'Dining Out'},
                {name: 'Nightlife'},
            ],
            conditions: {

            }
        }
    },
    computed: {
        ...mapGetters(['resturantList'])
    },
    components: {
        TabBar, 
        ResturantItemCard,
    },

    methods: {
        doFilter(){
            console.log('doFilter click')
        }
    }
}
</script>

<style scoped>
.v-tab--active {
  border-bottom: 2px solid #d23f57;
}
.v-slide-group {
  display: flex;
}
.v-slide-group:not(.v-slide-group--has-affixes) > .v-slide-group__next,
.v-slide-group:not(.v-slide-group--has-affixes) > .v-slide-group__prev {
  display: none;
}
.v-slide-group.v-item-group > .v-slide-group__next,
.v-slide-group.v-item-group > .v-slide-group__prev {
  cursor: pointer;
}
.v-slide-item {
  display: inline-flex;
  flex: 0 1 auto;
}
.v-slide-group__next,
.v-slide-group__prev {
  align-items: center;
  display: flex;
  flex: 0 1 52px;
  justify-content: center;
  min-width: 52px;
}
.v-slide-group__content {
  display: flex;
  flex: 1 0 auto;
  position: relative;
  transition: 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);
  white-space: nowrap;
}
.v-slide-group__wrapper {
  contain: content;
  display: flex;
  flex: 1 1 auto;
  overflow: hidden;
}
.v-slide-group__next--disabled,
.v-slide-group__prev--disabled {
  pointer-events: none;
}
</style>
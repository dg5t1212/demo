<template>
  <div class="v-tabs mb-8 theme--light">
    <div class="v-item-group theme--light v-slide-group v-tabs-bar v-tabs-bar--is-mobile primary--text">
      <div class="v-slide-group__prev v-slide-group__prev--disabled"></div>
      <div class="v-slide-group__wrapper">
        <div class="v-slide-group__content v-tabs-bar__content" v-on:click="switchTabToClick">
          <a v-for="(tab, index) in tabss" :key='index' v-bind:class="initTabBar(index)">{{ tab.name }}</a>
        </div>
      </div>
      <div class="v-slide-group__next v-slide-group__next--disabled"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TabBar",
  props: ['tabs'],
  data (){
      return {
          tabss : [
              {name: ' Order Online '},
              {name: ' Book A Table '},
              {name: ' Reviews '},
          ]
      }
  },
  methods:{
      initTabBar(index) {
          console.log('index:',index)
          let tabClass = "text-capitalize v-tab";
          if(index === 0){
              tabClass += " v-tab--active";
          } 
          return tabClass;
      },
      switchTabToClick(event) {
          if(!event.target.classList.contains('v-tab--active')){
              const activeTab = document.querySelector('.v-tab--active');
              activeTab.classList.remove('v-tab--active')
              event.target.classList.add('v-tab--active')
          }
          

      }
  }
};
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
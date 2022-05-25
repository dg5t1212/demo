<template>
    <div class="container">
        <div>
            <TabBar />
            <div class="v-window v-item-group theme--light v-tabs-items">
                <div class="v-window__container">
                    <TabOrderOnline />
                    <div class="v-window-item" id="tab2">
                        <div class="row"></div>
                    </div>
                    <div class="v-window-item" id="tab3">
                        <div class="row"></div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import TabBar from '@/components/tab-bar.vue';
import TabOrderOnline from '@/components/tab-order-online.vue';
export default {
    name : "FoodsMenuView",
    data() {
        return{
            tags: [
                {name: 'Order Online'},
                {name: 'Book A Table'},
                {name: 'Reviews'},
            ],
        }
    },
    components: {
        TabBar, TabOrderOnline
    },
    
}
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

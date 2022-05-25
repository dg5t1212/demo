<template>
    <footer class="bg-grey-light py-16">
        <div class="container">
            <div class="row">
                <FooterInfoDetails 
                    v-for="f in footerInfoDetailsList" 
                    :key="f.title" 
                    :title="f.title"
                    :linkInfos="f.linkInfo" />
            </div>
        </div>
    </footer>
</template>

<script>
import FooterInfoDetails from '@/components/footerInfoDetails.vue';
export default {
    name: 'Footer',
    components: {
        FooterInfoDetails
    },
    data (){
        return {
            a:'tt',
            footerInfoDetailsList :[
                {
                    title: 'About Us', 
                    linkInfo:[
                        {name:'Careers', link:'/'},
                        {name:'Our Stores', link:'/'},
                        {name:'Our Cares', link:'/'},
                        {name:'Terms & Conditions', link:'/'},
                        {name:'Privacy Policy', link:'/'}
                    ]
                },
                {
                    title: 'Customer Care', 
                    linkInfo:[
                        {name:'Help Center', link:'/'},
                        {name:'How to Buy', link:'/'},
                        {name:'Track Your Order', link:'/'},
                        {name:'Corporate & Bulk Purchasing', link:'/'},
                        {name:'Returns & Refunds', link:'/'}
                    ]
                },
                {
                    title: 'Contact Us', 
                    linkInfo:[
                        {name:'Jalalabad 20/1, Shah Farid Road Sylhet, Bangladesh. Email: uilib@gmail.com Phone: +880 1123 456 780', link:'/'},
                        {name:'Sylhet, Bangladesh.', link:'/'},
                        {name:'Email: uilib@gmail.com', link:'/'},
                        {name:'Phone: +880 1123 456 780', link:'/'},
                    ]
                },
            ]
        }
        
    }
}
</script>

<style scoped>
</style>

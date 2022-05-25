<template>
    <div class="col-md-6 col-lg-3 col-12">
        <h2>{{ title }}</h2>
        <div>
            <a v-for="linkInfo in linkInfos" 
                :key="linkInfo.name"
                v-bind:href="linkInfo.link"
                class="d-flex flex-column">
                {{ linkInfo.name }}
            </a>
        </div>
    </div>
</template>

<script>
export default {
    name: 'FooterInfoDetails',
    props: ['title', 'linkInfos'],
    // data() {
    //     return {
    //         footerInfo: {
    //             title: '',
    //             linkInfos:[
    //                 { name : '', link: ''}
    //             ]
    //         }
    //     }
    // }
}
</script>

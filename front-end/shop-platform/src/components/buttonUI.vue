<template>
    <button v-on:click="clickFunc" class="v-button">
        <span class="v-btn__content d-block"><slot></slot></span>
    </button>
</template>

<script>
export default {
    name: "ButtonUI",
    props: ['name','clickFunc'],
    methods: {
        buttonClick(){
            console.log('click');
        }
    }
}
</script>

<style scoped>
.v-button {
    width: 100%;
    border-radius: 4px;
    padding: 8px 12px;
    background-color: #d23f57 !important;
    border-color: #d23f57 !important;
}
.v-btn__content {
    color: #ffffff;
    line-height: normal;
    text-align: center;
}
.v-button:hover {
    opacity: .8;
}

</style>
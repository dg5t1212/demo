<template>
    <div class="mb-4">
        <fieldset class="noBorder" aria-hidden="true">
            <legend class="text-14" style="width: 100px;">{{inputInfo.label}}</legend>
            <div class="v-input-border">
                <input class="v-input" v-model="inputInfo.content" :placeholder="inputInfo.placeholder" :type="inputInfo.type">
            </div>
        </fieldset>
    </div>
</template>

<script>
export default {
    name: "InputUI",
    props: ['label','placeholder','content','type'],
    data(){ 
        return {
            inputInfo:{
                label : this.label,
                placeholder : this.placeholder,
                content : this.content,
                type : this.type,
            }
        }
    },
    watch: {
        inputInfo: {
            deep: true,
            handler(val){
                this.$emit('update',val.content);
            }
        }
    }
}
</script>

<style scoped>
.v-input-border {
    border-radius: 4px;
    border: 1px solid;
}
.v-input {
    align-items: flex-start;
    display: flex;
    flex: 1 1 auto;
    font-size: 16px;
    letter-spacing: normal;
    text-align: left;
    padding: 8px 12px;
    width: 100%;
}
.noBorder {
    border: 0px;
}
</style>
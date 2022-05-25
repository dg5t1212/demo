<template>
    <div class="v-dialog__content v-dialog--active" style=" z-index:202;">
        <div class="v-dialog v-dialog--active" style="transform-origin: center center; width: 500px;">
            <div class="v-card v-sheet theme--light">
                <div class="px-3 px-md-10 py-8">
                    <h3 class="mb-2 text-center">Login</h3>
                    <div>
                        <h5 class="mb-2 text-center">{{ message }}</h5>
                    </div>
                    <InputUI 
                            :label=vInputList[0].label
                            :placeholder=vInputList[0].placeholder
                            :content=vInputList[0].content
                            :type=vInputList[0].type
                            @update="updateAccount" />
                    <InputUI 
                            :label=vInputList[1].label
                            :placeholder=vInputList[1].placeholder
                            :content=vInputList[1].content
                            :type=vInputList[1].type
                            @update="updatePassword" />
                    <ButtonUI :clickFunc="login">開始購物！</ButtonUI>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import InputUI from '@/components/inputUI.vue';
import ButtonUI from '@/components/buttonUI.vue';
import { mapActions } from 'vuex';

export default {
  name: "LightBox",
  components: {
      InputUI, 
      ButtonUI,
  },
  data: ()=> ({
    message: '',
    userInfo:{
        account:'',
        password:''
    },
    vInputList: [
        {label:'Account',placeholder:'請輸入帳號',content:'', type:'text'},
        {label:'Password',placeholder:'請輸入密碼',content:'', type:'password'},
    ],
  }),
  methods: {
      ...mapActions(['loginAction']),
      login(){
          this.message = ''
          if(this.userInfo && this.userInfo.user !== '' && this.userInfo.password !== ''){
            console.log('data', this.userInfo);
            this.loginAction(this.userInfo);
          }else{
              this.message = '帳號密碼不能為空'
          }
          
      },
      updateAccount(val){
          this.userInfo.account = val;
      },
      updatePassword(val){
          this.userInfo.password = val;
      }
  }
};
</script>


<style scoped>
.v-dialog__content {
    align-items: center;
    display: flex;
    height: 100%;
    justify-content: center;
    left: 0;
    pointer-events: none;
    position: fixed;
    top: 0;
    transition: .2s cubic-bezier(.25,.8,.25,1),z-index 1ms;
    width: 100%;
    z-index: 6;
    outline: 0;
}
.v-dialog:not(.v-dialog--fullscreen) {
    max-height: 90%;
}
.v-dialog {
    border-radius: 4px;
    margin: 24px;
    overflow-y: auto;
    pointer-events: auto;
    transition: .3s cubic-bezier(.25,.8,.25,1);
    width: 100%;
    z-index: inherit;
    box-shadow: 0 11px 15px -7px rgb(0 0 0 / 20%), 0 24px 38px 3px rgb(0 0 0 / 14%), 0 9px 46px 8px rgb(0 0 0 / 12%);
}
</style>
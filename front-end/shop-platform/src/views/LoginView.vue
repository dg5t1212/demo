<template>
    <div class="login">
        <LightBox></LightBox>
    </div>
</template>

<script>
// @ is an alias to /src
import LightBox from '@/components/light-box.vue'
export default {
  name: 'LoginView',
  components: {
    LightBox
  },
}
</script>
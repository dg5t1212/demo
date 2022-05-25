import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import './assets/css/global.css'
import './assets/css/base5.css'
import './assets/css/base9.css'
import './assets/css/base12.css'

import './assets/css/window.css'

createApp(App).use(store).use(router).mount('#app')

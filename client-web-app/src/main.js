import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import VueSSE from 'vue-sse'

Vue.config.productionTip = false
Vue.use(VueSSE);

new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')

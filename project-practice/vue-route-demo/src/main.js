import Vue from 'vue'
import App from './App.vue'
import router from './router'

// 导入 element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 导入 font-awesome
import 'font-awesome/scss/font-awesome.scss'

// 使用 element-ui
Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

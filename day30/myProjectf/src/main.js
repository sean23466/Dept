import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios';//加這句引用
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.prototype.$http=axios;//加這句赋值
Vue.config.productionTip = false;
Vue.use(ElementUI);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App},
  template: '<App/>'
})

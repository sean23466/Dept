import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Dept from '../components/Dept.vue'
import DeptManager from  '../components/DeptManager.vue'
import AddDept from  '../components/AddDept.vue'
import App from  '../App.vue'
import Index from  '../components/Index.vue'
import DeptUpdate from '../components/DeptUpdate.vue'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: '部門管理',
      component: Index,
      redirect:'/DeptManager',
      children:[
        {
          path: '/DeptManager',
          name: '部門查詢',
          component: DeptManager
        },{
          path: '/AddDept',
          name: '添加部門',
          component: AddDept
        },{
          path:'/update',
          component:DeptUpdate
        },                        
      ]
    }
  ]
})

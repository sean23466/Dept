<template>
    <div>
     <el-container style="height: 500px; border: 1px solid #eee">
         <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <!--動態加載路由菜單
            菜單和路由動態綁定
            -->
            <el-menu router :default-openeds="['0']">
                <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''">
                    <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
                    <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                     :class="$route.path==item2.path?'is-active':''"       >{{item2.name}}</el-menu-item>
                </el-submenu>
            </el-menu>

            </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
          </el-aside>
       </el-container>
    </div>
</template>
<script>
    export default {
        name: "Index",
    }
</script>
<style>
</style>
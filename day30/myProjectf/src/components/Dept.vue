<template>
    <div>
      <table>
          <tr>
              <td>編號</td>
              <td>部門名稱</td>
              <td>地址</td>
          </tr>
          <tr v-for="item in depts">
              <td>{{item.deptno}}</td>
              <td>{{item.dname}}</td>
              <td>{{item.loc}}</td>
          </tr>
      </table>
    </div>
</template>
<script>
    export default {
        name: "Dept",
        data:function(){
          return {
              msg:'貝西beixi',
              depts:[
                  {
                      deptno:1,
                      dname:'研發部',
                      loc:'北京'
                  },{
                      deptno:2,
                      dname:'人事部',
                      loc:'北京'
                  },{
                      deptno:3,
                      dname:'行政部',
                      loc:'北京'
                  }
              ]
          }
        },
        created:function(){
            this.$http.get('http://localhost:8080/dept/findAll').then(resp=>{
               this.depts=resp.data;
            })
         }
    }
</script>
<style>
</style>
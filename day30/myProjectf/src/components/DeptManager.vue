<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="deptno"
                    label="編號"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="dname"
                    label="部門名稱"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="loc"
                    label="地址"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="delete1(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--分頁    總頁數=總條數/每頁顯示的條數-->
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            delete1(row){
              this.$http.delete("http://localhost:8080/dept/delete/"+row.deptno).then(resp=>{
                this.$alert('删除成功！', '消息', {
                    confirmButtonText: '確定',
                    callback: action => {
                    window.location.reload();
                }
            });
            })
            },
            edit(row) {
                this.$router.push({
                    path:'/update',
                    query:{
                        deptno:row.deptno
                    }
                });
           },
    page:function(currentPage){
        this.$http.get("http://localhost:8080/dept/findAll/"+(currentPage-1)+"/6").then(resp=>{
            console.log(resp);
            this.tableData=resp.data.content;
            this.pageSize=resp.data.size;
            this.total=resp.data.totalElements;
        })
    }
    },

    data:function() {
        return {
            pageSize:'1',
            total:'11',
            tableData: [{
                deptno: '001',
                dname: '王小虎1',
                loc: '上海',
            }, {
                deptno: '002',
                dname: '王小虎2',
                loc: '上海',
            }, {
                deptno: '003',
                dname: '王小虎3',
                loc: '上海',
            }]
        }
    },
    created:function(){
        this.$http.get("http://localhost:8080/dept/findAll/0/6").then(resp=>{
            console.log(resp);
            this.tableData=resp.data.content;
            this.pageSize=resp.data.size;
            this.total=resp.data.totalElements;
        })
    }
    }
</script>
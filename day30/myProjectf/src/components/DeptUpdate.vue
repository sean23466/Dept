<template>
    <el-form  :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="編號" prop="deptno">
            <el-input v-model="ruleForm.deptno" readonly></el-input>
        </el-form-item>
        <el-form-item label="部門名稱" prop="dname">
            <el-input v-model="ruleForm.dname"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="loc">
            <el-input v-model="ruleForm.loc"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>
<script>
    export default {
        data:function() {
            return {
                ruleForm: {
                    deptno:'',
                    dname: '',
                    loc: '',
                },
                rules: {
                    dname: [
                        { required: true, message: '請輸入部門名稱', trigger: 'blur' },
                        { min: 3, max: 10, message: '長度在 3 到 10 個字符', trigger: 'blur' }
                    ],
                    loc: [
                        { required: true, message: '請輸入部門地址', trigger: 'blur' },
                        { min: 3, max: 10, message: '長度在 3 到 10 個字符', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
        this.$refs[formName].validate((valid) => {
            if (valid) {
                this.$http.put("http://localhost:8080/dept/update",this.ruleForm).then(resp=>{
                    if(resp.data=='success'){
                        this.$alert('修改成功！', '消息', {
                            confirmButtonText: '確定',
                            callback: action => {
                                this.$router.push('/DeptManager');
                            }
                        });
                    }
                })
            } else {
                return false;
            }
        });
    },
    resetForm(formName) {
        this.$refs[formName].resetFields();
    }
    },
    created(){
        //alert(this.$route.query.deptno);
        this.$http.get("http://localhost:8080/dept/findById/"+this.$route.query.deptno).then(resp=>{
            this.ruleForm=resp.data;
        })
    }
    }
</script>

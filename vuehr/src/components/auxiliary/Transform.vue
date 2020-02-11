<template>
    <el-container>
     <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
       <div style="margin-left: 5px;margin-right: 20px;display: inline">
            <el-upload
                :show-file-list="false"
                accept="application/vnd.ms-excel"
                action="/auxiliary/transform/importorder"
                :on-success="fileUploadSuccess"
                :on-error="fileUploadError" :disabled="fileUploadBtnText=='正在导入'"
                :before-upload="beforeFileUpload" style="display: inline">
                <el-button size="mini" type="success" :loading="fileUploadBtnText=='正在导入'">
                  <i class="fa fa-lg fa-level-up" style="margin-right: 5px"></i>{{fileUploadBtnText}}
                </el-button>
            </el-upload>
                <el-button size="mini" @click="testpython">测试</el-button>
        </div>
      </el-header>
    </el-container>
</template>
<script>
  export default {
    data(){
      return {
        fileUploadBtnText:'导入数据',
     }
    },
    mounted: function () {
      // this.loadPros();
    },
    methods: {
      fileUploadSuccess(response, file, fileList) {
            if (response) {
              this.$message({type: response.status, message: response.msg});
            }
            this.loadPros();
            this.fileUploadBtnText = '导入数据';
          },
      fileUploadError(err, file, fileList) {
            this.$message({type: 'error', message: "导入失败!"});
            this.fileUploadBtnText = '导入数据';
          },
      beforeFileUpload(file) {
            this.fileUploadBtnText = '正在导入';
          },
      testpython(){
         window.open("/auxiliary/transform/testpython", "_parent");
      },
    }
 }
</script>

<style>
  .el-dialog__body {
    padding-top: 0px;
    padding-bottom: 0px;
  }

  .slide-fade-enter-active {
    transition: all .8s ease;
  }

  .slide-fade-leave-active {
    transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  }

  .slide-fade-enter, .slide-fade-leave-to {
    transform: translateX(10px);
    opacity: 0;
  }
</style>

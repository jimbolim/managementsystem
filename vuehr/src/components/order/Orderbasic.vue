<template>
  <div>
    <el-container>
      <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
        

        <div style="display: inline">
          <el-input
            placeholder="通过供应商编号搜索供应商,记得回车哦..."
            clearable
            @change="keywordsChange"
            style="width: 300px;margin: 0px;padding: 0px;"
            size="mini"
            :disabled="advanceSearchViewVisible"
            @keyup.enter.native="searchSup"
            prefix-icon="el-icon-search"
            v-model="keywords">
          </el-input>
          <el-button type="primary" size="mini" style="margin-left: 5px" icon="el-icon-search" @click="searchSup">搜索
          </el-button>
        </div>
        <div style="margin-left: 5px;margin-right: 20px;display: inline">
          <el-button type="primary" size="mini" icon="el-icon-plus"
                     @click="showAddSupView">
            添加供应商
          </el-button>
        </div>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <transition name="slide-fade">
            <div
              style="margin-bottom: 10px;border: 1px;border-radius: 5px;border-style: solid;padding: 5px 0px 5px 0px;box-sizing:border-box;border-color: #20a0ff"
              v-show="advanceSearchViewVisible">
              <el-row>


              </el-row>
            </div>
          </transition>
          <el-table
            :data="sups"
            v-loading="tableLoading"
            border
            stripe
            height="530"
            max-height="530"
            @selection-change="handleSelectionChange"
            size="mini"
            style="width: 100%">
            <el-table-column
              type="selection"
              align="left"
              fixed="left"
              width="30">
            </el-table-column>
            <el-table-column
              prop="suppliercode"
              align="left"
              label="编号"
              width="80">
            </el-table-column>
            <el-table-column
              prop="shopname"
              align="left"
              label="店名"
              width="90">
            </el-table-column>
            <el-table-column
              prop="lastbrandname"
              align="left"
              label="原厂品牌名称"
              width="120">
            </el-table-column>
            <el-table-column
              prop="brandname"
              width="120"
              align="left"
              label="挂牌品牌名称">
            </el-table-column>
            <el-table-column
              prop="shopurl"
              label="店铺链接"
              width="200">
            </el-table-column>
            <el-table-column
              prop="producttype"
              width="100"
              align="left"
              label="产品类型">
            </el-table-column>
            <el-table-column
              prop = "comment"
              width="300"
              align="left"
              label="备注">
            </el-table-column>
            <el-table-column
              width="100"
              align="left"
              prop="updatetime"
              label="更新时间">
              <!-- <template slot-scope="scope">{{ scope.row.beginDate | formatDate}}</template> -->
            </el-table-column>
            <el-table-column
              prop="checktype"
              width="200"
              label="对库存方式">
            </el-table-column>
            <el-table-column
              width="70"
              align="center"
              prop="purchaseprice"
              label="采购价">
            </el-table-column>
            <el-table-column
              prop="type"
              width="80"
              label="类目">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="80">
              <template slot-scope="scope">
                <el-button @click="showEditSupView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">编辑
                </el-button>
<!--                 <el-button @click="showDetailView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px" type="primary"
                           size="mini">查看
                </el-button> -->
                <el-button type="danger" style="padding: 3px 4px 3px 4px;margin: 2px" size="mini"
                           @click="deleteSup(scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>


          <div style="display: flex;justify-content: space-between;margin: 2px">
            <el-pagination
              background
              :page-size="30"
              :current-page="currentPage"
              @current-change="currentChange"
              layout="prev, pager, next"
              :total="totalCount">
            </el-pagination>
          </div>
        </div>
      </el-main>
    </el-container>
    

    <el-form :model="sup" :rules="rules" ref="addSupForm" style="margin: 0px;padding: 0px;">
      <div style="text-align: left">
        <el-dialog
          :title="dialogTitle"
          style="padding: 0px;"
          :close-on-click-modal="false"
          :visible.sync="dialogVisible"
          width="77%">
          <el-row>
            <el-col :span="6">
              <div>
                <el-form-item label="编号:" prop="suppliercode">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.suppliercode" size="mini" style="width: 150px"
                            placeholder="请输入编号"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="店名:" prop="shopname">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.shopname" size="mini" style="width: 150px"
                            placeholder="请输入店名"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="原厂品牌名称:" prop="lastbrandname">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.lastbrandname" size="mini" style="width: 150px"
                            placeholder="请输入原厂品牌名称"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="挂牌品牌名称:" prop="brandname">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.brandname" size="mini" style="width: 150px"
                            placeholder="请输入挂牌品牌名称"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="店铺链接:" prop="shopurl">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.shopurl" size="mini" style="width: 150px"
                            placeholder="请输入店铺链接"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="产品类型:" prop="producttype">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.producttype" size="mini" style="width: 150px"
                            placeholder="请输入产品类型"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="备注:" prop="comment">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.comment" size="mini" style="width: 150px"
                            placeholder="请输入备注"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="更新日期:" prop="updatetime">
                  <el-date-picker
                    v-model="sup.updatetime"
                    size="mini"
                    value-format="yyyy-MM-dd"
                    style="width: 150px"
                    type="date"
                    placeholder="更新日期">
                  </el-date-picker>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="对库存方式:" prop="checktype">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.checktype" size="mini" style="width: 150px"
                            placeholder="请输入对库存方式"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="采购价:" prop="purchaseprice">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.purchaseprice" size="mini" style="width: 150px"
                            placeholder="请输入采购价"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="类目:" prop="type">
                  <el-input prefix-icon="el-icon-edit" v-model="sup.type" size="mini" style="width: 150px"
                            placeholder="请输入类目"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <span slot="footer" class="dialog-footer">
    <el-button size="mini" @click="cancelEidt">取 消</el-button>
    <el-button size="mini" type="primary" @click="addSup('addSupForm')">确 定</el-button>
    </span>
        </el-dialog>
      </div>
    </el-form>


  </div>
</template>


<script>
  export default {
    data() {
      return {
        sups: [],
        sup: {
            workID:'',
            suppliercode: '',
            shopname: '',
            lastbrandname: '',
            brandname: '',
            shopurl: '',
            producttype: '',
            comment: '',
            updatetime: null,
            checktype: '',
            purchaseprice: '',
            type: ''
        },
        keywords: '',
        beginDateScope: '',
        dialogTitle: '',
        multipleSelection: [],
        depTextColor: '#c0c4cc',
        nations: [],
        politics: [],
        positions: [],
        joblevels: [],
        totalCount: -1,
        currentPage: 1,
        deps: [],
        defaultSupps: {
          label: 'name',
          isLeaf: 'leaf',
          children: 'children'
        },
        staticdialogVisible: false,
        dialogVisible: false,
        tableLoading: false,
        advanceSearchViewVisible: false,
        showOrHidePop: false,
        showOrHidePop2: false,
        rules: {
          suppliercode: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          shopname: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          lastbrandname: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          brandname: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          shopurl: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          producttype: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          comment: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          updatetime: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          checktype: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          purchaseprice: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          type: ''
        }
      };
    },
    mounted: function () {
      this.loadSups();
    },
    methods: {
      cancelSearch() {
        this.advanceSearchViewVisible = false;
        this.emptySupData();
        this.beginDateScope = '';
        this.loadSups();
      },
      showAdvanceSearchView() {
        this.advanceSearchViewVisible = !this.advanceSearchViewVisible;
        this.keywords = '';
        if (!this.advanceSearchViewVisible) {
          this.emptySupData();
          this.beginDateScope = '';
          this.loadSups();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      deleteSup(row) {
        this.$confirm('此操作将永久删除[' + row.suppliercode + '], 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.doDelete(row.id);
        }).catch(() => {
        });
      },
      doDelete(ids) {
        this.tableLoading = true;
        var _this = this;
        this.deleteRequest("/supplier/basic/sup?ids=" + ids).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.loadSups();
          }
        })
      },
      keywordsChange(val) {
        if (val == '') {
          this.loadSups();
        }
      },
      searchSup() {
        this.loadSups();
      },
      currentChange(currentChange) {
        this.currentPage = currentChange;
        this.loadSups();
      },
      loadSups() {
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/supplier/basic/sup?page=" + this.currentPage + "&size=30&keywords=" + this.keywords).then(
            resp => {
              this.tableLoading = false;
              if (resp && resp.status == 200) {
                var data = resp.data;
                _this.sups = data.sups;
                _this.totalCount = data.count;
              }
            }
          )
      },
      addSup(formName) {
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.sup.id) {
              //更新
              this.tableLoading = true;
              this.putRequest("/supplier/basic/sup", this.sup).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptySupData();
                  _this.loadSups();
                }
              })
            } else {
              //添加
              this.tableLoading = true;
              this.postRequest("/supplier/basic/sup", this.sup).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptySupData();
                  _this.loadSups();
                }
              })
            }
          } else {
            return false;
          }
        });
      },
      cancelEidt() {
        this.dialogVisible = false;
        this.emptySupData();
      },
      showEditSupView(row) {
        this.dialogTitle = "编辑信息";
        this.sup = row;
        this.dialogVisible = true;
      },
      showAddSupView() {
        this.dialogTitle = "添加";
        this.dialogVisible = true;
        var _this = this;
        this.getRequest("/supplier/basic/maxWorkID").then(resp => {
          if (resp && resp.status == 200) {
            _this.sup.workID = resp.data;
          }
        })
      },
     emptySupData() {
        this.sup = {
            workID:'',
            suppliercode: '',
            shopname: '',
            lastbrandname: '',
            brandname: '',
            shopurl: '',
            producttype: '',
            comment: '',
            updatetime: null,
            checktype: '',
            purchaseprice: '',
            type: ''
        }
      },
    }
  };
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


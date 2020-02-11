<template>
  <div>
    <el-container>
      <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
        <div style="display: inline">
          <el-input
            placeholder="通过客户名称搜索客户,记得回车哦..."
            clearable
            @change="keywordsChange"
            style="width: 300px;margin: 0px;padding: 0px;"
            size="mini"
            :disabled="advanceSearchViewVisible"
            @keyup.enter.native="searchCus"
            prefix-icon="el-icon-search"
            v-model="keywords">
          </el-input>
          <el-button type="primary" size="mini" style="margin-left: 5px" icon="el-icon-search" @click="searchCus">搜索
          </el-button>
        </div>
        <div style="margin-left: 5px;margin-right: 20px;display: inline">
          <el-button type="primary" size="mini" icon="el-icon-plus"
                     @click="showAddCusView">
            添加客户
          </el-button>
        </div>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <transition name="slide-fade">
            <div
              style="margin-bottom: 10px;border: 1px;border-radius: 5px;border-style: solid;padding: 5px 0px 5px 0px;box-sizing:border-box;border-color: #20a0ff"
              v-show="advanceSearchViewVisible">
            </div>
          </transition>
          <el-table
            :data="cuss"
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
              prop="name"
              align="left"
              label="客户名称"
              width="80">
            </el-table-column>
            <el-table-column
              prop="country"
              align="left"
              label="国家"
              width="90">
            </el-table-column>
            <el-table-column
              prop="address"
              align="left"
              label="地址"
              width="120">
            </el-table-column>
            <el-table-column
              prop="contacts"
              width="120"
              align="left"
              label="联系人">
            </el-table-column>
            <el-table-column
              prop="contactsnumber"
              label="联系电话"
              width="120">
            </el-table-column>
            <el-table-column
              prop="email"
              width="100"
              align="left"
              label="联系邮箱">
            </el-table-column>
            <el-table-column
              prop = "remarks"
              width="300"
              align="left"
              label="备注">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="230">
              <template slot-scope="scope">
                <el-button @click="showOrderView(scope.row.id

                )" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">订单
                </el-button>
<!--                 <el-button @click="showEditCusView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">发票
                </el-button>
                <el-button @click="showEditCusView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">附件
                </el-button> -->
                <el-button @click="showEditCusView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">编辑
                </el-button>
                <el-button type="danger" style="padding: 3px 4px 3px 4px;margin: 2px" size="mini"
                           @click="deleteCus(scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>


          <div style="display: flex;justify-content: space-between;margin: 2px">
            <el-pagination
              background
              :page-size="10"
              :current-page="currentPage"
              @current-change="currentChange"
              layout="prev, pager, next"
              :total="totalCount">
            </el-pagination>
          </div>
        </div>
      </el-main>
    </el-container>


    <el-form :model="cus" :rules="rules" ref="addCusForm" style="margin: 0px;padding: 0px;">
      <div style="text-align: left">
        <el-dialog
          title="添加客户"
          style="padding: 0px;"
          :visible.sync="dialogVisible"
          width="77%">
          <el-row>
            <el-col :span="6">
              <div>
                <el-form-item label="客户名称:" prop="name">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.name" size="mini" style="width: 150px"
                            placeholder="请输入客户名称"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="国家:" prop="country">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.country" size="mini" style="width: 150px"
                            placeholder="请输入国家"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="地址:" prop="address">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.address" size="mini" style="width: 150px"
                            placeholder="请输入地址"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="联系人:" prop="contacts">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.contacts" size="mini" style="width: 150px"
                            placeholder="请输入联系人"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="联系电话:" prop="contactsnumber">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.contactsnumber" size="mini" style="width: 150px"
                            placeholder="请输入联系电话"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="邮箱:" prop="email">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.email" size="mini" style="width: 150px"
                            placeholder="请输入邮箱"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="备注:" prop="remarks">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.remarks" size="mini" style="width: 150px"
                            placeholder="请输入备注"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <span slot="footer" class="dialog-footer">
            <el-button size="mini" @click="cancelEidt">取 消</el-button>
            <el-button size="mini" type="primary" @click="addCus('addCusForm')">确 定</el-button>
          </span>
        </el-dialog>
      </div>
    </el-form>


    <el-form :model="cus" :rules="rules" ref="updateCusForm" style="margin: 0px;padding: 0px;">
      <div style="text-align: left">
        <el-dialog
          title="更新信息"
          style="padding: 0px;"
          :close-on-click-modal="false"
          :visible.sync="updateVisible"
          width="77%">
          <el-row>
            <el-col :span="6">
              <div>
                <el-form-item label="客户名称:" prop="name">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.name" size="mini" style="width: 150px"
                            placeholder="请输入客户名称"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="国家:" prop="country">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.country" size="mini" style="width: 150px"
                            placeholder="请输入国家"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="地址:" prop="address">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.address" size="mini" style="width: 150px"
                            placeholder="请输入地址"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="联系人:" prop="contacts">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.contacts" size="mini" style="width: 150px"
                            placeholder="请输入联系人"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="联系电话:" prop="contactsnumber">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.contactsnumber" size="mini" style="width: 150px"
                            placeholder="请输入联系电话"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="邮箱:" prop="email">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.email" size="mini" style="width: 150px"
                            placeholder="请输入邮箱"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="备注:" prop="remarks">
                  <el-input prefix-icon="el-icon-edit" v-model="cus.remarks" size="mini" style="width: 150px"
                            placeholder="请输入备注"></el-input>
                </el-form-item>
              </div>
            </el-col>
        
          </el-row>
          <span slot="footer" class="dialog-footer">
            <el-button size="mini" @click="cancelEidt">取 消</el-button>
            <el-button size="mini" type="primary" @click="updateCus('updateCusForm')">确 定</el-button>
          </span>
        </el-dialog>
      </div>
    </el-form>




        <el-dialog
          :title="dialogTitle"
          style="padding: 0px;"
          :close-on-click-modal="false"
          :visible.sync="ordersVisible"
          width="85%">
          <el-table
            :data="orders"
            v-loading="tableLoading"
            border
            stripe
            height="450"
            max-height="450"
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
              prop="ordername"
              align="center"
              label="订单名"
              width="100">
            </el-table-column>
            <el-table-column
              prop="updatetime"
              align="left"
              label="更新时间"
              width="90">
            <template slot-scope="scope">{{ scope.row.updatetime | formatDate}}</template>
            </el-table-column>
            <el-table-column
              prop="state"
              align="left"
              label="状态"
              width="120">
            </el-table-column>
            <el-table-column
              prop="comment"
              width="650"
              align="left"
              label="备注">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="190">
              <template slot-scope="scope">
                <el-button @click="showEditOrdersView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">编辑
                </el-button>
                 <el-upload
                  :show-file-list="false"
                  accept="application/vnd.ms-excel"
                  :action="uploadurl"
                  :on-success="orderUploadSuccess"
                  :on-error="orderUploadError"
                  :disabled="orderUploadBtnText=='正在导入'"
                  :before-upload="beforeOrderUpload"
                  style="display: inline">
                  <el-button size="mini" type="success" @click="changeAction(scope.row.id)" :loading="orderUploadBtnText=='正在导入'">
                    <i class="fa fa-lg fa-level-up" style="margin-right: 5px"></i>{{orderUploadBtnText}}
                  </el-button>
                </el-upload>
<!--                 <el-button @click="showDetailView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px" type="primary"
                           size="mini">查看
                </el-button> -->
                <el-button type="danger" style="padding: 3px 4px 3px 4px;margin: 2px" size="mini"
                           @click="deleteOrder(scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        <span slot="footer" class="dialog-footer">
          <el-button size="mini" @click="showAddOrderView"> 添加新的订单</el-button>
          <el-button size="mini" type="primary" @click="cancelEidt">确 定</el-button>
        </span>
    </el-dialog>


    <el-form :model="order" :rules="orderrules" ref="addOrderForm" style="margin: 0px;padding: 0px;">
      <div style="text-align: left">
        <el-dialog
          title="添加订单"
          style="padding: 0px;"
          :visible.sync="addOrderVisible"
          width="60%">
          <el-row>
            <el-col :span="10">
              <div>
                <el-form-item label="订单名:" prop="ordername">
                  <el-input prefix-icon="el-icon-edit" v-model="order.ordername" size="mini" style="width: 150px"
                            placeholder="请输入订单名"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="状态:" prop="state">
                  <el-input prefix-icon="el-icon-edit" v-model="order.state" size="mini" style="width: 150px"
                            placeholder="请输入状态"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="备注:" prop="comment">
                  <el-input prefix-icon="el-icon-edit" v-model="order.comment" size="mini" style="width: 150px"
                            placeholder="请输入备注"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="更新日期:" prop="updatetime">
                  <el-date-picker
                    v-model="order.updatetime"
                    size="mini"
                    value-format="yyyy-MM-dd"
                    style="width: 150px"
                    type="date"
                    placeholder="更新日期">
                  </el-date-picker>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="数量:" prop="orderqty">
                  <el-input prefix-icon="el-icon-edit" v-model="order.orderqty" size="mini" style="width: 150px"
                            placeholder="请输入数量"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="订单金额:" prop="orderamount">
                  <el-input prefix-icon="el-icon-edit" v-model="order.orderamount" size="mini" style="width: 150px"
                            placeholder="请输入订单金额"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="货币:" prop="currency">
                  <el-input prefix-icon="el-icon-edit" v-model="order.currency" size="mini" style="width: 150px"
                            placeholder="请输入货币"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="cancelSecondEidt">取 消</el-button>
        <el-button size="mini" type="primary" @click="addOrder('addOrderForm')">确 定</el-button>
    </span>
        </el-dialog>
      </div>
    </el-form>


    <el-form :model="order" :rules="orderrules" ref="updateOrderForm" style="margin: 0px;padding: 0px;">
      <div style="text-align: left">
        <el-dialog
          title="更新订单信息"
          style="padding: 0px;"
          :visible.sync="updateOrderVisible"
          width="60%">
          <el-row>
            <el-col :span="10">
              <div>
                <el-form-item label="订单名:" prop="ordername">
                  <el-input prefix-icon="el-icon-edit" v-model="order.ordername" size="mini" style="width: 150px"
                            placeholder="请输入订单名"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="状态:" prop="state">
                  <el-input prefix-icon="el-icon-edit" v-model="order.state" size="mini" style="width: 150px"
                            placeholder="请输入状态"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="备注:" prop="comment">
                  <el-input prefix-icon="el-icon-edit" v-model="order.comment" size="mini" style="width: 150px"
                            placeholder="请输入备注"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="更新日期:" prop="updatetime">
                  <el-date-picker
                    v-model="order.updatetime"
                    size="mini"
                    value-format="yyyy-MM-dd"
                    style="width: 150px"
                    type="date"
                    placeholder="更新日期">
                  </el-date-picker>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="数量:" prop="orderqty">
                  <el-input prefix-icon="el-icon-edit" v-model="order.orderqty" size="mini" style="width: 150px"
                            placeholder="请输入数量"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="订单金额:" prop="orderamount">
                  <el-input prefix-icon="el-icon-edit" v-model="order.orderamount" size="mini" style="width: 150px"
                            placeholder="请输入订单金额"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="10">
              <div>
                <el-form-item label="货币:" prop="currency">
                  <el-input prefix-icon="el-icon-edit" v-model="order.currency" size="mini" style="width: 150px"
                            placeholder="请输入货币"></el-input>
                </el-form-item>
              </div>
            </el-col>

          </el-row>
          <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="cancelSecondEidt">取 消</el-button>
        <el-button size="mini" type="primary" @click="updateOrder('updateOrderForm')">确 定</el-button>
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
        cuss: [],
        cus: {
          id: "",
          name: "",
          country: "",
          address: "",
          contacts: "",
          contactsnumber: "",
          email: "",
          remarks: ""
        },
        orders:[],
        order:{
            id: "",
            ordername: "",
            updatetime: "",
            state: "",
            comment: "",
            orderqty:'',
            orderamount:'',
            currency:''
        },
        uploadurl:'/customer/basic/importorder',
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
        defaultCusps: {
          label: 'name',
          isLeaf: 'leaf',
          children: 'children'
        },
        orderUploadBtnText:"导入",
        staticdialogVisible: false,
        dialogVisible: false,
        tableLoading: false,
        advanceSearchViewVisible: false,
        showOrHidePop: false,
        showOrHidePop2: false,
        ordersVisible: false,
        addOrderVisible: false,
        updateVisible: false,
        updateOrderVisible: false,
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
        },
        orderrules:{
         lastbrandname: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          brandname: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          shopurl: [{required: true, message: '必填:供应商编码', trigger: 'blur'}],
          producttype: [{required: true, message: '必填:供应商编码', trigger: 'blur'}]
        }
      };
    },

    mounted: function () {
      this.loadCuss();
    },

    methods: {
      beforeOrderUpload(file){
         this.orderUploadBtnText = '正在导入';
      },
      orderUploadError(response, file, fileList){
        this.$message({type: 'error', message: "导入失败!"});
        this.orderUploadBtnText = '导入';
      },
      orderUploadSuccess(response, file, fileList){
        if (response) {
          this.$message({type: response.status, message: response.msg});
        }
        this.orderUploadBtnText = '导入';
      },

      changeAction(id){
        this.uploadurl="/customer/basic/importorder?oid="+id;
      },

      cancelSearch() {
        this.advanceSearchViewVisible = false;
        this.emptyCusData();
        this.beginDateScope = '';
        this.loadCuss();
      },


      showAdvanceSearchView() {
        this.advanceSearchViewVisible = !this.advanceSearchViewVisible;
        this.keywords = '';
        if (!this.advanceSearchViewVisible) {
          this.emptyCusData();
          this.beginDateScope = '';
          this.loadCuss();
        }
      },


      handleSelectionChange(val) {
        this.multipleSelection = val;
      },


      deleteCus(row) {
        this.$confirm('此操作将永久删除[' + row.name + '], 是否继续?', '提示', {
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
        this.deleteRequest("/customer/basic/cus?ids=" + ids).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.loadCuss();
          }
        })
      },

      deleteOrder(row){
        this.$confirm('此操作将永久删除[' + row.ordername + '], 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
              this.tableLoading = true;
              var _this = this;
              this.deleteRequest("/customer/basic/order?ids=" + row.id).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.showOrderView(this.cus.id);
                }
              })
        }).catch(() => {
        });
      },


      keywordsChange(val) {
        if (val == '') {
          this.loadCuss();
        }
      },


      searchCus() {
        this.loadCuss();
      },


      currentChange(currentChange) {
        this.currentPage = currentChange;
        this.loadCuss();
      },


      loadCuss() {
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/customer/basic/cus?page=" + this.currentPage + "&size=10&keywords=" + this.keywords).then(
            resp => {
              this.tableLoading = false;
              if (resp && resp.status == 200) {
                var data = resp.data
                _this.cuss = data.cuss;
                _this.totalCount = data.count;
                }
            }
          )
      },


      addCus(formName) {
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
              this.tableLoading = true;
              this.postRequest("/customer/basic/cus", this.cus).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyCusData();
                  _this.loadCuss();
                }
              })
          } else {
            return false;
          }
        });
      },

      updateCus(formName){
         var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
              //更新
              this.tableLoading = true;
              this.putRequest("/customer/basic/cus", this.cus).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.updateVisible = false;
                  _this.emptyCusData();
                  _this.loadCuss();
                }
              })
          } else {
            return false;
          }
        });
      },

      addOrder(formName){
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid){
             this.tableLoading = true;
            this.postRequest("/customer/basic/orders?cid="+this.cus.id, this.order).then( resp=>{
                  _this.tableLoading = false;
                  if (resp && resp.status == 200) {
                    var data = resp.data;
                    this.showOrderView(this.cus.id);
                    _this.addOrderVisible=false;
                    _this.emptyOrderData();
                    this.cus.id = '';
                  }
                }
              )
            } else {
            return false;
          }
        });
      },


    updateOrder(formName){
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid){
             this.tableLoading = true;
           this.putRequest("/customer/basic/orders", this.order).then( resp=>{
                  _this.tableLoading = false;
                  if (resp && resp.status == 200) {
                    var data = resp.data;
                    this.showOrderView(this.cus.id);
                    _this.updateOrderVisible = false;
                    _this.emptyOrderData();
                    this.cus.id = '';
                  }
                }
              )
            } else {
            return false;
          }
        });

    },


      cancelEidt() {
        this.ordersVisible = false;
        this.updateVisible = false;
        this.dialogVisible = false;
        this.emptyCusData();
      },

      cancelSecondEidt(){
        this.addOrderVisible = false;
        this.updateOrderVisible = false;
        this.emptyOrderData();
      },

      showEditCusView(row) {
        this.cus = row;
        this.updateVisible = true;
      },


      showAddCusView() {
        this.dialogTitle = "添加客户";
        this.dialogVisible = true;
        var _this = this;
        this.getRequest("/customer/basic/cusid").then(resp => {
          if (resp && resp.status == 200) {
            _this.cus.id = resp.data;
          }
        })
      },


      showOrderView(ids){
        this.dialogTitle = "订单列表";
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/customer/basic/orders?cid="+ids).then( resp => {
          _this.tableLoading=false;
          if (resp && resp.status ==200) {
            _this.orders = resp.data.orders;
            this.cus.id = ids;
          }
         }
        )
        this.ordersVisible = true;
      },


      showAddOrderView(){
        var _this = this;
        this.getRequest("/customer/basic/ordersid").then( resp =>{
          if (resp && resp.status == 200){
            _this.order.id = resp.data;
          }
        }
       )
        this.addOrderVisible=true;
      },


    showEditOrdersView(row){
        this.order = row;
        this.updateOrderVisible = true;
    },

     emptyCusData() {
        this.cus = {
            id: "",
            name: "",
            country: "",
            address: "",
            contacts: "",
            contactsnumber: "",
            email: "",
            remarks: ""
        }
      },

      emptyOrderData(){
        this.order = {
            id: "",
            ordername: "",
            updatetime: "",
            state: "",
            comment: ""
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

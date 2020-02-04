<template>
  <div>
    <el-container>
      <el-header style="padding: 0px;display:flex;justify-content:space-between;align-items: center">
        

        <div style="display: inline">
          <el-input
            placeholder="通过sku号搜索产品,记得回车哦..."
            clearable
            @change="keywordsChange"
            style="width: 300px;margin: 0px;padding: 0px;"
            size="mini"
            :disabled="advanceSearchViewVisible"
            @keyup.enter.native="searchPro"
            prefix-icon="el-icon-search"
            v-model="keywords">
          </el-input>
          <el-button type="primary" size="mini" style="margin-left: 5px" icon="el-icon-search" @click="searchPro">搜索
          </el-button>
          <!-- <el-button slot="reference" type="primary" size="mini" style="margin-left: 5px"
                     @click="showAdvanceSearchView"><i
            class="fa fa-lg" v-bind:class="[advanceSearchViewVisible ? faangledoubleup:faangledoubledown]"
            style="margin-right: 5px"></i>高级搜索
          </el-button> -->
        </div>
        <div style="margin-left: 5px;margin-right: 20px;display: inline">
          <el-upload
            multiple
            :show-file-list="false"
            accept="image/jpeg"
            action="/product/basic/importPic"
            :on-success="picUploadSuccess"
            :on-error="picUploadError" :disabled="pictureUploadBtnText=='正在导入'"
            :before-upload="beforePicUpload" style="display: inline">
            <el-button size="mini" type="success" :loading="pictureUploadBtnText=='正在导入'">
              <i class="fa fa-lg fa-level-up" style="margin-right: 5px"></i>{{pictureUploadBtnText}}
            </el-button>
          </el-upload>
          <el-upload
            :show-file-list="false"
            accept="application/vnd.ms-excel"
            action="/product/basic/importPro"
            :on-success="fileUploadSuccess"
            :on-error="fileUploadError" :disabled="fileUploadBtnText=='正在导入'"
            :before-upload="beforeFileUpload" style="display: inline">
            <el-button size="mini" type="success" :loading="fileUploadBtnText=='正在导入'">
              <i class="fa fa-lg fa-level-up" style="margin-right: 5px"></i>{{fileUploadBtnText}}
            </el-button>
          </el-upload>
          <el-button type="success" size="mini" @click="exportPros">
            <i class="fa fa-lg fa-level-down" style="margin-right: 5px"></i>导出数据
          </el-button>
          <el-button type="primary" size="mini" icon="el-icon-plus"
                     @click="showAddProView">
            添加产品
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
            :data="pros"
            v-loading="tableLoading"
            border
            stripe
            @selection-change="handleSelectionChange"
            size="mini"
            style="width: 100%">
            <el-table-column
              type="selection"
              align="left"
              fixed
              width="30">
            </el-table-column>

            <el-table-column
              prop="suppliercode"
              align="left"
              label="供应商编号"
              width="90">
            </el-table-column>
            <el-table-column
              prop="itemname"
              align="left"
              label="Item name"
              width="90">
            </el-table-column>
            <el-table-column
              prop="skunumber"
              align="left"
              label="货号"
              width="120">
            </el-table-column>
            <el-table-column
              prop="composition"
              width="120"
              align="left"
              label="材质">
            </el-table-column>
            <el-table-column
              prop="colour"
              label="颜色"
              width="120">
            </el-table-column>
            <el-table-column
              prop="size"
              width="100"
              align="left"
              label="尺码">
            </el-table-column>
            <el-table-column
              prop = "length"
              width="85"
              align="left"
              label="长度">
            </el-table-column>
            <el-table-column
              prop = "weight"
              width="60"
              align="left"
              label="重量">
            </el-table-column>
            <el-table-column
              prop="knitwearorwoven"
              width="90"
              label="针织或梭织">
            </el-table-column>
            <el-table-column
              width="90"
              prop="minimumorderquantity"
              label="最小起订量">
            </el-table-column>
            <el-table-column
              prop="description"
              width="200"
              label="描述">
            </el-table-column>
            <el-table-column
              width="100"
              align="left"
              prop="updatetime"
              label="更新时间">
              <!-- <template slot-scope="scope">{{ scope.row.beginDate | formatDate}}</template> -->
            </el-table-column>
            <el-table-column
              prop="season"
              width="80"
              label="季节">
            </el-table-column>
            <el-table-column
              prop="purchaseprice"
              width="60"
              align="left"
              label="采购价">
            </el-table-column>
            <el-table-column
              prop="purchaseurl"
              align="left"
              width="200"
              label="采购链接">
            </el-table-column>
            <el-table-column
              prop="buyingprice"
              width="60"
              label="销售价">
            </el-table-column>
            <el-table-column
              prop="radicalretropubicprostatectomy"
              width="90"
              label="参考零售价">
            </el-table-column>
            <el-table-column
              prop="offer"
              width="50"
              label="报价">
            </el-table-column>
            <el-table-column
              prop="profit"
              width="50"
              label="利润">
            </el-table-column>


            <el-table-column
              fixed="right"
              label="操作"
              width="80">
              <template slot-scope="scope">
                <el-button @click="showEditProView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px"
                           size="mini">编辑
                </el-button>
                <el-button @click="showDetailView(scope.row)" style="padding: 3px 4px 3px 4px;margin: 2px" type="primary"
                           size="mini">查看
                </el-button>
                <el-button type="danger" style="padding: 3px 4px 3px 4px;margin: 2px" size="mini"
                           @click="deletePro(scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>


          <div style="display: flex;justify-content: space-between;margin: 2px">
            <el-button type="danger" size="mini" v-if="pros.length>0" :disabled="multipleSelection.length==0"
                       @click="deleteManyPros">批量删除
            </el-button>
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
    

    <el-form :model="pro" :rules="rules" ref="addProForm" style="margin: 0px;padding: 0px;">
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
                <el-form-item label="供应商编码:" prop="suppliercode">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.suppliercode" size="mini" style="width: 150px"
                            placeholder="请输入供应商编码"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Item name:" prop="itemname">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.itemname" size="mini" style="width: 150px"
                            placeholder="请输入Item name"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="SKU:" prop="skunumber">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.skunumber" size="mini" style="width: 150px"
                            placeholder="请输入SKU No."></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Composition:" prop="composition">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.composition" size="mini" style="width: 150px"
                            placeholder="请输入Composition"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Colour:" prop="colour">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.colour" size="mini" style="width: 150px"
                            placeholder="请输入Colour"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Size:" prop="size">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.size" size="mini" style="width: 150px"
                            placeholder="请输入Size"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Length:" prop="length">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.length" size="mini" style="width: 150px"
                            placeholder="请输入Length"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Weight:" prop="weight">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.weight" size="mini" style="width: 150px"
                            placeholder="请输入Weight"></el-input>
                </el-form-item>
              </div>
            </el-col>
              <el-col :span="9">
              <div>
                <el-form-item label="Knitwear or woven:" prop="knitwearorwoven">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.knitwearorwoven" size="mini" style="width: 200px"
                            placeholder="请输入Knitwear or woven"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="9">
              <div>
                <el-form-item label="Minimum Order Quantity:" prop="minimumorderquantity">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.minimumorderquantity" size="mini" style="width: 200px"
                            placeholder="请输入Minimum Order Quantity"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Description:" prop="description">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.description" size="mini" style="width: 150px"
                            placeholder="请输入Description"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="更新日期:" prop="updatetime">
                  <el-date-picker
                    v-model="pro.updatetime"
                    size="mini"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 150px"
                    type="date"
                    placeholder="更新日期">
                  </el-date-picker>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="Season:" prop="season">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.season" size="mini" style="width: 150px"
                            placeholder="请输入Season"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="采购价:" prop="purchaseprice">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.purchaseprice" size="mini" style="width: 150px"
                            placeholder="请输入采购价"></el-input>
                </el-form-item>
              </div>
            </el-col>
          <el-col :span="6">
              <div>
                <el-form-item label="采购链接:" prop="purchaseurl">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.purchaseurl" size="mini" style="width: 150px"
                            placeholder="请输入采购链接"></el-input>
                </el-form-item>
              </div>
            </el-col>
          <el-col :span="8">
              <div>
                <el-form-item label="buying price（USD）:" prop="buyingprice">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.buyingprice" size="mini" style="width: 150px"
                            placeholder="请输入buying price（USD）"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="RRP（USD）:" prop="radicalretropubicprostatectomy">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.radicalretropubicprostatectomy" size="mini" style="width: 150px"
                            placeholder="请输入RRP（USD）"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="offer :" prop="offer">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.offer" size="mini" style="width: 150px"
                            placeholder="请输入offer"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="6">
              <div>
                <el-form-item label="profit :" prop="profit">
                  <el-input prefix-icon="el-icon-edit" v-model="pro.profit" size="mini" style="width: 150px"
                            placeholder="请输入profit"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <span slot="footer" class="dialog-footer">
    <el-button size="mini" @click="cancelEidt">取 消</el-button>
    <el-button size="mini" type="primary" @click="addPro('addProForm')">确 定</el-button>
    </span>
        </el-dialog>
      </div>
    </el-form>


      <el-dialog
          :title="dialogTitle"
          style="padding: 0px;"
          :close-on-click-modal="false"
          :visible.sync="staticdialogVisible"
          width="88%">
          <el-row>
            <div v-for="url in urls">
               <el-col :span="4">
                <a :href="url" target="_blank">
                <el-image
                  style="width: 100px; height: 100px"
                  :src="url">
                  <div slot="placeholder" class="image-slot">
                    加载中<span class="dot">...</span>
                  </div>
                  <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline"></i>
                  </div>
                </el-image>
                </a>
              </el-col>
            </div>

            <el-col :span="4">
              <p>供应商编码:{{pro.suppliercode}}</p>
            </el-col>
            <el-col :span="4">
              <p>Item name:{{pro.itemname}}</p>
            </el-col>
            <el-col :span="4">
              <p>SKU:{{pro.skunumber}}</p>
            </el-col>
            <el-col :span="4">
              <p>Composition:{{pro.composition}}</p>
            </el-col>
            <el-col :span="4">
              <p>Colour:{{pro.colour}}</p>
            </el-col>
            <el-col :span="4">
              <p>Size:{{pro.size}}</p>
            </el-col>
            <el-col :span="4">
              <p>Length:{{pro.length}}</p>
            </el-col>
            <el-col :span="4">
              <p>Weight:{{pro.weight}}</p>
            </el-col>
            <el-col :span="4">
              <p>Knitwear or woven:{{pro.knitwearorwoven}}</p>
            </el-col>
            <el-col :span="4">
              <p>Minimum Order Quantity:{{pro.minimumorderquantity}}</p>
            </el-col>
            <el-col :span="12">
              <p>Description:{{pro.description}}</p>
            </el-col>
            <el-col :span="6">
              <p>更新日期:{{pro.updatetime}}</p>
            </el-col>
            <el-col :span="6">
              <p>Season:{{pro.season}}</p>
            </el-col>
            <el-col :span="6">
              <p>采购价:{{pro.purchaseprice}}</p>
            </el-col>
            <el-col :span="6">
             <p>采购链接:{{pro.purchaseurl}}</p>
            </el-col>
            <el-col :span="8">
              <p>buying price（USD）:{{pro.buyingprice}}</p>
            </el-col>
            <el-col :span="6">
              <p>RRP（USD）:{{pro.radicalretropubicprostatectomy}}</p>
            </el-col>
            <el-col :span="6">
              <p>offer :{{pro.offer}}</p>
            </el-col>
            <el-col :span="6">
              <p>profit :{{pro.profit}}</p>
            </el-col>
          </el-row>
        </el-dialog>

  </div>
</template>


<script>
  export default {
    data() {
      return {
        pros: [],
        pro: {
          workID: '',
          suppliercode: '',
          itemname: '',
          skunumber: '',
          composition: '',
          colour: '',
          size: '',
          length: '',
          weight: '',
          knitwearorwoven: '',
          minimumorderquantity: '',
          description: '',
          updatetime: '',
          season: '',
          purchaseprice: '',
          purchaseurl: '',
          buyingprice: '',
          radicalretropubicprostatectomy: '',
          offer: '',
          profit: '',
        },
        urls: [],
        keywords: '',
        fileUploadBtnText: '导入数据',
        pictureUploadBtnText: '导入图片',
        beginDateScope: '',
        faangledoubleup: 'fa-angle-double-up',
        faangledoubledown: 'fa-angle-double-down',
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
        defaultProps: {
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
          length: [{required: true, message: '必填:Length', trigger: 'blur'}],
          itemname: [{required: true, message: '必填:Item name', trigger: 'blur'}],
          skunumber: [{required: true, message: '必填:SKU No', trigger: 'blur'}],
          composition: [{required: true, message: '必填:Composition', trigger: 'blur'}],
          colour: [{required: true, message: '必填:Colour', trigger: 'blur'}],
          size: [{required: true, message: '必填:Size', trigger: 'blur'}],
          weight: [{required: true, message: '必填:Weight', trigger: 'blur'}],
          knitwearorwoven: [{required: true, message: '必填:Knitwear or woven', trigger: 'blur'}],
          minimumorderquantity: [{required: true, message: '必填:Minimum Order Quantity', trigger: 'blur'}],
          description: [{required: true, message: '必填:Description', trigger: 'blur'}],
          updatetime: [{required: true, message: '必填:更新日期', trigger: 'change'}],
          season: [{required: true, message: '必填:Season', trigger: 'blur'}],
          purchaseprice: [{required: true, message: '必填:采购价', trigger: 'blur'}],
          size: [{required: true, message: '必填:Size', trigger: 'blur'}],
          purchaseurl: [{required: true, message: '必填:采购链接', trigger: 'blur'}],
          buyingprice: [{required: true, message: '必填:buying price（USD）', trigger: 'blur'}],
          radicalretropubicprostatectomy: [{required: true, message: '必填:RRP（USD）', trigger: 'blur'}],
          offer: [{required: true, message: '必填:offer', trigger: 'blur'}],
          profit: [{required: true, message: '必填:profit', trigger: 'blur'}]
        }
      };
    },
    mounted: function () {
      this.loadPros();
    },
    methods: {
      picUploadSuccess(response, file, fileList) {
        if (response) {
          this.$message({type: response.status, message: response.msg});
        }
        this.loadPros();
        this.pictureUploadBtnText = '导入图片';
      },
      fileUploadSuccess(response, file, fileList) {
        if (response) {
          this.$message({type: response.status, message: response.msg});
        }
        this.loadPros();
        this.fileUploadBtnText = '导入数据';
      },
      picUploadError(err, file, fileList) {
        this.$message({type: 'error', message: "导入失败!"});
        this.pictureUploadBtnText = '导入图片';
      },
      fileUploadError(err, file, fileList) {
        this.$message({type: 'error', message: "导入失败!"});
        this.fileUploadBtnText = '导入数据';
      },
      beforePicUpload(file) {
        this.pictureUploadBtnText = '正在导入'
        const isIMAGE = file.type === 'image/jpeg'||'image/gif'||'image/png';
        const isLt1M = file.size / 1024 / 1024 /1024 < 1;

        if (!isIMAGE) {
          this.$message({type: 'error', message: "上传文件只能是图片格式!"});
        }
        if (!isLt1M) {
          this.$message({type: 'error', message: "上传文件大小不能超过 1MB!"});
        }
      },
      beforeFileUpload(file) {
        this.fileUploadBtnText = '正在导入';
      },
      exportPros() {
        window.open("/product/basic/exportPros", "_parent");
      },
      cancelSearch() {
        this.advanceSearchViewVisible = false;
        this.emptyProData();
        this.beginDateScope = '';
        this.loadPros();
      },
      showAdvanceSearchView() {
        this.advanceSearchViewVisible = !this.advanceSearchViewVisible;
        this.keywords = '';
        if (!this.advanceSearchViewVisible) {
          this.emptyProData();
          this.beginDateScope = '';
          this.loadPros();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      deleteManyPros() {
        this.$confirm('此操作将删除[' + this.multipleSelection.length + ']条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          var ids = '';
          for (var i = 0; i < this.multipleSelection.length; i++) {
            ids += this.multipleSelection[i].id + ",";
          }
          this.doDelete(ids);
        }).catch(() => {
        });
      },
      deletePro(row) {
        this.$confirm('此操作将永久删除[' + row.skunumber + '], 是否继续?', '提示', {
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
        this.deleteRequest("/product/basic/pro?ids=" + ids).then(resp => {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;
            _this.loadPros();
          }
        })
      },
      keywordsChange(val) {
        if (val == '') {
          this.loadPros();
        }
      },
      searchPro() {
        this.loadPros();
      },
      currentChange(currentChange) {
        this.currentPage = currentChange;
        this.loadPros();
      },
      loadPros() {
        var _this = this;
        this.tableLoading = true;
        this.getRequest("/product/basic/pro?page=" + this.currentPage + "&size=10&keywords=" + this.keywords).then(
            resp => {
              this.tableLoading = false;
              if (resp && resp.status == 200) {
                var data = resp.data;
                _this.pros = data.pros;
                _this.totalCount = data.count;
              }
            }
          )
      },
      addPro(formName) {
        var _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.pro.id) {
              //更新
              this.tableLoading = true;
              this.putRequest("/product/basic/pro", this.pro).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyProData();
                  _this.loadPros();
                }
              })
            } else {
              //添加
              this.tableLoading = true;
              this.postRequest("/product/basic/pro", this.pro).then(resp => {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;
                  _this.dialogVisible = false;
                  _this.emptyProData();
                  _this.loadPros();
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
        this.emptyProData();
      },
      showDepTree() {
        this.showOrHidePop = !this.showOrHidePop;
      },
      showDepTree2() {
        this.showOrHidePop2 = !this.showOrHidePop2;
      },
      showEditProView(row) {
        this.dialogTitle = "编辑产品";
        this.pro = row;
        this.dialogVisible = true;
      },
      showDetailView(row){
        this.getRequest("/product/basic/getPic?pid="+row.id).then(resp => {
           if (resp && resp.status == 200) {
            this.urls = resp.data;
           }
        })
        this.pro = row;
        this.dialogTitle = "产品详情";
        this.staticdialogVisible = true;
      },
      showAddProView() {
        this.dialogTitle = "添加产品";
        this.dialogVisible = true;
        var _this = this;
        this.getRequest("/product/basic/maxWorkID").then(resp => {
          if (resp && resp.status == 200) {
            _this.pro.workID = resp.data;
          }
        })
      },
     emptyProData() {
        this.pro = {
          workID: '',
          suppliercode: '',
          itemname: '',
          skunumber: '',
          composition: '',
          colour: '',
          size: '',
          length: '',
          weight: '',
          knitwearorwoven: '',
          minimumorderquantity: '',
          description: '',
          updatetime: '',
          season: '',
          purchaseprice: '',
          purchaseurl: '',
          buyingprice: '',
          radicalretropubicprostatectomy: '',
          offer: '',
          profit: '',
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

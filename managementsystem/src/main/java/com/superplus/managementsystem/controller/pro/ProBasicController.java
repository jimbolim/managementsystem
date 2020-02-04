package com.superplus.managementsystem.controller.pro;


import com.superplus.managementsystem.bean.Product;
import com.superplus.managementsystem.bean.RespBean;
import com.superplus.managementsystem.common.test.PoiUtils;
import com.superplus.managementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/product/basic")
public class ProBasicController {

    @Autowired
    ProService proService;

    private String url;

    @RequestMapping("/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", proService.getMaxWorkID() + 1);
    }


    @RequestMapping(value = "/pro", method = RequestMethod.GET)
    public Map<String, Object> getProductByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords
            ) {

        Map<String, Object> map = new HashMap<>();
        List<Product> productByPage = proService.getProductByPage(page, size, keywords);
        Long count = proService.getCountByKeywords(keywords);
        map.put("pros", productByPage);
        map.put("count", count);
        return map;

    }

    @RequestMapping(value = "/importPro", method = RequestMethod.POST)
    public RespBean importPro(MultipartFile file) {
        List<Product> pros = PoiUtils.importPro2List(file);
        if (proService.addPros(pros) == pros.size()) {
            return RespBean.ok("导入成功!");
        }
        return RespBean.error("导入失败!");
    }

    @RequestMapping(value = "importPic", method = RequestMethod.POST)
    public RespBean importPic(MultipartFile file){

        if (file.isEmpty()) {
            return RespBean.error("不可为空!");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
//        System.out.print("上传的文件名为: "+fileName+"\n");
//        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //加个时间戳，尽量避免文件名称重复
        String path = "/Users/jimbolim/Documents/testpicture/" +fileName;
        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //文件绝对路径
        //创建文件路径
        File dest = new File(path);
        //判断文件是否已经存在
        if (dest.exists()) {
            return RespBean.error("文件已经存在");
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //上传文件
            file.transferTo(dest); //保存文件
            //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
            url="/images/"+fileName;//本地运行项目
            //这里截取文件名，不太可靠。。
            String skunum = fileName.substring(0,fileName.length()-6);
            List<Long> pids = proService.getIdBySkunum(skunum);
            for(Long pid:pids){
                proService.insertUrl(fileName,path,url,pid);
            }
        } catch (IOException e) {
            RespBean.error("导入失败!");
        }
        return RespBean.ok("导入成功!");
    }

    @RequestMapping(value = "/exportPros", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        return PoiUtils.exportPro2Excel(proService.getAllProducts());
    }

    @RequestMapping(value = "/pro", method = RequestMethod.POST)
    public RespBean addPro(Product product) {
        if (proService.addPro(product) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/pro", method = RequestMethod.PUT)
    public RespBean updatePro(Product product) {
        if (proService.updatePro(product) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/pro", method = RequestMethod.DELETE)
    public RespBean deleteProById(@RequestParam(defaultValue = "") String ids) {
        if (proService.deleteProById(ids)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/getPic", method = RequestMethod.GET)
    public List<String> getPic(@RequestParam(defaultValue = "")Long pid){
        return proService.getPic(pid);
    }
}

package com.superplus.managementsystem.controller;


import com.superplus.managementsystem.bean.Product;
import com.superplus.managementsystem.bean.RespBean;
import com.superplus.managementsystem.common.test.PoiUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/auxiliary/transform")
public class AuxiliaryController {

    @RequestMapping(value = "/importorder", method = RequestMethod.POST)
    public RespBean importOrder(MultipartFile file) {
//        List<Product> pros = PoiUtils.importPro2List(file);
//        if (proService.addPros(pros) == pros.size()) {
//            return RespBean.ok("导入成功!");
//        }
        return RespBean.error("导入失败!");
    }

    @RequestMapping(value = "/testpython", method =  RequestMethod.GET)
    public ResponseEntity<FileSystemResource> testpython(){
            File file = new File("/Users/jimbolim/Documents/testpython/test.py");
            if(file.exists()){
                System.out.println("可以读取到非项目中脚本");
            }else{
                System.out.println("不可以读取到非项目中脚本");
                return PoiUtils.export(new File("/Users/jimbolim/Documents/testpython/error.xls"));
//                return RespBean.error("不可以读取到非项目中脚本");
            }

            try {
                Process process = Runtime.getRuntime().exec("python /Users/jimbolim/Documents/testpython/test.py");
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while( ( line = in.readLine() ) != null ) {
                    System.out.println(line);
                }
                in.close();
                int result = process.waitFor();
//                System.out.println("执行结果:" + result);
                if(new File("/Users/jimbolim/Documents/testpython/a.xls").exists()){
                    return PoiUtils.export(new File("/Users/jimbolim/Documents/testpython/a.xls"));
                }else {
                    return PoiUtils.export(new File("/Users/jimbolim/Documents/testpython/error.xls"));
                }
            } catch (Exception e) {
                e.printStackTrace();
//                return RespBean.error("执行python脚本失败");
            }
//            return RespBean.error("执行python脚本成功");
        return PoiUtils.export(new File("/Users/jimbolim/Documents/testpython/error.xls"));
        }
}


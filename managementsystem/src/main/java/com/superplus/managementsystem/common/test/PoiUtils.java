package com.superplus.managementsystem.common.test;


import com.superplus.managementsystem.bean.Product;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PoiUtils{
    public static ResponseEntity<byte[]> exportPro2Excel(List<Product> pros) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("产品信息");
            //3.2设置文档管理员
            dsi.setManager("江南一点雨");
            //3.3设置组织机构
            dsi.setCompany("XXX集团");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("产品信息表");
            //4.2.设置文档标题
            si.setTitle("产品信息");
            //4.3 设置文档作者
            si.setAuthor("XXX集团");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("XXX集团产品信息表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);
            sheet.setColumnWidth(1, 12 * 256);
            sheet.setColumnWidth(2, 10 * 256);
            sheet.setColumnWidth(3, 5 * 256);
            sheet.setColumnWidth(4, 12 * 256);
            sheet.setColumnWidth(5, 20 * 256);
            sheet.setColumnWidth(6, 10 * 256);
            sheet.setColumnWidth(7, 10 * 256);
            sheet.setColumnWidth(8, 16 * 256);
            sheet.setColumnWidth(9, 12 * 256);
            sheet.setColumnWidth(10, 15 * 256);
            sheet.setColumnWidth(11, 20 * 256);
            sheet.setColumnWidth(12, 16 * 256);
            sheet.setColumnWidth(13, 14 * 256);
            sheet.setColumnWidth(14, 14 * 256);
            sheet.setColumnWidth(15, 12 * 256);
            sheet.setColumnWidth(16, 8 * 256);
            sheet.setColumnWidth(17, 16 * 256);
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("供应商编码");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("Item name");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("SKU No.");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("Composition");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("Colour");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("Size");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("Length（cm）");
            cell6.setCellStyle(headerStyle);
            HSSFCell cell7 = headerRow.createCell(7);
            cell7.setCellValue("Weight (kg)");
            cell7.setCellStyle(headerStyle);
            HSSFCell cell8 = headerRow.createCell(8);
            cell8.setCellValue("Knitwear or woven");
            cell8.setCellStyle(headerStyle);
            HSSFCell cell9 = headerRow.createCell(9);
            cell9.setCellValue("Minimum Order Quantity");
            cell9.setCellStyle(headerStyle);
            HSSFCell cell10 = headerRow.createCell(10);
            cell10.setCellValue("Description");
            cell10.setCellStyle(headerStyle);
            HSSFCell cell11 = headerRow.createCell(11);
            cell11.setCellValue("Update time");
            cell11.setCellStyle(headerStyle);
            HSSFCell cell12 = headerRow.createCell(12);
            cell12.setCellValue("Season");
            cell12.setCellStyle(headerStyle);
            HSSFCell cell13 = headerRow.createCell(13);
            cell13.setCellValue("采购价");
            cell13.setCellStyle(headerStyle);
            HSSFCell cell14 = headerRow.createCell(14);
            cell14.setCellValue("采购链接");
            cell14.setCellStyle(headerStyle);
            HSSFCell cell15 = headerRow.createCell(15);
            cell15.setCellValue("buying price（USD）");
            cell15.setCellStyle(headerStyle);
            HSSFCell cell16 = headerRow.createCell(16);
            cell16.setCellValue("RRP（USD）");
            cell16.setCellStyle(headerStyle);
            HSSFCell cell17 = headerRow.createCell(17);
            cell17.setCellValue("报价");
            cell17.setCellStyle(headerStyle);
            HSSFCell cell18 = headerRow.createCell(18);
            cell18.setCellValue("利润");
            cell18.setCellStyle(headerStyle);
            //6.装数据
            for (int i = 0; i < pros.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                Product pro = pros.get(i);
                row.createCell(0).setCellValue(pro.getSuppliercode());
                row.createCell(1).setCellValue(pro.getItemname());
                row.createCell(2).setCellValue(pro.getSkunumber());
                row.createCell(3).setCellValue(pro.getComposition());
                row.createCell(4).setCellValue(pro.getColour());
                row.createCell(5).setCellValue(pro.getSize());
                row.createCell(6).setCellValue(pro.getLength());
                row.createCell(7).setCellValue(pro.getWeight());
                row.createCell(8).setCellValue(pro.getKnitwearorwoven());
                row.createCell(9).setCellValue(pro.getMinimumorderquantity());
                row.createCell(10).setCellValue(pro.getDescription());
                HSSFCell birthdayCell = row.createCell(11);
                birthdayCell.setCellValue(pro.getUpdatetime());
                birthdayCell.setCellStyle(dateCellStyle);
                row.createCell(12).setCellValue(pro.getSeason());
                row.createCell(13).setCellValue(pro.getPurchaseprice());
                row.createCell(14).setCellValue(pro.getPurchaseurl());
                row.createCell(15).setCellValue(pro.getBuyingprice());
                row.createCell(16).setCellValue(pro.getRadicalretropubicprostatectomy());
                row.createCell(17).setCellValue(pro.getOffer());
                row.createCell(18).setCellValue(pro.getProfit());
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("产品表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<Product> importPro2List(MultipartFile file) {
        List<Product> pros = new ArrayList<>();
        try {
            HSSFWorkbook workbook =
                    new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Product product;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    product = new Product();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 0:
                                        product.setSuppliercode(cellValue);
                                        break;
                                    case 1:
                                        product.setItemname(cellValue);
                                        break;
                                    case 2:
                                        product.setSkunumber(cellValue);
                                        break;
                                    case 3:
                                        product.setComposition(cellValue);
                                        break;
                                    case 4:
                                        product.setColour(cellValue);
                                        break;
                                    case 5:
                                        product.setSize(cellValue);
                                        break;
                                    case 6:
                                        product.setLength(cellValue);
                                        break;
                                    case 8:
                                        product.setKnitwearorwoven(cellValue);
                                        break;
                                    case 10:
                                        product.setDescription(cellValue);
                                        break;
                                    case 12:
                                        product.setSeason(cellValue);
                                        break;
                                    case 14:
                                        product.setPurchaseurl(cellValue);
                                        break;
                                }
                            }
                            break;
                            default: {
                                switch (k) {
                                    case 7:
                                        product.setWeight(cell.getNumericCellValue());
                                        break;
                                    case 9:
                                        product.setMinimumorderquantity(cell.getNumericCellValue());
                                        break;
                                    case 11:
                                        product.setUpdatetime(cell.getDateCellValue());
                                        break;
                                    case 13:
                                        product.setPurchaseprice(cell.getNumericCellValue());
                                        break;
                                    case 15:
                                        product.setBuyingprice(cell.getNumericCellValue());
                                        break;
                                    case 16:
                                        product.setRadicalretropubicprostatectomy(cell.getNumericCellValue());
                                        break;
                                    case 17:
                                        product.setOffer(cell.getNumericCellValue());
                                        break;
                                    case 18:
                                        product.setProfit(cell.getNumericCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    pros.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pros);
        return pros;
    }

}

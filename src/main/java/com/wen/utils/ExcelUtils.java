package com.wen.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * excel导出工具类
 * @author wencun
 * @date 2018年10月25日 下午4:15:06
 * @version 1.0
 * @since JDK 1.8
 */
public class ExcelUtils {
    /**
     * 带头部导出
     * @author wencun
     * @date: 2018年9月27日 下午10:36:15
     * @param header
     * @param fileName
     * @param list
     * @param columnNames
     * @param keys
     * @param response
     * @throws IOException
     */
    public void getEXCELFileWithHeader(String header,String fileName, List<Map<String, Object>> list,
            String[] columnNames, String[] keys, HttpServletResponse response) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try (HSSFWorkbook workbook =createWorkBookWithHeader(header,list, keys, columnNames)) {
            workbook.write(os);
        }
        byte[] content = os.toByteArray();
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
        try (BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(content));
                BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        }
    }
    
    /**
     * excel导出加表头
     * @author wencun
     * @date: 2018年9月27日 下午10:25:07
     * @param list
     * @param keys
     * @param columnNames
     * @return
     */
    @SuppressWarnings("deprecation")
    public static HSSFWorkbook createWorkBookWithHeader(String header,List<Map<String, Object>> list, String[] keys, String[] columnNames) {
        // 创建excel工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        HSSFSheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for (int i = 0; i < keys.length; i++) {
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }
        if(0!=keys.length) {
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,keys.length-1));//合并单元格
        }
        //创建第一行，标题头部
        Row rowHeader = sheet.createRow((short) 0);
        org.apache.poi.ss.usermodel.Cell headerCell = rowHeader.createCell(0);
        headerCell.setCellValue(header);
        //字体
        HSSFFont headerFont = wb.createFont();
        headerFont.setFontHeightInPoints((short)20);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        //样式
        CellStyle headerCss = wb.createCellStyle();
        headerCss.setFont(headerFont);
        headerCss.setBorderLeft(BorderStyle.THIN);
        headerCss.setBorderRight(BorderStyle.THIN);
        headerCss.setBorderTop(BorderStyle.THIN);
        headerCss.setBorderBottom(BorderStyle.THIN);
        headerCss.setAlignment(HorizontalAlignment.CENTER);
        headerCell.setCellStyle(headerCss);

        // 创建第二行
        Row row = sheet.createRow((short) 1);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        HSSFFont f = wb.createFont();
        HSSFFont f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

        // Font f3=wb.createFont();
        // f3.setFontHeightInPoints((short) 10);
        // f3.setColor(IndexedColors.RED.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(BorderStyle.THIN);
        cs.setBorderRight(BorderStyle.THIN);
        cs.setBorderTop(BorderStyle.THIN);
        cs.setBorderBottom(BorderStyle.THIN);
        cs.setAlignment(HorizontalAlignment.CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置列名
        for (int i = 0; i < columnNames.length; i++) {
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        // 设置每行每列的值
        for (int i = 1; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow(i+1);
            // 在row行上创建一个方格
            for (int j = 0; j < keys.length; j++) {
                org.apache.poi.ss.usermodel.Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null ? " " : list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }
}
package com.huawei.l00379880.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * POI相关操作
 *
 * @author Louis
 * @date Jan 14, 2019
 */
public class PoiUtils {

    /**
     * 生成Excel文件
     *
     * @param workbook excel对象
     * @param fileName 生成的excel文件名
     * @return 生成的excel文件对象
     */
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}

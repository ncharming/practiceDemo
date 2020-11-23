package dealExcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 使用 poi 处理 excel 文件(.xls 或者 .xlsx)
 */
public class DealExcelWithPoi {
    public static void main(String[] args) throws Exception {
        File file1 = new File("C:\\Users\\17323\\Desktop\\BATCH20200903400155435803_RESULT.xls");
        File file2 = new File("C:\\Users\\17323\\Desktop\\1111.xls");
        System.out.println(doDealResultData(file1, file2));
    }

    /**
     * 下面的代码处理逻辑（因为是对模板文件进行处理，所以列数是写死的）
     * 对某一列的 “异常” 过滤（即删除指定行，但是不留空白）
     *
     * @param fileResult 输入需要处理的文件
     * @param fileDeal   输出处理后的文件
     * @return
     * @throws Exception
     */
//    public static String doDealResultData(File fileResult, File fileDeal) throws Exception {
//        try {
//            //读入
//            FileInputStream fis = new FileInputStream(fileResult);//创建输入流
//            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fis);//解析文件
//            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);//读入excel文件
//            HSSFSheet sh = workbook.getSheetAt(0);//读取第一个sheet页
////        String dealType = sh.getRow(2).getCell(5).getStringCellValue(); //取得第三行第六列的值
////        System.out.println(dealType);//异常
//
//            int i = sh.getLastRowNum();
//            int ycTmp = 0;//记录excel表中的行数
//            String tempRow;
//
//            while (i > 1) {//前面两行是列表头，不用操作
//
//                tempRow = sh.getRow(i).getCell(10).getStringCellValue();
//                if ("异常".equals(tempRow)) {
//                    ycTmp++;
//                    sh.shiftRows(i + 1, sh.getLastRowNum() + 1, -1);
//                    //当前行的后一行到末尾都向前移动一行（相当于覆盖要去掉的行）
//                    // endRow +1操作，是为了大于startRow
//                }
//                i--;//放到后面；不然最后一行无法处理到
//            }
//
//
//            System.out.println(sh.getLastRowNum());
//            for (int m = 0; m < sh.getLastRowNum() - ycTmp + 1; m++) {
//                //取的行数，是从 0 开始计数
////                int n = sh.getRow(m).getPhysicalNumberOfCells();
//                int n = 14;
////            for (int n = 5; n < 9; n++) { //总共列数
////                sh.getRow(m).removeCell(sh.getRow(m).getCell(n));
////            }// 不能使用 for 循环的方式（因为你操作的时候，里面的行数或者列数在发生变化）
//                while (n > 10) { //模板文件里面有10列，需要保留
//                    n--;
//                    HSSFCell cell = sh.getRow(m).getCell(n);
//                    if (cell == null) {
//                        continue;
//                    }
//                    sh.getRow(m).removeCell(cell);
//                }
//            }
//
//
//            //模板文件有2行，说明全是失败的。
//            if (i < 2) {
//                return "1";
//            }
//
//            /**  可以去掉匹配的行，但存在空行
//             int rowNums = sh.getLastRowNum();
//             System.out.println(rowNums);
//             for (int row = 2; row < rowNums + 1; row++) {//第三行开始
//             if ("异常".equals(sh.getRow(row).getCell(5).getStringCellValue())) {
//             sh.removeRow(sh.getRow(row)); //写出的有空白行
//             }
//             }
//             */
//            //读出
//            FileOutputStream fileOutputStream = null;
//            try {
//                fileOutputStream = new FileOutputStream(fileDeal);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            workbook.write(fileOutputStream);
//
//            fis.close();
//            fileOutputStream.close();
//        } catch (Exception e) {
//            return "1";
//        }
//        return "0";
//    }
    public static String doDealResultData(File fileResult, File fileDeal) throws Exception {
        try {
            //读入
            FileInputStream fis = new FileInputStream(fileResult);//创建输入流
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fis);//解析文件
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);//读入excel文件
            HSSFSheet sh = workbook.getSheetAt(0);//读取第一个sheet页
//        String dealType = sh.getRow(2).getCell(5).getStringCellValue(); //取得第三行第六列的值
//        System.out.println(dealType);//异常

            int i = sh.getLastRowNum();
            String tempRow;
            while (i > 1) {//前面两行是列表头，不用操作

//                tempRow = sh.getRow(i).getCell(10).getStringCellValue();
                HSSFRow row = sh.getRow(i);
                HSSFCell cell = row.getCell(12);
                tempRow = cell.getStringCellValue();


                if ("异常".equals(tempRow)) { //取第十二列的值判断
                    sh.shiftRows(i + 1, sh.getLastRowNum() + 1, -1);
                    //当前行的后一行到末尾都向前移动一行（相当于覆盖要去掉的行）
                    // endRow +1 操作，是为了大于 startRow
                }
                i--;//放到后面；不然最后一行无法处理到
            }

            for (int m = 0; m < sh.getLastRowNum() + 1; m++) { //取的行数，是从 0 开始计数
                int n = 16;//
                //int n = sh.getRow(m).getPhysicalNumberOfCells();   //这里的取值在数据行会出错(7)，所以直接写死14列
//            for (int n = 5; n < 9; n++) { //总共列数
//                sh.getRow(m).removeCell(sh.getRow(m).getCell(n));
//            }// 不能使用 for 循环的方式（因为你操作的时候，里面的行数或者列数在发生变化）
                while (n > 12) { //模板文件里面有12列，需要保留
                    n--;//先--，再删除操作
                    HSSFCell cell = sh.getRow(m).getCell(n);
                    if (cell == null) {
                        continue;
                    }
                    sh.getRow(m).removeCell(sh.getRow(m).getCell(n));
                }
            }


            /**  可以去掉匹配的行，但存在空行
             int rowNums = sh.getLastRowNum();
             System.out.println(rowNums);
             for (int row = 2; row < rowNums + 1; row++) {//第三行开始
             if ("异常".equals(sh.getRow(row).getCell(5).getStringCellValue())) {
             sh.removeRow(sh.getRow(row)); //写出的有空白行
             }
             }
             */
            //读出
            FileOutputStream fileOutputStream = new FileOutputStream(fileDeal);
            workbook.write(fileOutputStream);

            //模板文件有2行，说明全是失败的。
            /**
             * 空文件（只有表头的文件）是不能发起审批的；这里不能使用 sh.getLastRowNum() ,这个获得的是文件初始的行数,从0计数
             */

            if (i < 1) {
                return "1";
            }

            fis.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }


}

package dealExcel;

import com.alibaba.excel.EasyExcel;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * 语雀：easyExcel 框架： https://www.yuque.com/easyexcel/doc/easyexcel
 * 官方很详细的文档
 */

public class ExportDataEasyExcel {

    /**
     *
     * @param queryPairingOrderListIn：自己定义的实体类
     * @param response
     * @throws IOException
     *
     * JdjdData()：数据库返回的数据
     *
     * 前台调用，直接弹窗下载
     */
    /*
    @RequestMapping("exportExcelDayFinishOrdList")
    public void exportExcelJdjd(QueryPairingOrderListIn queryPairingOrderListIn, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //获取年月日作为文件名
        String dateName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        String filename = URLEncoder.encode(dateName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + filename + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Detaillist.class).sheet("sheet").doWrite(JdjdData(queryPairingOrderListIn));
    }
*/




}

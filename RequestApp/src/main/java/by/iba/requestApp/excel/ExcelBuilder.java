package by.iba.requestApp.excel;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import by.iba.requestApp.viewBean.OrderBean;

public class ExcelBuilder extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<OrderBean> orders = (List<OrderBean>) model.get("orders");
		HSSFSheet sheet = workbook.createSheet("Orders");
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.BLUE.index);
	    
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.WHITE.index);
	    style.setFont(font);
	    
	    HSSFRow dateHeader = sheet.createRow(0);
	    GregorianCalendar calendar = new GregorianCalendar();
	    dateHeader.createCell(0).setCellValue(calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR));
	    dateHeader.createCell(1).setCellValue(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
	    HSSFRow header = sheet.createRow(1);
	    
        header.createCell(0).setCellValue("Product");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Type");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("Count");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Price");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("Status");
        header.getCell(4).setCellStyle(style);	

		int rowCount  = 2;
		
		for (int i = 0; i < orders.size(); i++) {
			HSSFRow row = sheet.createRow(rowCount++);
			OrderBean order = orders.get(i);
            row.createCell(0).setCellValue(order.getProduct().getProductName());
            row.createCell(1).setCellValue(order.getProductType().getProductTypeName());
            row.createCell(2).setCellValue(order.getCount());
            row.createCell(3).setCellValue(order.getPrice() + " BYN");
            if (order.getStatus()  == 1) {
            	row.createCell(4).setCellValue("Completed"); 
            } else {
            	row.createCell(4).setCellValue("In Progress"); 	
            }
		}
				
	}
}
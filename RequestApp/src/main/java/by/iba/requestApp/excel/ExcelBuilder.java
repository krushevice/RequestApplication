package by.iba.requestApp.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelBuilder extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		HSSFSheet sheet = workbook.createSheet("Revenue Report");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("user");
		header.createCell(1).setCellValue("password");

		
//		User user = (User) model.get("user");
		
		int rowNum = 1;
		/*for (Map.Entry<String, String> entry : revenueData.entrySet()) {
			//create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
        }*/
		for (int i = 1; i < 10; i++) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue("user name");
			row.createCell(1).setCellValue("user password");
		}
				
	}
}
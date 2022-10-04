package com.masterteknoloji.net.service;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.masterteknoloji.net.domain.BusDensityHistory;
 
@Service
public class ExcelExportService {
    
	SimpleDateFormat dateFormatForTime = new SimpleDateFormat("HH:mm:ss");
	
	private MessageSource messageSource;
	
	Locale locale;
	
	public ExcelExportService(MessageSource messageSource) {
		this.messageSource = messageSource;
		this.locale = Locale.forLanguageTag("tr");
	}
	
	public String getMessage(String key) {
		String value = messageSource.getMessage(key, null, locale);
		return value;
	}
 
    public XSSFSheet createSheet(XSSFWorkbook workbook,String sheetName) {
    	XSSFSheet sheet = workbook.createSheet(sheetName);
    
    	Row row = sheet.createRow(0);
        
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, getMessage("voyage.report.id"), style);      
        createCell(row, 1, getMessage("voyage.report.routeCode"), style);       
        createCell(row, 2, getMessage("voyage.report.routeName"), style);    
        createCell(row, 3, getMessage("voyage.report.voyageTime"), style);	
       
        createCell(row, 4, getMessage("voyage.report.bus"), style);	
        createCell(row, 5, getMessage("voyage.report.station"), style);	
        createCell(row, 6, getMessage("voyage.report.recordDate"), style);	
        createCell(row, 7, getMessage("voyage.report.differance"), style);	
        
        createCell(row, 8, getMessage("voyage.report.passengerCount"), style);	
        createCell(row, 9, getMessage("voyage.report.density"), style);	
        return sheet;
    }
    
    public void writeImage(XSSFWorkbook workbook,XSSFSheet sheet,byte[] image) {
    	final int pictureIndex = workbook.addPicture(image, Workbook.PICTURE_TYPE_PNG);
    	
    	CreationHelper helper = workbook.getCreationHelper();
    	   //Creates the top-level drawing patriarch.
    	   Drawing drawing = sheet.createDrawingPatriarch();

    	   //Create an anchor that is attached to the worksheet
    	   ClientAnchor anchor = helper.createClientAnchor();
    	   
    	   anchor.setCol1(1); //Column B
    	   anchor.setRow1(2); //Row 3
    	   anchor.setCol2(2); //Column C
    	   anchor.setRow2(3); //Row 4

    	   Picture pict = drawing.createPicture(anchor, pictureIndex);
    	   pict.resize();
    }
    
    public void writeData(XSSFWorkbook workbook,XSSFSheet sheet,List<BusDensityHistory> dataList) {
    	int rowCount = 1;
    	 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        Long totalCount = 0l;
        for (BusDensityHistory item : dataList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, item.getId(), style);
            createCell(row, columnCount++, item.getRoute().getRouteCode(), style);
            createCell(row, columnCount++, item.getRoute().getName(), style);
            createCell(row, columnCount++, item.getScheduledVoyage().getScheduledTime(), style);
            createCell(row, columnCount++, item.getBus().getPlate(), style);
            createCell(row, columnCount++, item.getStation().getName(), style);
            createCell(row, columnCount++, item.getRecordDate(), style);
            createCell(row, columnCount++, item.getGetInPassengerCount()-item.getGetOutPassengerCount(), style);
            createCell(row, columnCount++, item.getTotalPassengerCount(), style);
            createCell(row, columnCount++, item.getDensity(), style);
            
        }
//        Row row = sheet.createRow(rowCount++);
//        int columnCount = 0;
//        createCell(row, columnCount++, "", style);
//        createCell(row, columnCount++, "", style);
//        createCell(row, columnCount++, getMessage("excel.total"), style);
//        createCell(row, columnCount++, String.valueOf(totalCount), style);
    }
    
    public void writeDataForVehicleType(XSSFWorkbook workbook,XSSFSheet sheet,Iterable<Map<String,Object>> dataList) {
    	int rowCount = 1;
    	 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        style.setShrinkToFit(true);
         
        Long totalCount = 0l;
        for (Map<String,Object> videoRecordSummaryVM : dataList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, videoRecordSummaryVM.get("type"), style);
            createCell(row, columnCount++, videoRecordSummaryVM.get("count").toString(), style);
            
        }
        
//        sheet.autoSizeColumn(0);
//        sheet.autoSizeColumn(1);
//        
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }
        else if (value instanceof Long ) {
            cell.setCellValue((Long ) value);
        }  
        else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof java.sql.Timestamp) {
        	cell.setCellValue(dateFormatForTime.format(value));
        } else if (value instanceof Instant) {
        	Instant a= (Instant)value;
        	cell.setCellValue(dateFormatForTime.format(Date.from(a)));
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    
     
    public void export(XSSFWorkbook workbook,HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
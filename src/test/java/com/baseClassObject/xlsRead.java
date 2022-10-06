package com.baseClassObject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;

public class xlsRead {
	public static void main(String[] args) throws IOException {
		String xlsPath=".\\Utility/carddetails.xls";
		FileInputStream inputstream=new FileInputStream(xlsPath);
		HSSFWorkbook workbook= new HSSFWorkbook(inputstream);
		HSSFSheet sheet= workbook.getSheetAt(0);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println("card no is "+workbook.getSheetAt(0).getRow(1).getCell(1));
		
		for(int r=0;r<=rows;r++) {
			HSSFRow row=sheet.getRow(r);		
			
					
			for(int c=0;c<cols;c++){
				HSSFCell cell=row.getCell(c);
								
//				DataFormatter formatter = new DataFormatter();
//				String strValue = formatter.formatCellValue(cell);
//				if(cell.getStringCellValue().equalsIgnoreCase("Card Number")) {
//					
//					System.out.println("visa card is");					
//				}
				switch (cell.getCellType()) {
				case STRING : System.out.println(cell.getStringCellValue());				
					break;
				case NUMERIC :System.out.println(cell.getNumericCellValue());
				}
				System.out.println(" | ");
			}
		}
	}

}

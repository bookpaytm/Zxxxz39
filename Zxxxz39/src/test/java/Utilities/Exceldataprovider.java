package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider {
	
	
	XSSFWorkbook wb;
	
public Exceldataprovider(){
File f=new File("./Testdata/salman excel data.xlsx");
try {
	FileInputStream fis=new FileInputStream(f);
	 wb=new XSSFWorkbook(fis);
} catch (Exception e) {
	System.out.println("unsuccessful"+e.getMessage());
}

}
public String getStringdata(int index,int row,int coloum){
	return wb.getSheetAt(index).getRow(row).getCell(coloum).getStringCellValue();
}
public String getString(String sheetname,int row,int coloum){
	return wb.getSheet(sheetname).getRow(row).getCell(coloum).getStringCellValue();
	
}
public double getnumerically(String sheetname,int row,int coloum){
	return wb.getSheet(sheetname).getRow(row).getCell(coloum).getNumericCellValue();
}
}



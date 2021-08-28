package p1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo2 {
public static void main(String[] args) throws Exception {
	String path="./data/book1.xlsx";
	Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	Sheet sheet = wb.getSheet("Sheet1");
	int rowcount = sheet.getLastRowNum();
//	System.out.println(rowcount);
	for(int i=0;i<=rowcount;i++){
		try {
			int colcount = sheet.getRow(i).getLastCellNum();
//			System.out.println(colcount);
			for(int j=0;j<colcount;j++) {
				try {
					String v = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.print(v+" ");
					}
				catch(Exception e) {
					System.out.print("--");
					}
				}
		}
		catch(Exception e) {
			System.out.println("---------");
		}
		System.out.println();
	}
	wb.close();
}}

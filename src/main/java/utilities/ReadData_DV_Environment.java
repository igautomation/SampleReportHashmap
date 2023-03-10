package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData_DV_Environment {

	private FileInputStream file;
	private XSSFWorkbook Workbook;
	private XSSFSheet sheet;


	public HashMap<String, String> HashMap_Data_Environment_Details(String Environment , String Test_Data_Path) throws IOException{

		HashMap<String, String> hmap = new HashMap<String, String>();

		file = new FileInputStream(Test_Data_Path);

		Workbook = new XSSFWorkbook(file);
		sheet = Workbook.getSheet("Environment_Details");
		XSSFSheet Login_Details = sheet;

		hmap.put("Browser", Login_Details.getRow(1).getCell(1).getRichStringCellValue().getString());
		hmap.put("Environment", Login_Details.getRow(2).getCell(1).getRichStringCellValue().getString());
		hmap.put("TDRA_URL", Login_Details.getRow(4).getCell(1).getRichStringCellValue().getString());

		return hmap;

	}

}

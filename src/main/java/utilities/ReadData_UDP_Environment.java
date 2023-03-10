package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ReadData_UDP_Environment {

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
		hmap.put("TDRA_UDP_URL", Login_Details.getRow(4).getCell(1).getRichStringCellValue().getString());
		hmap.put("TDRA_UDP_Username", Login_Details.getRow(6).getCell(1).getRichStringCellValue().getString());
		hmap.put("TDRA_UDP_Password", Login_Details.getRow(7).getCell(1).getRichStringCellValue().getString());

		return hmap;

	}

}

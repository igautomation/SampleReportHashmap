package utilities;

import java.util.HashMap;

public class ReadExcelDataUsingUtilClass {
	
	
	public HashMap<String, String> HashMap_Data_Inspection_DubaiTrade(int j , String Test_Data_Path , String Sheet) throws Exception {
		ExcelApiTest eat = new ExcelApiTest(Test_Data_Path);

		HashMap<String, String> hmap = new HashMap<String, String>();

		hmap.put("Execute", eat.getCellData(Sheet, "Execute", j));
		hmap.put("TestCaseNo", eat.getCellData(Sheet, "TestCaseNo", j));
		hmap.put("TestCaseDescription", eat.getCellData(Sheet, "TestCaseDescription", j));
		hmap.put("Declaration_No", eat.getCellData(Sheet, "Declaration_No", j));
		hmap.put("Booking_Ref_No", eat.getCellData(Sheet, "Booking_Ref_No", j));


		return hmap;
	}

}

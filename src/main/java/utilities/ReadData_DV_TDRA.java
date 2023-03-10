package utilities;

import java.util.HashMap;

public class ReadData_DV_TDRA {
	
	
	public HashMap<String, String> HashMap_Data_TDRA_CASES(int j , String Test_Data_Path , String Sheet) throws Exception {
		ExcelApiTest eat = new ExcelApiTest(Test_Data_Path);

		HashMap<String, String> hmap = new HashMap<String, String>();

		//Test Case Variables
		hmap.put("Execute", eat.getCellData(Sheet, "Execute", j));
		hmap.put("TestCaseNo", eat.getCellData(Sheet, "TestCaseNo", j));
		hmap.put("TestScenarios", eat.getCellData(Sheet, "TestScenarios", j));
		hmap.put("IterationNo", eat.getCellData(Sheet, "IterationNo", j));
		hmap.put("TestCaseDescription", eat.getCellData(Sheet, "TestCaseDescription", j));

		//Flag Variables
		hmap.put("Flag", eat.getCellData(Sheet, "Flag", j));

		//Common Variables

		//Test Case Variables
		hmap.put("Upload_File", eat.getCellData(Sheet, "Upload_File", j));
		hmap.put("Document_Type", eat.getCellData(Sheet, "Document_Type", j));

		return hmap;
	}

}

package test_POC;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom_WEB.*;
import utilities.*;

import java.util.HashMap;

public class TC_TDRA_DV_001 {

    WebDriver driver;
    WebElement element;
    public String Result;
    public ExtentSparkReporter htmlReporter;
    public ExtentReports reports;
    public ExtentTest test;
    public ReadData_DV_TDRA readData_DV_TDRA_Hasmap;
    public ReadData_DV_Environment readData_DV_Environment_Details;
    private Chrome_Browser getChrome;
    private IE_Browser getie;
    public Reports report_Generator;
    public TakeScreenShot Take_Screenshot;
    public String BookingRefNo;


    private TDRA_DV_Login var_TDRAlogin;
    private TDRA_PG_001 var_TDRA_PG_001;
    public HashMap<String, String> map_Environment_Details;
    public HashMap<String, String> map_TDRA_CASES;
    public static DB_Connections Connect_DB;


    @Parameters({"Test_Data_Path", "Environment"})
    @Test
    public void TC_TDRA_DV_001(String Test_Data_Path, String Environment) throws Exception {


        //Initialise Browser
        getChrome = new Chrome_Browser();
        new Chrome_Browser();
        Take_Screenshot = new TakeScreenShot();
        Connect_DB = new DB_Connections();

        //Initialise Excel data read through HashMap

        ExcelApiTest Read_Data = new ExcelApiTest(Test_Data_Path);
        int NoOf_Itration = Read_Data.ExcelIteration_Count(Test_Data_Path, "TDRA_CASES");
        readData_DV_TDRA_Hasmap = new ReadData_DV_TDRA();
        readData_DV_Environment_Details = new ReadData_DV_Environment();
        // Create Local Hash Map for Environment sheet
        map_Environment_Details = readData_DV_Environment_Details.HashMap_Data_Environment_Details(Environment, Test_Data_Path);
        NoOf_Itration = NoOf_Itration - 1;

        //Start of Test Iteration
        for (int i = 1; i <= NoOf_Itration; i++) {
            // Create Local Hash Map for Inspection_DubaiTrade sheet
            map_TDRA_CASES = readData_DV_TDRA_Hasmap.HashMap_Data_TDRA_CASES (i, Test_Data_Path,
                    "TDRA_CASES");
            // Create Local Hash Map for Inspection_Siebel sheet
            //map_Inspection_Siebel = ReadData_Siebel_Hasmap.HashMap_Data_Inspection_Siebel(i, Test_Data_Path, "Inspection_Siebel");
            if (map_TDRA_CASES.get("Execute").equals("NO")) {
                continue;
            }
            if (map_TDRA_CASES.get("TestCaseNo").equals("TC_TDRA_001")) {
                reports = Reports.reports;
                test = reports.createTest(map_TDRA_CASES.get("TestCaseDescription"));

                //Initialise Browser

                if (map_Environment_Details.get("Browser").equals("IE")) {
                    driver = getie.IEBrowser(driver);

                } else if (map_Environment_Details.get("Browser").equals("CHROME")) {
                    driver = getChrome.ChromeBrowser(driver);
                }
                //Enter URL
                driver.get(map_Environment_Details.get("TDRA_URL"));

                //Environmental Change Functionality
                if (Environment.equals("SIT1") || Environment.equals("UAT1")) {

                }

                //Login to Application
                var_TDRAlogin = new TDRA_DV_Login();
                Thread.sleep(5000);
                // Functional Flow
                Result = var_TDRAlogin.TDRA_login(driver, test, reports, Environment, Test_Data_Path);
                if (Result.equals("Fail")) {
                    test.log(Status.FAIL, "TDRA Login Failed");
                    String Screen = Take_Screenshot.take_screenshot(driver);
                    test.addScreenCaptureFromPath(Screen);
                    reports.flush();
                    continue;
                }
                //Initiate Inspection Cleared
                Result = var_TDRA_PG_001.Fn_UAEVERIFYDOCUMENT(driver, test, Environment, reports, i,
                        Test_Data_Path, "TDRA_CASES");
                // Retrieve Booking Ref NO From DB
                if (Result.equals("Pass")) {
                    test.log(Status.PASS, "UAEVERIFYDOCUMENT Test Passed");
                    test.log(Status.PASS, "Booking Reference Number : " + BookingRefNo);
                    reports.flush();
                    driver.quit();
                    Thread.sleep(3000);

                } else if (Result.equals("Fail")) {
                    test.log(Status.FAIL, "UAEVERIFYDOCUMENT Test Failed");
                    reports.flush();
                    driver.quit();
                    continue;
                }


            }

        }

    }

}

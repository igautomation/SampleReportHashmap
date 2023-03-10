package pom_WEB;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.*;
import java.util.HashMap;

public class TDRA_UDP_001 {

    WebDriver driver;
    WebElement element;
    public String Result;
    public ExtentSparkReporter htmlReporter;
    public ExtentReports reports;
    public ExtentTest test;
    public Reports report_Generator;
    public TakeScreenShot Take_Screenshot;

    public ReadData_DV_TDRA Read_TDRA_Details;
    public HashMap<String, String> map_TDRA;

    public static DB_Connections Connect_DB;


    public String Fn_UAEVERIFYDOCUMENT(WebDriver driver , ExtentTest test, String Environment, ExtentReports reports ,  int j , String Test_Data_Path, String Sheet ) throws Exception {

        Read_TDRA_Details = new ReadData_DV_TDRA();
        map_TDRA = Read_TDRA_Details.HashMap_Data_TDRA_CASES(j, Test_Data_Path, Sheet);

        try {
            By chooseFile = By.xpath("//button[@type='button']");

            // FILE UPLOADING USING SENDKEYS ....
            WebElement uploadFile = driver.findElement(chooseFile);
            //click on ‘Choose file’ to upload the desired file
            uploadFile.sendKeys(map_TDRA.get("Upload_File"));
            //Uploading the file using sendKeys
            System.out.println("File is Uploaded Successfully");

        } catch (Exception exception) {
            System.out.println(exception);
        }

        return Result;
    }


}

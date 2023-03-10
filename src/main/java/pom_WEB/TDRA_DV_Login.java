package pom_WEB;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utilities.Elements;
import utilities.ReadData_DV_Environment;
import utilities.Reports;
import utilities.ScreenShot;

import java.io.IOException;
import java.util.HashMap;

public class TDRA_DV_Login {
    public WebDriver driver;
    public ExtentTest test;
    public ExtentReports reports;
    public Reports report_Generator;
    public ScreenShot Take_Screenshot;
    public String Result;
    public Elements Element;
    public ReadData_DV_Environment ReadData_DV_Environment;
    public HashMap<String, String> map;

    public String TDRA_login(WebDriver driver, ExtentTest test, ExtentReports reports, String Environment, String Test_Data_Path) throws IOException, InterruptedException {

        this.driver = driver;
        this.test = test;
        this.reports = reports;
        Take_Screenshot = new ScreenShot();
        Element = new Elements();
        ReadData_DV_Environment = new ReadData_DV_Environment();

        map = ReadData_DV_Environment.HashMap_Data_Environment_Details(Environment, Test_Data_Path);

        try {

            By webLogo = By.xpath("//a[@class='navbar-brand header-image']//img");

            if (driver.findElements(webLogo).size() != 0) {
                test.log(Status.PASS, "TDRA Application Logged in successfully");
                reports.flush();
                Result = "Pass";
            } else {
                Result = "Fail";
            }

        } catch (WebDriverException e) {
            test.log(Status.FAIL, "TDRA Application Login Failed");
            String Screen = Take_Screenshot.take_screenshot(driver);
            test.addScreenCaptureFromPath(Screen);
            reports.flush();
        }

        return Result;
    }

}
	

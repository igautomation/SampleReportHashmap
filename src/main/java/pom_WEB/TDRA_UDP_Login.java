package pom_WEB;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utilities.*;

import java.io.IOException;
import java.util.HashMap;

public class TDRA_UDP_Login {
    public WebDriver driver;
    public ExtentTest test;
    public ExtentReports reports;
    public Reports report_Generator;
    public ScreenShot Take_Screenshot;
    public String Result;
    public Elements Element;
    public ReadData_UDP_Environment ReadData_UDP_Environment;
    public HashMap<String, String> map_Environment_Details;
    private Object ReadData_UDP_TDRA;
    private ReadData_UDP_TDRA Read_TDRA_Details;

    public String TDRA_login(WebDriver driver, ExtentTest test, ExtentReports reports, String Environment, String Test_Data_Path) throws IOException, InterruptedException {

        this.driver = driver;
        this.test = test;
        this.reports = reports;
        Take_Screenshot = new ScreenShot();
        Element = new Elements();
        ReadData_UDP_Environment = new ReadData_UDP_Environment();
        map_Environment_Details = ReadData_UDP_Environment.HashMap_Data_Environment_Details(Environment, Test_Data_Path);

        try{

            By webLogo = By.xpath("//img[@class='my-auto']");
            By username = By.xpath("//input[@placeholder='User Name']");
            By password = By.xpath("//input[@placeholder='Password']");
            By loginButton = By.xpath("//button[normalize-space()='Log in']");

            if (driver.findElements(webLogo).size() != 0) {
                test.log(Status.PASS, "TDRA Application Launched successfully");

                driver.findElement(username).sendKeys(map_Environment_Details.get("TDRA_UDP_Username"));
                driver.findElement(password).sendKeys(map_Environment_Details.get("TDRA_UDP_Password"));
                driver.findElement(loginButton).click();

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
	

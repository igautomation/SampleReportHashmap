package pom_WEB;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;

public class HandlingCalendar {

    public static void selectDate(WebElement calendar, String year, String monthName, String day, WebDriver driver) throws ParseException {
        //Clicking on calendar to open calendar widget
        calendar.click();

        // Retrieving current year value
        String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        // Click on Next arrow till we get desired year
        if (!currentYear.equals(year)) {
            do {
                Select dropdown = new Select(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")));
                dropdown.selectByVisibleText(year);
            } while (!driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().equals(year));
        }

        // Select desired month after selecting desired year
        String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        if (!currentMonth.equalsIgnoreCase(monthName)) {
            do {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            } while (!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim().equalsIgnoreCase(monthName));

        }
        //Select desired date after selecting desired month
        String currentDay = driver.findElement(By.xpath("//a[normalize-space()='" + day + "']")).getText();
        if (!currentDay.equalsIgnoreCase(day)) {
            do {
                driver.findElement(By.xpath("//a[normalize-space()='" + day + "']")).click();
            } while (!driver.findElement(By.xpath("//a[normalize-space()='\"+day+\"']")).getText().trim().equalsIgnoreCase(day));
        }

    }


    public static void main(String[] args) throws ParseException, InterruptedException {


        try {

            System.setProperty("webdriver.chrome.driver", "C:\\Automation\\DCSELENIUM\\Automation\\Projects\\Project_Inspection\\src\\main\\resources\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //WebDriverManager.chromedriver().setup();
            //WebDriverManager.edgedriver().setup();
            //WebDriverManager.chromedriver().setup();
            //WebDriverManager.firefoxdriver().setup();
            //WebDriver driver = new FirefoxDriver();
            //WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
            driver.get("http://192.168.100.16:8180/accident-reports/#/login");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        /*private By password = By.id("input-password");
        private By loginBtn = By.xpath("//input[@value='Login']");
        private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
        private By header = By.cssSelector("div#logo h1 a");
        private By registerLink = By.linkText("Register");*/

            By userName = By.xpath("//input[@id='username']");
            By passWord = By.xpath("//input[@type='password']");
            By captcha = By.xpath("//input[@id='captchaVal']");
            By loginButton = By.xpath("//button[contains(text(),'تسجيل الدخول')]");
            By seriousAccidentReport = By.xpath("//div[contains(text(),'الحوادث الجسيمة')]");
            By addAccidentReport = By.xpath("//button[@class=\"primaryButton addNewAccidentBtn\"]");
            By openMap = By.xpath("//*[contains(text(),' الانتقال الى الخرائط')]");
            By findAddress = By.xpath("//*[@id=\"viewDiv\"]/div[1]/div[3]/div[1]/div[2]/div/div/div[1]/form/input");
            By searchButton = By.xpath("//div[@class='esri-search--show-suggestions esri-search__container']//button[@title='Search']");
            By firstAddressListSelection = By.xpath("//li[@role='menuitem']//strong");
            By locationPointer = By.xpath("//div[@class='esri-popup__pointer']");
            By dialogOKButton = By.xpath("//button[@class='btn btn-outline-dark']");


            Thread.sleep(5000);
            driver.findElement(userName).sendKeys("9999999999");
            driver.findElement(passWord).sendKeys("welcome2");
            driver.findElement(captcha).sendKeys("123456");
            driver.findElement(loginButton).click();
            driver.findElement(seriousAccidentReport).click();
            Thread.sleep(5000);
            driver.findElement(addAccidentReport).click();
            Thread.sleep(2000);
            driver.findElement(openMap).click();
            Thread.sleep(2000);
            driver.findElement(findAddress).sendKeys("Riyadh, SAU");
            Thread.sleep(5000);
            driver.findElement(firstAddressListSelection).click();
            Thread.sleep(5000);


        /*Actions action = new Actions(driver);
        action.moveToElement((WebElement) locationPointer);
        driver.findElement(locationPointer).click();*/

           /* WebElement ele = driver.findElement(locationPointer);
            js.executeScript("arguments[0].scrollIntoView(true);", ele);
            js.executeScript("arguments[0].click();", ele); */

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='esri-popup__pointer']")));
            driver.findElement(By.xpath("//*[@class='esri-popup__pointer']")).click();

            Thread.sleep(2000);
            driver.findElement(dialogOKButton).click();

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }


}

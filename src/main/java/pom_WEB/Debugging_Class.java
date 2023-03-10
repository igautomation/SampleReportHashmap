package pom_WEB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Debugging_Class {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();

        // set the driver path- You can also use WebDriverManager for drivers
        //System.setProperty("webdriver.chrome.driver", "E:\\MukeshData\\chromedriver.exe");

        // Create object of ChromeOptions Class
        ChromeOptions opt = new ChromeOptions();

        // pass the debuggerAddress and pass the port along with host. Since I am running test on local so using localhost
        opt.setExperimentalOption("debuggerAddress", "localhost:57707");

        // pass ChromeOptions object to ChromeDriver constructor
        WebDriver driver = new ChromeDriver(opt);

        // now you can use now existing Browser
        //driver.get("http://facebook.com");
        String varTitle = driver.getTitle();
		//System.out.println("Get Title : " + varTitle);

        if (varTitle == "Facebook – log in or sign up") {
            System.out.println("Page title is : " + varTitle);
        }

    }

}

package utilities;

import java.awt.*;
import java.io.IOException;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Browser {

	WebDriver driver;
	String Result;

	public WebDriver ChromeBrowser(WebDriver driver) throws IOException, AWTException {

		//Close all running IEDriverServer.exe
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.driver = driver;
		ChromeOptions options = new ChromeOptions();
		options.addExtensions();
		//options.setExperimentalOption("useAutomationExtension", false);
		//System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\src\\main\\resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

}
package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public String take_screenshot(WebDriver driver ) throws IOException {
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		//Date date = new Date();  
	    //System.out.println(formatter.format(date));  
	
			String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
		
			File ScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String Screen = "Z:\\INS_AUTOMATION\\INS_SCREENSHOTS\\"+System. currentTimeMillis()+".png";

			FileHandler.copy(ScreenshotFile , new File(Screen));
					
			return Screen;
		}
	
}

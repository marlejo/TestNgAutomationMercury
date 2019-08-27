package helpers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {
	public void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void TakeScreenshot(WebDriver driver, String screenName) {
		//Toma screenshot despues de realizar el test
		File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		//Guarda el screenshot en la direccion especificada
		try {
			FileUtils.copyFile(myScreenShot, new File(
					"\\Screenshots\\"+screenName+
					new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

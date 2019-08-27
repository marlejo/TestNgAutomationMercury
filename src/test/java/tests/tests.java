package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import page.PageLogin;
import page.PageLogon;
import page.PageReservation;

public class tests {
	private WebDriver driver;
	Helpers helper;
	PageLogin pageLogin;
	PageLogon pageLogon;
	PageReservation pageReservation;
	
	@BeforeMethod
	public void setUp() {
		//set system property to use chromewebdriver
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//Maximizar la ventana que se abre con el driver
		driver.manage().window().maximize();
		
		//Pagina a la que se dirige cuando abre el navegador
		driver.navigate().to("http://newtours.demoaut.com");
		
		//Wait for the page to fully download
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*/Abrir una nueva ventana usando javascript
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String newTab = "window.open('http://www.google.com.co')";
		javascriptExecutor.executeScript(newTab);*/
		
		//Instancias de las pages
		pageLogin = new PageLogin(driver);
		pageLogon = new PageLogon(driver);
		pageReservation = new PageReservation(driver);
	}
	@Test
	public void pruebaUno() {
		pageLogin.Login("user", "user");
		pageLogon.assertLogonPage();
	}
	@Test
	public void pruebaDos() {
		pageLogin.Login("mercury", "mercury");
		pageReservation.assertPage();
	}
	@Test
	public void pruebaTres() {
		pageLogin.Login("mercury", "mercury");
		pageReservation.selectPassangers(2);
		pageReservation.selectDepartingFrom(5);
		pageReservation.selectArrivingTo("Paris");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		Helpers.TakeScreenshot(driver, result.getMethod().getMethodName());
		driver.close();
	}
}

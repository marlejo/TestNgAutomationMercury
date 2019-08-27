package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passField;
	private By loginBtn;

	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("userName");
		passField = By.name("password");
		loginBtn = By.name("login");
	}
	
	public void Login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginBtn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}

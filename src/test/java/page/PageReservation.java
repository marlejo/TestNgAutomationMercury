package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageReservation {
	private WebDriver driver;
	private By registrationText;
	private By passangerDDL;
	private By departingFromDDL;
	private By arrivingToDDL;
	

	public PageReservation(WebDriver driver) {
		this.driver = driver;
		registrationText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		passangerDDL = By.name("passCount");
		departingFromDDL = By.name("fromPort");
		arrivingToDDL = By.name("toPort");
	}
	
	public void assertPage() {
		Assert.assertTrue(driver.findElement(registrationText).getText().contains("Use our Flight Finder"));
	}
	
	public void selectPassangers(int cant) {
		Select selectPasajersos= new Select(driver.findElement(passangerDDL));
		selectPasajersos.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectDepartingFrom(int index) {
		Select selectDepartingFrom = new Select(driver.findElement(departingFromDDL));
		selectDepartingFrom.selectByIndex(index);
	}
	
	public void selectArrivingTo(String city) {
		Select selectArrivingTo = new Select(driver.findElement(arrivingToDDL));
		selectArrivingTo.selectByValue(city);
	}

}

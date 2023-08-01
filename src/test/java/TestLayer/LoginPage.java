package TestLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import Utility.ExcelReader;

public class LoginPage extends BaseClass {
	@BeforeTest
	public void setUp() {
		BaseClass.initialization();
	}

	@Test(priority = 1, dataProvider = "getAllData")
	public void AllInfo(String fname, String Lname, String phone, String email, String Address, String city,
			String state, String postalCode, String country, String username, String password, String Cpass)
			throws InterruptedException {
		// Thread.sleep(5000);
		driver.findElement(By.name("firstName")).sendKeys(fname);

		driver.findElement(By.name("lastName")).sendKeys(Lname);

		driver.findElement(By.name("phone")).sendKeys(phone);

		driver.findElement(By.name("userName")).sendKeys(email);

		driver.findElement(By.name("address1")).sendKeys(Address);

		driver.findElement(By.name("city")).sendKeys(city);

		driver.findElement(By.name("state")).sendKeys(state);

		driver.findElement(By.name("postalCode")).sendKeys(postalCode);

		WebElement wb = driver.findElement(By.name("country"));
		Select sel = new Select(wb);
		sel.selectByVisibleText(country);

		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(Cpass);
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();

	}

	@DataProvider
	public Object[][] getAllData() throws IOException {
		ExcelReader obj = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Guru99Data.xlsx");

		Object[][] data = obj.getAllSheetData(0);
		return data;
	}

}

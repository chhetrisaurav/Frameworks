package dataDriverFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bravenet.pages.Login;

import utils.ReadExcel;

public class DataDrivenFramework {
	
	WebDriver driver;
	
	@BeforeTest
	public void lunchApplication() {
	
	//	1) Open the browser
		driver = new ChromeDriver();
		
	//	2) Maximize it
		driver.manage().window().maximize();
		
	//	3) Navigate to the application
		driver.get("https://www.bravenet.com/login");
	}
	
	@Test
	public void enterCredentials() throws IOException {
	
		Login login = new Login(driver);
		
		String [][] data = ReadExcel.getData("resources//userdata.xlsx", "Sheet1");
		
		for (int i = 1;i<6; i++) {
			
			String username = data[i][1];
			String password = data[i][2];
			
		//	4) Enter an invalid username
			login.enterUsername(username);
				
		//	5) Enter an invalid password
			login.enterPassword(password);
			
		//	6) Click on Login button
			login.clickLoginBtn();
			
		//	7) Verify the error message - "You must login with your username"
			String expectedErrMsg = "You must login with your username";
			String actualErrMsg = login.getErrMsg();
			
			Assert.assertEquals(actualErrMsg, expectedErrMsg);
		}
	}
	
	@AfterTest
	public void closeBrowser() {
	//	8) Close the browser
		driver.quit();
	}
}

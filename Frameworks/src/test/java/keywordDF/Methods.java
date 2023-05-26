package keywordDF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Methods {
	static WebDriver driver;
	
	public static void openBrowser() {
		driver = new ChromeDriver();
	}
	public static void maximizeIt() {
		driver.manage().window().maximize();
	 }
	 public static void navigateTo(String url) {
		driver.get(url);
	 }
	 public static void enterUsername(String value, String param) {
		driver.findElement(By.id(value)).sendKeys(param);
	 }
	 public static void enterPassword(String value, String param) {
		driver.findElement(By.id(value)).sendKeys(param);
	 }
	 public static void clickLoginBtn(String locator, String value) {
		 if (locator.equals("xpath")) {
			 driver.findElement(By.xpath(value)).click();
		 }
		 else if(locator.equals("name")) {
			 driver.findElement(By.name(value)).click();
		 }
	 }
	 public static void verifyErrMsg(String locator, String value, String param) {
		String expectedErr = param;
		String actualErr = null;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		if(locator.equals("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			actualErr = driver.findElement(By.xpath(value)).getText();
		}
		else if(locator.equals("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			actualErr = driver.findElement(By.id(value)).getText();
		}
			
		Assert.assertEquals(actualErr, expectedErr);
	 }
	 public static void closeBrowser() {
		 driver.quit();
	 }
	
	
}

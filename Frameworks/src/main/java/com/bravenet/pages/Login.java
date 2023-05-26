package com.bravenet.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	WebDriverWait wait;
	
	@FindBy(id = "userid")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement loginBtn;
	
	@FindBy (xpath = "(//span[contains(@class,'md-error')])[1]")
	private WebElement errMsg;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public void enterUsername(String username) {
		email.clear();
		email.sendKeys(username);
		
	}
	
	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String getErrMsg() {
		wait.until(ExpectedConditions.visibilityOf(errMsg));
		String errorMsg = errMsg.getText();
		return errorMsg;
	}

}

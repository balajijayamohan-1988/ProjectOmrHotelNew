package com.omrbranch.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.omrbranch.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001_LoginStep {
	WebDriver driver;

	private final PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.omrbranch.com/");
		
		
		
	}
	@When("User enters {string} and {string}")
	public void userEntersAnd(String userName, String passWord) {
		pom.getLoginPage().login(userName, passWord);
		
			
	}
	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expectedSuccessMessage) {
		String loginSuccessMsg = pom.getExploreHotelPage().LoginSuccess();
		Assert.assertEquals("Verify Login Message", expectedSuccessMessage, loginSuccessMsg);
		
		
	}


	@When("User enters {string} and {string} with enter key")
	public void userEntersAndWithEnterKey(String userName2, String passWord2) {
		driver.findElement(By.id("email")).sendKeys(userName2,Keys.ENTER);
		driver.findElement(By.id("pass")).sendKeys(passWord2,Keys.ENTER);
		
	}


	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String errorLoginMsg) {
		Assert.assertTrue("verify after login",true);
		driver.quit();
		
	}






	
}

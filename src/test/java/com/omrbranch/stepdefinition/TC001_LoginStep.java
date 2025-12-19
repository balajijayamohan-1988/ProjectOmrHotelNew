
package com.omrbranch.stepdefinition;



import java.awt.AWTException;


import org.junit.Assert;

import com.omrbranch.manager.PageObjectManager;
import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.*;

public class TC001_LoginStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {
		
	}
	
	@When("User enters {string} and {string}")
	public void userEntersAnd(String name, String pass) {
	pom.getLoginPage().login(name, pass);	

	}
	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expFirstName) {
		String successfulLoginMsg = pom.getExploreHotelPage().getSuccessfulLoginMsg();
		Assert.assertEquals(expFirstName, successfulLoginMsg);
	}

	@When("User enters {string} and {string} with enter key")
	public void userEntersAndWithEnterKey(String userName, String password ) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(userName, password);
		String successfulLoginMsgR = pom.getExploreHotelPage().getSuccessfulLoginMsg();
		Assert.assertEquals("Verify Login Message","Welcome Balaji" , successfulLoginMsgR);
	}

	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expErrorMessageLoginText) {
		String errLoginMessage = pom.getLoginPage().getErrLoginMessage();
		Assert.assertTrue(errLoginMessage.contains(errLoginMessage));
		
	}



}


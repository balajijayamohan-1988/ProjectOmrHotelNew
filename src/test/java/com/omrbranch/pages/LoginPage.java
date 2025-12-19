
package com.omrbranch.pages;



import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id = "email")
	private WebElement txtUserName;
	
	@FindBy(id = "pass")
	private WebElement txtPassord;
	
	@FindBy(xpath = "//button[@value='login']")
	private WebElement btnLogin;
	
	@FindBy(id = "errorMessage")
	private WebElement errLoginMessage;
	
	
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassord() {
		return txtPassord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public String getErrLoginMessage() {
		return getElementText(errLoginMessage) ;
	}
	
//	1.Login
	public void login(String UserName, String password) {
		elementSendKeys(txtUserName, UserName);
		elementSendKeys(txtPassord, password);
		elementClick(btnLogin);
	}
//	2.Login With Enter Key
	public void loginWithEnterKey(String UserName,String password) throws AWTException {
		elementSendKeys(txtUserName, UserName);
		elementSendKeys(txtPassord, password);
		enterKey();
	}
//	3.Insert invalid Credentials and Get Error Message
	public void getErrorMessageText(String userName, String password) {
		elementSendKeys(txtUserName,userName);
		elementSendKeys(txtPassord, password);
		elementClick(btnLogin);
		
	
	}

	
	
	
	
	
	
	
	
	

}


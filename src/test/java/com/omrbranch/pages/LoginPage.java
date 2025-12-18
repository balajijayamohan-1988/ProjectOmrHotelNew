package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class LoginPage extends BaseClass {

	//constructor
public LoginPage(){
		PageFactory.initElements(driver, this);
	}	
	
	//Locators
	
	@FindBy(id="email")
	private  WebElement txtEmailId;	

	@FindBy(id="pass")
	private  WebElement txtPassword;

	@FindBy(xpath="//button[@value='login']")
	private WebElement BtnLogin;

	public WebElement getTxtEmailId() {
		return txtEmailId;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getLstBtnLogin() {
		return BtnLogin;
	}

	//business class
	public  void login(String userName,String passWord) {

		elementSendKeys(txtEmailId, userName);
		elementSendKeys(txtPassword, passWord);
		elementClick(BtnLogin);


		}
			
	
}

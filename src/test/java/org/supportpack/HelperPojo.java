package org.supportpack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelperPojo extends UtilClass{

	public HelperPojo() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	private WebElement txtemail;
	
	@FindBy(id="pass")
	private WebElement txtpass;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgetpassbtn;
	
	@FindBy(id="identify_email")
	private WebElement txtfindacc;
	
	@FindBy(id="did_submit")
	private WebElement search;
	
	@FindBy(id="identify_email")
	private WebElement fbforget;
	
	
	
	public WebElement getFbforget() {
		return fbforget;
	}

	public WebElement getTxtemail() {
		return txtemail;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getForgetpassbtn() {
		return forgetpassbtn;
	}

	public WebElement getTxtfindacc() {
		return txtfindacc;
	}

	public WebElement getSearch() {
		return search;
	}
	
	
}

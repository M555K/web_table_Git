package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoApplicationLoginPage {
    public CydeoApplicationLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "input[type='text']")
    public WebElement inputUsername;
    @FindBy(css = "input[type='password']")
    public WebElement inputPassword;
    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

}

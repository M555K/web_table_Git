package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage extends BasePage {
    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="username")
    public WebElement inputUsername;

    @FindBy(name="password")
    public WebElement inputPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;


    /**
     * This method will accept username and password and login to app
     * @param username
     * @param password
     */
    public void login(String username,String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }
}

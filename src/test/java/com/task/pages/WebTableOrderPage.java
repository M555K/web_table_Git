package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebTableOrderPage {
    public WebTableOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "select")
    public WebElement product;


    public void selectProduct(String productName) {

        Select selectOptionProduct = new Select(Driver.getDriver().findElement(By.tagName("select")));
        List<WebElement> allOptionProduct = selectOptionProduct.getOptions();
        for (WebElement oneProductName : allOptionProduct) {
            selectOptionProduct.selectByVisibleText(productName);
        }
    }

    @FindBy(css = "input[name='quantity']")
    public WebElement quantity;

    @FindBy(css = "input[placeholder='Enter the price for an individual unit']")
    public WebElement pricePerUnit;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateButton;

    @FindBy(css = "input[name='name']")
    public WebElement customerName;

    @FindBy(css = "input[name='street']")
    public WebElement street;

    @FindBy(css = "input[name='city']")
    public WebElement city;

    @FindBy(css = "input[name='state']")
    public WebElement state;

    @FindBy(css = "input[name='zip']")
    public WebElement zip;

    @FindBy(xpath = "//div[@class='control']/label")
    List<WebElement> card;

    public void selectCard (String cardName){
        for (WebElement eachCard : card) {
            if(eachCard.getText().equalsIgnoreCase(cardName)){
                eachCard.click();
            }
        }
        }

    @FindBy(css = "input[name='cardNo']")
    public WebElement cardNumber;

    @FindBy(css = "input[name='cardExp']")
    public WebElement expiryDate;
    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrder;

    @FindBy(xpath = "//button[.='Reset Fields']")
    public WebElement resetFields;

    @FindBy (xpath = "//tbody//td[1]")
    public List<WebElement> firstCell;
    
    public void firstNameFromCell(String name){
        List<String> allName= new ArrayList<>();
        for (WebElement eachName : firstCell) {
            allName.add(eachName.getText());
        }
    }

}

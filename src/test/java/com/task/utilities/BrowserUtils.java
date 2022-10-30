package com.task.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BrowserUtils {
    //methods are static because we do not want to create an object to call this method. We just want to call this methods with class name, that's why they are static type
    public static void SwitchWindowAndVerify(String expectedInURl, String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String eachWindow : allWindowHandles) {
            //driver switchTo.window(eachWindow);syntax will switch each windows
            Driver.getDriver().switchTo().window(eachWindow);
            if(Driver.getDriver().getCurrentUrl().contains(expectedInURl)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed",actualTitle.contains(expectedTitle));
    }
    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds *1000);
        }catch (InterruptedException e ){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }

    }// when you want to call it just write BrowserUtils.
    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals("Actual title is not as expected",expectedTitle,Driver.getDriver().getTitle());
    }
    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static List<String> dropdownOptionsAsString(WebElement dropdownWebElement){
        Select select = new Select(dropdownWebElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String > actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }
}

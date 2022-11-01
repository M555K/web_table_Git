package com.task.step_definitions;

import com.task.pages.BasePage;
import com.task.pages.WebTableLoginPage;
import com.task.pages.WebTableOrderPage;
import com.task.utilities.BrowserUtils;
import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.awt.image.Kernel;

import static junit.framework.TestCase.assertEquals;

public class WebTableStepDefinitions {
    BasePage basePage = new BasePage();
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    WebTableOrderPage webTableOrderPage = new WebTableOrderPage();
    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
    Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    webTableLoginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
    basePage.order.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {
        webTableOrderPage.selectProduct(productType);
      
    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer quantity) {
        webTableOrderPage.quantity.sendKeys(Keys.BACK_SPACE);
        webTableOrderPage.quantity.sendKeys(String.valueOf(quantity));


    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
        webTableOrderPage.customerName.sendKeys(name);


    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {
        webTableOrderPage.street.sendKeys(street);


    }
    @When("user enters city {string}")
    public void user_enters_city(String city) {
        webTableOrderPage.city.sendKeys(city);


    }
    @When("user enters state {string}")
    public void user_enters_state(String state) {
        webTableOrderPage.state.sendKeys(state);


    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String zip) {
        webTableOrderPage.zip.sendKeys(zip);


    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String creditCard) {
        webTableOrderPage.selectCard(creditCard);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String cardNumber) {
        webTableOrderPage.cardNumber.sendKeys(cardNumber);


    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String expireDate) {
        webTableOrderPage.expiryDate.sendKeys(expireDate);


    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webTableOrderPage.processOrder.click();


    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String firstNameInCell) {
        webTableOrderPage.firstNameFromCell(firstNameInCell);

    }

}


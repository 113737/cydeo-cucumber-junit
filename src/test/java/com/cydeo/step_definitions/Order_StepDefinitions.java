package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage= new WebTableLoginPage();
    BasePage basePage=new BasePage();
    OrderPage orderPage= new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage= new ViewAllOrdersPage();
    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
      webTableLoginPage.login();
      basePage.order.click();
        }

    @When("user selects product type {string}")
    public void userSelectsProductType(String string) {
        Select select=new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        //orderPage.inputQuantity.clear();
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        orderPage.inputQuantity.sendKeys(arg0+"");
       // orderPage.inputQuantity.sendKeys(String.valueOf(arg0));

    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String string) {
        orderPage.inputName.sendKeys(string);
    }

    @And("user enters street {string}")
    public void userEntersStreet(String string) {
        orderPage.inputStreet.sendKeys(string);
    }

    @And("user enters city {string}")
    public void userEntersCity(String string) {
        orderPage.inputCity.sendKeys(string);
    }

    @And("user enters state {string}")
    public void userEntersState(String string) {
        orderPage.inputState.sendKeys(string);
    }

    @And("user enters zipcode {string}")
    public void userEntersZipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }

    @And("user selects credit card type {string}")
    public void userSelectsCreditCardType(String expectedCardType) {
      BrowserUtils.clickRadioButton(orderPage.cardType,expectedCardType);
      //This line will loop through the list and decide which radio button to click

    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String string) {
        orderPage.inputCard.sendKeys(string);
    }

    @And("user enters expiry date {string}")
    public void userEntersExpiryDate(String string) {
        orderPage.inputCardExp.sendKeys(string);
    }

    @And("user enters process order button")
    public void userEntersProcessOrderButton() {
        orderPage.processButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void userShouldSeeInFirstRowOfTheWebTable(String expectedName) {
      //  System.out.println("viewAllOrdersPage.newCustomerCell.getText() = " + viewAllOrdersPage.newCustomerCell.getText());

        String actualName= viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedName,actualName);
    }
}

package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage=new GoogleSearchPage();

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword+Keys.ENTER);
    }
    @Then("user sees {string} in t google title")
    public void user_sees_in_t_google_title(String string) {
        String expectedTitle= string+" - Google'da Ara";
        String actualTitle= Driver.getDriver().getTitle();

        //jUnit assertion accepts firs arg as expected
        Assert.assertEquals("Title is not as expected!",expectedTitle,actualTitle);
        

    }

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");

    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTtile= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTtile,expectedTitle);

        Driver.closeDriver();

    }


    @When("user types apple and clicks enter")
    public void userTypesAppleAndClicksEnter() {
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);

    }

    @Then("user sees apple in t google title")
    public void userSeesAppleInTGoogleTitle() {
        String expectedTitle= "apple - Google'da Ara";
        String actualTitle= Driver.getDriver().getTitle();

        //jUnit assertion accepts firs arg as expected
        Assert.assertEquals("Title is not as expected!",expectedTitle,actualTitle);


    }
}

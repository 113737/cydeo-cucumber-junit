package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefinitions {
    WebTableLoginPage webTableLoginPage=new WebTableLoginPage();
    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url= ConfigurationReader.getProperty("web.table.url");
       Driver.getDriver().get(url);
      // you can write like that also Driver.getDriver().get("");
    }
    @When("user enters username {string}")
    public void userEntersUsername(String string) {
        webTableLoginPage.inputUsername.sendKeys(string);
    }
    @When("user enters password {string}")
    public void userEntersPassword(String string) {
        webTableLoginPage.inputPassword.sendKeys(string);
    }
    @When("user clicks to login button")
    public void userClicksToLoginButton() {
        webTableLoginPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
       // String actualTitle=Driver.getDriver().getCurrentUrl();
        BrowserUtils.verifyUrlContains("orders");
    }


    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
       // webTableLoginPage.inputUsername.sendKeys(username);
     //   webTableLoginPage.inputPassword.sendKeys(password);
       // webTableLoginPage.loginButton.click();

        webTableLoginPage.login(username,password);


    }
    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
    //    webTableLoginPage.inputUsername.sendKeys(credentials.get("username"));
      //  webTableLoginPage.inputPassword.sendKeys(credentials.get("password"));
        //webTableLoginPage.loginButton.click();

        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));
    }



}

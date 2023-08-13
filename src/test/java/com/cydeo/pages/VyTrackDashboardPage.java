package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.github.dockerjava.api.model.Link;
import com.sun.source.doctree.LinkTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashboardPage {

    public VyTrackDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(linkText="Logout")
    public WebElement logOutLink;

    public void logOut(){
        fullName.click();
        logOutLink.click();
    }
}

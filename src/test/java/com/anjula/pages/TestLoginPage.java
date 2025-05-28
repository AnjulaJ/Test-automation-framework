package com.anjula.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public TestLoginPage(WebDriver lwebdriver)
    {
        driver = lwebdriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="")
    private WebElement loginbtn;

    @FindBy(xpath="")
    private WebElement email;

    @FindBy(xpath="")
    private WebElement password;

    public void logib()
    {
        System.out.println("Hi I am working");
    }

}

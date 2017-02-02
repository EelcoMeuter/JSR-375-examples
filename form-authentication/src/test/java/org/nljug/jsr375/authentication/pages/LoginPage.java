package org.nljug.jsr375.authentication.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class LoginPage {

    private WebDriver driver;

    private URL root;

    public static final String TITLE = "Hello, please log in:";

    public LoginPage(WebDriver driver, URL root){
        this.driver = driver;
        this.root = root;
    }

    public String getTitle(){
        return driver.findElement(By.id("title")).getText();
    }

    public void login(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));
        username.sendKeys("admin");
        password.sendKeys("admin");
        login.click();
   }

}

package org.nljug.jsr375.authentication.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HomePage {

    private WebDriver driver;

    private URL root;

    public static final String TITLE = "JSF example";

    public HomePage(WebDriver driver, URL root){
        this.driver = driver;
        this.root = root;
    }

    public void navigateToHome(){
        driver.get(root.toExternalForm());
        WebElement title = driver.findElement(By.id("title"));
        assertEquals(TITLE, title.getText());
    }

    public void clickOnArea51(){
        driver.get(root.toExternalForm());
        WebElement link = driver.findElement(By.id("link"));
        link.click();
    }

}

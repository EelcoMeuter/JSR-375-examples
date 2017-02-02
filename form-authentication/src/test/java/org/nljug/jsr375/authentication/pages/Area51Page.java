package org.nljug.jsr375.authentication.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class Area51Page {

    private WebDriver driver;

    private URL root;

    public static final String TITLE = "Welcome to Area 51";

    public Area51Page(WebDriver driver, URL root) {
        this.driver = driver;
        this.root = root;
    }

    public String getTitle() {
        return driver.findElement(By.id("title")).getText();
    }

}

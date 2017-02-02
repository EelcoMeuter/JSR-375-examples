package org.nljug.jsr375.authentication;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nljug.jcp.jsr375.authentication.SecurityConfig;
import org.nljug.jsr375.authentication.pages.Area51Page;
import org.nljug.jsr375.authentication.pages.HomePage;
import org.nljug.jsr375.authentication.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.nljug.jcp.jsr375.test.util.MavenShrinkWrapper.wrap;

@RunWith(Arquillian.class)
public class SecurtiyConfigIT {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return wrap(new String[] { "index.xhtml", "login.xhtml", "restricted/index.xhtml" },
                    SecurityConfig.class);
    }

    @ArquillianResource
    private URL base;

    @Drone
    private WebDriver browser;

    private HomePage homePage;

    private LoginPage loginPage;

    private Area51Page area51Page;

    @Before
    public void intializePages() {
        homePage = new HomePage(browser, base);
        loginPage = new LoginPage(browser, base);
        area51Page = new Area51Page(browser, base);
    }

    @Test
    public void should_navigate_home() {
        homePage.navigateToHome();
    }

    @Test
    public void should_show_login() {
        homePage.clickOnArea51();
        assertEquals(LoginPage.TITLE, loginPage.getTitle());
    }

    @Test
    public void should_login_successfully() {
        homePage.clickOnArea51();
        loginPage.login();
        assertEquals(Area51Page.TITLE, area51Page.getTitle());
    }
}

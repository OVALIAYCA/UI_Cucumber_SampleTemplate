package stepdefinitions;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import pages.Base;
import pages.LoginPage;
import utilities.Driver;
import utilities.PropManager;

import static org.junit.Assert.assertEquals;


@Slf4j
public class LoginStepDefinition extends Base {

    LoginPage loginPage = new LoginPage();

    @Given("Open browser and Go to {string}")
    public void open_browser_and_go_to(String url) {
       driver.get(PropManager.getProperties(env,url));
    }

    @Given("Verify that title is {string}")
    public void verify_that_title(String title) {
        String expectedTitle = title;
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Given("Close the page")
    public void close_the_page() {
       Driver.quit();
    }

    @Given("Click the {string} button")
    public void click_the_button(String string) {
       loginPage.verifyAboutPage();
    }
}

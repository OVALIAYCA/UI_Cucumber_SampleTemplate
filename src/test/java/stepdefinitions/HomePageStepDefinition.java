package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import pages.AdminPage;
import pages.Base;
import pages.HomePage;
import utilities.Driver;
import utilities.PropManager;

import static org.junit.Assert.assertEquals;


@Slf4j
public class HomePageStepDefinition extends Base {

    HomePage homePage = new HomePage();
    AdminPage adminPage = new AdminPage();

    @Given("Open browser and Go to {string}")
    public void open_browser_and_go_to(String url) {
       driver.get(PropManager.getProperties(env,url));
    }



    @Given("Close the page")
    public void close_the_page() {
       Driver.quit();
    }



    @When("Click on the login button")
    public void clickOnTheButton() {
        homePage.loginLink.click();
    }


    @And("Enter the valid {string} and valid {string}")
    public void enterTheValidAndValid(String username, String password) {

        homePage.userNameButton.click();
        homePage.userNameButton.sendKeys(PropManager.getProperties(env,username));
        hardWait(1000);
        homePage.passwordButton.click();
        homePage.passwordButton.sendKeys(PropManager.getProperties(env,password));
        hardWait(1000);
        homePage.loginButtonSubmit.click();
        Assert.assertTrue(adminPage.helloAdminButton.isDisplayed());

    }
}

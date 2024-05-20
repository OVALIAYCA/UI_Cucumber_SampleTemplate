package pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends Base {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='About Us']")
    public WebElement aboutUs;

    @FindBy(xpath = "(//*[text()='About Us'])[2]")
    public WebElement titleAboutUs;

    public AboutPage verifyAboutPage(){
        waitAndClick(aboutUs);
        Assert.assertTrue(titleAboutUs.isDisplayed());
        return new AboutPage();
    }


    //Locates and Methods
}

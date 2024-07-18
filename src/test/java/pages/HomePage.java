package pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends Base {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "loginLink")
    public WebElement loginLink;

    @FindBy(id="UserName")
    public WebElement userNameButton;

    @FindBy(id="Password")
    public WebElement passwordButton;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement loginButtonSubmit;


}

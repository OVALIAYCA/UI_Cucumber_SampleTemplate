package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.Base.driver;

public class AdminPage extends Base{

    public AdminPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text()='Employee List']")
    public WebElement employeeListButton;

    @FindBy(xpath = "//*[text()='Hello admin!']")
    public WebElement helloAdminButton;

    @FindBy(xpath = "//*[text()='Create New']")
    public WebElement createNewButton;

    @FindBy(id = "Name")
    public WebElement employeeName;

    @FindBy(id = "Salary")
    public WebElement salary;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement createButton;

    @FindBy(id = "DurationWorked")
    public WebElement durationWorked;

    @FindBy(id = "Grade")
    public WebElement gradeDropDownMenu;

    @FindBy(xpath = "//*[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[1]")
    public WebElement firstRow;

    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "/html/body/div[2]/div/form/div/input")
    public WebElement deleteConfirmButton;

    @FindBy(tagName = "table")
    public WebElement table;

}
